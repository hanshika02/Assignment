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

public class KKServer {
    public static void main(String[] args) throws IOException {
        
        if (args.length != 1) {
            System.err.println("Usage: java KKServer <port number>");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[0]);
        //int portNumber=10020;
        
        String file = "/home/zemoso05/Training/ClientServer/file.txt";
        
        try ( 
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out =
                new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        ) {
        
            String inputLine, outputLine;
            
            // Initiate conversation with client
            System.out.println("Accepted connection :\n " + clientSocket+"\n"); 
            KKProtocol kkp = new KKProtocol();
            outputLine = kkp.processInput(null);
            out.println(outputLine);

            while ((inputLine = in.readLine()) != null) {
                outputLine = kkp.processInput(inputLine);
                out.println(outputLine);
                if(outputLine.equalsIgnoreCase("ACK"))
                {
                	File transferFile = new File (file); 
                	byte [] bytearray = new byte [(int)transferFile.length()]; 
                	BufferedInputStream bin = new BufferedInputStream(new FileInputStream(transferFile)); 
                	bin.read(bytearray,0,bytearray.length); 
                	OutputStream os = clientSocket.getOutputStream();
                	String name=kkp.getName(inputLine);
                	System.out.println("Sending Files...to "+name); 
                	os.write(bytearray,0,bytearray.length); 
                	System.out.println("File transfer completed!");
                	os.flush(); 
                	bin.close();
                	clientSocket.close(); 
                    break;
                }

            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        } 
    }
}