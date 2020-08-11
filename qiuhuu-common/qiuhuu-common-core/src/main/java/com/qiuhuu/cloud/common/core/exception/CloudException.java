package com.qiuhuu.cloud.common.core.exception;

import com.qiuhuu.cloud.common.core.constant.ResultEnum;

/**
 * 自定义服务异常
 * @author : qiuhuu
 * @date : 2020-07-08 11-13
 */
public class CloudException extends RuntimeException{

    private static final long serialVersionUID = -7366007549667765202L;

    private int code;

    public CloudException(String message) {
        this(400, message);
    }

    public CloudException(int code, String message) {
        super(message);
        this.code = code;
    }

    public CloudException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public CloudException(ResultEnum resultEnum){
        this(resultEnum.getCode(),resultEnum.getMessage());
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
