package poker;

public class Card implements Comparable<Card> {
	enum Suit{
		Diamond, Club, Heart, Spade
	};
	
	Suit suit;
	int value;
	
    public String getSuit() {
    	return suit.toString();
	}

	public void setSuit(char suit) {
		if (suit == 'D') this.suit=Suit.Diamond;
		else if (suit == 'C') this.suit=Suit.Club;
		else if (suit == 'H') this.suit=Suit.Heart;
        else { this.suit=Suit.Spade;}
	}

	public int getValue() {
        return value;
	}

	public void setValue(char value) {
		if(value =='1' || value =='2' || value =='3'|| value =='4' || value =='5'|| value =='6' || value =='7'|| value =='8' || value =='9') {
    		int intvalue= (int) (value);
            this.value=(intvalue-48);
    	}
    	
        if (value == 'T') this.value=10;
        if (value == 'J') this.value=11;
        if (value == 'Q') this.value=12;
        if (value == 'K') this.value=13;
        if (value == 'A') this.value=14;
        
	}	
		
	@Override
	public String toString() {
		return "Card [suit=" + suit + ", value=" + value + "]";
	}

	@Override
	public int compareTo(Card c) {
		// TODO Auto-generated method stub
	    if (this.value < c.value) {
	      return -1;
	    }else if (this.value > c.value) {
	      return 1;
	    }
	    return 0;
         
	}
	
}

