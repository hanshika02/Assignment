package sudoku;

public class sudoku {
	public static void main(String[] args) throws Exception{
		App sudoku=new App();
		int modelx[][]=new int[9][9];
		
		for(int r=0;r<9;r++){
			for(int c=0;c<9;c++){
				modelx[r][c]=0;
			}
		}
		
		modelx[0][0] = 9 ; modelx[0][4] = 2 ; modelx[0][6] = 7 ; modelx[0][7] = 5 ;
	    modelx[1][0] = 6 ; modelx[1][4] = 5 ; modelx[1][7] = 4 ;
	    modelx[2][1] = 2 ; modelx[2][3] = 4 ; modelx[2][7] = 1 ;
	    modelx[3][0] = 2 ; modelx[3][2] = 8 ;
	    modelx[4][1] = 7 ; modelx[4][3] = 5 ; modelx[4][5] = 9 ; modelx[4][7] = 6 ;
	    modelx[5][6] = 4 ; modelx[5][8] = 1 ;
	    modelx[6][1] = 1 ; modelx[6][5] = 5 ; modelx[6][7] = 8 ;
	    modelx[7][1] = 9 ; modelx[7][4] = 7 ; modelx[7][8] = 4 ;
	    modelx[8][1] = 8 ; modelx[8][2] = 2 ; modelx[8][4] = 4 ; modelx[8][8] = 6 ;
	      
		sudoku.createSituation(modelx);
		sudoku.solve(0, 0);
		int x=sudoku.showAns();
		System.out.println(x);
	}
}
