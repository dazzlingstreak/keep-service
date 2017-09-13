package com.learning.keep;

import com.learning.keep.properties.OssSettings;
import io.swagger.annotations.Api;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(
        basePackages = {"com.learning.keep"},
        includeFilters = {@ComponentScan.Filter(Api.class)}
)
@MapperScan(
        basePackages = {"com.learning.keep.dao"}
)
@EnableConfigurationProperties({OssSettings.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
