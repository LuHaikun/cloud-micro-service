package com.cloud.provider.exception;

import lombok.Getter;
import lombok.Setter;

public class IllegalPropertiesException extends Exception{

    @Getter
    @Setter
    protected String message;

    public IllegalPropertiesException() {
        setMessage("Session is not found!");
    }

    public IllegalPropertiesException(String message) {
        this.message = message;
    }
}
