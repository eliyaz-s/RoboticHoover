/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.robotichoover.operation;

import com.mycompany.robotichoover.exception.RoboticHooverCustomException;
import com.mycompany.robotichoover.exception.InvalidDirectionException;
import com.mycompany.robotichoover.exception.InvalidNumberOfPointCoordsException;
import com.mycompany.robotichoover.exception.InvalidPointException;
import com.mycompany.robotichoover.model.Coords;
import com.mycompany.robotichoover.model.Request;
import com.mycompany.robotichoover.model.Room;
import java.awt.Point;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 *
 * @author eliyaz
 */
@Component
public class RequestProcessor {
    private static final Logger LOGGER = LogManager.getLogger(RequestProcessor.class);

    private Room room = null;
    private Coords coords = null;
    private RoomMap roomMap = null;
    private HooverInstructions hooverInstructions = null;
    
    public void processRequest(Request request) throws Exception{
        LOGGER.debug("Processing request", request);
        room = processRoom(request.getRoomSize());
        coords = processPoint(request.getCoords());
        roomMap = new RoomMap(room);
        processDirtPatches(request.getPatches(), roomMap);
        processHooveringInstructions(request.getInstructions());
    }
    
    /**
     * A generic process method to be used by various entities.
     * 
     * @return Point  Point to be processed
     * @throws RoboticHooverCustomException
     */
    private Coords processPoint(List<Integer> pointList) throws RoboticHooverCustomException {
        Point point = null;
        // Make sure we only have one x and one y 
        if (pointList.size() == 2) {
            try {
                // Must be integers
                int x = pointList.get(0);  
                int y = pointList.get(1);
                    
                // There should not be any point with negative coordinates. 
                // Throw a generic error and will be caught just after.
                if (x < 0 || y < 0 ) {
                    throw new RoboticHooverCustomException("Point has negative coordinates");
                }
                    
                point = new Point(x, y);
            } catch (NumberFormatException | RoboticHooverCustomException e) {
                    throw new InvalidPointException(e.getMessage());
            }
        } else {
            throw new InvalidNumberOfPointCoordsException();
        }
        return new Coords(point, room);
    }

    
    /**
     * Method to process our position.
     * 
     * @param coords
     * @return Point          Position converted to a point
     * @throws RoboticHooverCustomException  Position should be consisted of two positive integer 
     *                        coordinates
     */    
    public Point processPosition(List<Integer> coords) throws RoboticHooverCustomException {
        LOGGER.debug("Process position of coords");
        Point position = null;
        
        try {
            position = processPoint(coords);
        } catch (InvalidNumberOfPointCoordsException itopce) {
            LOGGER.error("Invalid number of position coordinates", itopce);
            throw new InvalidNumberOfPointCoordsException(
                                       "Invalid number of position coordinates",
                                       itopce);
        } catch (InvalidPointException ipe) {
            LOGGER.error("The position coordinates are not positive integers", ipe);
            throw new InvalidPointException(
                           "The position coordinates are not positive integers",
                           ipe);
        }
        return position;
    }
    
    /**
     * Method to process our dimensions.
     * 
     * @param roomSize
     * @return Point          Dimensions converted to a point
     * @throws RoboticHooverCustomException  Dimensions should be consisted of two numbers, and
     *                        be positive integers
     */
    public Room processRoom(List<Integer> roomSize) throws RoboticHooverCustomException {
        LOGGER.debug("Processing roomsize");
        Point dimensionsPoint = null;
        try {
            dimensionsPoint = processPoint(roomSize);
        } catch (InvalidNumberOfPointCoordsException inopce) {
            LOGGER.error("Invalid number of dimension coordinates", inopce);
            throw new InvalidNumberOfPointCoordsException(
                                      "Invalid number of dimension coordinates",
                                      inopce);
        } catch (InvalidPointException ipe) {
            LOGGER.error("The dimension coordinates are not positive integers", ipe);
            throw new InvalidPointException(
                          "The dimension coordinates are not positive integers",
                          ipe);
        }
        return new Room(dimensionsPoint);
    }
    
    /**
     * Method to process patches of dirt.
     *  
     * @param patches
     * @param roomMap
     * @throws RoboticHooverCustomException  Dirt should be consisted of two positive integer 
     *                        coordinates
     */
    public void processDirtPatches(List<List<Integer>> patches, RoomMap roomMap) throws RoboticHooverCustomException {
        LOGGER.debug("Processing dirt patches");
        Point patchPoint = null;
        try {
            for(int i = 0; i < patches.size(); i ++){
                List<Integer> patch = patches.get(i);
                patchPoint = processPoint(patch);
                roomMap.applyDirtPatch(patchPoint);
            }
        } catch (InvalidNumberOfPointCoordsException inopce) {
            LOGGER.error("Invalid number of dirt coordinates", inopce);
            throw new InvalidNumberOfPointCoordsException(
                                      "Invalid number of dirt coordinates",
                                      inopce);
        } catch (InvalidPointException ipe) {
            LOGGER.error("The dirt coordinates are not positive integers", ipe);
            throw new InvalidPointException(
                               "The dirt coordinates are not positive integers",
                               ipe);
        }
    }

    /**
     * Method to process our driving instructions.
     *  
     * @param instructions 
     * @throws com.mycompany.robotichoover.exception.InvalidDirectionException 
     */
    public void processHooveringInstructions(String instructions) 
                                              throws InvalidDirectionException {
        LOGGER.debug("Processing hoovering instructions",instructions);

        hooverInstructions = new HooverInstructions(instructions);
        if (!hooverInstructions.isValid()) {
            LOGGER.error("Invalid hovering instructions");
            throw new InvalidDirectionException();
        }
    }
    
    /**
     * Getter for dimensions.
     * @return Room.   The room of the map
     */
    public Room getRoom() {
        return room;
    }
    
    /**
     * Getter for position.
     * @return Position  The position of the robot
     */
    public Coords getPosition() {
        return coords;
    }

    /**
     * Getter for the map
     * @return Map  Our map
     */
    public RoomMap getRoomMap() {
        return roomMap;
    }
    
    /**
     * Getter for the Hoover instructions
     * @return HooverInstructions 
     */    
    public HooverInstructions getHooveringInstructions() {
        return hooverInstructions;
    }
}
