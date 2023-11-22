package org.example;

import org.example.Controller.LightingController;
import org.example.ControllerImpl.LightsBrightnessController;
import org.example.ControllerImpl.LightsSwitchController;
import org.example.LightGrid.LightGrid;
import org.example.Entities.Point;

public class Main {
    public static void main(String[] args) {
        LightGrid lightGrid = new LightGrid(1000, 1000);
        LightGrid lightGrid1 = new LightGrid(1000,1000);
        
        LightingController lightsSwitchController = new LightsSwitchController(lightGrid);
        LightingController lightsBrightnessController = new LightsBrightnessController(lightGrid1);
        
        // Process the instructions
        String[] instructions = {
                "turn on 887,9 through 959,629",
                "turn on 454,398 through 844,448",
                "turn off 539,243 through 559,965",
                "turn off 370,819 through 676,868",
                "turn off 145,40 through 370,997",
                "turn off 301,3 through 808,453",
                "turn on 351,678 through 951,908",
                "toggle 720,196 through 897,994",
                "toggle 831,394 through 904,860"
        };
        
        for (String instruction : instructions) {
            String[] parts = instruction.split(" ");
            String operationType = parts[0];
            String operation;
            String[] startCoords;
            String[] endCoords;
            if (operationType.equals("turn")) {
                operation = parts[1];
                startCoords = parts[2].split(",");
                endCoords = parts[4].split(",");
            } else {
                operation = parts[0];
                startCoords = parts[1].split(",");
                endCoords = parts[3].split(",");
            }
            
            int startX = Integer.parseInt(startCoords[0]);
            int startY = Integer.parseInt(startCoords[1]);
            int endX = Integer.parseInt(endCoords[0]);
            int endY = Integer.parseInt(endCoords[1]);
            
            Point startingPoint = new Point(startX, startY);
            Point endingPoint = new Point(endX, endY);
            
            switch (operationType) {
                case "turn":
                    if (operation.equals("on")) {
                        lightsSwitchController.performTurnOn(startingPoint, endingPoint);
                        lightsBrightnessController.performTurnOn(startingPoint, endingPoint);
                    } else if (operation.equals("off")) {
                        lightsSwitchController.performTurnOff(startingPoint, endingPoint);
                        lightsBrightnessController.performTurnOff(startingPoint, endingPoint);
                    }
                    break;
                case "toggle":
                    lightsSwitchController.performToggle(startingPoint, endingPoint);
                    lightsBrightnessController.performToggle(startingPoint, endingPoint);
                    break;
            }
        }
        
        lightGrid.calculateTotalLightsTurnedOn();
        lightGrid1.calculateTotalBrightness();
    }
}
