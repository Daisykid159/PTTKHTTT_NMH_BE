package com.pttkhttt.PTTKHTTT_NMH_BE.response;

public class CommonResponse<T> {

    private boolean ok;
    private String message;

    private T data;

    public CommonResponse success(){
        this.ok = true;
        this.message = "Thành công";
        return  this;
    }

    public CommonResponse data(T data){
        this.data = data;
        return  this;
    }

    public CommonResponse ok(boolean ok){
        this.ok = ok;
        return this;
    }

    public CommonResponse message(String message){
        this.message = message;
        return this;
    }


}
