package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Translate {
	private Map<String, String> library = new HashMap<>();

	public Translate() {
		super();
	}

	public Translate(Map<String, String> library) {
		super();
		this.library = library;
	}

	public Map<String, String> getLibrary() {
		return library;
	}

	public void setLibrary(Map<String, String> library) {
		this.library = library;
	}

	@Override
	public String toString() {
		return "Translate [library=" + library + "]";
	}

	public void translating(File english, File ukranian) {
		try (BufferedReader br = new BufferedReader(new FileReader(english));
				PrintWriter pw = new PrintWriter(ukranian)) {

			for (;;) {
				String line  = br.readLine();
				if (line == null) {
					break;
				}
				String[] arr = line.split(" ");

				for (int i = 0; i < arr.length; i++) {
					if (library.containsKey(arr[i])) {
						pw.print(library.get(arr[i]) + " ");
					} else {
						pw.print("'Unknow word' ");
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void editingDictionary (String englishWord, String ukranianWord) {
		library.put(englishWord, ukranianWord);
	}
	
	public void savingDictionaryToCSV (File file) {
			String delim = ";";
			Set<Map.Entry<String, String>> set = library.entrySet();
			try (PrintWriter pw = new PrintWriter(file)) {
				for (Entry<String, String> pair : set) {
					pw.println(pair + delim);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

	}

}
