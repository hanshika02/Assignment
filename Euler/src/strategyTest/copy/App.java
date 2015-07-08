package strategyTest.copy;

import java.util.ArrayList;
import java.util.Random;

public class App {
	
	private static final int iter=(10000/2);
	static int[] ls=new int[iter];
	static int[] rs=new int[iter];
	
	public static void main(String[] args) {
		ArrayList<Integer> lm=new ArrayList<>();
		ArrayList<Integer> rm=new ArrayList<>();
		
		int ltscore=0,rtscore=0;
		int calledNum;
		Random randomGenerator = new Random();
		
		for(int a=0;a<iter;a++)
		{ 
			ltscore=0;
			rtscore=0;
			for(int i=0;i<40;i++){
				//Random Number:
				calledNum=randomGenerator.nextInt(10);
				
				Context context=new Context(new LarryStrategy());
				ltscore+=context.executeStrategy(lm, calledNum);
				
				context=new Context(new RobinStrategy());
				rtscore+=context.executeStrategy(rm, calledNum);
			}
			ls[a]=ltscore;
			rs[a]=rtscore;
		}
		//Random Number:
		calledNum=randomGenerator.nextInt(10);
		
		Context context=new Context(new LarryStrategy());
		System.out.println(context.executeStrategy(lm, calledNum));
		
		context=new Context(new RobinStrategy());
		System.out.println(context.executeStrategy(lm, calledNum));
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
	
	public float ans(){
		float f=expectedValue(ls,rs);
		return f;
	}
	
}


