package pack12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Program12 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/PRT1",
                "root",
                "navi@25")) {

            boolean exit = false;

            while (!exit) {

                System.out.println("\nBooks Database Manager");
                System.out.println("1. Add a New Author");
                System.out.println("2. Edit Existing Author Information");
                System.out.println("3. Add a New Title for an Author");
                System.out.println("4. Add a New Entry in the AuthorISBN Table");
                System.out.println("5. Exit");
                System.out.print("Select an option: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {

                    case 1:
                        addNewAuthor(conn, scanner);
                        break;

                    case 2:
                        editAuthor(conn, scanner);
                        break;

                    case 3:
                        addNewTitle(conn, scanner);
                        break;

                    case 4:
                        addNewAuthorISBNEntry(conn, scanner);
                        break;

                    case 5:
                        exit = true;
                        break;

                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        scanner.close();
    }

    private static void addNewAuthor(
            Connection connection,
            Scanner scanner) throws SQLException {

        System.out.print("Enter author's first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter author's last name: ");
        String lastName = scanner.nextLine();

        String query =
                "INSERT INTO Authors(first_name, last_name) VALUES (?, ?)";

        try (PreparedStatement pstmt =
                     connection.prepareStatement(query)) {

            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);

            pstmt.executeUpdate();

            System.out.println("Author added successfully.");
        }
    }

    private static void editAuthor(
            Connection conn,
            Scanner scanner) throws SQLException {

        System.out.print("Enter author ID: ");
        int authorId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter new first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter new last name: ");
        String lastName = scanner.nextLine();

        String query =
                "UPDATE Authors SET first_name = ?, last_name = ? " +
                "WHERE author_id = ?";

        try (PreparedStatement pstmt =
                     conn.prepareStatement(query)) {

            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setInt(3, authorId);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Author updated successfully.");
            } else {
                System.out.println("Author ID not found.");
            }
        }
    }

    private static void addNewTitle(
            Connection conn,
            Scanner scanner) throws SQLException {

        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();

        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        System.out.print("Enter price: ");
        double price = scanner.nextDouble();

        scanner.nextLine();

        System.out.print("Enter author ID: ");
        int authorId = scanner.nextInt();

        scanner.nextLine();

        String titleQuery =
                "INSERT INTO Titles(isbn, title, price) VALUES (?, ?, ?)";

        String authorISBNQuery =
                "INSERT INTO AuthorISBN(author_id, isbn) VALUES (?, ?)";

        try {

            conn.setAutoCommit(false);

            try (PreparedStatement pstmt =
                         conn.prepareStatement(titleQuery)) {

                pstmt.setString(1, isbn);
                pstmt.setString(2, title);
                pstmt.setDouble(3, price);

                pstmt.executeUpdate();
            }

            try (PreparedStatement pstmt =
                         conn.prepareStatement(authorISBNQuery)) {

                pstmt.setInt(1, authorId);
                pstmt.setString(2, isbn);

                pstmt.executeUpdate();
            }

            conn.commit();

            System.out.println(
                    "Title added and linked to author successfully.");

        } catch (SQLException e) {

            conn.rollback();
            throw e;

        } finally {

            conn.setAutoCommit(true);
        }
    }

    private static void addNewAuthorISBNEntry(
            Connection conn,
            Scanner scanner) throws SQLException {

        System.out.print("Enter author ID: ");
        int authorId = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();

        String query =
                "INSERT INTO AuthorISBN(author_id, isbn) VALUES (?, ?)";

        try (PreparedStatement pstmt =
                     conn.prepareStatement(query)) {

            pstmt.setInt(1, authorId);
            pstmt.setString(2, isbn);

            pstmt.executeUpdate();

            System.out.println(
                    "AuthorISBN entry added successfully.");
        }
    }
}

