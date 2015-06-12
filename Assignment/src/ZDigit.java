/**
 * 
 */

/**
 * @author zemoso05
 * Problem:
 * Write a class that represents a ZDigit (can hold 0,A-Z).
 * Constructor:
 * Accept any character A-Z, 0. Anything else it should throw an IllegalArgumentException.
 * ZDigit zd = new ZDigit('A')
 * ZDigit zd = new ZDigit('0')
 *
 */
public class ZDigit {
	
	private char zd;
	
	public ZDigit (char zd) {
		
		int ascii = (int) zd;
		
		if(( ( ascii>=65 && ascii<=90 ) || (ascii==48 )))
		{
			this.zd=zd;
		}
		else
		{
			//System.out.println((("IllegalArgumentException! "+zd+" is not a valid ZDigit. \n")));
			zd='\0';
			throw new IllegalArgumentException(Character.toString(zd));
		}
		
	}
	
	public char getZd() {
		return this.zd;
	}

}