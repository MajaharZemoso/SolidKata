package org.example.ControllerImpl;

import org.example.Controller.TurnLightsOn;
import org.example.DataItems.Lights;
import org.example.DataItems.Points;

public class LightsBrightnessOnController implements TurnLightsOn {

    private Lights lights;

    public LightsBrightnessOnController(Lights lights) {
        this.lights = lights;
    }
    @Override
    public void performOnOperation(Points startPoint, Points endPoint, int[][] lightGrids) {
        for(int i= startPoint.getX();i< endPoint.getX(); i++){
            for (int j= startPoint.getY(); j < endPoint.getY(); j++){
                lightGrids[i][j] += 1;
            }
        }
        lights.setLightGrids(lightGrids);
    }
}
