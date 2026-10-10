// Practical 11: Book database - query application (JDBC + MySQL)
//
// Requires the MySQL Connector/J jar on the classpath. Run this SQL first:
//
//   create database bm;
//   use bm;
//   create table authors ( author_id int primary key auto_increment,
//                          first_name varchar(100), last_name varchar(100) );
//   insert into authors (first_name, last_name) values ('John', 'Doe');
//   insert into authors (first_name, last_name) values ('Jane', 'Smith');
//   create table books ( book_id int primary key auto_increment, title varchar(255),
//                        year int, isbn varchar(20), author_id int,
//                        foreign key (author_id) references authors(author_id) );
//   insert into books (title, year, isbn, author_id) values ('Java Programming', 2020, '1234567890', 1);
//   insert into books (title, year, isbn, author_id) values ('Database Design', 2018, '0987654321', 2);
//   insert into books (title, year, isbn, author_id) values ('Advanced Java', 2021, '1122334455', 1);

import java.sql.*;
import java.util.Scanner;

public class program11 {
    private static final String URL = "jdbc:mysql://localhost:3306/bm";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            while (true) {
                System.out.println("1. Select all authors");
                System.out.println("2. List all books for a specific author");
                System.out.println("3. List all authors for a specific title");
                System.out.println("4. Exit");
                System.out.println("Enter your choice:");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        selectAllAuthors(connection);
                        break;
                    case 2:
                        System.out.print("Enter author ID: ");
                        int authorId = scanner.nextInt();
                        scanner.nextLine();
                        selectBooksForAuthor(connection, authorId);
                        break;
                    case 3:
                        System.out.print("Enter book title: ");
                        String title = scanner.nextLine();
                        selectAuthorsForTitle(connection, title);
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void selectAllAuthors(Connection connection) throws SQLException {
        String query = "SELECT * FROM Authors ORDER BY last_name, first_name";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            System.out.println("Authors:");
            while (rs.next()) {
                System.out.println(rs.getString("first_name") + " " + rs.getString("last_name"));
            }
        }
    }

    private static void selectBooksForAuthor(Connection connection, int authorId) throws SQLException {
        String query = "SELECT b.title, b.year, b.isbn FROM Books b WHERE b.author_id = ? ORDER BY b.title";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, authorId);
            try (ResultSet rs = pstmt.executeQuery()) {
                System.out.println("Books for Author ID " + authorId + ":");
                while (rs.next()) {
                    System.out.println("Title: " + rs.getString("title")
                            + ", Year: " + rs.getInt("year")
                            + ", ISBN: " + rs.getString("isbn"));
                }
            }
        }
    }

    private static void selectAuthorsForTitle(Connection connection, String title) throws SQLException {
        String query = "SELECT a.first_name, a.last_name FROM Authors a "
                + "JOIN Books b ON a.author_id = b.author_id "
                + "WHERE b.title = ? ORDER BY a.last_name, a.first_name";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, title);
            try (ResultSet rs = pstmt.executeQuery()) {
                System.out.println("Authors for Title: " + title);
                while (rs.next()) {
                    System.out.println(rs.getString("first_name") + " " + rs.getString("last_name"));
                }
            }
        }
    }
}
