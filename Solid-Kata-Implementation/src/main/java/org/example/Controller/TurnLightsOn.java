package org.example.Controller;

import org.example.DataItems.Points;

public interface TurnLightsOn {

    public void performOnOperation(Points startPoint, Points endPoint, int[][] lightGrids);
}
