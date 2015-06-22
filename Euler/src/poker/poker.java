package poker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


public class poker {
    
	public static void main(String[] args) {
		
		Card[] hand1 = new Card[5];
	    Card[] hand2 = new Card[5];
	    
		int result = 0;
		String file="/home/zemoso05/training/Euler/poker";
		File f=new File(file);
		
		try (
			BufferedReader br=new BufferedReader(new FileReader(f))
		)
		
		{   String line;
			String[] linepieces;
			while( (line=br.readLine()) != null) {
				linepieces=line.split(" ");
				for (int i = 0; i < 5; i++) {
		            hand1[i] = new Card();
		            hand1[i].setValue(linepieces[i].substring(0,1).charAt(0));
		            hand1[i].setSuit(linepieces[i].substring(1,2).charAt(0));
		        }

		        for (int i = 0; i < 5; i++) {
		            hand2[i] = new Card();
		            hand2[i].setValue(linepieces[i+5].substring(0,1).charAt(0));
		            hand2[i].setSuit(linepieces[i+5].substring(1,2).charAt(0));
		        }
		        	
		      
				 Arrays.sort(hand1);
				 Arrays.sort(hand2);
				
				 if (DidPlayer1Win(hand1, hand2)) result++;   
		         
			}
			
			   
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		} catch (IOException e) {
			System.out.println("File cannot be read.");
		}			
		        
        System.out.println("Player 1 won {0} hands " + result);
     
	}
	
	
	
    private static boolean DidPlayer1Win(Card[] hand1, Card[] hand2) {
    	
        if (IsRoyalFlush(hand1) != IsRoyalFlush(hand2)) return IsRoyalFlush(hand1) > IsRoyalFlush(hand2);            
        if (IsStraightFlush(hand1) != IsStraightFlush(hand2)) return IsStraightFlush(hand1) > IsStraightFlush(hand2);                        
        if (IsFourOfAKind(hand1) != IsFourOfAKind(hand2)) return IsFourOfAKind(hand1) > IsFourOfAKind(hand2);                        
        if (IsFullHouse(hand1, 1) != IsFullHouse(hand2, 1)) return IsFullHouse(hand1,1) > IsFullHouse(hand2,1);            
        if (IsFullHouse(hand1,2) != IsFullHouse(hand2,2)) return IsFullHouse(hand1,2) < IsFullHouse(hand2,2);                                      
        if (IsFlush(hand1) != IsFlush(hand2)) return IsFlush(hand1) > IsFlush(hand2);            
        if (IsStraight(hand1) != IsStraight(hand2)) return IsStraight(hand1) > IsStraight(hand2);                      
        if (IsThreeOfAKind(hand1) != IsThreeOfAKind(hand2)) return IsThreeOfAKind(hand1) > IsThreeOfAKind(hand2);            
        if (IsTwoPairs(hand1, 1) != IsTwoPairs(hand2, 1)) return IsTwoPairs(hand1, 1) > IsTwoPairs(hand2, 1);            
        if (IsTwoPairs(hand1, 2) != IsTwoPairs(hand2, 2)) return IsTwoPairs(hand1, 2) > IsTwoPairs(hand2, 2);            
        if (IsOnePair(hand1) != IsOnePair(hand2)) return IsOnePair(hand1) > IsOnePair(hand2);            
        if (IsHighCard(hand1,0) != IsHighCard(hand2,0)) return IsHighCard(hand1,0) > IsHighCard(hand2,0);            
        if (IsHighCard(hand1,1) != IsHighCard(hand2,1)) return IsHighCard(hand1,1) > IsHighCard(hand2,1);            
        if (IsHighCard(hand1,2) != IsHighCard(hand2,2)) return IsHighCard(hand1,2) > IsHighCard(hand2,2);            
        if (IsHighCard(hand1,3) != IsHighCard(hand2,3)) return IsHighCard(hand1,3) > IsHighCard(hand2,3);

        return false;
    }
    
    private static int IsStraight(Card[] h) {                                               
        for (int i = 0; i < 4; i++) {
            if (h[i].getValue() != (h[i+1].getValue() - 1)) {
                return -1;                    
            }
        }
        return h[4].getValue();
    }

