
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class stage_3 {
	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new File("//home//emmaka//eclipse-workspace//Comprehensive Practice 1//src//book.txt"));
		// declare an ArrayList names to store the names from the file
		ArrayList<String> words = new ArrayList<String>();
		ArrayList<String> noDuplicateStrings = new ArrayList<String>();
		
		// add names to the ArrayList names
		while (sc.hasNext()) {
			String name = sc.useDelimiter("[^a-zA-Z']+").next().toLowerCase();
			words.add(name);
		}
		System.out.println(words.size());
		//sort names
		Collections.sort(words);
		System.out.println(words.size());
		
		String name = words.get(0);
		for (int i = 1; i < words.size(); i++) {
			if (!words.get(i).equals(name)) {
				noDuplicateStrings.add(name);
			}
			name = words.get(i);
			if (i == words.size()-1) {
				noDuplicateStrings.add(name);
			}
		}
		System.out.println(noDuplicateStrings.size());

	}
}
