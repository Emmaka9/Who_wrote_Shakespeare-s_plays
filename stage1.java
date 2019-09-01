import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class stage1 {

	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();
		
		Scanner scanner1 = new Scanner(new File("//home//emmaka//Desktop//2019 class schedule//Comprehensive Programming Class//Hamlet.txt"));
		Scanner scanner2 = new Scanner(new File("//home//emmaka//Desktop//2019 class schedule//Comprehensive Programming Class//book.txt"));
		//add all the words from text files to ArrayList
		fileToArrayList(scanner1, list1);
		fileToArrayList(scanner2, list2);
		
		
	}
	/**
	 * 
	 * @param sc
	 * @param list
	 * Adds strings from a file to an Arraylist
	 */
	static void fileToArrayList(Scanner sc, ArrayList<String> list) {
		while(sc.hasNext()) {
			String name = sc.useDelimiter("[^a-zA-Z']+").next().toLowerCase();
			list.add(name);
		}
	}
	/**
	 * 
	 * @param list1
	 * @param list2
	 * @return list1
	 * adds list2 at the back of list1
	 */
	static ArrayList<String> mergeTwoArrayList(ArrayList<String> list1, ArrayList<String> list2) {
		
		for (int i = 0, len = list2.size(); i < len; i++) {
			list1.add(list2.get(i));
		}
		return list1;
	}

}
