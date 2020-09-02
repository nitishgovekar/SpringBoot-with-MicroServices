package com.confidentcoder.microservices.beans;

public class LimitsConfiguration {

private	int max;
private	int min;
	
	protected LimitsConfiguration() {
		
	}
	
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public LimitsConfiguration(int max, int min) {
		super();
		this.max = max;
		this.min = min;
	}
	
	
}
