package com.learning.keep;

import com.learning.keep.properties.OssSettings;
import io.swagger.annotations.Api;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

@SpringBootApplication
@ComponentScan(
        basePackages = {"com.learning.keep"},
        includeFilters = {@ComponentScan.Filter(Api.class)}
)
@MapperScan(
        basePackages = {"com.learning.keep.dao"}
)
@EnableConfigurationProperties({OssSettings.class})
@EnableCaching
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * redis模板操作类,类似于jdbcTemplate的一个类;
     * <p>
     * 虽然CacheManager也能获取到Cache对象，但是操作起来没有那么灵活；
     * <p>
     * 这里在扩展下：RedisTemplate这个类不见得很好操作，我们可以在进行扩展一个我们
     * <p>
     * 自己的缓存类，比如：RedisStorage类;
     *
     * @param factory : 通过Spring进行注入，参数在application.yml进行配置；
     * @return
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);
        return redisTemplate;
    }

    @Bean
    public RedisCacheManager redisCacheManager(RedisTemplate<?, ?> redisTemplate) {
        RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate);
        redisCacheManager.setUsePrefix(true);
        //设置一个默认的过期时间: 60秒
        redisCacheManager.setDefaultExpiration(60);
        return redisCacheManager;
    }

    @Bean(name = "executor")
    public ThreadPoolTaskExecutor executor() {

        /**
         * ThreadPoolExecutor执行器的处理流程
         * (1)当线程池大小小于corePoolSize就新建线程，并处理请求
         * (2)当线程池大小等于corePoolSize，把请求放入workQueue中，池子里的空闲线程就去从workQueue中取任务并处理.
         * (3)当workQueue放不下新入的任务时，新建线程加入线程池，并处理请求，如果池子大小撑到了maximumPoolSize就用RejectedExecutionHandler来做拒绝处理.
         * (4)另外，当线程池的线程数大于corePoolSize的时候，多余的线程会等待keepAliveTime长的时间，如果无请求可处理就自行销毁
         *
         * Reject策略预定义有四种：
         * (1)ThreadPoolExecutor.AbortPolicy策略，是默认的策略,处理程序遭到拒绝将抛出运行时 RejectedExecutionException。
         * (2)ThreadPoolExecutor.CallerRunsPolicy策略 ,调用者的线程会执行该任务,如果执行器已关闭,则丢弃.
         * (3)ThreadPoolExecutor.DiscardPolicy策略，不能执行的任务将被丢弃.
         * (4)ThreadPoolExecutor.DiscardOldestPolicy策略，如果执行程序尚未关闭，则位于工作队列头部的任务将被删除，然后重试执行程序（如果再次失败，则重复此过程）.
         *
         *  注意这边设置的最大线程数，如果数据库操作也用到了连接池，那么需要确定，数据库连接池的并发数是否满足，如果数量过小不满足，则会无jdbc连接可用，导致出错。
         */
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5); //线程池维护线程的最小数量.
        executor.setMaxPoolSize(10); //线程池维护线程的最大数量
        executor.setQueueCapacity(20); //workQueue的最大长度
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.setWaitForTasksToCompleteOnShutdown(true);
        return executor;
    }
}
