package org.example.ControllerImpl;

import org.example.Controller.TogglingLights;
import org.example.DataItems.Lights;
import org.example.DataItems.Points;

public class LightsBrightnessTogglingController implements TogglingLights {
    private Lights lights;

    public LightsBrightnessTogglingController(Lights lights) {
        this.lights = lights;
    }


    @Override
    public void performToggleOperation(Points startPoint, Points endPoint, int[][] lightGrids) {
        for(int i= startPoint.getX();i< endPoint.getX(); i++){
            for (int j= startPoint.getY(); j< endPoint.getY(); j++){
                lightGrids[i][j] += 2;
            }
        }
        lights.setLightGrids(lightGrids);
    }
}
