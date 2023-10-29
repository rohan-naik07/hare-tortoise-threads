package com.gems.race;
import java.util.Calendar;
import java.util.Random;

/**
 * @author Rohan Naik
 * 
 * This is an implementation of the Hare class which is the child class of the 
 * Participant class.
 * The hare sleeps on any two random points on the track.
 *
 */

public class Hare extends Participant implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Random random = new Random();
		int sleepPoint=(random.nextInt()%7) + 5; 
		long startTime = Calendar.getInstance().getTimeInMillis();
		while(getPosition() < 49) {
			try {
				if(getPosition()==sleepPoint) {
					Thread.sleep(3000);
					sleepPoint=(random.nextInt()%7) + 20;
				} else {
					Thread.sleep(400);
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			setTrack(getPosition()+1,"H");
			setTrack(getPosition(),".");
			setPosition(getPosition() + 1);
		}
		setFinish(true);
		long endTime =  Calendar.getInstance().getTimeInMillis();
		setRunningTime(endTime-startTime);
	}

	public Hare() {
		// TODO Auto-generated constructor stub
		super("H");
	}

}
