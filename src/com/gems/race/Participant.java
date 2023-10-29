/**
 * 
 */
package com.gems.race;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rohan Naik
 * 
 * This is an implementation of the Participant class.
 * Hare and Tortoise are child classes of the Participant class
 *
 */

public abstract class Participant {
	private String symbol;
	private int position;
	private boolean finish;
	private double runningTime;
	private List<String> track;
	
	public Participant(String symbol) {
		// TODO Auto-generated constructor stub
		this.symbol = symbol;
		position = 0;
		runningTime = 0;
		track = new ArrayList<>();
		track.add(symbol);
		for(int i=1;i<50;i++) {
			track.add(".");
		}
	}
	
	public boolean isFinish() {
		return finish;
	}

	public void setFinish(boolean finish) {
		this.finish = finish;
	}

	protected int getPosition() {
		return position;
	}

	protected void setPosition(int position) {
		this.position = position;
	}

	protected String getSymbol() {
		return symbol;
	}

	protected void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public List<String> getTrack() {
		return track;
	}

	protected void setTrack(int position,String element) {
		track.set(position, element);
	}

	protected double getRunningTime() {
		return runningTime;
	}

	protected void setRunningTime(double runningTime) {
		this.runningTime = runningTime;
	}
	
	
	
}
