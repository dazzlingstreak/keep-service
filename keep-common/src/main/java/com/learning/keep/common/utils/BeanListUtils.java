package com.learning.keep.common.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by huangdawei on 2017/9/11.
 */
public class BeanListUtils {

    public static <S, T> void copyProperties(List<S> sourceList, List<T> targetList, Class<T> classType) {
        if (sourceList == null || targetList == null) {
            return;
        }
        for (S sourceItem : sourceList) {
            try {
                T t = classType.newInstance();
                BeanUtils.copyProperties(sourceItem, t);
                targetList.add(t);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
