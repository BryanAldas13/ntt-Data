package com.nttdata.devops.dto;

public class MessageResponse {
    private String message;

    public MessageResponse(String message) {  // Constructor agregado
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

