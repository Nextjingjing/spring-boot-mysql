package com.example.testSql.dto;

public class APIResponse<T> {
    private String message;
    private T data;

    public APIResponse(String message, T data) {
        this.data = data;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "APIResponse [message=" + message + ", data=" + data + "]";
    }
    
}
