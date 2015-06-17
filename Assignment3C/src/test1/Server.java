package test1;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    public static void main(String[] args) throws IOException {

        int portNumber=10020;
        
        try ( 
            ServerSocket serverSocket = new ServerSocket(portNumber);
           // Socket clientSocket = serverSocket.accept();
        ) {
           // System.out.println("Accepted connection :\n " + clientSocket+"\n"); 
        	while(true){
       	 		Thread x=new Thread(new SCThread(serverSocket.accept()));
       	 		x.start();
       	 		System.out.println(" Thread Done!!!");
        	}
        } 
        catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        } 
        
    }
}




class SCThread extends Thread implements Runnable  {
	
	private Socket socket;
	private String fileName;
	
	public SCThread(Socket ksocket){
		this.socket=ksocket;
		this.fileName="/home/zemoso05/Training/Assignment3C/file1.txt";
	}

	public void run() {
		System.out.println("New Thread Started! Welcome "+socket+" Aboard!!\n");
		try(
				PrintWriter out =new PrintWriter(socket.getOutputStream(), true);
			    BufferedReader in = new BufferedReader(
			    		new InputStreamReader(socket.getInputStream()));
		){	
			String inputLine,outputLine;
			outputLine="Welcome";
			out.println(outputLine);
	        while ((inputLine = in.readLine()) != null) {
	            if(inputLine.contains("hello")||inputLine.contains("Hello")){
	            	outputLine="ACK";
	            	out.println(outputLine);
	            }
	            if(outputLine.contains("ACK"))
	            {
	            	File transferFile = new File (fileName);  
	                BufferedInputStream bin = new BufferedInputStream(new FileInputStream(transferFile));
	                byte [] bytearray = new byte [(int)transferFile.length()];
	                bin.read(bytearray,0,bytearray.length); 
	                OutputStream os = socket.getOutputStream();
	                System.out.println("Sending Files..."); 
	                os.write(bytearray,0,bytearray.length); 
	                System.out.println("File transfer completed!");
	                os.flush(); 
	                bin.close();
	                System.out.println("Done!! File Send.");
	                break;
	            }
	        }
		}catch(IOException e){
			System.out.println("Unable to read file.");
			System.err.println(e.getMessage());
		}
	}
	
}
