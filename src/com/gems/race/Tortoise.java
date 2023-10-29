package com.gems.race;
import java.util.Calendar;

/**
 * @author Rohan Naik
 * 
 * This is an implementation of the Tortoise class which is the child class of the 
 * Participant class.
 * The tortoise keeps moving at a slower pace than hare
 *
 */

public class Tortoise extends Participant implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		long startTime = Calendar.getInstance().getTimeInMillis();
		while(getPosition() < 49) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			setTrack(getPosition()+1,"T");
			setTrack(getPosition(),".");
			setPosition(getPosition()+1);
		}
		setFinish(true);
		long endTime = Calendar.getInstance().getTimeInMillis();
		setRunningTime(endTime-startTime);
	}
	
	public Tortoise() {
		// TODO Auto-generated constructor stub
		super("T");
	}

}
