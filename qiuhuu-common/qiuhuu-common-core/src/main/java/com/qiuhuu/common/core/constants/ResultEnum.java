package com.qiuhuu.common.core.constants;

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

    /**
     * 内部错误
     */
    ERROR(400,"error");

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
