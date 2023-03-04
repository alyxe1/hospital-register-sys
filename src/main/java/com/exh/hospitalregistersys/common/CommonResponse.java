package com.exh.hospitalregistersys.common;

import com.exh.hospitalregistersys.common.exception.BackendErrorCodeEnum;
import com.exh.hospitalregistersys.common.exception.BizErrorCodeEnum;
import com.exh.hospitalregistersys.common.exception.BizException;
import com.exh.hospitalregistersys.common.exception.ErrorCode;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 尔宣赫
 * @date 29/11/2021
 */
@Data
public final class CommonResponse<T> implements Serializable {
    private static final long serialVersionUID = -4540673037543549080L;

    private CommonResponse() {
    }


    private T data;

    private Boolean success;

    private Integer errno;

    private String message;


    public CommonResponse(Boolean success, Integer status, String message, T data) {
        this.data = data;
        this.success = success;
        this.errno = status;
        this.message = message;

    }

    public CommonResponse(Boolean success, ErrorCode error, T data) {
        this.data = data;
        this.success = success;
        this.errno = error.getCode();
        this.message = error.getDescription();

    }

    public static <T> CommonResponse<T> ok(T data) {
        return new CommonResponse<>(Boolean.TRUE, BizErrorCodeEnum.SUCCESS, data);
    }

    public static <T> CommonResponse<T> ok() {
        return new CommonResponse<>(Boolean.TRUE, BizErrorCodeEnum.SUCCESS, null);
    }

    public static <T> CommonResponse<T> ok(T data, String msg) {
        return new CommonResponse<T>(Boolean.TRUE, BizErrorCodeEnum.SUCCESS.getCode(), msg, data);
    }

    public static <T> CommonResponse<T> fail(BizException bizException) {
        return new CommonResponse<>(Boolean.FALSE, bizException.getErrorCode(), null);
    }

    public static <T> CommonResponse<T> fail(BizErrorCodeEnum bizErrorCodeEnum) {
        return new CommonResponse<>(Boolean.FALSE, bizErrorCodeEnum, null);
    }

    public static <T> CommonResponse<T> fail(BizErrorCodeEnum bizErrorCodeEnum, String errorMsg) {
        return new CommonResponse<T>(Boolean.FALSE, bizErrorCodeEnum.getCode(), errorMsg, null);
    }

    public static <T> CommonResponse<T> fail(Integer code, String errorMsg) {
        return new CommonResponse<>(Boolean.FALSE, code, errorMsg, null);
    }

    public static <T> CommonResponse<T> fail(BackendErrorCodeEnum backendErrorCodeEnum) {
        return new CommonResponse<>(Boolean.FALSE, backendErrorCodeEnum, null);
    }

    @JsonIgnore
    public Boolean isSuccess() {
        return getSuccess() != null
                && getErrno() != null
                && getSuccess()
                && BizErrorCodeEnum.SUCCESS.getCode().equals(getErrno());
    }


    public T getData() {
        return data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public Integer getErrno() {
        return errno;
    }

    public String getMessage() {
        return message;
    }

}
