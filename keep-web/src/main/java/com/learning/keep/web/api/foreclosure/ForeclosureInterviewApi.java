package com.learning.keep.web.api.foreclosure;

import com.learning.keep.model.foreclosure.ForeclosureInterview;
import com.learning.keep.service.foreclosure.IForeclosureInterviewService;
import com.learning.keep.web.api.foreclosure.model.ForeclosureInterviewVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Objects;

/**
 * Created by huangdawei on 2017/9/18.
 */
@Path("/foreclosure/interview")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
@Api(tags = "赎楼贷面签模块")
public class ForeclosureInterviewApi {

    @Autowired
    private IForeclosureInterviewService foreclosureInterviewService;

    @GET
    @Path("/{orderId}")
    @ApiOperation("查询面签信息")
    public ForeclosureInterviewVO getForeclosureInterviewInfo(@PathParam("orderId") Integer orderId) {
        ForeclosureInterviewVO foreclosureInterviewVO = new ForeclosureInterviewVO();
        ForeclosureInterview foreclosureInterview = foreclosureInterviewService.selectByOrderId(orderId);
        if(Objects.nonNull(foreclosureInterview)){
            BeanUtils.copyProperties(foreclosureInterview,foreclosureInterviewVO);
        }
        return foreclosureInterviewVO;
    }

}
