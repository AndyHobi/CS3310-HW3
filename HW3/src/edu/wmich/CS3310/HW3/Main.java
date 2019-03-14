package edu.wmich.CS3310.HW3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		HashMap<String> map = new HashMap<String>(100); 
		
		File inFile = new File("sample.txt");
		Scanner inScanner = new Scanner(inFile);
		
		Scanner kbd = new Scanner(System.in);
		String input;
		LinkedList<String> searchResult;
		while(inScanner.hasNextLine()) {
			
			map.add(inScanner.nextLine(), inScanner.nextLine().split(" "));
			
		}
		
		while(true) {
			System.out.println("\nPlease enter your search term (or x to exit):");
			input = kbd.nextLine();
			
			if(input.compareTo("x") == 0) {
				break;
			}
			
			searchResult = map.search(input);
			
			for(String result:searchResult) {
				
				System.out.println(result);
				
			}
			
		}
		
		inScanner.close();
		kbd.close();
		
	}

}
