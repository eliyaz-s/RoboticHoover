/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.robotichoover.service;

import com.mycompany.robotichoover.operation.RoboticHoover;
import com.mycompany.robotichoover.model.Solution;
import com.mycompany.robotichoover.model.Request;
import com.mycompany.robotichoover.operation.RequestProcessor;
import com.mycompany.robotichoover.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author eliyaz
 */
@Controller
public class RoboticHooverService {
    
    @Autowired
    private RequestProcessor reqProcessor;
    
    @RequestMapping(value = "/clean", method = RequestMethod.POST)
    @ResponseBody
    public Response getLocationAndPatches(@RequestBody Request request) throws Exception{
        getReqProcessor().processRequest(request);
        RoboticHoover roboticHoover = new RoboticHoover(getReqProcessor().getRoomMap(), getReqProcessor().getPosition());
        Solution solution = roboticHoover.clean(getReqProcessor().getHooveringInstructions());
        return new Response(solution);
    }

    /**
     * @return the reqProcessor
     */
    public RequestProcessor getReqProcessor() {
        return reqProcessor;
    }

    /**
     * @param reqProcessor the reqProcessor to set
     */
    public void setReqProcessor(RequestProcessor reqProcessor) {
        this.reqProcessor = reqProcessor;
    }



}
