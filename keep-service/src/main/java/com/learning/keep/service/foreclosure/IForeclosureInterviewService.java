package com.learning.keep.service.foreclosure;

import com.learning.keep.model.foreclosure.ForeclosureInterview;

/**
 * Created by huangdawei on 2017/9/18.
 */
public interface IForeclosureInterviewService {

    ForeclosureInterview selectByOrderId(Integer orderId);
}
