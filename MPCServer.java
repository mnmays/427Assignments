//imports
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class MPCServer 
{
	public static void main(String[] argv) throws Exception
	{
		//declarations
		String clientSentence; 
		byte Array[] = null; 

	  ServerSocket welcomeSocket = new ServerSocket(2228); 
	    
  	  inputFile(Array);
  	  
	  
	      while(true) 
	      { 
	    	  Socket connectionSocket = welcomeSocket.accept(); 	//welcoming socket
	    	  BufferedReader inFromClient =  new BufferedReader(new InputStreamReader(connectionSocket.getInputStream())); 	//creates input stream & attaches to socket
	    	  DataOutputStream  outToClient = new DataOutputStream(connectionSocket.getOutputStream());  //creates output stream& attaches to socket 
	    	 
	    	  clientSentence = inFromClient.readLine();				//from client   
	      }		//end while

	}	//end main method
	
	
	
	public static void inputFile(byte Array[]) throws Exception
	//this method reads the Alice in Wonderland input file from the text file to the program and converts the strings to bytes
	{
		//import file
		java.io.File file = new java.io.File("/Users/meganmays/Documents/workspace/Mays_Keyser_427AssignmentOne/src/AliceInput.txt");

		//declarations 
		int totalNumber=0;  	
		
		try 
		{
			Scanner input = new Scanner(file);		//scanner, to read input file 

	        while (input.hasNextLine()) 
	        {
	            String line = input.nextLine();	//reads each line from the input file individually
	            Array = line.getBytes();		//converts each line from input file from string to bytes
	            int number = Array.length;		
	            totalNumber = totalNumber + number;		//sums all of the bytes from all of the lines that have been read thus far 
	            System.out.println(totalNumber);		//prints current byte total
	            
	        }	//end while loop
	        
	        input.close();	//close scanner
	    } 	//end try
	    catch (FileNotFoundException e) 
		{
	        e.printStackTrace();
	    }	//end catch 
	}	//end input File method
}	//end MPC Server class

