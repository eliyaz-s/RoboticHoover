/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.robotichoover.operation;

import com.mycompany.robotichoover.exception.InvalidDirtCoordinatesException;
import com.mycompany.robotichoover.model.Coords;
import com.mycompany.robotichoover.model.Room;
import java.awt.Point;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author eliyaz
 */
public class RoomMapTest {
    
    HooverInstructions hooverInstructions;
    Room room;
    RoomMap map;
    Coords coords;
    Point dirtPatch;
    
    public RoomMapTest() throws InvalidDirtCoordinatesException {
        hooverInstructions = new HooverInstructions("NNESEESWNWW");
        room = new Room(5, 5);
        map = new RoomMap(room);
        coords = new Coords(1, 2, room);
        dirtPatch = new Point(1, 3);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of applyDirtPatch method, of class RoomMap.
     */
    @Test
    public void testApplyDirtPatch_Point() throws Exception {
        map.applyDirtPatch(new Point(1,2));
        assertTrue(map.isDirty(1,2));
    }

    /**
     * Test of applyDirtPatch method, of class RoomMap.
     */
    @Test
    public void testApplyDirtPatch_int_int() throws Exception {
        int x = 1;
        int y = 3;
        map.applyDirtPatch(x, y);
        assertTrue(map.isDirty(1,3));
    }

    /**
     * Test of isValid method, of class RoomMap.
     */
    @Test
    public void testIsValid() {
        boolean expResult = true;
        boolean result = map.isValid();
        assertEquals(expResult, result);
    }
    
}
