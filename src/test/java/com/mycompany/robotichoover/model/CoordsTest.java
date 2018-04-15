/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.robotichoover.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author eliyaz
 */
public class CoordsTest {
    
    /**
     * Test of isValid method, of class Coords.
     */
    @Test
    public void testIsValid() {
        Room room = new Room(5,5);
        Coords instance = new Coords(1,2,room);
        assertTrue(instance.isValid());
    }
    
    @Test
    public void testIsValid_withInvalidData() {
        Room room = new Room(1,1);
        Coords instance = new Coords(1,2,room);
        assertFalse(instance.isValid());
    }
    
    @Test
    public void testIsValid_withNullDimensions() {
        Coords instance = new Coords(1,2,null);
        assertFalse(instance.isValid());
    }
    
}
