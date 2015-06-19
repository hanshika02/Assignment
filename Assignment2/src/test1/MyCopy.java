package test1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MyCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream input = null;
		OutputStream output = null;
		try {
			input= new FileInputStream(args[0]);
			output = new FileOutputStream(args[1]);
			byte[] buf = new byte[1024];
			int bytesRead;
			while ((bytesRead = input.read(buf)) > 0) {
				output.write(buf, 0, bytesRead);
			}
		}catch (FileNotFoundException e) {
			 System.out.println("File Not Found!!");
		}catch (IOException e) {
			System.out.println("Unable to read file!!");
		}finally {
		       try {
		    	   input.close();
		    	   output.close();
		       } catch (IOException e) {
				
		       }
		      
		}	
		
	}

}
