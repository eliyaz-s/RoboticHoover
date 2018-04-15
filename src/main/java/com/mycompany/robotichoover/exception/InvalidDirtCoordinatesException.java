package com.mycompany.robotichoover.exception;


public class InvalidDirtCoordinatesException extends RoboticHooverCustomException {

    private static final long serialVersionUID = 1L;

    public InvalidDirtCoordinatesException() {
        super("Patch of dirt coordinates are outside of the map bounds");
    }
    
}
