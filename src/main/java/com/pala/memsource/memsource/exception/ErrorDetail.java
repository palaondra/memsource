package com.pala.memsource.memsource.exception;

import java.time.OffsetDateTime;

public class ErrorDetail {
    
    private OffsetDateTime date;
    private String message;

    public ErrorDetail(OffsetDateTime date, String message) {
        this.date = date;
        this.message = message;
    }

    public OffsetDateTime getDate() {
        return date;
    }

    public void setDate(OffsetDateTime date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    

}
