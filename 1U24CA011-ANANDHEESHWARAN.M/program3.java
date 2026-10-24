// Practical 3: Tokenizer - words starting with "b" and ending with "ED"
import java.util.ArrayList;
import java.util.Scanner;

public class program3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Input handling
        System.out.println("Enter a line of text:");
        String inputLine = scanner.nextLine();

        // Step 2: Tokenization
        String[] words = inputLine.split(" ");

        // Step 3: Words starting with "b"
        ArrayList<String> wordsStartingWithB = new ArrayList<>();
        for (String word : words) {
            if (word.toLowerCase().startsWith("b")) {
                wordsStartingWithB.add(word);
            }
        }

        // Step 4: Words ending with "ED"
        ArrayList<String> wordsEndingWithED = new ArrayList<>();
        for (String word : words) {
            if (word.toUpperCase().endsWith("ED")) {
                wordsEndingWithED.add(word);
            }
        }

        // Step 5: Print results
        System.out.println("Words starting with 'b': " + wordsStartingWithB);
        System.out.println("Words ending with 'ED': " + wordsEndingWithED);
    }
}
