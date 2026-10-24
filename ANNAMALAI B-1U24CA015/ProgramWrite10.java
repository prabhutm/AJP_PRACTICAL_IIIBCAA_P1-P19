import java.util.Formatter;
import java.util.Scanner;

public class ProgramWrite10 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        try {
            Formatter formatter = new Formatter("numbers.txt");

            System.out.println("Enter 5 survey responses:");

            for (int i = 1; i <= 5; i++) {
                System.out.print("Response " + i + ": ");
                int response = input.nextInt();

                formatter.format("%d%n", response);
            }

            formatter.close();
            System.out.println("Responses saved to numbers.txt");

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        input.close();
    }
}