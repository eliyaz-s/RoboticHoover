/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.robotichoover.model;

import java.awt.Point;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author eliyaz
 */
public class RoomTest {

    private Room invalidRoom;
    private Room room;
    
    public RoomTest() {
        this.room = null;
        invalidRoom = null;
    }
    
    
    @Before
    public void setUp() {
        room = new Room(new Point(1,2));
        invalidRoom = new Room(new Point(1,-1));
    }
    
    /**
     * Test of isValid method, of class Room.
     */
    @Test
    public void testIsValid() {
        boolean expResult = true;
        boolean result = room.isValid();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isValid method, of class Room.
     */
    @Test
    public void testIsValid_withInvalidData() {
        boolean expResult = false;
        boolean result = invalidRoom.isValid();
        assertEquals(expResult, result);
    }
}
