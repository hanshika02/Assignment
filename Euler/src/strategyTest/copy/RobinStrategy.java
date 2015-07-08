package strategyTest.copy;

import java.util.ArrayList;

public class RobinStrategy implements Strategy{
	
	@Override
	public int calScore(ArrayList<Integer> m, int num) {
		// TODO Auto-generated method stub
		int score=0;
		
		if(m.contains(num)){
			score++;
		}
		else if(m.size()<5){
			m.add(num);
		}
		else{
			m.remove(0);
			m.add(num);
		}
		
		return score;
	}
}
