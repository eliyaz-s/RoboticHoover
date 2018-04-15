package com.mycompany.robotichoover.model;

import com.mycompany.robotichoover.validation.IValidation;
import java.awt.Point;


public class Coords extends Point implements IValidation {

    private static final long serialVersionUID = 1L;
    
    private Room dimensions = null;

    /**
     * Constructor using x and y coordinates
     * 
     * @param x  The x coordinate
     * @param y  The y coordinate
     */
    public Coords(int x, int y, Room dimensions) {
        super(x, y);
        this.dimensions = dimensions;
    }

    /**
     * Constructor using Point
     * 
     * @param point       The position
     * @param dimensions  The dimensions of the map
     */
    public Coords(Point point, Room dimensions) {
        this(point.x, point.y, dimensions);
    }

    /**
     * Implemented method. Checks if a position is inside the map.
     */
    @Override
    public boolean isValid() {
        boolean isValid = false;
        
        if (dimensions != null && 
            x >= 0 && x < dimensions.x &&
            y>= 0 && y < dimensions.y) {
            return true;
        }
        return isValid;
    }
    
    /**
     * Copy constructor
     * 
     * @param position  Another position
     */
    public Coords(Coords position) {
        super(position);
    }
}
