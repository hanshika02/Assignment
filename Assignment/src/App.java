import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 */

/**
 * @author zemoso05
 *
 */
public class App {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		// For input type (['A','B']), an invalid case
		ArrayList<Character> z=new ArrayList<>(Arrays.asList('A','J','T'));
		ZNumber z1=new ZNumber(z);
		System.out.println(z1.toString()+"\n\n");
		
		//For input type ['A','B'], a valid case
		ArrayList<Character> zx=new ArrayList<>(Arrays.asList('A','0','T'));
		ZNumber z2=new ZNumber(zx);
		System.out.println(z2.toString()+"\n\n");
		
		
		
		// For input type ('A','F'), an invalid case
		ZNumber z3 = new ZNumber('A','H','C','G');
		System.out.println(z3.toString()+"\n\n");
		
		// For input type ('A','F'), a valid case
		ZNumber z4 = new ZNumber('A','B');
		System.out.println(z4.toString()+"\n\n");
		
		
		
		// For input type ("ABCD"), an invalid case
		ZNumber z5 = new ZNumber("ABD");
		System.out.println(z5.toString()+"\n\n");
		
		// For input type ("ABCD"), a valid case
		ZNumber z6 = new ZNumber("ABCDEF");
		System.out.println(z6.toString()+"\n\n");
		
		
		// For implementation of toDecimal() function
		ZNumber z7=new ZNumber("ABCD");
		System.out.println(z7.toDecimal()+"\n\n");
		// for an invalid case:
		ZNumber z8=new ZNumber("AY");
		System.out.println(z8.toDecimal()+"\n\n");
		ZNumber z9=new ZNumber("AB");
		System.out.println(z9.toDecimal()+"\n\n");
		
		try
		{
			// For implementation of getZDigits() function
			int l=z7.len();
			ZDigit[] zd=new ZDigit[l];
			zd=z7.getDigits();
			for(int i=0;i<l;i++)
			{
				System.out.println(zd[i].getZd());
			}
			System.out.println();
			// For an invalid case
			int l1=z8.len();
			ZDigit[] zd1=new ZDigit[l];
			zd1=z8.getDigits();
			for(int i=0;i<l1;i++)
			{
				System.out.println(zd1[i].getZd());
			}
		}
		catch(NullPointerException e)
		{
			
		}
	}
	
}