package edu.wmich.CS3310.HW3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class SearchEngine {

	HashMap<String> map;
	LinkedList<String> queryStack;
	
	
	
	

	SearchEngine(int mapSize) {

		map = new HashMap<String>(mapSize);
		queryStack = new LinkedList<String>();

	}

	/**
	 * @param file
	 */
	public void readIndex(String file) {

		File inFile = new File(file);
		Scanner inScanner;
		try {
			inScanner = new Scanner(inFile);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			return;
		}

		while (inScanner.hasNextLine()) {
			map.add(inScanner.nextLine(), inScanner.nextLine().toLowerCase().split(" "));
		}

		inScanner.close();
		
		System.out.println("Index Created from " + file);

	}

	/**
	 * @param query
	 */
	public void addQuery(String query) {

		queryStack.add(0, query);

	}
	
	Iterator<String> iter;

	public LinkedList<String> search() {

		switch (queryStack.peek()) {

		case "&&":
		case "||":
			iter = queryStack.iterator();
			return evalQuery(iter.next());

		default:
			return evalQuery(queryStack.getFirst());
		}

	}

	private LinkedList<String> evalQuery(String operator) {

		LinkedList<String> op1;
		LinkedList<String> op2;
		LinkedList<String> returnList = new LinkedList<String>();
		
		switch (operator) {

		case "&&":
			
			op1 = evalQuery(iter.next());
			op2 = evalQuery(iter.next());
			
			
			
			for(String result : op1) {
				
				if(op2.contains(result)) {
					returnList.add(result);
				}
				
			}
			
			return returnList;
			
		case "||":
			
			op1 = evalQuery(iter.next());
			op2 = evalQuery(iter.next());

			for(String result : op2) {
				
				if(!op1.contains(result)) {
					op1.add(result);
				}
				
			}
			
			return op1;

		default:
			
			returnList = map.search(operator);
			
			if(returnList == null) {
				returnList = new LinkedList<String>();
			}
			
			return returnList;
		}

	}

}
