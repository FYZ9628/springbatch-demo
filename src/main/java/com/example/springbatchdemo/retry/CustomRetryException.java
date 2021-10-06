package com.example.springbatchdemo.retry;

/**
 * @Author Administrator
 * @Date 2021/10/6 10:15
 */
public class CustomRetryException extends Exception {

    public CustomRetryException() {
        super();
    }

    public CustomRetryException(String msg) {
        super(msg);
    }
}
