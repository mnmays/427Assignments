//imports
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class MPSClient 
{
	public static void main(String[] argv) throws Exception 
	{
		//declarations
        String sentence; 
        String modifiedSentence; 

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in)); 
        Socket clientSocket = new Socket("hostname", 6789); 
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream()); 
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); 
        
        //display menu to user
        System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
        System.out.println("+-+-+-+-+-+-+ Multiple Channel Protocol +-+-+-+-+-+-+");
        System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
        System.out.println("Commands allowed by user:");
        System.out.println("-Query");
        System.out.println("-Download");
        
        //prompt user
        System.out.println("command: ");
        
        //read input from user
        sentence = inFromUser.readLine(); 
        
        outToServer.writeBytes(sentence + '\n'); 
        
        //server response
        modifiedSentence = inFromServer.readLine(); 
        System.out.println("FROM SERVER: " + modifiedSentence); 

        clientSocket.close(); 

	}

}
