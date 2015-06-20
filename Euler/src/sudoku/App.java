package sudoku;

public class App {
	
	protected int model[][]=new int[9][9] ;
	
	   public void createSituation(int modelx[][]){
		   for(int r=0;r<9;r++){
			   for(int c=0;c<9;c++){
				     model[r][c]=modelx[r][c];
			   }
		   }
	   }
	   
	   protected boolean checkRow(int row,int num) {
		   for(int col=0;col<9;col++){
			   if(model[row][col]==num)
				   return false;
		   }
		   return true;
	   }
	   
	   protected boolean checkCol(int col,int num) {
		   for(int row=0;row<9;row++){
			   if(model[row][col]==num)
				   return false;
		   }
		   return true;
	   }
	   
	   protected boolean checkGrid(int row, int col, int num){
		   row= (row/3)*3;
		   col=	(col/3)*3;
		   for(int r=0;r<3;r++){
			   for(int c=0;c<3;c++){
				   if(model[row+r][col+c]==num)
					   return false;
			   }
		   }
		   return true;
	   }
	   
	   public void solve( int row, int col) throws Exception{
		   if(row>8)
		   { 
			   System.out.println("SOLUTION FOUND::");
			   showAns();
			   System.exit(1);
		   }
		   
		   if(model[row][col] != 0){
			   next(row,col);
		   }
		   else
		   {
			   for(int num=1;num<10;num++)
			   {
				   if(checkRow(row,num) && checkCol(col,num) && checkGrid(row,col,num)){
					   model[row][col]=num;
					   next(row,col);
				   }
			   }
		   }
		   
		   model[row][col]=0;
	   }
	   
	   protected void next(int row, int col) throws Exception{
		   if(col<8)
			   solve(row,col+1);
		   else
			   solve(row+1,0);
	   }
	   
	   protected int showAns(){
		   for(int row=0;row<9;row++){
			   for(int col=0;col<9;col++){
				   System.out.print(model[row][col]+"\t");
			   }
			   System.out.println();
		   }
		   return(sumOfTopLeft3digit());
	   }
	   
	   protected int sumOfTopLeft3digit(){
		   return(model[0][0]+model[0][1]+model[0][2]);
	   }
	   
}
