package com.exh.hospitalregistersys.common.exception;

/**
 * @author 王永天
 * @date 2020/7/7
 */
public interface ErrorCode {

    /**
     * 获取错误码
     * @return
     */
    Integer getCode();

    /**
     * 获取错误信息
     * @return
     */
    String getDescription();
}
