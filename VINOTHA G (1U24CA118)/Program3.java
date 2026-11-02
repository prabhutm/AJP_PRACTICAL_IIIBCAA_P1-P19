import java.util.Scanner;
import java.util.ArrayList;

public class Program3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner scanner =new Scanner(System.in);
		System.out.println("Enter a line of text.");
		String inputLine=scanner.nextLine();
		String[] words=inputLine.split(" ");
		ArrayList<String> wordsStartingWithB=new ArrayList<>();
		for(String word:words) {
			if(word.toLowerCase().startsWith("b")) {
				wordsStartingWithB.add(word);
			}
		}
		
		ArrayList<String> wordsEndingWithED=new ArrayList<>();
		for(String word:words) {
			if(word.toUpperCase().endsWith("ED")) {
				wordsEndingWithED.add(word);
			}
			}
		System.out.println("Words starting with 'b': "+wordsStartingWithB);
		System.out.println("Words ending with 'ED': "+wordsEndingWithED);
		}
	}
