package org.example.LightningPattern;

public class Lightning {


    public void calculateTotalLightsTurnedOn(int[][] lights){
        int count = 0;
        for (int[] row : lights) {
            for (int light : row) {
                if (light==1) {
                    count++;
                }
            }
        }
        System.out.println("Today Number of lights turned on are: " + count);
    }
}
