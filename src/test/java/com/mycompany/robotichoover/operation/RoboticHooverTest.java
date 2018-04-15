/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.robotichoover.operation;

import com.mycompany.robotichoover.exception.InvalidDirtCoordinatesException;
import com.mycompany.robotichoover.model.Coords;
import com.mycompany.robotichoover.model.Room;
import com.mycompany.robotichoover.model.Solution;
import java.awt.Point;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author eliyaz
 */
public class RoboticHooverTest {

    HooverInstructions hooverInstructions;
    Room room;
    RoomMap map;
    Coords coords;
    Point dirtPatch;


    @Before
    public void setUp() throws InvalidDirtCoordinatesException {
        hooverInstructions = new HooverInstructions("NNESEESWNWW");
        room = new Room(5, 5);
        map = new RoomMap(room);
        coords = new Coords(1, 2, room);
        dirtPatch = new Point(1, 3);
        map.applyDirtPatch(dirtPatch);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of clean method, of class RoboticHoover.
     *
     * @throws
     * com.mycompany.robotichoover.exception.InvalidDirtCoordinatesException
     */
    @Test
    public void testClean() throws InvalidDirtCoordinatesException {

        RoboticHoover instance = new RoboticHoover(map, coords);
        Solution expResult = new Solution(new Coords(dirtPatch, room), 1);
        Solution result = instance.clean(hooverInstructions);
        assertEquals(expResult, result);
    }

}
