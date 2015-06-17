package test1;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	private static long start = System.currentTimeMillis();
    public static void main(String[] args) throws IOException {
        
        String hostName=args[0];
        int portNumber=10020;
        
        String clientName=null;
        String filer=null;
        
        try (
            Socket kkSocket = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(kkSocket.getInputStream()));
        ) {
        	System.out.println("Server Started and listening to the port : "+portNumber+"!");
            
        	BufferedReader stdIn =
                new BufferedReader(new InputStreamReader(System.in));
            String fromServer;
            String fromUser;
            
            while ((fromServer = in.readLine()) != null) {
                System.out.println("Server: " + fromServer);
                if(fromServer.equals("ACK")){
                	System.out.println("Welcome "+clientName+" Aboard!!");
                	System.out.println("Recieving files....");
                	int filesize=1022386; 
                	int bytesRead; 
                	int currentTot = 0; 
                	byte [] bytearray = new byte [filesize]; 
                	InputStream is = kkSocket.getInputStream(); 
                	FileOutputStream fos = new FileOutputStream(filer); 
                	BufferedOutputStream bos = new BufferedOutputStream(fos);
                	System.out.println("Download Starting....");
                	while((bytesRead=is.read(bytearray))>=0){
            			bos.write(bytearray, 0, bytesRead);
            			currentTot+=bytesRead;
            		}
                	bos.flush(); 
                    System.out.println("File " + filer
                        + " downloaded (" + currentTot + " bytes read)");
                    long end = System.currentTimeMillis();
                    System.out.println("Time taken " + (end - start) + " milliseconds");
                    bos.close(); 
                    break;
                }
                fromUser = stdIn.readLine();
                System.out.println("Client: " + fromUser);
                out.println(fromUser);
                if(fromUser.contains("Hello")||fromUser.contains("hello")) {
                	clientName=fromUser.substring(14, fromUser.length());
                	filer=clientName+".txt";
                }
                if (! (fromUser.contains("hello") || fromUser.contains("Hello")) ) {
                    System.out.println("Invalid or bad statement. Terminating connection..");
                    System.exit(1);
                }
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                hostName);
            System.exit(1);
        }
        
    }
}
