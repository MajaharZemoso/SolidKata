package org.example.Controller;

import org.example.DataItems.Points;

public interface TogglingLights {

    public void performToggleOperation(Points startPoint, Points endPoint, int[][] lightGrids);
}
