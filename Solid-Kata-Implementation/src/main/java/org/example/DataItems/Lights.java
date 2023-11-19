package org.example.DataItems;

public class Lights {

    private static final int rows = 1000;

    private static final int columns = 1000;

    private int[][] lightGrids = new int[rows][columns];

    public void setLightsDefaultValue(){
        for (int i =0 ; i<rows ; i++){
            for (int j =0; j<columns; j++){
                lightGrids[i][j] = 0; // light is off
            }
        }
    }

    public int[][] getLightGrids() {
        return lightGrids;
    }

    public void setLightGrids(int[][] lightGrids) {
        this.lightGrids = lightGrids;
    }

}
