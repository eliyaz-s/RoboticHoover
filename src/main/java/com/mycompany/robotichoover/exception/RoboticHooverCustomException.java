package com.mycompany.robotichoover.exception;

public class RoboticHooverCustomException extends Exception {

    private static final long serialVersionUID = 1L;

    
    public RoboticHooverCustomException(String message) {
        super(message);
    }

    public RoboticHooverCustomException(String message, Exception e) {
        super(message, e);
    }

}
