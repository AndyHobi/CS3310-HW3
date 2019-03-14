package edu.wmich.CS3310.HW3;

public class Stopwatch {
	
	long[] startTime;
	long[] elapsedTime;
	boolean[] state;
	
	boolean highDef = true;
	
	Stopwatch() {
		
		startTime = new long[10];
		elapsedTime = new long[10];
		state = new boolean[10];
		
	}
	
	public void start(int timer) {
		if(highDef) {
			startTime[timer] = System.nanoTime();
		} else {
			startTime[timer] = System.currentTimeMillis();
		}
		
		state[timer] = true;
		
	}
	
	public long stop(int timer) {
		if(highDef) {
			elapsedTime[timer] += System.nanoTime() - startTime[timer];
		} else {
			elapsedTime[timer] += System.currentTimeMillis() - startTime[timer];
		}
		
		state[timer] = false;
		
		return elapsedTime[timer];
		
	}
	
	public long reset(int timer) {
		
		long time = stop(timer);
		elapsedTime[timer] = 0;
		
		return time;
		
	}
	
	public long getTime(int timer) {
		
		if(state[timer]) {
			return elapsedTime[timer] + (System.nanoTime() - startTime[timer]);
		} else {
			return elapsedTime[timer];
		}
		
	}

	
	
}
