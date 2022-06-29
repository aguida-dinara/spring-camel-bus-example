package com.example.springcamelbusexample.exceptions;

public class NonTransientErrorException extends RuntimeException {
    public NonTransientErrorException() {
    }

    public NonTransientErrorException(String message) {
        super(message);
    }

    public NonTransientErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public NonTransientErrorException(Throwable cause) {
        super(cause);
    }

    public NonTransientErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
