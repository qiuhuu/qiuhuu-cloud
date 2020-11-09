package com.qiuhuu.cloud.common.core.constant;

/**
 * 自定义的返回状态码
 * @author : qiuhuu
 * @date : 2020-07-02 17-37
 */
public enum ResultEnum {

    /**
     * 成功
     */
    OK(200,"success"),

    /*****************系统错误************************/
    /**
     * 网关超时
     */
    GATEWAY_TIMEOUT(100001, "gateway_timeout"),
    /**
     * 服务降级
     */
    SERVICE_FALLBACK(100002,"service_fallback"),

    PARAMETER_VERIFICATION_ERROR(100003,"参数校验错误"),
    /**
     * 内部错误
     */
    ERROR(100000,"error"),

    /*****************授权错误************************/

    NO_AUTHORIZATION(200001,"no_authorization")





    ;


    /**
     * 状态码
     */
    private int code;
    /**
     * 消息
     */
    private String message;

    ResultEnum() {
    }

    ResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ResultEnum getResultEnum(int code){
        for (ResultEnum type : ResultEnum.values()){
            if (type.getCode() == code){
                return type;
            }
        }
        return ERROR;
    }
    public static ResultEnum getResultEnum(String message){
        for (ResultEnum type : ResultEnum.values()){
            if (type.getMessage().equals(message)){
                return type;
            }
        }
        return ERROR;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
