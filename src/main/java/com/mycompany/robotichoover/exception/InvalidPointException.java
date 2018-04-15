package com.mycompany.robotichoover.exception;

public class InvalidPointException extends RoboticHooverCustomException {

    private static final long serialVersionUID = 1L;

    public InvalidPointException(String message) {
        super(message);
    }
    
    public InvalidPointException(String message, Exception e) {
        super(message, e);
    }
    
}
