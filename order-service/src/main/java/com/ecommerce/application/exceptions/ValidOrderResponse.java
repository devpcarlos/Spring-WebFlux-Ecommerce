package com.ecommerce.application.exceptions;

import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
public class ValidOrderResponse {
    private String message;
    private Date TimeStamp;
    private List<String> Details;


    public ValidOrderResponse(String message, Date timeStamp, List<String> details) {
        TimeStamp = timeStamp;
        Details = details;
        this.message = message;
    }
}
