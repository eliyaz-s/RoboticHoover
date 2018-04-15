/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.robotichoover.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author eliyaz
 */
public class ResponseTest {
    
    Response response;
    
    public ResponseTest() {
        this.response = new Response();
    }
    
    @Before
    public void setUp() {
        int[] coords = {1,2};
        response.setCoords(coords);
        response.setPatches(1);
    }
    
    /**
     * Test of getCoords method, of class Response.
     */
    @Test
    public void testGetCoords() {
        int[] expResult = {1,2};
        int[] result = response.getCoords();
        assertArrayEquals(expResult, result);
    }


    /**
     * Test of getPatches method, of class Response.
     */
    @Test
    public void testGetPatches() {
        int expResult = 1;
        int result = response.getPatches();
        assertEquals(expResult, result);
    }

    
}
