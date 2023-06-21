package com.example.sarasartsecommerce.models;

public class ResponseBodyMessage {
    private final String message;
    private final int status;

    public ResponseBodyMessage(String message,int status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() { return status; }
}
