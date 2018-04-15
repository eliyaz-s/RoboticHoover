package com.mycompany.robotichoover.exception;

public class InvalidNumberOfPointCoordsException extends RoboticHooverCustomException {

    private static final long serialVersionUID = 1L;

    public InvalidNumberOfPointCoordsException() {
        super("Invalid number of position coordinates");
    }

    public InvalidNumberOfPointCoordsException(
                                  String message,
                                  Exception e) {
        super(message, e);
    }

}
