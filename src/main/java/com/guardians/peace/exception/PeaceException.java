package com.guardians.peace.exception;

public class PeaceException extends RuntimeException {

    public PeaceException(String message) {
        super(message);
    }

    public PeaceException(String message, Throwable cause) {
        super(message, cause);
    }
}
