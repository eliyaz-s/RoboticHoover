/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.robotichoover.model;

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
public class SolutionTest {
    
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    Solution instance;
    private Coords coords;
    private int dirtsCleaned;
    
    public SolutionTest() {
        this.instance = null;
    }
    
    @Before
    public void setUp() {
        coords = new Coords(new Point(1,2), new Room(5,5));
        dirtsCleaned = 2;
        instance = new Solution(coords, dirtsCleaned);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of equals method, of class Solution.
     */
    @Test
    public void testEquals() {
        Coords coordsTest = new Coords(new Point(1,2), new Room(5,5));
        int dirtsCleanedTest = 2;
        Solution sol = new Solution(coordsTest, dirtsCleanedTest);
        boolean expResult = true;
        boolean result = instance.equals(sol);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class Solution.
     */
    @Test
    public void testHashCode() {
        Coords coordsTest = new Coords(new Point(1,2), new Room(5,5));
        int dirtsCleanedTest = 2;
        Solution sol = new Solution(coordsTest, dirtsCleanedTest);
        int expResult = sol.hashCode();
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCoords method, of class Solution.
     */
    @Test
    public void testGetCoords() {
        Coords expResult = new Coords(new Point(1,2), new Room(5,5));
        Coords result = instance.getCoords();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDirtsCleaned method, of class Solution.
     */
    @Test
    public void testGetDirtsCleaned() {
        int expResult = 2;
        int result = instance.getDirtsCleaned();
        assertEquals(expResult, result);
    }
    
}
