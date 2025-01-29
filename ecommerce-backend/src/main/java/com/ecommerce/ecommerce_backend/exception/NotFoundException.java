package com.ecommerce.ecommerce_backend.exception;

public class NotFoundException extends RuntimeException {
    
    public NotFoundException(String exMessage) {
        super(exMessage);
    }

}
