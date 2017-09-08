package com.learning.keep.dto;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangdawei on 2017/9/8.
 */
public class PageResult<T> implements Serializable {

    private Long totalCount;

    private List<T> items = new ArrayList<>();

    public PageResult() {
    }

    public PageResult(Long totalCount, List<T> items) {
        this.totalCount = totalCount;
        this.items = items;
    }

    public PageResult(List<T> items) {
        if (items instanceof Page) {
            Page pageList = (Page) items;
            this.totalCount = pageList.getTotal();
        }
        this.items = items;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
