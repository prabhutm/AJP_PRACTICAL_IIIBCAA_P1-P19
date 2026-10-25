// Practical 7: Tokenizer with TreeSet (sorted output)
import java.util.Scanner;
import java.util.TreeSet;

public class program7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a line of text:");
        String inputText = scanner.nextLine();

        // Tokenize the input text into individual words
        String[] tokens = inputText.split("\\s+");

        TreeSet<String> tokenSet = new TreeSet<>();
        for (int i = 0; i < tokens.length; i++) {
            tokenSet.add(tokens[i]);
        }

        System.out.println("Tokens in ascending sorted order:");
        for (String token : tokenSet) {
            System.out.println(token);
        }
        scanner.close();
    }
}
