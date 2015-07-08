package strategyTest.copy;

import java.util.ArrayList;

public class Context {
	private Strategy strategy;
	
	public Context(Strategy strategy){
		this.strategy=strategy;
	}
	
	public int executeStrategy(ArrayList<Integer> m,int num){
		return(strategy.calScore(m, num));
	}
}
