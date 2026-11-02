import java.io.BufferedReader;

import java.io.FileReader;

import java.io.IOException;

import java.util.*;



public class Program9 {



	public static void main(String[] args) {

		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the account number to be searched in the file:");

		

		String find =sc.nextLine(); 

		try 

		{ 

			BufferedReader br = new BufferedReader(new FileReader("D:\\AJP & REACT JS\\AJP RECORD\\Program9\\old.txt")); 

			String line; 

			boolean details= false;

			while((line=br.readLine())!=null)

		{ 

				if(line.contains(find)) {

					details = true;

					} 

				} 

			br.close(); 

			if(details) { 

				System.out.println("Details found in the file");

				} else 

				{ System.out.println("Details not found in the file"); } } catch(IOException e) {

		System.out.println("Excpetion message"+e); 

		}

	}



}