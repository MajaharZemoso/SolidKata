package org.example.Entities;

public class Light {
	private int value;
	public Light(int value) {
		this.value = value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getValue() {
		return value;
	}
	public void toggle() {
		value = (value == 0) ? 1 : 0;
	}
}
