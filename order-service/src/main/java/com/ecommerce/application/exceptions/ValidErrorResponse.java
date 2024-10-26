package com.ecommerce.application.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ValidErrorResponse {
    private String message;
    private Date TimeStamp;
    private String Details;

    public ValidErrorResponse(String message, Date timeStamp, String details) {
        this.message = message;
        this.TimeStamp = timeStamp;
        this.Details = details;
    }
}
