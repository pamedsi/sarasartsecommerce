package com.example.sarasartsecommerce.dto;

public class ResponseErrorDTO extends Exception{
    private String timestamp;
    private int status;
    private String error;
    private String trace;
    private String message;
    private String path;

    public String getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getTrace() {
        return trace;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }
}
