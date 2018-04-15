package com.mycompany.robotichoover.model;

import com.mycompany.robotichoover.validation.IValidation;
import java.awt.Point;


/**
 * Holds the dimensions of the room. It uses the Point
 * class for storing the dimensions.
 */
public class Room extends Point implements IValidation {

    /**
     * Constructor using a Point.
     * 
     * @param position  Dimensions as a point
     */
    public Room(Point position) {
        super(position);
    }

    /**
     * Constructor that uses x and y coordinates.
     * 
     * @param x  X coordinate
     * @param y  Y coordinate
     */
    public Room(int x, int y) {
        super(x, y);
    }

    
    /**
     * Implements the interface. Map must be square, thus X and y dimensions
     * must match   .
     * 
     * @return boolean  true if map is square, false otherwise  
     */
    @Override
    public boolean isValid() {
        boolean isValid = true;
        if (x < 0 ||  y < 0) {
            isValid = false;
        }
        return isValid;
    }
}
