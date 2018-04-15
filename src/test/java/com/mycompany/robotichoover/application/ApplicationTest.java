/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.robotichoover.application;

import com.mycompany.robotichoover.service.RoboticHooverService;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author eliyaz
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTest {

    @Autowired
    RoboticHooverService roboticHooverService;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() throws Exception {
        assertNotNull(roboticHooverService);
    }

    /**
     * Test of getLocationAndPatches method, of class RoboticHooverService.
     */
    @Test
    public void testApplication() throws Exception {
        String url = "http://localhost:" + port + "/clean";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        String requestMsg = new String("{\n"
                + "  \"roomSize\" : [5, 5],\n"
                + "  \"coords\" : [1, 2],\n"
                + "  \"patches\" : [\n"
                + "    [1, 0],\n"
                + "    [1, 2],\n"
                + "    [2, 3]\n"
                + "  ],\n"
                + "  \"instructions\" : \"NNESEESWNWW\"\n"
                + "}");
        HttpEntity<String> entity = new HttpEntity<String>(requestMsg ,headers);
        String response = this.restTemplate.postForObject(url, entity, String.class);
        String expected = "{\"coords\":[1,3],\"patches\":2}";
        assertEquals(expected, response);
    }

}
