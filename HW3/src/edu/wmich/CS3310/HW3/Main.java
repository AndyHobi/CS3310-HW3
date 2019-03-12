package edu.wmich.CS3310.HW3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		HashMapTest map = new HashMapTest(100); 
		
		File inFile = new File("sample.txt");
		Scanner inScanner = new Scanner(inFile);
		
		Scanner kbd = new Scanner(System.in);
		String input;
		while(inScanner.hasNextLine()) {
			
			map.add(inScanner.nextLine(), inScanner.nextLine().split(" "));
			
		}
		
		while(true) {
			System.out.println("Please ender your search term (or x to exit):");
			input = kbd.nextLine();
			
			if(input.compareTo("x") == 0) {
				break;
			}
			
			System.out.println(map.search(input)[0]);
			
		}
		
		
	}

}
