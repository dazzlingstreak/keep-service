package com.learning.keep.dto;

import javax.ws.rs.DefaultValue;
import java.io.Serializable;

/**
 * Created by huangdawei on 2017/9/8.
 */
public class PageParam implements Serializable {

    @DefaultValue("1")
    private Integer pageIndex;

    @DefaultValue("20")
    private Integer pageSize;

    public PageParam() {
    }

    public PageParam(Integer pageIndex, Integer pageSize) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
