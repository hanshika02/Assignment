package project18;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Project18 {
	
	public static void main(String[] args) {
		 int A[][]=new int[101][101];
		 File file=new File("triangle.txt");
		 try {
			BufferedReader br=new BufferedReader(new FileReader(file));
			int i=0,j=0;  String[] l=new String[105];
			while( (l[i]=br.readLine()) != null)
			{
				//System.out.println(l[i]);
				@SuppressWarnings("resource")
				Scanner in = new Scanner(l[i]).useDelimiter("[^0-9]+");
				j=0;
				while(in.hasNextInt()){
					A[i][j]=in.nextInt();
					j++;
				}
			    i++;
			}
			System.out.println();
			System.out.println("For third large matrix:");
			run(A);
			br.close();
			
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		
	 }

	
	public static void run(int B[][]) {
		int row,col;
		int l=B.length;
		for(row=(l-2);row>=0;row--){
			for(col=0;col<(B[row].length-1);col++){
				B[row][col]+=Math.max(B[row+1][col],B[row+1][col+1]);
			}
		}
		System.out.println();
		
		System.out.println("Maximum sum in the path is: "+B[0][0]+"\n");
		
	}


}
