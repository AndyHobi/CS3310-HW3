package edu.wmich.CS3310.HW3;

import java.util.Iterator;
import java.util.LinkedList;

public class HashMapTest {

	String[] keys;
	LinkedList<Integer>[] hashMap;
	String[] IDRef;

	int m; // This is the size of the Map
	int nextRef; // next index for IDRef

	HashMapTest(int mapSize) {

		m = mapSize;
		keys = new String[m];
		hashMap = new LinkedList[m];
		IDRef = new String[100];
		nextRef = 0;

	}

	public void add(String data, String... keys) {

		IDRef[nextRef] = data;

		for (String key : keys) {

			int keyIndex = getIndex(key);

			this.keys[keyIndex] = key;

			if (hashMap[keyIndex] == null) {
				hashMap[keyIndex] = new LinkedList<Integer>();
			}

			hashMap[keyIndex].add(nextRef);

		}

		nextRef++;

	}

	public String[] search(String key) {

		return getItems(getIndex(key));

	}

	public int CompareTo() {
		return m;
	}

	public String toString() {
		return null;
	}

	// ====== PRIVATE METHODS ======

	private String[] getItems(int index) {

		String[] returnArr = { "Nothing Found" };

		if (hashMap[index] != null) {

			Iterator<Integer> iter = hashMap[index].iterator();

			returnArr = new String[hashMap[index].size()];
			int j = 0;

			while (iter.hasNext()) {

				returnArr[j] = IDRef[iter.next()];
				j++;
			}

		}

		return returnArr;

	}

	private int getIndex(String key) { // using linear probing

		int hash = Math.abs(key.hashCode()) % m;
		int index = hash;

		do {
			String currKey = keys[index];
			if (currKey == null || currKey.compareTo(key) == 0) {
				return index;
			} else {
				index++;
			}

			if (index >= m) {
				index = 0;
			}

		} while (index != hash);

		return -1;

	}

}
