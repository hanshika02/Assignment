package strategyTest;

import java.util.ArrayList;

public class LarryStrategy implements Strategy {

	@Override
	public int calScore(ArrayList<Integer> m, int num) {
		// TODO Auto-generated method stub
		int score=0;
		int x;
		
		if(m.contains(num)){
			score++;
			x=m.indexOf(num);
			m.remove(x);
			m.add(num);
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
