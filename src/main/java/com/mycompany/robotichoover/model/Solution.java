/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.robotichoover.model;

import java.util.Objects;

public class Solution {

    private Coords coords= null;
    private int dirtsCleaned = 0;
    
    /**
     * Solution constructor.
     * 
     * @param coords
     * @param dirtsCleaned  Dirts that have been cleaned
     */
    public Solution(Coords coords, int dirtsCleaned) {
        this.coords = coords;
        this.dirtsCleaned = dirtsCleaned;
    }
    
    /**
     * Checks that our solution matches another solution. Used in unit testing.
     * @param object
     * @return 
     */
    @Override
    public boolean equals(Object object){
        boolean isEqual = false;
        
        if (object != null && object instanceof Solution) {
            Solution other = (Solution)object;
            isEqual = coords.equals(other.getCoords()) &&
                      dirtsCleaned == other.getDirtsCleaned();
        }
        return isEqual;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.coords);
        hash = 71 * hash + this.dirtsCleaned;
        return hash;
    }
    
    /**
     * Getter for the position
     * @return Position
     */
    public Coords getCoords(){
        return coords;
    }
    
  
    public int getDirtsCleaned() {
        return dirtsCleaned;
    }
}
