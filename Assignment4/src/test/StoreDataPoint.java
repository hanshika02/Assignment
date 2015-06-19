/**
 *  This class to store data points with following fields: name, category, month & sales.
 */
package test;

/**
 * @author zemoso05
 *
 */
public class StoreDataPoint {
	
	private String name;
	private String category;
	private String month;
	private int sales;
	
	public StoreDataPoint(String name, String category, String month, int sales) {
		this.name = name;
		this.category = category;
		this.month = month;
		this.sales = sales;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getMonth() {
		/*int month=0;
		
		switch (this.month) {
		case "Jan": month = 1; break;
		case "Feb": month = 2; break;
		case "Mar": month = 3; break;
		case "Apr": month = 4; break;
		case "May": month = 5; break;
		case "Jun": month = 6; break;
		case "Jul": month = 7; break;
		case "Aug": month = 8; break;
		case "Sep": month = 9; break;
		case "Oct": month = 10; break;
		case "Nov": month = 11; break;
		case "Dec": month = 12; break;
 
		}*/
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}
	

}
