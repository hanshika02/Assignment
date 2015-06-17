package test;

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
        
        String hostName = args[0];
        //String hostName="192.168.1.72";
        int portNumber=10020;
        String clientName="hanshika";
        String filer="recieved.java";
        //Protocol kkp = new Protocol();
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
            //fromUser = stdIn.readLine();
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
                	int i=0;
                	System.out.println(i);
                	while((bytesRead=is.read(bytearray))>=0){
            			System.out.println(i);
            			bos.write(bytearray, 0, bytesRead);
            			currentTot+=bytesRead;
            		}
                	System.out.println(i);
                	bos.flush(); 
                    System.out.println("File " + filer
                        + " downloaded (" + currentTot + " bytes read)");
                    long end = System.currentTimeMillis();
                    System.out.println("Time taken " + (end - start) + " milliseconds");
                    bos.close(); 
                    kkSocket.close();
                    break;
                }
                if (fromServer.equals("TERMINATED"))
                	{
                		System.out.println("Bad Input or no response. Terminating!!");
                    	kkSocket.close();
                		break;
                	}
                fromUser = stdIn.readLine();
               /* if(fromUser.contains("Hello")||fromUser.contains("hello")) {
                	clientName=kkp.getName(fromUser).toString();
                	filer=clientName+".txt";
                }*/
                if (fromUser != null) {
                    System.out.println("Client: " + fromUser);
                    out.println(fromUser);
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
