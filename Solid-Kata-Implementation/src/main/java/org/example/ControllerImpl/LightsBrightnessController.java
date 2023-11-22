package org.example.ControllerImpl;

import org.example.Controller.LightingController;
import org.example.LightGrid.LightGrid;
import org.example.Entities.Point;

public class LightsBrightnessController implements LightingController {
    
    private LightGrid lightGrid;
    
    public LightsBrightnessController(LightGrid lightGrid) {
        this.lightGrid = lightGrid;
    }
    
    @Override
    public void performTurnOn(Point startPoint, Point endPoint) {
        lightGrid.lightOperation(startPoint, endPoint, "second", "on", 1);
    }
    
    @Override
    public void performTurnOff(Point startPoint, Point endPoint) {
        lightGrid.lightOperation(startPoint, endPoint, "second", "off", 1);
    }
    
    @Override
    public void performToggle(Point startPoint, Point endPoint) {
        lightGrid.lightOperation(startPoint, endPoint, "second", "toggle", 2);
    }
}