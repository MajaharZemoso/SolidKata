package org.example.ControllerImpl;

import org.example.Controller.LightingController;
import org.example.LightGrid.LightGrid;
import org.example.Entities.Point;

public class LightsSwitchController implements LightingController {
    
    private LightGrid lightGrid;
    
    public LightsSwitchController(LightGrid lightGrid) {
        this.lightGrid = lightGrid;
    }
    
    @Override
    public void performTurnOn(Point startPoint, Point endPoint) {
        lightGrid.lightOperation(startPoint, endPoint, "first", "on", 1);
    }
    
    @Override
    public void performTurnOff(Point startPoint, Point endPoint) {
        lightGrid.lightOperation(startPoint, endPoint, "first", "off", 0);
    }
    
    @Override
    public void performToggle(Point startPoint, Point endPoint) {
        lightGrid.lightOperation(startPoint, endPoint, "first", "toggle", 0);
    }
}
