/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.robotichoover.operation;

import com.mycompany.robotichoover.exception.InvalidDirectionException;
import com.mycompany.robotichoover.exception.InvalidNumberOfPointCoordsException;
import com.mycompany.robotichoover.exception.InvalidPointException;
import com.mycompany.robotichoover.exception.RoboticHooverCustomException;
import com.mycompany.robotichoover.model.Room;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author eliyaz
 */
public class RequestProcessorTest {
    
    private static final Logger LOGGER = LogManager.getLogger(RequestProcessor.class);
    private RequestProcessor instance;

    public RequestProcessorTest() {
        this.instance = new RequestProcessor();
    }

    
    /**
     * Test of processPosition method, of class RequestProcessor.
     */
    @Test
    public void testProcessPosition_valid_two_coords() throws Exception {
        LOGGER.info("testProcessPosition_valid_two_coords");
        List<Integer> coords = new ArrayList<>(Arrays.asList(1, 2));
        Point expResult = new Point(1,2);
        Point result = getInstance().processPosition(coords);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testProcessPosition_negative_coords() throws Exception {
        LOGGER.info("testProcessPosition_negative_coords");
        List<Integer> coords = new ArrayList<>(Arrays.asList(-1, -2));
        String expResult = "The position coordinates are not positive integers";
        try{
            getInstance().processPosition(coords);
        }catch(InvalidPointException ipe){
            assertEquals(expResult, ipe.getMessage());
        }
    }
    
    @Test
    public void testProcessPosition_three_coords() throws Exception {
        LOGGER.info("testProcessPosition_three_coords");
        List<Integer> coords = new ArrayList<>(Arrays.asList(1, 2, 3));
        String expResult = "Invalid number of position coordinates";
        try{
            getInstance().processPosition(coords);
        }catch(InvalidNumberOfPointCoordsException inopce){
            assertEquals(expResult, inopce.getMessage());
        }
    }
    
    

    /**
     * Test of processRoom method, of class RequestProcessor.
     */
    @Test
    public void testProcessRoom_square() throws Exception {
        LOGGER.info("testProcessRoom_square");
        List<Integer> roomSize = new ArrayList<>(Arrays.asList(5, 5));
        Room expResult = new Room(5,5);
        Room result = getInstance().processRoom(roomSize);
        assertEquals(expResult, result);
    }
    
        /**
     * Test of processRoom method, of class RequestProcessor.
     */
    @Test
    public void testProcessRoom_rectangular_room() throws Exception {
        LOGGER.info("testProcessRoom_rectangular_room");
        List<Integer> roomSize = new ArrayList<>(Arrays.asList(5, 6));
        Room expResult = new Room(5,6);
        Room result = getInstance().processRoom(roomSize);
        assertEquals(expResult, result);
    }

    /**
     * Test of processRoom method, of class RequestProcessor.
     */
    @Test
    public void testProcessRoom_negativeCoords() throws Exception {
        LOGGER.info("testProcessRoom_negativeCoords");
        List<Integer> roomSize = new ArrayList<>(Arrays.asList(-5, -6));
        String expResult = "The dimension coordinates are not positive integers";
        try{
            getInstance().processRoom(roomSize);
        }catch(InvalidPointException ipe){
            assertEquals(expResult, ipe.getMessage());
        }
    }
    
    /**
     * Test of processDirtPatches method, of class RequestProcessor.
     * @throws com.mycompany.robotichoover.exception.RoboticHooverCustomException
     */
    @Test
    public void testProcessDirtPatches() throws RoboticHooverCustomException {
        LOGGER.info("testProcessDirtPatches");
        List<Integer> coords0 = new ArrayList<>(Arrays.asList(1, 0));
        List<List<Integer>> patches = new ArrayList<>(Arrays.asList(coords0));
        RoomMap roomMap = new RoomMap(new Room(5,5));
        getInstance().processDirtPatches(patches, roomMap);
        assertTrue(roomMap.isDirty(1,0));
    }
    
    /**
     * Test of processHooveringInstructions method, of class RequestProcessor.
     */
    @Test
    public void testProcessHooveringInstructions() throws Exception {
        LOGGER.info("testProcessHooveringInstructions");
        String instructions = "NNESEESWNWW";
        String expResult = "[N, N, E, S, E, E, S, W, N, W, W]";
        getInstance().processHooveringInstructions(instructions);
        assertEquals(expResult, getInstance().getHooveringInstructions().toString());
    }
    
    @Test
    public void testProcessHooveringInstructions_withInvalidInstruction() {
        LOGGER.info("testProcessHooveringInstructions_withInvalidInstruction");
        String instructions = "NPESEESWNWW";
        try {
            getInstance().processHooveringInstructions(instructions);
        } catch (InvalidDirectionException ide) {
            assertEquals("Invalid direction was given as part of the movements list", ide.getMessage());
        }
    }

    /**
     * @return the instance
     */
    public RequestProcessor getInstance() {
        return instance;
    }

    /**
     * @param instance the instance to set
     */
    public void setInstance(RequestProcessor instance) {
        this.instance = instance;
    }

}
