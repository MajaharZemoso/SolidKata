package org.example.Controller;

import org.example.DataItems.Points;

public interface TurnLightsOff {
    public void performLightOffOperation(Points startPoint, Points endPoint, int[][] lightGrids);
}
