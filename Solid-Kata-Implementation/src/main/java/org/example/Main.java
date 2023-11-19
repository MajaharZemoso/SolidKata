package org.example;

import org.example.Controller.TogglingLights;
import org.example.Controller.TurnLightsOff;
import org.example.Controller.TurnLightsOn;
import org.example.ControllerImpl.*;
import org.example.DataItems.Lights;
import org.example.DataItems.Points;
import org.example.LightningPattern.Lightning;
import org.example.LightningPattern.LightningWithBrightness;

public class Main {
    public static void main(String[] args) {
        Lights lights = new Lights();
        
        lights.setLightsDefaultValue();
        
        //Commented Part 1 implementation

        TurnLightsOn onController = new LightsOnController(lights);
        TurnLightsOff offController = new LightsOffController(lights);
        TogglingLights toggleController = new LightsTogglingController(lights);

        Lightning finalLightning = new Lightning();
        
        //TurnLightsOn brightnessOnController = new LightsBrightnessOnController(lights);
        //TurnLightsOff brightnessOffController = new LightsBrightnessOffController(lights);
        //TogglingLights brightnessToggleController =  new LightsBrightnessTogglingController(lights);
        
        LightningWithBrightness lightningWithBrightness = new LightningWithBrightness();
        
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
            if (parts[0].equals("turn")) {
                if (parts[1].equals("on")) {
                    String[] startCords = parts[2].split(",");
                    String[] endCords = parts[4].split(",");
                    int startX = Integer.parseInt(startCords[0]);
                    int startY = Integer.parseInt(startCords[1]);
                    int endX = Integer.parseInt(endCords[0]);
                    int endY = Integer.parseInt(endCords[1]);
                    
                    Points startingPoint = new Points(startX, startY);
                    Points endingPoint = new Points(endX, endY);
                    
                    onController.performOnOperation(startingPoint, endingPoint, lights.getLightGrids());
                    //brightnessOnController.performOnOperation(startingPoint, endingPoint, lights.getLightGrids());
                } else if (parts[1].equals("off")) {
                    
                    String[] startCords = parts[2].split(",");
                    String[] endCords = parts[4].split(",");
                    int startX = Integer.parseInt(startCords[0]);
                    int startY = Integer.parseInt(startCords[1]);
                    int endX = Integer.parseInt(endCords[0]);
                    int endY = Integer.parseInt(endCords[1]);
                    
                    Points startingPoint = new Points(startX, startY);
                    Points endingPoint = new Points(endX, endY);
                    
                    offController.performLightOffOperation(startingPoint, endingPoint, lights.getLightGrids());
                    //brightnessOffController.performLightOffOperation(startingPoint, endingPoint, lights.getLightGrids());
                }
            } else if (parts[0].equals("toggle")) {
                String[] startCords = parts[1].split(",");
                String[] endCords = parts[3].split(",");
                int startX = Integer.parseInt(startCords[0]);
                int startY = Integer.parseInt(startCords[1]);
                int endX = Integer.parseInt(endCords[0]);
                int endY = Integer.parseInt(endCords[1]);
                
                Points startingPoint = new Points(startX, startY);
                Points endingPoint = new Points(endX, endY);
                
                toggleController.performToggleOperation(startingPoint, endingPoint, lights.getLightGrids());
                //brightnessToggleController.performToggleOperation(startingPoint, endingPoint, lights.getLightGrids());
                
            }
        }
        
        finalLightning.calculateTotalLightsTurnedOn(lights.getLightGrids());
        //lightningWithBrightness.calculateTotalBrightness(lights.getLightGrids());
    }
}