import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class prac1 {
	public static void main(String[] args) throws FileNotFoundException {
		ArrayList arrayList = new ArrayList();
		
		File file = new File("//home//emmaka//mobydick.txt");
		Scanner scanner = new Scanner(file);
		
		ArrayList<String> strings= new ArrayList<String>();
		while (scanner.hasNext()) {
			strings.add(scanner.next());
		}
		System.out.println(strings.size());
		
	}
}
