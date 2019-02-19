package com.cloud.provider.exception;

import lombok.Getter;
import lombok.Setter;

public class SessionNotFoundException extends Exception{
    @Getter
    @Setter
    protected String message;

    public SessionNotFoundException() {
        setMessage("Prop is illegal!");
    }

    public SessionNotFoundException(String message) {
        this.message = message;
        setMessage(String.format("Prop: %s is illegal!", message));
    }
}
