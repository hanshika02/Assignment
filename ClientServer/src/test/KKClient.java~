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

public class KKClient {
	 
    public static void main(String[] args) throws IOException {
        
        if (args.length != 2) {
            System.err.println(
                "Usage: java KKClient <host name> <port number>");
            System.exit(1);
        }
        
        String hostName = args[0];
        //String hostName="zemoso05-Vostro-3546";
        int portNumber = Integer.parseInt(args[1]);
        //int portNumber=10020;
        String clientName=null;
        String filer=null;
        KKProtocol kkp = new KKProtocol();
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
                	while((bytesRead=is.read(bytearray))>=0){
            			bos.write(bytearray, 0, bytesRead);
            			currentTot+=bytesRead;
            		}
                	bos.flush(); 
                	bos.close(); 
                	kkSocket.close();
                    System.out.println("File " + filer
                        + " downloaded (" + currentTot + " bytes read)");
                    break;
                }
                if (fromServer.equals("TERMINATED"))
                	{
                		System.out.println("Bad Input or no response. Terminating!!");
                    	kkSocket.close();
                		break;
                	}
                fromUser = stdIn.readLine();
                if(fromUser.contains("Hello")||fromUser.contains("hello")) {
                	clientName=kkp.getName(fromUser).toString();
                	filer=clientName+".txt";
                }
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