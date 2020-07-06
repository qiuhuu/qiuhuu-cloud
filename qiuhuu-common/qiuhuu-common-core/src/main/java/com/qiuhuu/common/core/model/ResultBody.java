package com.qiuhuu.common.core.model;

import com.qiuhuu.common.core.constants.ResultEnum;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * 统一返回类型
 * @author : qiuhuu
 * @date : 2020-07-02 16-32
 */
public class ResultBody<T> implements Serializable {

    private static final long serialVersionUID = 5427142320311871503L;
    /**
     * 消息码
     */
    private int code = 0;
    /**
     * 返回消息信息
     */
    private String message;
    /**
     * 返回数据
     */
    private T data;
    /**
     * http状态码
     */
    private int httpStatus;

    /**
     * 服务器时间
     */
    private long timestamp = System.currentTimeMillis();

    public ResultBody success(int code){
        return success(code, "", null, HttpStatus.OK.value());
    }
    public ResultBody success(int code, String message){
        return success(code, message, null, HttpStatus.OK.value());
    }
    public ResultBody success(int code, String message, T data){
        return success(code, message, data, HttpStatus.OK.value());
    }
    /**
     * 成功
     * @param code 消息码
     * @param message 返回消息信息
     * @param data 返回的数据
     * @return ResultBody
     */
    @SuppressWarnings("unchecked")
    public ResultBody success(int code, String message, T data,int httpStatus){
        this.setCode(code);
        this.setMessage(message);
        this.setData(data);
        this.setHttpStatus(httpStatus);
        return this;
    }
    public ResultBody success(ResultEnum resultEnum, T data,int httpStatus){
        return success(resultEnum.getCode(),resultEnum.getMessage(),data,httpStatus);
    }
    public ResultBody success(ResultEnum resultEnum, T data){
        return success(resultEnum.getCode(),resultEnum.getMessage(),data);
    }

    public ResultBody success(ResultEnum resultEnum){
        return success(resultEnum.getCode(),resultEnum.getMessage());
    }


    public ResultBody failure(int code){
        return failure(code, "", null, HttpStatus.BAD_REQUEST.value());
    }
    public ResultBody failure(int code, String message){
        return failure(code, message, null, HttpStatus.BAD_REQUEST.value());
    }
    public ResultBody failure(int code, String message, T data){
        return failure(code, message, data, HttpStatus.BAD_REQUEST.value());
    }
    /**
     * 失败
     * @param code 消息码
     * @param message 返回消息信息
     * @param data 返回的数据
     * @return ResultBody
     */
    public ResultBody failure(int code, String message, T data,int httpStatus){
        this.setCode(code);
        this.setMessage(message);
        this.setData(data);
        this.setHttpStatus(httpStatus);
        return this;
    }
    public ResultBody failure(ResultEnum resultEnum, T data,int httpStatus){
        return failure(resultEnum.getCode(),resultEnum.getMessage(),data,httpStatus);
    }
    public ResultBody failure(ResultEnum resultEnum, T data){
        return failure(resultEnum.getCode(),resultEnum.getMessage(),data);
    }

    public ResultBody failure(ResultEnum resultEnum){
        return failure(resultEnum.getCode(),resultEnum.getMessage());
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

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }
}
