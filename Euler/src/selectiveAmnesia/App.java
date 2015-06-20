package selectiveAmnesia;

import java.util.ArrayList;
import java.util.Random;

public class App {
	
	private static final int iter=100;
	
	public static void main(String[] args){
		ArrayList<Integer> lm=new ArrayList<>();
		ArrayList<Integer> rm=new ArrayList<>();
		int ltscore=0,rtscore=0;
		int calledNum;
		Random randomGenerator = new Random();
		int[] ls=new int[iter];
		int[] rs=new int[iter];
		
		for(int a=0;a<iter;a++)
		{ 
			ltscore=0;
			rtscore=0;
			for(int i=0;i<50;i++){
				calledNum=randomGenerator.nextInt(10);
				int x=0;
				System.out.println("calednum:"+calledNum);
			
				//For Larry
				if(lm.contains(calledNum)){
					ltscore++;
					x=lm.indexOf(calledNum);
					lm.remove(x);
					lm.add(calledNum);
				}
				else if(lm.size()<5){
					lm.add(calledNum);
				}
				else{
					lm.remove(0);
					lm.add(calledNum);
				}
				
				//System.out.println("Larry's Memory:"+lm);
				
				//For Robin
				if(rm.contains(calledNum)){
					rtscore++;
				}
				else if(rm.size()<5){
					rm.add(calledNum);
				}
				else{
					rm.remove(0);
					rm.add(calledNum);
				}
				
				//System.out.println("Robin's Memory:"+rm);
				
				
			}
			
			System.out.println("Larry's Score : "+ltscore);
			System.out.println("Robin's Score : "+rtscore);
			
			/*if(ltscore>rtscore) { System.out.println("Larry won!!"); }
			else { System.out.println("Robin won!!!"); }*/
			
			ls[a]=ltscore;
			rs[a]=rtscore;
		}
		
		
		float f=expectedValue(ls,rs);
		System.out.println("Expected value of |L-R| is : "+String.format("%.6f",f));
	}
	
	
	public static float expectedValue(int[] ls,int[] rs){
		float f=(float) 0.000000;
		int i=0;
		for(i=0;i<iter;i++)
		{
			f=f+((float) Math.abs(ls[i]-rs[i]));
		}
		return (f/i);
	}
	
}
