/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.robotichoover.operation;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author eliyaz
 */
public class HooverInstructionsTest {
    
    
    private HooverInstructions instance;
    public HooverInstructionsTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of isValid method, of class HooverInstructions.
     */
    @Test
    public void testIsValid() {
        instance = new HooverInstructions("NNEESSWNSW");
        boolean expResult = true;
        boolean result = instance.isValid();
        assertEquals(expResult, result);
    }
    
        /**
     * Test of isValid method, of class HooverInstructions.
     */
    @Test
    public void testIsValid_withInvalidInstructions() {
        instance = new HooverInstructions("NNEESSWNSWP");
        boolean expResult = false;
        boolean result = instance.isValid();
        assertEquals(expResult, result);
    }


    /**
     * Test of setInstructionsArray method, of class HooverInstructions.
     */
    @Test
    public void testSetAndGetInstructionsArray() {
        char[] instructionsArray = {'N','E','S','W'};
        instance = new HooverInstructions();
        instance.setInstructionsArray(instructionsArray);
        Assert.assertArrayEquals(instance.getInstructionsArray(),instructionsArray);
    }
    
}
