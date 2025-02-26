package com.nttdata.devops.dto;

import jakarta.validation.constraints.NotNull;

public class MessageRequest {
    @NotNull(message = "Message is required")
    private String message;
    @NotNull(message = "Recipient (to) is required")
    private String to;
    @NotNull(message = "Sender (from) is required")
    private String from;
    @NotNull(message = "Time to life in seconds is required")
    private Integer timeToLifeSec;

    public String getMessage() {
        return message;
    }

    public String getTo() {
        return to;
    }

    public String getFrom() {
        return from;
    }

    public int getTimeToLifeSec() {
        return timeToLifeSec;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTimeToLifeSec(Integer timeToLifeSec) {
        this.timeToLifeSec = timeToLifeSec;
    }
}
