
package xor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
	
	public static void main(String[] args){
		
		List<Integer> c = new ArrayList<Integer>();
		
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("cipher1.txt"));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		scanner.useDelimiter(",");
		while (scanner.hasNextInt())
			c.add(scanner.nextInt());
		scanner.close();
		
		
		char[] password = new char[3];

		
		//Array of all possible keys
		for(int i=97;i<=122;i++){
			for(int j=97;j<=122;j++){
				for(int k=97;k<=122;k++){
					password[0]= (char) (i);
					password[1]= (char) (j);
					password[2]= (char) (k);
					int n = 0;
					StringBuilder sb = new StringBuilder();
					
					for (Integer x : c) {
						sb.append((char) (x ^ (int) password[n]));
						if (++n == 3)
							n = 0;
					}
					String text = sb.toString();
					if (text.indexOf(" the ") > -1) {
						int sum = 0;
						for (int t = 0; t < text.length(); ++t)
							sum += (int) text.charAt(t);
						System.out.println("Answer: " + sum);
					}
				}
			}
		}
		
		
	}
}
