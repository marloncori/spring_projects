package com.jguides.student.registration.exception;

public class StudentAlreadySavedException extends Exception {
    public StudentAlreadySavedException() {
        super();
    }

    public StudentAlreadySavedException(String message) {
        super(message);
    }

    public StudentAlreadySavedException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentAlreadySavedException(Throwable cause) {
        super(cause);
    }

    protected StudentAlreadySavedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
