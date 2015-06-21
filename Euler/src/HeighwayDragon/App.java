package HeighwayDragon;

import java.awt.Point;

public class App {
	
	
	private static Point position;
	private static Point direction;
	private static StringBuffer instruction=new StringBuffer();
	private static long steps=0;
	private static int level=0;
	
	
	public App() {
		position=new Point(0,0);
		direction=new Point(0,1);
		instruction.append("Fa");

        for (int i = 0; i < 25; i++) {
            instruction = D(instruction);
            level++;
        }
		
	}
	
	public static void main(String[] args) {
		
		//System.out.println("Initial position : ("+position.x+","+position.y+")");
		App a=new App();
		try {
			a.traverse();
		} catch (Exception e) {
			System.out.println("Unable to execute at level : "+level+"position :"+position.x+","+position.y);
			System.out.println(e.getMessage());
		}
	}
	

	
	public void traverse() throws Exception {
        
		 for (int i = 0; i < instruction.length(); i++) {
	        	//System.out.println("len :"+instruction.length());
	        	
	            // draw
	            if (instruction.charAt(i) == 'F') {
	                position.x += direction.x;
	                position.y += direction.y;
	                steps++;
	 
	            } else if (instruction.charAt(i) == 'R') {
	                // turn right
	            	 int tmp = direction.x;
	                 direction.x = direction.y;
	                 direction.y = tmp * -1;
	 
	            } else if (instruction.charAt(i) == 'L') {
	                // turn left
	                int tmp = direction.x;
	                direction.x = direction.y * -1;
	                direction.y = tmp;
	            }
	            if(steps==100000000L){
	            	System.out.println("Final position at level :"+level+" after "+steps+" steps: ("+position.x+","+position.y+")");
	            	System.exit(1);
	            }
	        }
  	  }
	
	 private  StringBuffer D (StringBuffer instructionString) {
		 
	        StringBuffer newString = new  StringBuffer ( "" );
	 
	        for (int i = 0; i < instructionString.length(); i++) {
	            if (instructionString.charAt(i) == 'a') {
	                newString.append("aRbFR");
	            } else if (instructionString.charAt(i) == 'b') {
	                newString.append("LFaLb");
	            } else {
	                newString.append(instructionString.charAt(i));
	            }
	        }
	 
	        return  newString;
	    }
}
	
