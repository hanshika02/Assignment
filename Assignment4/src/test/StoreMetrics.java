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

/**
 * @author zemoso05
 *
 */
public class StoreMetrics {
	
	private StoreDataPoint[] s; 
	
	public StoreMetrics() {
		
		try
		{
			String csvFile="/home/zemoso05/Downloads/store_data.csv";
			BufferedReader br=new BufferedReader(new FileReader(csvFile));
			String line="";
			int i=0;
			line=br.readLine();
			String cvsSplitBy = ",";
			s=new StoreDataPoint[192];
			while( (line=br.readLine()) != null){
				String[] z=line.split(cvsSplitBy);
				s[i]=new StoreDataPoint(z[0],z[1],z[2],Integer.parseInt(z[3]));
				i++;
			}
			br.close();
		}catch(Exception e){
			System.err.println(" CSV file cannot be read : "+e);
		}
		
	}
	
	public String HighestSalesMonCategory(String mon,String cat){
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
	
	public String HighestSalesMonAllCategory(String mon){
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
	
	
	public int AvgMonSalesCategory(String cat){
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
