package com.mycompany.robotichoover.operation;

import com.mycompany.robotichoover.model.Coords;
import com.mycompany.robotichoover.model.Room;
import com.mycompany.robotichoover.exception.InvalidDirtCoordinatesException;
import java.awt.Point;

import com.mycompany.robotichoover.validation.IValidation;


/**
 * Represents the map of the room as per given dimensions. It does that by initially creating and empty
 * array with the size of the dimensions. It can be filled with dirts, or any
 * other elements that can be added in the future.
 * 
 */
public class RoomMap implements IValidation {

    private PositionOnMap[][] map;
    private Room roomSize = null;
    
    /**
     * Constructor
     * 
     * @param roomSize  Dimensions of the map
     */
    public RoomMap(Room roomSize) {
        this.roomSize = roomSize;
        map = new PositionOnMap[roomSize.x][roomSize.y];
        
        // Initialise map
        for (int x = 0; x < roomSize.x; x ++) {
            for (int y = 0; y < roomSize.y; y++) {
                map[x][y] = PositionOnMap.CLEAN_POS;
            }
        }
    }
    
    /**
     * Adds the dirt to a certain map tile.
     * 
     * @param  point       Coordinates of the dirt
     * @throws InvalidDirtCoordinatesException
     */
    public void applyDirtPatch(Point point)   throws InvalidDirtCoordinatesException {
        applyDirtPatch(point.x, point.y);
    }
    
    /**
     * Adds the dirt to a certain map coordinates
     * 
     * @param x  The x coordinate
     * @param y  The y coordinate
     * @throws com.mycompany.robotichoover.exception.InvalidDirtCoordinatesException
     */
    public void applyDirtPatch(int x, int y) 
                                            throws InvalidDirtCoordinatesException {
        // This is no syntax validation per se, but needed to not get out of 
        // array bounds
        if (x >= roomSize.x ||
            y >= roomSize.y) {
            throw new InvalidDirtCoordinatesException();
        }
        map[x][y] = PositionOnMap.DIRTY_POS;
    }
 
    /**
     * Checks if a certain tile is dirty
     * 
     * @param coords
     * @return boolean   Is dirty or not
     */
    public boolean isDirty(Coords coords) {
        boolean isDirty = false;
        
        if (map[coords.x][coords.y] == PositionOnMap.DIRTY_POS) {
            map[coords.x][coords.y] = PositionOnMap.CLEAN_POS;
            isDirty = true;
        }
        return isDirty;
    }
    
    public boolean isDirty(int x, int y) {
        boolean isDirty = false;
        if (map[x][y] == PositionOnMap.DIRTY_POS) {
            isDirty = true;
        }
        return isDirty;
    }
    
    /**
     * Checks if map is valid
     * 
     * @return boolean true/false
     */
    @Override
    public boolean isValid() {
        return roomSize.isValid();
    }
    
    private enum PositionOnMap {
        CLEAN_POS, DIRTY_POS
    }
    
}

