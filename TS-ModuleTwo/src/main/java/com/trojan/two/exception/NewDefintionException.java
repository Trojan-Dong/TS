package com.trojan.two.exception;

public class NewDefintionException extends Exception {
    //错误码
    private String errCode;
    //错误信息
    private String errMsg;

    public NewDefintionException() {

    }

    public NewDefintionException(String errCode, String errMsg) {
        super(errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public NewDefintionException(Throwable e, String errCode, String errMsg) {
        super(e);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }
}
