package com.learning.keep.dao.foreclosure;

import com.learning.keep.model.foreclosure.ForeclosureInterview;
import org.apache.ibatis.annotations.Param;

public interface ForeclosureInterviewMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ForeclosureInterview record);

    int insertSelective(ForeclosureInterview record);

    ForeclosureInterview selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ForeclosureInterview record);

    int updateByPrimaryKey(ForeclosureInterview record);

    ForeclosureInterview selectByOrderId(@Param("orderId") Integer orderId);
}