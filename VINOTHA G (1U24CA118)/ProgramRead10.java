import java.util.Formatter;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ProgramRead10 {

    public static void main(String[] args) {

        try {
            Scanner input = new Scanner(new File("numbers.txt"));
            Formatter output = new Formatter("output.txt");

            while (input.hasNextInt()) {
                int response = input.nextInt();

                output.format("%d%n", response);
            }

            input.close();
            output.close();

            System.out.println("Responses copied to output.txt");

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}