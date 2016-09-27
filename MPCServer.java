package _427Assignment;

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
import java.util.Scanner;

public class MPCServer 
{
	public static void main(String[] argv) throws Exception
	{
		//declarations
		String clientSentence; 
		String byteArray[]; 

	  ServerSocket welcomeSocket = new ServerSocket(6789); 
	    
  	  inputFile();
  	  
	  
	      while(true) 
	      { 
	    	  Socket connectionSocket = welcomeSocket.accept(); 	//welcoming socket
	    	  BufferedReader inFromClient =  new BufferedReader(new InputStreamReader(connectionSocket.getInputStream())); 	//creates input stream & attaches to socket
	    	  DataOutputStream  outToClient = new DataOutputStream(connectionSocket.getOutputStream());  //creates output stream& attaches to socket 
	    	 
	    	  clientSentence = inFromClient.readLine();				//from client   
	      }		//end while

	}	//end main method
	
	
	
	public static void inputFile() throws IOException
	{
		String stringLine; 
		
		FileInputStream input = new FileInputStream("AliceInWonderland_input.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(input));
		
		
		while((stringLine = br.readLine()) != null)
		{
			System.out.println(stringLine);
		}	//end while 
	
	}	//end input File method

	
}	//end MPC Server class
