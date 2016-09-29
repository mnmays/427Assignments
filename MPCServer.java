//package //_427Assignment;

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
		//String byteArray[] = null; 
		byte Array[] = null; 

	  ServerSocket welcomeSocket = new ServerSocket(6789); 
	    
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
	{
		String stringLine; 
		
		//File fileInput = new File("AliceInWonderland_input.txt");
		//FileInputStream input = new FileInputStream("AliceInWonderland_input.txt");
		//FileInputStream input = null; 
		//input = new FileInputStream(fileInput);
		//BufferedReader br = new BufferedReader(new InputStreamReader(input));
		
		java.io.File file = new java.io.File("AliceInWonderland_input.txt");

		
		try {

			Scanner input = new Scanner(file);

	        while (input.hasNextLine()) {
	            String line = input.nextLine();
	            Array = line.getBytes();
	            System.out.println(Array.length);
	        }
	        input.close();
	    } 
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
		

		
		//while((stringLine = br.readLine()) != null)
		//{
			//Array = stringLine.getBytes();	//converts to sequence of bytes
			
			//System.out.println(Array.length);
		//}	//end while 
	
	//}	//end input File method

	
}	//end MPC Server class
}
