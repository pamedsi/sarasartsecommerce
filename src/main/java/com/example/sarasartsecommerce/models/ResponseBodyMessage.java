package com.example.sarasartsecommerce.models;

import lombok.Getter;

@Getter
public class ResponseBodyMessage {
    private final String message;
    private final int status;

    public ResponseBodyMessage(String message,int status) {
        this.message = message;
        this.status = status;
    }
}
