package edu.wmich.CS3310.HW3;

public class Stopwatch {
	
	long[] startTimes;
	long[] endTimes;
	
	boolean highDef = true;
	
	Stopwatch() {
		
		startTimes = new long[10];
		endTimes = new long[10];
		
	}
	
	public void start(int timer) {
		if(highDef) {
			startTimes[timer] = System.nanoTime();
		} else {
			startTimes[timer] = System.currentTimeMillis();
		}
		
		endTimes[timer] = startTimes[timer];
		
	}
	
	public long stop(int timer) {
		if(highDef) {
			endTimes[timer] = System.nanoTime();
		} else {
			endTimes[timer] = System.currentTimeMillis();
		}
		
		return getTime(timer);
		
	}
	
	public long getTime(int timer) {
		return endTimes[timer] - startTimes[timer];
	}

	
	
}
