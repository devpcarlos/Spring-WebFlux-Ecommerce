package com.ecommerce.application.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class ValidErrorResponse {
    private List<String> message;
    private Date TimeStamp;
    private String Details;


    public ValidErrorResponse(List<String> message, Date timeStamp, String details) {
        TimeStamp = timeStamp;
        Details = details;
        this.message = message;
    }
}
