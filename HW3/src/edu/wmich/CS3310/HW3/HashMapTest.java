package edu.wmich.CS3310.HW3;

import java.util.LinkedList;

public class HashMapTest {

	String[] keys;
	LinkedList<Integer>[] IDs;
	String[] IDRef;
	
	int m; // This is the size of the Map
	
	
	@SuppressWarnings("unchecked")
	HashMapTest(int mapSize) {
		
		m = mapSize;
		keys = new String[m];
		IDs = new LinkedList[m];
		IDRef = new String[10];	
			
	}
	
	public void add(String Data, String Key) {
		
		
		
	}
	
	public String search(String key) {
		
		return null;
		
	}
	
	public Integer CompareTo() {
		return m;
	}
	
	public String toString() {
		return null;
	}
	
}
