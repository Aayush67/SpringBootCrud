package com.decipher.crud.model;

import lombok.*;

@Getter @Setter
public class ResponseStatus {
    private String responseMessage;
    private  Integer responseCode;
    public ResponseStatus(Integer responseCode, String  responseMessage)
    {
        this.responseCode=responseCode;
        this.responseMessage=responseMessage;
    }
    public ResponseStatus(){}
}
