package main;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Map<String, String> library = new HashMap<>();
		library.put("apple", "€блоко");
		library.put("street", "улица");
		library.put("table", "стол");

		Translate tr = new Translate(library);

		File english = new File("English.in.txt");
		File ukranian = new File("Ukrainian.out.txt");
		File dictionary = new File("Dictionary.csv");

		tr.translating(english, ukranian);

		for (;;) {
			System.out.println("Enter a new pair of words and enter s to save");
			Scanner sc = new Scanner(System.in);
			String command = sc.nextLine();
			if (command.equals("s")) {
				tr.savingDictionaryToCSV(dictionary);
				break;
			} else {
				String[] arr = command.split(" ");
				tr.editingDictionary(arr[0], arr[1]);
			}
		}
		
		
	}

}
