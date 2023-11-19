package org.example.ControllerImpl;

import org.example.Controller.TurnLightsOff;
import org.example.Controller.TurnLightsOn;
import org.example.DataItems.Lights;
import org.example.DataItems.Points;

public class LightsOffController implements TurnLightsOff {

    private Lights lights;

    public LightsOffController(Lights lights) {
        this.lights = lights;
    }

    @Override
    public void performLightOffOperation(Points startPoint, Points endPoint, int[][] lightGrids) {
        for(int i= startPoint.getX();i< endPoint.getX(); i++){
            for (int j= startPoint.getY(); j < endPoint.getY(); j++){
                lightGrids[i][j] = 0;
            }
        }
        lights.setLightGrids(lightGrids);
    }
}

