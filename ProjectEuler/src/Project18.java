public class Project18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int A[][]={{3},
			      {7,4},
			      {2,4,6},
			      {8,5,9,3}};*/
		int B[][]={ {75},
				  {95,64},
				 {17,47,82},
				{18,35,87,10},
			   {20,4,82,47,65},
			  {19,1,23,75,3,34},
			 {88,2,77,73,7,63,67},
			{99,65,4,28,6,16,70,92},
		   {41,41,26,56,83,40,80,70,33},
		  {41,48,72,33,47,32,37,16,94,29},
		 {53,71,44,65,25,43,91,52,97,51,14},
		{70,11,33,28,77,73,17,78,39,68,17,57},
	   {91,71,52,38,17,14,91,43,58,50,27,29,48},
	  {63,66,4,68,89,53,67,30,73,16,69,87,40,31},
	 {04,62,98,27,23,9,70,98,73,93,38,53,60,04,23} };
		int sum=0,num=0; int j=0;
		num=B[0][0];
		System.out.print("Path is: "+num+" ");
		sum+=num;
		for(int i=0;i<(B.length-1);i++){
			/*if(B[i].length>2 && j>0){
				int x=B[i+1][j-1];
				int y=B[i+1][j];
				int z=B[i+1][j+1];
				if ( x > y && x > z )
			        { num=x; j--; }
			    else if ( y > x && y > z )
			    	{ num=y;  }
			    else if ( z > x && z > y )
			    	{ num=z; j++; }
			}
			else
			{*/
				if(B[i+1][j]>B[i+1][j+1]) {num=B[i+1][j]; }
				else {num=B[i+1][j+1]; j++;}
			//}
			System.out.print(num+" ");
			sum+=num;
		}
		System.out.println();
		System.out.println("Maximum sum in this path is:"+sum);
		
	}
/*
 *    0
 *   1 2
 *  3 4 5
 * 6 7 8 9
 *  
 */
}
