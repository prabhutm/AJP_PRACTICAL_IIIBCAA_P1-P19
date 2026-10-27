// Practical 4: Age calculator
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class program4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Input handling
        System.out.println("Enter the month you were born (1 to 12):");
        int month = scanner.nextInt();
        System.out.println("Enter the day of the month you were born:");
        int day = scanner.nextInt();
        System.out.println("Enter the year you were born (four digits):");
        int year = scanner.nextInt();

        // Step 2: Print the birthdate in the specified format
        LocalDate birthDate = LocalDate.of(year, month, day);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        System.out.println("Your birth date is " + formatter.format(birthDate));

        // Step 3: Print the current date
        LocalDate currentDate = LocalDate.now();
        System.out.println("Today's date is " + formatter.format(currentDate));

        // Step 4: Calculate and display the person's age
        Period age = Period.between(birthDate, currentDate);
        int ageInYears = age.getYears();
        System.out.println("Your age is: " + ageInYears + " years.");
    }
}
