package com.ecommerce.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ValidProductResponse {
    private String message;
    private Date TimeStamp;
    private String Details;

    public ValidProductResponse(String message, Date timeStamp, String details) {
        this.message = message;
        this.TimeStamp = timeStamp;
        this.Details = details;
    }
}
