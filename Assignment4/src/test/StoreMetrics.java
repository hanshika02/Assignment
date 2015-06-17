/**
 *
 * Class called StoreMetrics which takes a collection of StoreDataPoints.
 * StoreMetrics should have methods which give
 *  a) Store with highest sales for any given month in a particular category.
 *  b) Store with highest sales for any given month for all categories combined.
 *	c) Average monthly sales for a category (all stores combined)
 *
 */
package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * @author zemoso05
 *
 *  All comments are codes written for checking working of this class.
 *  
 */
public class StoreMetrics {
	
	private /*static*/ ArrayList<StoreDataPoint> s; 
	
	public StoreMetrics(String csvFile) {
	//public static void main(String[] args){
		
		try
		{
			//String csvFile="/home/zemoso05/Downloads/store_data.csv";
			BufferedReader br=new BufferedReader(new FileReader(csvFile));
			String line="";
			line=br.readLine();
			String cvsSplitBy = ",";
			StoreDataPoint e;
			s=new ArrayList<>();
			while( (line=br.readLine()) != null){
				String[] z=line.split(cvsSplitBy);
				e=new StoreDataPoint(z[0],z[1],z[2],Integer.parseInt(z[3]));
				s.add(e);
			}
			br.close();
		}catch(Exception e){
			System.err.println(" CSV file cannot be read : "+e);
		}
		
		//System.out.println(HighestSalesMonCategory(s.get(45).getMonth(),s.get(45).getCategory()));
		//System.out.println(HighestSalesMonAllCategory(s.get(99).getMonth()));
		//System.out.println(AvgMonSalesCategory(s.get(156).getCategory()));
	}
	
	public /*static*/ String HighestSalesMonCategory(String mon,String cat){
		int sales=0; String name=null;
		for(StoreDataPoint x:s){
			if( (x.getCategory().equals(cat)) && (x.getMonth().equals(mon)) ){
				int y=x.getSales();
				if(y>sales)
				{	
					sales=y;
					name=x.getName();
				}
			}
		}
		return name;
	}
	
	public /*static*/ String HighestSalesMonAllCategory(String mon){
		String name=null; int sales=0;
		for(StoreDataPoint x:s){
			if( (x.getMonth().equals(mon)) ){
				int y=x.getSales();
				if(y>sales)
				{	
					sales=y;
					name=x.getName();
				}
			}
		}
		return name;
	}
	
	
	public /*static*/ int AvgMonSalesCategory(String cat){
		int avgsales=0, totsales=0; int n=0;
		for(StoreDataPoint x:s){
			if( (x.getCategory().equals(cat)) ){
				totsales+=x.getSales();
				n++;
			}
		}
		avgsales=totsales/n;
		return avgsales;
	}
}
