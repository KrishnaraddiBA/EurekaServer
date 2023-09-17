package com.userservice.dto;

import java.util.Date;

public class ErrorDetails {
    private Date date;
    private String msg;

    private String msg1;

    public ErrorDetails(Date date, String msg,String msg1) {
        this.date = date;
        this.msg = msg;
        this.msg1=msg1;
    }

    public ErrorDetails() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg1() {
        return msg1;
    }

    public void setMsg1(String msg1) {
        this.msg1 = msg1;
    }
}
