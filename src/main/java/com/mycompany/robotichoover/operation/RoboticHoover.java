/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.robotichoover.operation;

import com.mycompany.robotichoover.model.Solution;
import com.mycompany.robotichoover.model.Coords;
import java.util.ListIterator;

/**
 *
 * @author eliyaz
 */
public class RoboticHoover {

    private RoomMap map = null;
    private Coords coords = null;
    private int dirtsCleaned = 0;
    private Coords previousPosition = null;
    
    /**
     * Constructor
     * 
     * @param map       Robot is aware of the whole map.
     * @param coords  Initial coords of the robot
     */
    public RoboticHoover(RoomMap map, Coords coords) {
        this.map = map;
        this.coords = coords;
        previousPosition = new Coords(coords);
    }
    
    /**
     * Makes the robot move to a direction
     * 
     * @param direction  Direction to move towards
     */
    private void move(char direction) {
        
        getPreviousPosition().setLocation(coords);
        
        switch (direction) {
            case 'N':
                coords.y++;
                break;
            case 'S':
                coords.y--;
                break;
            case 'E':
                coords.x++;
                break;                
            case 'W':
                coords.x--;
                break;
            default:
                break;
        }
        
        // If a coords is not in the map, the robot stays in the same place
        if (coords.isValid()) {
            doClean(coords);
        } else {
            coords.setLocation(getPreviousPosition());
        }
        
    }

    /**
     * Goes through the driving instructions and checks for dirts to clean.
     * 
     * @param  drivingInstructions  Our instructions
     * @return Solution             The solution of the Hoover operations
     */
    public Solution clean(HooverInstructions drivingInstructions) {
        
        Solution solution = null;
        
        // Check if initial coords needs cleaning
        if (coords.isValid()) {
            doClean(coords);
        }
        
        for (ListIterator<Character> iter = drivingInstructions.listIterator();
             iter.hasNext(); ) {
            Character direction = iter.next();
            move(direction);
        }

        solution = new Solution(coords, dirtsCleaned);
        
        return solution;
    }
    

    /**
     * Cleans dirt on a specific coords
     * 
     * @param Coords  coords with potential dirt to be cleaned
     */
    private void doClean(Coords coords) {
        if (map.isDirty(coords)) {
            dirtsCleaned ++;
        }
    }

    /**
     * @return the previousPosition
     */
    public Coords getPreviousPosition() {
        return previousPosition;
    }

    /**
     * @param previousPosition the previousPosition to set
     */
    public void setPreviousPosition(Coords previousPosition) {
        this.previousPosition = previousPosition;
    }
}