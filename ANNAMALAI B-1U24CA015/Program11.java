package pack11;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import java.util.Scanner;



public class Program11 {

 

	public static void main(String[] args) {

		// TODO Auto-generated method stub



		Scanner scanner = new Scanner(System.in);



		 try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/p11", "root", "navi@25")) {

		 while (true) {

		 System.out.println("1. Select all authors");

		 System.out.println("2. List all books for a specific author");

		 System.out.println("3. List all authors for a specific title");

		 System.out.println("4. Exit");

		System.out.println("Enter your choice:");

		 int choice = scanner.nextInt();

		 scanner.nextLine(); // Consume newline

		 switch (choice) {

		 case 1:

		 selectAllAuthors(connection);

		 break;

		 case 2:

		 System.out.print("Enter author ID: ");

		 int authorId = scanner.nextInt();

		 selectBooksForAuthor(connection, authorId);

		 break;

		 case 3:

		 System.out.print("Enter book title: ");

		 String title = scanner.nextLine();

		 selectAuthorsForTitle(connection, title);

		 break;

		 case 4:

		 System.out.println("Exiting...");

		 System.exit(0);

		 default:

		 System.out.println("Invalid choice. Please try again.");

		 }

		 }

		 } catch (SQLException e) {



			 e.printStackTrace();

		     }

		 }



	private static void selectAuthorsForTitle(Connection connection, String title) throws SQLException

	{

		// TODO Auto-generated method stub

//			String query="SELECT a.first_name, a.last_name FROM authors a JOIN books b ON a.author_id=b.author_id WHERE b.title =? ORDER BY a.lastname, a.firstname";

		String query = "SELECT a.first_name, a.last_name FROM Authors a JOIN Books b ON a.author_id = b.author_id WHERE b.title = ? ORDER BY a.last_name, a.first_name";	

		try(PreparedStatement pstmt=connection.prepareStatement(query)){

				pstmt.setString(1, title);

				

				try(ResultSet rs=pstmt.executeQuery()){

					System.out.println("Authors for Title : "+title);

					while(rs.next()) {

						System.out.println(rs.getString("first_name")+""+rs.getString("last_name"));

			

					}

				}

			}

	

	}



	private static void selectBooksForAuthor(Connection connection, int authorId) throws SQLException {

		// TODO Auto-generated method stub

		String query="SELECT b.title, b.year, b.isbn FROM Books b WHERE b.author_id=? ORDER BY b.title";

		try(PreparedStatement pstmt=connection.prepareStatement(query)){

			pstmt.setInt(1, authorId);

			try(ResultSet rs=pstmt.executeQuery()){

				System.out.println("Books for Author ID"+authorId+":");

				while(rs.next()) {

					System.out.println("Title: "+rs.getString("title")+", Year: "+rs.getInt("year")+", ISBN: " +rs.getString("isbn"));

				}

			}

		}

	}



	private static void selectAllAuthors(Connection connection)throws SQLException {

		// TODO Auto-generated method stub

		String query="SELECT * FROM Authors ORDER BY last_name, first_name";

		try(Statement stmt=connection.createStatement();

				ResultSet rs=stmt.executeQuery(query)){

			System.out.println("Authors");

			while(rs.next()) {

				System.out.println(rs.getString("first_name")+""+rs.getString("last_name"));

			}

		}

		

	}

		 

	}