package chase;
/*
 * 3780.618622
 */
public class App {
	     
        public static void main(String[] args) {
           
           Player dice;          // A variable that will refer to the dice.
           int rollCount;    // Number of times the dice have been rolled.
     
           dice = new Player();  // Create the PairOfDice object.
           rollCount = 0;
           
           /* Roll the dice until they come up snake eyes. */
           
           do {
               System.out.println("The dice come up " + dice.getDice1() 
                                                + " and " + dice.getDice2());
               rollCount++;
           } while (dice.isDice1kept() && dice.isDice2kept());
           
           /* Report the number of rolls. */
           
           System.out.println("\nIt took " + rollCount);
           
        }
        
     }  // end class RollFor2
     
	
	/*public static void main(String[] args) {
		Player p1=new Player();
		Player p2=new Player();
		
		whoWon(p1,p2);
		
	}
	
	public static void whoWon(Player p1,Player p2){
		if(p1.isDice1kept() && p1.isDice2kept()){
			System.out.println("Player 1 lost. Game over!!");
		}
		else if(p2.isDice1kept() && p2.isDice2kept())
		{
			System.out.println("Player 2 lost. Game over!!");	
		}
		else{
			chase(p1,p2);
		}
	}
	
	public static void chase(Player p1,Player p2){
		if(p1.getDice1()==1 || p1.getDice1()==6){
			if(p2.getDice1() == 1 || p2.getDice1()==6){
				whoWon(p1,p2);
			}
			else
			{
				p2.setDice1kept();
			}
		}
		else{
			p1.setDice1kept();
		}
	}*/
