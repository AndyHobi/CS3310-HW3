package edu.wmich.CS3310.HW3;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		SearchEngine SE = new SearchEngine(1000000);

		Scanner kbd = new Scanner(System.in);
		String input;
		LinkedList<String> searchResult;

		Stopwatch timer = new Stopwatch();

		// reading input file
		timer.start(0);
		SE.readIndex("url.txt");
		timer.stop(0);

		// start main loop

		while (true) {
			System.out.print(">");
			input = kbd.nextLine().toLowerCase();

			if (input.compareTo("!") == 0) {
				break;
			} else if (input.compareTo("?") == 0) {
				
				searchResult = SE.search();

				if (searchResult.isEmpty()) {
					System.out.println("No results found");
				} else {
					for (String result : searchResult) {
						System.out.println(result);
					}
				}

			} else {
				SE.addQuery(input);
			}

		}

		kbd.close();

	}

}
