package org.example.ControllerImpl;

import org.example.Controller.TurnLightsOn;
import org.example.DataItems.Lights;
import org.example.DataItems.Points;

public class LightsOnController implements TurnLightsOn {

    private Lights lights;

    public LightsOnController(Lights lights) {
        this.lights = lights;
    }

    @Override
    public void performOnOperation(Points startPoint, Points endPoint, int[][] light) {
        for(int i= startPoint.getX();i< endPoint.getX(); i++){
            for (int j= startPoint.getY(); j< endPoint.getY(); j++){
                light[i][j] = 1;
            }
        }
        lights.setLightGrids(light);
    }
}
