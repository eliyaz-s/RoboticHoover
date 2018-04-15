package com.mycompany.robotichoover.operation;

import java.util.LinkedList;

import com.mycompany.robotichoover.validation.IValidation;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * HooverInstructions is a series of directions to follow on the map. 
 */
public class HooverInstructions extends LinkedList<Character> implements IValidation {

    private static final long serialVersionUID = 1L;

    private char[] instructionsArray;

    /**
     * Constructor
     *
     * @param instructions The hoovering instructions as a string
     */
    public HooverInstructions(String instructions) {
        instructionsArray = instructions.toCharArray();
        for (int index = 0; index < instructionsArray.length; index++) {
            add(instructionsArray[index]);
        }
    }

    HooverInstructions() {
    }

    @Override
    public boolean isValid() {
        if (size() < 1) {
            return false;
        }
        boolean isValid = true;
        Character direction;
        ArrayList<Character> validInstructions;
        validInstructions = new ArrayList<>(Arrays.asList('N', 'S', 'E', 'W'));
        for (int i = 0; i < instructionsArray.length; i++) {
            direction = instructionsArray[i];
            if(!validInstructions.contains(direction)){
                return false;
            }
        }
        return isValid;
    }

    /**
     * @return the instructionsArray
     */
    public char[] getInstructionsArray() {
        return instructionsArray;
    }

    /**
     * @param instructionsArray the instructionsArray to set
     */
    public void setInstructionsArray(char[] instructionsArray) {
        this.instructionsArray = instructionsArray;
    }
}
