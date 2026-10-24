import java.util.Scanner;
import java.util.TreeSet;

public class Program7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter a line of text:");
        
        // Check if input is available before calling nextLine()
        if (scanner.hasNextLine()) {
            String inputText = scanner.nextLine();
            String[] tokens = inputText.split("\\s+");
            
            TreeSet<String> tokenSet = new TreeSet<>();
            
            for (int i = 0; i < tokens.length; i++) {
                tokenSet.add(tokens[i]);
            }
            
            System.out.println("Token in ascending sorted order:");
            for (String token : tokenSet) {
                System.out.println(token);
            }
        }
        
        scanner.close();
    }
}