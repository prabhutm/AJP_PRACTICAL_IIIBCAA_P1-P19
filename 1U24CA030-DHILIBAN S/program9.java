// Practical 9: Sequential file matching
//
// oldmast.txt must be in the folder you run the program from, e.g.:
//   123 1000.00
//   456 500.00
//   789 200.00
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class program9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the account number to be searched in the file:");
        String find = sc.nextLine().trim();

        try {
            BufferedReader br = new BufferedReader(new FileReader("oldmast.txt"));
            String line;
            boolean details = false;
            while ((line = br.readLine()) != null) {
                // First column of each row is the account number
                String[] parts = line.trim().split("\\s+");
                if (parts.length > 0 && parts[0].equals(find)) {
                    details = true;
                }
            }
            br.close();

            if (details) {
                System.out.println("Details found in the file");
            } else {
                System.out.println("Details not found in the file");
            }
        } catch (IOException e) {
            System.out.println("Exception message: " + e);
        }
    }
}
