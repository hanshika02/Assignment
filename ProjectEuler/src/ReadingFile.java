import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class ReadingFile {

	public static void main(String[] args) throws FileNotFoundException {
		String fileName="triangle.txt";
		int b[][]=new int[100][100];
		File triangle = new File(fileName);
		BufferedReader br=new BufferedReader(new FileReader(triangle));
		String line; int j=0;
		try {
			while((line=br.readLine())!= null){
				int l=line.length();
				for(int i=0;i<l;i++){
					b[i][j]=line.charAt(i);
					System.out.print(b[i][j]);
				}
				System.out.println();
				j++;
			}
		} catch (IOException e1) {
			System.out.println("Unable to read file!");
		}
		
		try {
			br.close();
		} catch (IOException e) {
			System.out.println("Unable to close file!");
		}
	}

}
