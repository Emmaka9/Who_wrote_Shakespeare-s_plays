
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 * 
 * @author group_1
 * @version 3.0.0
 * 
 */

public class compre1 {
	public static void main(String[] args) throws FileNotFoundException {
		//declare two Arraylist
		//list1 to store Hamlet, list2 to store 
		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();
		
		Scanner scanner1 = new Scanner(new File("//home//emmaka//Desktop//2019 class schedule//Comprehensive Programming Class//Hamlet.txt"));
		Scanner scanner2 = new Scanner(new File("//home//emmaka//Desktop//2019 class schedule//Comprehensive Programming Class//mobydick.txt"));
		//add all the words from text files to ArrayList
		fileToArrayList(scanner1, list1);
		fileToArrayList(scanner2, list2);
		
		System.out.println("list1 size: "+list1.size());
		System.out.println("list2 size: "+list2.size());
		
		
		//sort list1
		Collections.sort(list1);
		Collections.sort(list2);
		//System.out.println("list1 size: "+list1);
		//System.out.println("list2 size: "+list2);

		//get rid of duplicate words in both ArrayLists individually.
		list1 = getRidOfDuplicates(list1);
		list2 = getRidOfDuplicates(list2);
		
		int sum = list1.size()+list2.size();
		
		System.out.println("list1 size after getting rid of duplicates: "+list1.size());
		System.out.println("list2 size after getting rid of duplicates: "+list2.size());
		
		//add list2 
		//list1 + list2 = list1
		list1 = mergeTwoArrayList(list1, list2);
		Collections.sort(list1);
		System.out.println("list1 merged with list2 and sorted: "+list1.size());
		
		ArrayList<String> uniqueWords = getUniqueWords(list1);
		System.out.println("number of unique words: " + uniqueWords.size());
		 
		ArrayList<String> overlaps = getOverlappedWords(list1);
		System.out.println("number of overlap words: "+overlaps.size());
		//Find the percentage of overlap
		double overlap = overlaps.size();
		double percentage = (overlap / sum) * 100;
		
		System.out.println("sum = "+sum);
		System.out.println("Percentage of overlap = "+percentage);
		
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
	/**
	 * This method to gets rid of the duplicate words
	 * @param list
	 * @return noDuplicates
	 */
	static  ArrayList<String> getRidOfDuplicates(ArrayList<String> list) {
		ArrayList<String> noDuplicates = new ArrayList<String>();
		String prev =list.get(0);
		for(int i = 1; i < list.size(); i++) {
			String curr = list.get(i);
			if (!curr.equals(prev))
				noDuplicates.add(prev);
			prev = curr;
			if (i == list.size()-1) 
				noDuplicates.add(prev);
		}
		return noDuplicates;
	}
	/**
	 * Method to get all the unique words
	 * @param list
	 * @return uniqueWords
	 */
	static ArrayList<String> getUniqueWords(ArrayList<String> list) {
		ArrayList<String> uniqueWords = new ArrayList<String>();
		String curr = list.get(0);
		for(int i = 1, len = list.size(); i < len; i++) {
			
			if (!list.get(i).equals(curr)){
				curr = list.get(i);
				if(i < len - 1 && !curr.equals(list.get(i+1)) ){
					uniqueWords.add(curr);
				}
				else if (i == len-1) {
					uniqueWords.add(curr);
				}
			}
		}
		return uniqueWords;
	} 
	
	/**
	 * 
	 * @param list
	 * @return
	 */
	static ArrayList<String> getOverlappedWords(ArrayList<String> list) {
		ArrayList<String> overlaps = new ArrayList<String>();
		String prev =list.get(0);
		for(int i = 1; i < list.size(); i++) {
			String curr = list.get(i);
			if (curr.equals(prev))
				overlaps.add(prev);
			prev = curr;
			if (i == list.size()-1) 
				overlaps.add(prev);
		}
		return overlaps;
	}
	
}
