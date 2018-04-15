package com.mycompany.robotichoover.exception;


public class InvalidDirectionException extends RoboticHooverCustomException {

    private static final long serialVersionUID = 1L;

    public InvalidDirectionException() {
        super("Invalid direction was given as part of the movements list");
    }
}
