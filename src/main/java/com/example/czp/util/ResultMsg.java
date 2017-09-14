package com.example.czp.util;

import com.alibaba.fastjson.annotation.JSONField;

public class ResultMsg {
    @JSONField(ordinal = 1)
    private int resultCode;
    @JSONField(ordinal = 2)
    private String msg;
    @JSONField(ordinal = 3)
    private Object data;

    public void setSuccess(){
        this.resultCode = 200;
        this.msg = "成功";
    }
    public void setError(){
        this.resultCode = 400;
        this.msg = "失败";
    }
    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
