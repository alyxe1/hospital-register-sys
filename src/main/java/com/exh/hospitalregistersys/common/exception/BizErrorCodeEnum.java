package com.exh.hospitalregistersys.common.exception;

/**
 * @author liuzhongxu
 * @date 2020/7/7
 */
public enum BizErrorCodeEnum implements ErrorCode {


    /**
     * 成功
     */
    SUCCESS(0, "服务运行成功"),
    /**
     * 未指明的异常
     */
    UNSPECIFIED(500, "网络异常，请稍后再试"),
    DATA_EXIST(50000, "数据已存在"),
    PARAMS_VALIDATION_ERRNO(50001, "参数校验异常"),
    SYSTEM_ERRNO(50002, "系统内部错误"),

    NO_ABILITY_ERRNO(50011, "暂无此能力"),
    DATA_EMPTY_ERRNO(50017, "数据为空");

    /**
     * 错误码
     */
    private final Integer code;

    /**
     * 描述
     */
    private final String description;

    /**
     * 构造器
     *
     * @param code        码值
     * @param description 描述
     */
    BizErrorCodeEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}
