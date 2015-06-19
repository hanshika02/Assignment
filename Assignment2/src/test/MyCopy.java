package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MyCopy {
public static void main(String[] args){
	BufferedReader br=null;
	BufferedWriter brw=null;
	try {
		br=new BufferedReader(new FileReader(args[0]));
		brw=new BufferedWriter(new FileWriter(args[1]));
		char[] buf=new char[1024];
		int bytesRead;
		while((bytesRead=br.read())>0){
			brw.write(buf, 0, bytesRead);
		}
	} catch (FileNotFoundException e) {
		System.out.println("File not found!");
	} catch (IOException e) {
		System.out.println("Unable to read file!");
	}
	;
	
}
}
