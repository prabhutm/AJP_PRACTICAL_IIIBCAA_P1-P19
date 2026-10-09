// Practical 10: Text file using read and write operations
//   Part 1: write survey responses (integers) to numbers.txt using Formatter
//   Part 2: read them back with Scanner.nextInt() and write them to output.txt
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Formatter;
import java.util.Scanner;

public class program10 {

    // Program 1: Writing survey responses to numbers.txt
    static void writeResponsesToFile() {
        try {
            Formatter formatter = new Formatter("numbers.txt");
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter survey responses, one per line (type done to finish):");
            String input;
            while (!(input = scanner.nextLine()).equalsIgnoreCase("done")) {
                try {
                    int number = Integer.parseInt(input.trim());
                    formatter.format("%d%n", number);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input " + e);
                }
            }
            formatter.close();
            System.out.println("Responses written to numbers.txt successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }
    }

    // Program 2: Reading from numbers.txt and writing to output.txt
    static void readResponsesFromFile() {
        try {
            Scanner scanner = new Scanner(new File("numbers.txt"));
            PrintWriter pw = new PrintWriter("output.txt");

            while (scanner.hasNextInt()) {
                int response = scanner.nextInt();
                pw.println(response);
            }
            scanner.close();
            pw.close();
            System.out.println("Responses read from numbers.txt and written to output.txt successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }
    }

    public static void main(String[] args) {
        writeResponsesToFile();
        readResponsesFromFile();
    }
}
