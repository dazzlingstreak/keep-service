package com.learning.keep.dto;

import com.learning.keep.enums.ApiResponseCode;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by huangdawei on 2017/9/11.
 */
public class Result<T> implements Serializable {

    private int code;

    private String message;

    private T data;

    private String serverTime;

    public Result() {
        this(ApiResponseCode.SUCCESS.getCode(), "");
    }

    public Result(ApiResponseCode code) {
        this(code.getCode(), code.getName());
    }

    public Result(ApiResponseCode code, T data) {
        this(code.getCode(), code.getName(), data);
    }

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
        this.serverTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.serverTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public static <T> Result<T> createSuccess() {
        return createSuccess(null);
    }

    public static <T> Result<T> createSuccess(T t) {
        return new Result<>(ApiResponseCode.SUCCESS, t);
    }

    public static <T> Result<T> createFail(ApiResponseCode code, String message) {
        return new Result(code.getCode(), message);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getServerTime() {
        return serverTime;
    }

    public void setServerTime(String serverTime) {
        this.serverTime = serverTime;
    }
}
