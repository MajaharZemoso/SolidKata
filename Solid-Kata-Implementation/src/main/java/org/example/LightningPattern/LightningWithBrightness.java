package org.example.LightningPattern;

public class LightningWithBrightness {

    public void calculateTotalBrightness(int[][] lights){
        int brightness = 0;
        for (int[] row : lights) {
            for (int light : row) {
                brightness += light;
            }
        }
        System.out.println("Today Brightness of all lights: " + brightness);
    }
}
