package com.learning.keep.web.filter;

import com.learning.keep.dto.Result;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.StreamingOutput;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.Objects;

/**
 * Created by huangdawei on 2017/9/11.
 */
@Provider
@Priority(value = Priorities.USER)
public class ResponseFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {

        Object result = containerResponseContext.getEntity();

        if (Objects.nonNull(result)) {
            if (result instanceof Result) {
                return;
            }
            if(result instanceof StreamingOutput){
                return;
            }
            Result<Object> entity = Result.createSuccess(result);
            containerResponseContext.setEntity(entity);
        }
    }
}
