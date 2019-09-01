import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 * 
 * @author emmaka
 *
 */
public class compre2 {
	public static void main(String[] args) throws FileNotFoundException {
		/*
		 * create 2 ArrayList: list1 and lis2
		 * list1 to store book1 and list2 to store book2
		 */
		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();//Edwin Abott Abott//flatland.txt
		
		Scanner scanner1 = new Scanner(new File("//home//emmaka//Desktop//2019 class schedule//Comprehensive Programming Class//Hamlet.txt"));
		Scanner scanner2 = new Scanner(new File("//home//emmaka//Desktop//2019 class schedule//Comprehensive Programming Class//mobydick.txt"));//Edwin Abott Abott//Silanus.txt
		//add all the words from text files to ArrayList
		fileToArrayList(scanner1, list1);
		fileToArrayList(scanner2, list2);
		System.out.println("list1 size: "+list1.size());
		System.out.println("list2 size: "+list2.size());
		/*
		 *stopWordsArray contains 1527 stopwords.
		 *
		 * then remove all the stopwords from list1 and list2
		 */
		String[] stopWordsArray = {"a", "about", "above", "after", "again", "against", "ain", "all", "am", "an", "and", "any", "are","aren", "aren't", "as", "at", "be", "because", "been", "before", "being", "below", "between", "both", "but", "by", "can", "couldn", "couldn't", "d", "did", "didn", "didn't", "do", 
				"does", "doesn", "doesn't", "doing", "don", "don't", "down",
				"during", "each", "few", "for", "from", "further", "had",
				"hadn", "hadn't", "has", "hasn", "hasn't", "have", "haven", 
				"haven't", "having", "he", "her", "here", "hers", "herself", "him", 
				"himself", "his", "how", "i", "if", "in", "into", "is", "isn", 
				"isn't", "it", "it's", "its", "itself", "just", "ll", "m", "ma",
				"me", "mightn", "mightn't", "more", "most", "mustn", "mustn't", 
				"my", "myself", "needn", "needn't", "no", "nor", "not", "now", "o", 
				"of", "off", "on", "once", "only", "or", "other", "our", "ours", 
				"ourselves", "out", "over", "own", "re", "s", "same", "shan", 
				"shan't", "she", "she's", "should", "should've", "shouldn", 
				"shouldn't", "so", "some", "such", "t", "than", "that", "that'll", 
				"the", "their", "theirs", "them", "themselves", "then", "there", 
				"these", "they", "this", "those", "through", "to", "too", "under", 
				"until", "up", "ve", "very", "was", "wasn", "wasn't", "we", "were", 
				"weren", "weren't", "what", "when", "where", "which", "while", 
				"who", "whom", "why", "will", "with", "won", "won't", "wouldn", 
				"wouldn't", "y", "you", "you'd", "you'll", "you're", "you've", 
				"your", "yours", "yourself", "yourselves", "could", "he'd", "he'll", 
				"he's", "here's", "how's", "i'd", "i'll", "i'm", "i've", "let's", 
				"ought", "she'd", "she'll", "that's", "there's", "they'd", "they'll", 
				"they're", "they've", "we'd", "we'll", "we're", "we've", "what's", 
				"when's", "where's", "who's", "why's", "would", "able", "abst", 
				"accordance", "according", "accordingly", "across", "act", 
				"actually", "added", "adj", "affected", "affecting", "affects", 
				"afterwards", "ah", "almost", "alone", "along", "already", "also", 
				"although", "always", "among", "amongst", "announce", "another", "anybody", "anyhow", "anymore", "anyone", "anything", "anyway", "anyways", "anywhere", "apparently", "approximately", "arent", "arise", "around", "aside", "ask", "asking", "auth", "available", "away", "awfully", "b", "back", "became", "become", "becomes", "becoming", "beforehand", "begin", "beginning", "beginnings","begins", "behind", "believe", "beside", "besides", "beyond", "biol", "brief", "briefly", "c", "ca", "came", "cannot", "can't", "cause", "causes", "certain", "certainly", "co", "com", "come", "comes", "contain", "containing", "contains", "couldnt", "date", "different", "done", "downwards", "due", "e", "ed", "edu", "effect", "eg", "eight", "eighty", "either", "else", "elsewhere", "end", "ending", "enough", "especially", "et", "etc", "even", "ever", "every", "everybody", "everyone", "everything", "everywhere", "ex", "except", "f", "far", "ff", "fifth", "first", "five", "fix", "followed", "following", "follows", "former", "formerly", "forth", "found", "four", "furthermore", "g", "gave", "get", "gets", "getting", "give", "given", "gives", "giving", "go", "goes", "gone", "got", "gotten", "h", "happens", "hardly", "hed", "hence", "hereafter", "hereby", "herein", "heres", "hereupon", "hes", "hi", "hid", "hither", "home", "howbeit", "however", "hundred", "id", "ie", "im", "immediate", "immediately", "importance", "important", "inc", "indeed", "index", "information", "instead", "invention", "inward", "itd", "it'll", "j", "k", "keep", "keeps", "kept", "kg", "km", "know", "known", "knows", "l", "largely", "last", "lately", "later", "latter", "latterly", "least", "less", "lest", "let", "lets", "like", "liked", "likely", "line", "little", "'ll", "look", "looking", "looks", "ltd", "made", "mainly", "make", "makes", "many", "may", "maybe", "mean", "means", "meantime", "meanwhile", "merely", "mg", "might", "million", "miss", "ml", "moreover", "mostly", "mr", "mrs", "much", "mug", "must", "n", "na", "name", "namely", "nay", "nd", "near", "nearly", "necessarily", "necessary", "need", "needs", "neither", "never", "nevertheless", "new", "next", "nine", "ninety", "nobody", "non", "none", "nonetheless", "noone", "normally", "nos", "noted", "nothing", "nowhere", "obtain", "obtained", "obviously", "often", "oh", "ok", "okay", "old", "omitted", "one", "ones", "onto", "ord", "others", "otherwise", "outside", "overall", "owing", "p", "page", "pages", "part", "particular", "particularly", "past", "per", "perhaps", "placed", "please", "plus", "poorly", "possible", "possibly", "potentially", "pp", "predominantly", "present", "previously", "primarily", "probably", "promptly", "proud", "provides", "put", "q", "que", "quickly", "quite", "qv", "r", "ran", "rather", "rd", "readily", "really", "recent", "recently", "ref", "refs", "regarding", "regardless", "regards", "related", "relatively", "research", "respectively", "resulted", "resulting", "results", "right", "run", "said", "saw", "say", "saying", "says", "sec", "section", "see", "seeing", "seem", "seemed", "seeming", "seems", "seen", "self", "selves", "sent", "seven", "several", "shall", "shed", "shes", "show", "showed", "shown", "showns", "shows", "significant", "significantly", "similar", "similarly", "since", "six", "slightly", "somebody", "somehow", "someone", "somethan", "something", "sometime", "sometimes", "somewhat", "somewhere", "soon", "sorry", "specifically", "specified", "specify", "specifying", "still", "stop", "strongly", "sub", "substantially", "successfully", "sufficiently", "suggest", "sup", "sure", "take", "taken", "taking", "tell", "tends", "th", "thank", "thanks", "thanx", "thats", "that've", "thence", "thereafter", "thereby", "thered", "therefore", "therein", "there'll", "thereof", "therere", "theres", "thereto", "thereupon", "there've", "theyd", "theyre", "think", "thou", "though", "thoughh", "thousand", "throug", "throughout", "thru", "thus", "til", "tip", "together", "took", "toward", "towards", "tried", "tries", "truly", "try", "trying", "ts", "twice", "two", "u", "un", "unfortunately", "unless", "unlike", "unlikely", "unto", "upon", "ups", "us", "use", "used", "useful", "usefully", "usefulness", "uses", "using", "usually", "v", "value", "various", "'ve", "via", "viz", "vol", "vols", "vs", "w", "want", "wants", "wasnt", "way", "wed", "welcome", "went", "werent", "whatever", "what'll", "whats", "whence", "whenever", "whereafter", "whereas", "whereby", "wherein", "wheres", "whereupon", "wherever", "whether", "whim", "whither", "whod", "whoever", "whole", "who'll", "whomever", "whos", "whose", "widely", "willing", "wish", "within", "without", "wont", "words", "world", "wouldnt", "www", "x", "yes", "yet", "youd", "youre", "z", "zero", "a's", "ain't", "allow", "allows", "apart", "appear", "appreciate", "appropriate", "associated", "best", "better", "c'mon", "c's", "cant", "changes", "clearly", "concerning", "consequently", "consider", "considering", "corresponding", "course", "currently", "definitely", "described", "despite", "entirely", "exactly", "example", "going", "greetings", "hello", "help", "hopefully", "ignored", "inasmuch", "indicate", "indicated", "indicates", "inner", "insofar", "it'd", "keep", "keeps", "novel", "presumably", "reasonably", "second", "secondly", "sensible", "serious", "seriously", "sure", "t's", "third", "thorough", "thoroughly", "three", "well", "wonder", "a", "about", "above", "above", "across", "after", "afterwards", "again", "against", "all", "almost", "alone", "along", "already", "also", "although", "always", "am", "among", "amongst", "amoungst", "amount", "an", "and", "another", "any", "anyhow", "anyone", "anything", "anyway", "anywhere", "are", "around", "as", "at", "back", "be", "became", "because", "become", "becomes", "becoming", "been", "before", "beforehand", "behind", "being", "below", "beside", "besides", "between", "beyond", "bill", "both", "bottom", "but", "by", "call", "can", "cannot", "cant", "co", "con", "could", "couldnt", "cry", "de", "describe", "detail", "do", "done", "down", "due", "during", "each", "eg", "eight", "either", "eleven", "else", "elsewhere", "empty", "enough", "etc", "even", "ever", "every", "everyone", "everything", "everywhere", "except", "few", "fifteen", "fify", "fill", "find", "fire", "first", "five", "for", "former", "formerly", "forty", "found", "four", "from", "front", "full", "further", "get", "give", "go", "had", "has", "hasnt", "have", "he", "hence", "her", "here", "hereafter", "hereby", "herein", "hereupon", "hers", "herself", "him", "himself", "his", "how", "however", "hundred", "ie", "if", "in", "inc", "indeed", "interest", "into", "is", "it", "its", "itself", "keep", "last", "latter", "latterly", "least", "less", "ltd", "made", "many", "may", "me", "meanwhile", "might", "mill", "mine", "more", "moreover", "most", "mostly", "move", "much", "must", "my", "myself", "name", "namely", "neither", "never", "nevertheless", "next", "nine", "no", "nobody", "none", "noone", "nor", "not", "nothing", "now", "nowhere", "of", "off", "often", "on", "once", "one", "only", "onto", "or", "other", "others", "otherwise", "our", "ours", "ourselves", "out", "over", "own", "part", "per", "perhaps", "please", "put", "rather", "re", "same", "see", "seem", "seemed", "seeming", "seems", "serious", "several", "she", "should", "show", "side", "since", "sincere", "six", "sixty", "so", "some", "somehow", "someone", "something", "sometime", "sometimes", "somewhere", "still", "such", "system", "take", "ten", "than", "that", "the", "their", "them", "themselves", "then", "thence", "there", "thereafter", "thereby", "therefore", "therein", "thereupon", "these", "they", "thickv", "thin", "third", "this", "those", "though", "three", "through", "throughout", "thru", "thus", "to", "together", "too", "top", "toward", "towards", "twelve", "twenty", "two", "un", "under", "until", "up", "upon", "us", "very", "via", "was", "we", "well", "were", "what", "whatever", "when", "whence", "whenever", "where", "whereafter", "whereas", "whereby", "wherein", "whereupon", "wherever", "whether", "which", "while", "whither", "who", "whoever", "whole", "whom", "whose", "why", "will", "with", "within", "without", "would", "yet", "you", "your", "yours", "yourself", "yourselves", "the", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "co", "op", "research-articl", "pagecount", "cit", "ibid", "les", "le", "au", "que", "est", "pas", "vol", "el", "los", "pp", "u201d", "well-b", "http", "volumtype", "par", "0o", "0s", "3a", "3b", "3d", "6b", "6o", "a1", "a2", "a3", "a4", "ab", "ac", "ad", "ae", "af", "ag", "aj", "al", "an", "ao", "ap", "ar", "av", "aw", "ax", "ay", "az", "b1", "b2", "b3", "ba", "bc", "bd", "be", "bi", "bj", "bk", "bl", "bn", "bp", "br", "bs", "bt", "bu", "bx", "c1", "c2", "c3", "cc", "cd", "ce", "cf", "cg", "ch", "ci", "cj", "cl", "cm", "cn", "cp", "cq", "cr", "cs", "ct", "cu", "cv", "cx", "cy", "cz", "d2", "da", "dc", "dd", "de", "df", "di", "dj", "dk", "dl", "do", "dp", "dr", "ds", "dt", "du", "dx", "dy", "e2", "e3", "ea", "ec", "ed", "ee", "ef", "ei", "ej", "el", "em", "en", "eo", "ep", "eq", "er", "es", "et", "eu", "ev", "ex", "ey", "f2", "fa", "fc", "ff", "fi", "fj", "fl", "fn", "fo", "fr", "fs", "ft", "fu", "fy", "ga", "ge", "gi", "gj", "gl", "go", "gr", "gs", "gy", "h2", "h3", "hh", "hi", "hj", "ho", "hr", "hs", "hu", "hy", "i", "i2", "i3", "i4", "i6", "i7", "i8", "ia", "ib", "ic", "ie", "ig", "ih", "ii", "ij", "il", "in", "io", "ip", "iq", "ir", "iv", "ix", "iy", "iz", "jj", "jr", "js", "jt", "ju", "ke", "kg", "kj", "km", "ko", "l2", "la", "lb", "lc", "lf", "lj", "ln", "lo", "lr", "ls", "lt", "m2", "ml", "mn", "mo", "ms", "mt", "mu", "n2", "nc", "nd", "ne", "ng", "ni", "nj", "nl", "nn", "nr", "ns", "nt", "ny", "oa", "ob", "oc", "od", "of", "og", "oi", "oj", "ol", "om", "on", "oo", "oq", "or", "os", "ot", "ou", "ow", "ox", "oz", "p1", "p2", "p3", "pc", "pd", "pe", "pf", "ph", "pi", "pj", "pk", "pl", "pm", "pn", "po", "pq", "pr", "ps", "pt", "pu", "py", "qj", "qu", "r2", "ra", "rc", "rd", "rf", "rh", "ri", "rj", "rl", "rm", "rn", "ro", "rq", "rr", "rs", "rt", "ru", "rv", "ry", "s2", "sa", "sc", "sd", "se", "sf", "si", "sj", "sl", "sm", "sn", "sp", "sq", "sr", "ss", "st", "sy", "sz", "t1", "t2", "t3", "tb", "tc", "td", "te", "tf", "th", "ti", "tj", "tl", "tm", "tn", "tp", "tq", "tr", "ts", "tt", "tv", "tx", "ue", "ui", "uj", "uk", "um", "un", "uo", "ur", "ut", "va", "wa", "vd", "wi", "vj", "vo", "wo", "vq", "vt", "vu", "x1", "x2", "x3", "xf", "xi", "xj", "xk", "xl", "xn", "xo", "xs", "xt", "xv", "xx", "y2", "yj", "yl", "yr", "ys", "yt", "zi","zz"};
		
		//put the stopwods into stopWordsArrayList from stopWordsArray
		ArrayList<String> stopWordsArrayList = new ArrayList<String>();
		
		for (int i = 0, len = stopWordsArray.length; i < len; i++) {
			stopWordsArrayList.add(stopWordsArray[i]);
		}
		System.out.println("size of the stopWords: "+stopWordsArrayList.size());
				

		
		//remove all the stopWords from list1 and list2
		list1.removeAll(stopWordsArrayList);
		list2.removeAll(stopWordsArrayList);
		System.out.println("list1 size after getting "
				+ "rid of all the stopWords: "+list1.size());
		
		System.out.println("list2 size after getting "
				+ "rid of all the stopWords: "+list2.size());
		//---------------------------------------------------------------------------------
		//get rid of the duplicates
		list1 = getRidOfDuplicates(list1);
		list2 = getRidOfDuplicates(list2);
		
		System.out.println("list1 size after getting "
				+ "rid of all the duplicates: "+list1.size());
		
		System.out.println("list2 size after getting "
				+ "rid of all the duplicates: "+list2.size());
		
//		ArrayList countOfWordsList1 = wordOccurrenceCounter(list1);
//		System.out.println(countOfWordsList1);
//		System.out.println(list2);
//		ArrayList countOfWordsList2 = wordOccurrenceCounter(list2);
//		System.out.println(countOfWordsList2);
		
		//create an arraylist to store the uniqueWords
		ArrayList<String> uniqueWords = getUniqueWords(list1, list2);
		System.out.println("number of unique words: " + uniqueWords.size());
		
		//create an ArrayList overlaps to store the overlaps
		ArrayList<String> overlapedWords = getOverlappedWords(list1, list2);
		System.out.println("number of overlapped words: "+overlapedWords.size());

		//Find the percentage of overlap
		double overlap_number = overlapedWords.size();
		double percentage_book1 = (overlap_number / list1.size()) * 100;
		double percentage_book2 = (overlap_number / list2.size()) * 100;
		
		//System.out.println("sum = "+sum);
		System.out.println("Percentage of overlap in book 1 = "+percentage_book1);
		System.out.println("Percentage of overlap in book 2 = "+percentage_book2);
		
		
	}
	static void printKmostOccurence(ArrayList<String> list, int k) {
		
		ArrayList countsArrayList = wordOccurrenceCounter(list);
		for (int i = 0 ; i < 2*k; i++) {
			//System.out.println("Frequency of word "++);
		}
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
	 * This method takes in two ArrayList as formal parameter and adds 
	 * list2 at the back of list1. Then returns list1.
	 * 
	 * @param list1 ArrayList1, at the back of which list2 gets added
	 * @param list2 ArrayList2
	 * @return newArrayList
	 */
	static ArrayList<String> mergeTwoArrayList(ArrayList<String> list1, ArrayList<String> list2) {
		ArrayList<String> newArrayList = new ArrayList<String>();
		//add words in list1 into newArrayList
		for (int i = 0, len = list1.size();  i < len; i++) {
			newArrayList.add(list1.get(i));
		}
		//add words in list2 into newArrayList
		for (int i = 0, len = list2.size();  i < len; i++) {
			newArrayList.add(list2.get(i));
		}
		return newArrayList;
	}
	/**
	 * This method gets rid of the duplicate words
	 * if any word has appeared several tiimes, add only one copy into noDuplicates
	 * If any word unique, add it to noDuplicates
	 * @param list
	 * @return noDuplicates
	 */
	static  ArrayList<String> getRidOfDuplicates(ArrayList<String> list) {
		ArrayList<String> noDuplicates = new ArrayList<String>();
		//sort list
		Collections.sort(list);
		//find duplicates and get rid of 'em
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
	 * This method takes in two ArrayLists and returns a new ArrayList
	 * which contains the unique words between them.
	 * first it merges the two lists into the mergedList. then sorts them. 
	 * get rid of the 
	 * Then finds the unique words.
	 * 
	 * @param list1
	 * @param list2
	 * @return uniqueWords
	 */
	static ArrayList<String> getUniqueWords(ArrayList<String> list1, ArrayList<String> list2) {
		
		ArrayList<String> uniqueWords = new ArrayList<String>();
		//merge list1 and list2 into mergedList
		ArrayList<String> mergedList = mergeTwoArrayList(list1, list2);
		Collections.sort(mergedList);

		//look for unique words.
		//If it is unique add it to uniqueWords
		String curr = mergedList.get(0);
		for(int i = 1, len = mergedList.size(); i < len; i++) {
			
			if (!mergedList.get(i).equals(curr)){
				curr = mergedList.get(i);
				if(i < len - 1 && !curr.equals(mergedList.get(i+1)) ){
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
	static ArrayList<String> getOverlappedWords(ArrayList<String> list1, ArrayList<String> list2) {
		
		ArrayList<String> overlaps = new ArrayList<String>();
		//merge list1 and list2 into mergedList
		ArrayList<String> mergedList = mergeTwoArrayList(list1, list2);
		Collections.sort(mergedList);

		String prev =mergedList.get(0);
		for(int i = 1, n = mergedList.size() - 1; i < n; i++) {
			String curr = mergedList.get(i);
			if (curr.equals(prev))
				overlaps.add(prev);
			prev = curr;
		}
		return overlaps;
	}
	/**
	 * 
	 * @param list
	 * @return counterList
	 */
	static ArrayList wordOccurrenceCounter(ArrayList<String> list) {
		ArrayList counterList = new ArrayList();
		Collections.sort(list);
		String currString = list.get(0);
		int counter = 1;
		for (int i = 1, len = list.size(); i < len; i++) {
			if (list.get(i).equals(currString)) 
				counter++;
			else {
				counterList.add(counter);
				counterList.add(currString);
				
				counter = 1;
			}
			currString = list.get(i);
		}
		
		return counterList;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
