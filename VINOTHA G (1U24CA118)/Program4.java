import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program4
  {
public static void main(String args[])
    {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the month you wher born (1, to 12):");
		int month = scanner.nextInt();
		System.out.println("Enter the day of the month you wher born:");
		int day = scanner.nextInt();
		System.out.println("Enter the year you wher born(four digits):");
		int year = scanner.nextInt();
		LocalDate birthDate = LocalDate.of(year, month, month);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd ,yyyy");
		System.out.println("Your birth date is: " + formatter.format(birthDate));
		LocalDate currentDate = LocalDate.now();
		System.out.println("Todays date is: " + formatter.format (currentDate));
		Period age = Period.between(birthDate,  currentDate);
		int ageInYears = age.getYears();
		System.out.println("Your age is: " + ageInYears + "years.");
    }
  }