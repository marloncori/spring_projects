package com.millenium.company.models;

import org.springframework.stereotype.Component;

@Component
public class ErrorMsg {

    String msg;

    public ErrorMsg() {
        this.msg = " WARNING: Employee not present in database.";
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
