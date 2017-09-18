package com.learning.keep.service.foreclosure.impl;

import com.learning.keep.dao.foreclosure.ForeclosureInterviewMapper;
import com.learning.keep.model.foreclosure.ForeclosureInterview;
import com.learning.keep.service.foreclosure.IForeclosureInterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by huangdawei on 2017/9/18.
 */
@Service
public class ForeclosureInterviewServiceImpl implements IForeclosureInterviewService {

    @Autowired
    private ForeclosureInterviewMapper foreclosureInterviewMapper;

    @Override
    public ForeclosureInterview selectByOrderId(Integer orderId) {
        return foreclosureInterviewMapper.selectByOrderId(orderId);
    }
}
