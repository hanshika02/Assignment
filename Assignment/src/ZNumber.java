import java.util.ArrayList;

/*
 *  ZNumber zn = new ZNumber('A','B','C','D')
 *  System.out.println(zn) -> ABCD
 */
public class ZNumber {
	
	//Override toString()
	private StringBuffer zn =new StringBuffer("");
	
	
	// for parameters send in as arraylist
	// for type: ZNumber zn = new ZNumber(['A','B'])
	public ZNumber(ArrayList<Character> z) {
		int n=z.size();
		for(int i=0;i<n;i++)
		{
			ZDigit zd=new ZDigit(z.get(i));
			if(zd.getZd() != '\0'){
				zn.append(zd.getZd());
			}
			else
			{
				System.out.println("Invalid ZDigit : "+z.get(i)+" , so cannot form valid ZNumber");
				zn=null; break;
			}
		}
		if(zn!=null) System.out.println(zn);
	}
	
	
	// for parameters send in as chars eg: ZNumber zn = new ZNumber('A','B','C','D');
	public ZNumber(char... c) {
		int l=c.length;
		for(int i=0;i<l;i++)
		{
			ZDigit zd=new ZDigit(c[i]);
			if(zd.getZd() != '\0'){
				zn.append(zd.getZd());
			}
			else
			{
				System.out.println("Invalid ZDigit : "+c[i]+" , so cannot form valid ZNumber");
				zn=null; break;
			}
		}
		if(zn!=null) System.out.println(zn);
	}
	
	
	// for parameters send in as string eg: ZNumber zn = new ZNumber("ABCD");
	public ZNumber(String s){
		int l=s.length();
		for(int i=0;i<l;i++)
		{
			ZDigit zd=new ZDigit(s.charAt(i));
			if(zd.getZd() != '\0'){
				zn.append(zd.getZd());
			}
			else
			{
				System.out.println("Invalid ZDigit : "+s.charAt(i)+" , so cannot form valid ZNumber");
				zn=null; break;
			}
		}
		if(zn!=null) System.out.println(zn);
	}
	
	
	@Override
	public String toString() {
		if(zn != null){
			return "ZNumber [z=" + this.zn + "]";
		}
		else
		{
			return "Invalid ZNumber!!";
		}
	}
	
	
	//toDecimal()
	//- Will output the decimal value of the ZNumber.
	public int toDecimal(){
		int z=0;
		/*
		 * A is 1, B is 2.. Z is 26
		 * ZAlgebra to Decimal Conversion
		 * AB = (26^1)*1 + (26^0)*2 = 28
		 * A0 = (26^1)*1+(26^0)*0=26
		 * ABCD = (27^3)*1+(27^2)*2+(27^1)*3+(27^0)*4=19010
		 * 
		 * */
		if (zn != null)
		{
			int l=zn.length();
			for(int i=0;i<l;i++){
				char x=zn.charAt(i);
				int ascii=(int)x;
				if(ascii>=65)
				{
					z+=(Math.pow(27,(l-i-1)))*(ascii-64);
				}
				else
				{
					z+=(Math.pow(27, (l-i-1))*0);
				}
			}
			return z;
		}
		else
		{
			return 0;
		}
	}
	
	public int len() {
		return(zn.length());
	}
	
	//Implement a method on ZNumber
	public ZDigit[] getDigits(){
		
		if(zn != null)
		{
			int l=zn.length();
			ZDigit[] zs=new ZDigit[l];
			for(int i=0;i<l;i++){
				char c = zn.charAt(i);
				zs[i]=new ZDigit(c);
			}
			return zs;
		}
		else
		{	
			System.out.println("Not valid ZDigit & ZNumber, so no get ZDigits possible!! \n\n");
			return null;
		}
	}

}