    private static int IsFlush(Card[] h) {
        for (int i = 0; i < 4; i++) {
            if (h[i].getSuit().equals(h[i+1].getSuit()) == false ) {
                return -1;                    
            }
        }
        return h[4].getValue();
    }

    private static int IsStraightFlush(Card[] h) {
        if (IsFlush(h) > 0 && IsStraight(h) > 0) {
            return h[4].getValue();
        }
        return -1;                     
    }

    private static int IsRoyalFlush(Card[] h) {
        if (IsFlush(h) == 14) return 14;
        return -1;
    }

    private static int IsFourOfAKind(Card[] h) {
        if (h[0].getValue() == h[1].getValue() &&
            h[1].getValue() == h[2].getValue() &&
            h[2].getValue() == h[3].getValue())
            return h[0].getValue();
        if (h[1].getValue() == h[2].getValue() &&
            h[2].getValue() == h[3].getValue() &&
            h[3].getValue() == h[4].getValue())
            return h[1].getValue();

        return -1;

    }

    private static int IsFullHouse(Card[] h, int set) {            
        if(set == 1 &&
           h[0].getValue() == h[1].getValue() &&
           h[1].getValue() == h[2].getValue() &&
           h[3].getValue() == h[4].getValue())
            return h[0].getValue();
        if (set == 2 &&
            h[0].getValue() == h[1].getValue() &&
           h[1].getValue() == h[2].getValue() &&
           h[3].getValue() == h[4].getValue())
            return h[4].getValue();
        if(set == 1 &&
           h[0].getValue() == h[1].getValue() &&
           h[2].getValue() == h[3].getValue() &&
           h[3].getValue() == h[4].getValue())
            return h[4].getValue();
        if (set == 2 &&
            h[0].getValue() == h[1].getValue() &&
           h[2].getValue() == h[3].getValue() &&
           h[3].getValue() == h[4].getValue())
            return h[0].getValue();
        return -1;
    }

    private static int IsThreeOfAKind(Card[] h) {
        if (h[0].getValue() == h[1].getValue() &&
           h[1].getValue() == h[2].getValue())
            return h[0].getValue();

        if (h[1].getValue() == h[2].getValue() &&
           h[2].getValue() == h[3].getValue())
            return h[1].getValue();

        if (h[2].getValue() == h[3].getValue() &&
           h[3].getValue() == h[4].getValue())
            return h[2].getValue();

        return -1;
    }

    private static int IsTwoPairs(Card[] h, int set) {
        if (set == 1 &&
            h[0].getValue() == h[1].getValue() &&
            h[2].getValue() == h[3].getValue())
            return h[0].getValue();
        if (set == 2 &&
        		h[0].getValue() == h[1].getValue() &&
            		h[2].getValue() == h[3].getValue())
            return h[2].getValue();                        
        if (set == 1 &&
        		h[0].getValue() == h[1].getValue() &&
            		h[3].getValue() == h[4].getValue())
            return h[0].getValue();
        if (set == 2 &&
        		h[0].getValue() == h[1].getValue() &&
            		h[3].getValue() == h[4].getValue())
            return h[3].getValue();

        if (set == 1 &&
        		h[1].getValue() == h[2].getValue() &&
            		h[3].getValue() == h[4].getValue())
            return h[1].getValue();
        if (set == 2 &&
        		h[1].getValue() == h[2].getValue() &&
            		h[3].getValue() == h[4].getValue())
            return h[3].getValue();
        return -1;
    }

    private static int IsOnePair(Card[] h) {
        if ( h[0].getValue() == h[1].getValue() ) return h[0].getValue();
        if ( h[1].getValue() == h[2].getValue() ) return h[1].getValue();
        if ( h[2].getValue() == h[3].getValue() ) return h[2].getValue();
        if ( h[3].getValue() == h[4].getValue() ) return h[3].getValue();
                    
        return -1;
    }

    private static int IsHighCard(Card[] h, int card) {            
        return h[4-card].getValue();
    }    

    
}
