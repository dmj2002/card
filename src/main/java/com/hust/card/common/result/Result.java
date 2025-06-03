package com.hust.card.common.result;

import java.io.Serializable;

public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 返回处理消息
     */
    private String message = "";

    /**
     * 返回代码
     */
    private Integer code = 0;

    /**
     * 返回数据对象 data
     */
    private Object result;

    public Result() {
    }

    public static<T> Result<T> OK(T data) {
        Result<T> r = new Result<T>();
        r.setCode(200);
        r.setResult(data);
        return r;
    }

    public static<T> Result<T> OK(String msg) {
        Result<T> r = new Result<T>();
        r.setCode(200);
        r.setMessage(msg);
        return r;
    }

    public static<T> Result<T> OK(String msg, T data) {
        Result<T> r = new Result<T>();
        r.setCode(200);
        r.setMessage(msg);
        r.setResult(data);
        return r;
    }

    public static<T> Result<T> error(String msg, T data) {
        Result<T> r = new Result<T>();
        r.setCode(500);
        r.setMessage(msg);
        r.setResult(data);
        return r;
    }

    public static<T> Result<T> error(String msg) {
        return error(500, msg);
    }

    public static<T> Result<T> error(int code, String msg) {
        Result<T> r = new Result<T>();
        r.setCode(code);
        r.setMessage(msg);
        return r;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
