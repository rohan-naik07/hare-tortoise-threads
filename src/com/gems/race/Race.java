/**
 * 
 */
package com.gems.race;

import java.util.List;

/**
 * @author Rohan Naik
 * 
 * This is an implementation of the Race class which spawns two threads representing the hare 
 * and the tortoise.
 * The display of the two tracks is handled by the main thread.
 *
 */
public class Race {
	private Hare hare;
	private Tortoise tortoise;
	private String winner;
	
	public Race(int hareId,int tortoiseId) {
		// TODO Auto-generated constructor stub
		hare = new Hare();
		tortoise = new Tortoise();
		this.winner = null;
	}
	
	public Race() {
		this(1,1);
	}
	
	private String getWinner() {
		return winner;
	}

	private void setWinner(String winner) {
		this.winner = winner;
	}

	public void start() {
		Thread hareThread = new Thread(hare);
		Thread tortoiseThread = new Thread(tortoise);
		hareThread.start();
		tortoiseThread.start();
		while(hare.isFinish()==false && tortoise.isFinish()==false) {
			System.out.println(System.lineSeparator().repeat(10));
			printTrack(hare.getTrack());
			printTrack(tortoise.getTrack());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			hareThread.join();
			tortoiseThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setWinner(hare.getRunningTime() > tortoise.getRunningTime() ? "Tortoise" : "Hare");
		System.out.println("Winner is " + getWinner());
	}
	
	private void printTrack(List<String> track)  {
		for(int i=0;i<50;i++) {
			System.out.print(track.get(i));
		}
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}

}
