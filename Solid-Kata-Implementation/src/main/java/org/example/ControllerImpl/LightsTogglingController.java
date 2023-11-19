package org.example.ControllerImpl;

import org.example.Controller.TogglingLights;
import org.example.DataItems.Lights;
import org.example.DataItems.Points;

public class LightsTogglingController implements TogglingLights {

    private Lights lights;

    public LightsTogglingController(Lights lights) {
        this.lights = lights;
    }

    @Override
    public void performToggleOperation(Points startPoint, Points endPoint, int[][] lightGrids) {
        for(int i= startPoint.getX();i< endPoint.getX(); i++){
            for (int j= startPoint.getY(); j< endPoint.getY(); j++){
                if(lightGrids[i][j]== 0)
                    lightGrids[i][j] = 1;
                else if (lightGrids[i][j] == 1)
                    lightGrids[i][j] = 0;
            }
        }
        lights.setLightGrids(lightGrids);
    }
}
