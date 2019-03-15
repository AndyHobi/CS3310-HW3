package edu.wmich.CS3310.HW3;

import java.util.LinkedList;

public class HashMap<T> {

	String[] keys;
	LinkedList<T>[] hashMap;

	int m; // This is the size of the Map

	HashMap(int mapSize) {

			m = mapSize;
			keys = new String[m];
			hashMap = new LinkedList[m];

		}

	public void add(T data, String... keys) {

		for (String key : keys) {

			int keyIndex = getIndex(key);

			this.keys[keyIndex] = key;

			if (hashMap[keyIndex] == null) {
				hashMap[keyIndex] = new LinkedList<T>();
			}

			hashMap[keyIndex].add(data);

		}

	}

	public LinkedList<T> search(String key) {

		return getItems(getIndex(key));

	}

	public int CompareTo(HashMap<T> map) {
		
		if(map.m == this.m) {
			
			
			
		} else {
			return this.m - map.m;
		}
		
		return m;
	}

	public String toString() {
		return null;
	}

	// ====== PRIVATE METHODS ======

	private LinkedList<T> getItems(int index) {
		
		return hashMap[index];
		
	}

	private int getIndex(String key) { // using quadratic probing

		int hash = Math.abs(key.hashCode()) % m;
		int index = hash;
		int k = 1;
		
		do {
			String currKey = keys[index];
			if (currKey == null || currKey.compareTo(key) == 0) {
				return index;
			} else {
				index += k^2;
			}

			if (index >= m) {
				index %= m;
			}
			
			k++;

		} while (k < m);

		return -1;

	}

}
