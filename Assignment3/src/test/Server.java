package test;

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
import java.util.logging.Level;
import java.util.logging.Logger;


public class Server {
    public static void main(String[] args) throws IOException {

        int portNumber=10020;
        
        //String file = "/home/zemoso05/Training/ClientServer/file.txt";
        
        try ( 
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out =
                new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        ) {
            
            System.out.println("Accepted connection :\n " + clientSocket+"\n"); 
         // Initiate conversation with client
            String inputLine,outputLine;
	        Protocol kkp = new Protocol();
	        outputLine = kkp.processInput(null);
	        out.println(outputLine);
	        while ((inputLine = in.readLine()) != null) {
	            outputLine = kkp.processInput(inputLine);
	            out.println(outputLine);
	            if(outputLine.contains("ACK"))
	            {
	            	String name="hanshika";
	            	 Thread x=new Thread(new SCThread(clientSocket,name));
	            	 System.out.println("here");
	            	 x.start();
	            }
	        }
           
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        } 
        
    }
}





class SCThread implements Runnable {
	
	private Socket socket;
	private String name;
	public SCThread(Socket ksocket,String name){
		this.socket=ksocket;
		this.name=name;
	}

	public void run() {
		System.out.println("New Thread Started! Welcome "+socket+" Aboard!!\n");
		String file = "/home/zemoso05/HelloWorld.txt";
		try(
				PrintWriter out =new PrintWriter(socket.getOutputStream(), true);
			    BufferedReader in = new BufferedReader(
			    		new InputStreamReader(socket.getInputStream()));
		){	
			File transferFile = new File (file);  
            BufferedInputStream bin = new BufferedInputStream(new FileInputStream(transferFile));
            byte [] bytearray = new byte [(int)transferFile.length()];
            bin.read(bytearray,0,bytearray.length); 
            OutputStream os = socket.getOutputStream();
            System.out.println("Sending Files...to "+name); 
            os.write(bytearray,0,bytearray.length); 
            System.out.println("File transfer completed!");
            os.flush(); 
            bin.close();
		}catch(IOException e){
			 Logger.getLogger(SCThread.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
}