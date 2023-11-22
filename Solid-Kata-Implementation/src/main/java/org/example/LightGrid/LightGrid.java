package org.example.LightGrid;

import org.example.Entities.Light;
import org.example.Entities.Point;

public class LightGrid {
	
	private int rows;
	private int columns;
	private Light[][] lightGrid;
	
	public LightGrid(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		this.lightGrid = new Light[rows][columns];
		initializeLightGrid();
	}
	
	public Light[][] getLightGrid() {
		return lightGrid;
	}
	
	public void setLightGrid(Light[][] lightGrid) {
		this.lightGrid = lightGrid;
	}
	
	private void initializeLightGrid() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				lightGrid[i][j] = new Light(0);
			}
		}
	}
	
	public void lightOperation(Point startPoint, Point endPoint, String type, String operation, int value) {
		int startRow = Math.max(startPoint.getX(), 0);
		int endRow = Math.min(endPoint.getX(), rows);
		int startCol = Math.max(startPoint.getY(), 0);
		int endCol = Math.min(endPoint.getY(), columns);
		
		if ("first".equals(type)) {
			for (int i = startRow; i < endRow; i++) {
				for (int j = startCol; j < endCol; j++) {
					if ("on".equals(operation) || "off".equals(operation)) {
						lightGrid[i][j].setValue(value);
					} else {
						lightGrid[i][j].toggle();
					}
				}
			}
		} else {
			for (int i = startRow; i < endRow; i++) {
				for (int j = startCol; j < endCol; j++) {
					lightGrid[i][j].setValue(lightGrid[i][j].getValue() + value);
				}
			}
		}
	}
	
	public void calculateTotalLightsTurnedOn(){
		int count = 0;
		for (Light[] row : lightGrid) {
			for (Light light : row) {
				if (light.getValue()==1) {
					count++;
				}
			}
		}
		System.out.println("Today Number of lights turned on are: " + count);
	}
	
	public void calculateTotalBrightness(){
		int brightness = 0;
		for (Light[] row : lightGrid) {
			for (Light light : row) {
				brightness += light.getValue();
			}
		}
		System.out.println("Today Brightness of all lights: " + brightness);
	}
}

