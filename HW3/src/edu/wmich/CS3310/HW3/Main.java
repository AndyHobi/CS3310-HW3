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

		System.out.println(">Starting Search Engine<");
		
		if (args.length == 0) {
			args = new String[1];
			args[0] = "url.txt";
		}

		// reading input file
		SE.readIndex(args[0]);

		
		// start main loop
		while (true) {
			System.out.print(">");
			input = kbd.nextLine().toLowerCase();

			if (input.compareTo("!") == 0) {
				break;
			} else if (input.compareTo("?") == 0) {

				searchResult = SE.search();

				if (searchResult != null) {

					if (searchResult.isEmpty()) {
						System.out.println("No results found");
					} else {
						for (String result : searchResult) {
							System.out.println(result);
						}
					}
				} else {
					System.out.println("Invalid query sequence");
				}

			} else {
				SE.addQuery(input);
			}

		}

		kbd.close();

	}

}
