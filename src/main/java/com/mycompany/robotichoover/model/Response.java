/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.robotichoover.model;

/**
 *
 * @author eliyaz
 */
public class Response {
    
    private int [] coords ;
    private int patches ;
    
    public Response(){
        
    }
    public Response(Solution solution){
        int x = (int) solution.getCoords().getX();
        int y = (int) solution.getCoords().getY();
        coords = new int[]{x,y};
        patches = solution.getDirtsCleaned();
    }
    /**
     * @return the coords
     */
    public int[] getCoords() {
        return coords;
    }

    /**
     * @param coords the coords to set
     */
    public void setCoords(int[] coords) {
        this.coords = coords;
    }

    /**
     * @return the patches
     */
    public int getPatches() {
        return patches;
    }

    /**
     * @param patches the patches to set
     */
    public void setPatches(int patches) {
        this.patches = patches;
    }

}
