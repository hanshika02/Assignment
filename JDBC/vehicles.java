package Assignments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class vehicles {
	
	private static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost/training";
	private static final String user="root";
	private static final String password="12345";
	
	public static void main(String[] args) {
		Connection con=null;
		Statement smt=null;
		try{
			Class.forName(JDBC_DRIVER);
			con=DriverManager.getConnection(url, user, password);
			smt=con.createStatement();
			String sql;
			
			sql="SELECT a.StateUts,ABS(a.y2010/v.y2010) AS cal FROM accidents a JOIN vehicle_counts v "
					+ "ON (v.StateUts=a.StateUts) ORDER BY cal DESC LIMIT 0,5;  ";
			ResultSet rs=smt.executeQuery(sql);
			System.out.println("\n\n");
			System.out.println("States & Union Territories   \t| Value for Most Accident Prone States by number of vehicle for year 2010");
			System.out.println("-----------------------------\t---------------------");
			while(rs.next()){
				String first=rs.getString("StateUts");
				double num1=rs.getDouble("cal");
				System.out.println(first+"\t\t\t| "+num1);
			}
			System.out.println("\n\n");
			
			sql="SELECT a.StateUts,ABS(a.y2011/v.y2011) AS cal FROM accidents a JOIN vehicle_counts v "
					+ "ON (v.StateUts=a.StateUts) ORDER BY cal DESC LIMIT 0,5;  ";
			rs=smt.executeQuery(sql);
			System.out.println("\n\n");
			System.out.println("States & Union Territories   \t| Value for Most Accident Prone States by number of vehicle for year 2011");
			System.out.println("-----------------------------\t---------------------");
			while(rs.next()){
				String first=rs.getString("StateUts");
				double num1=rs.getDouble("cal");
				System.out.println(first+"\t\t\t| "+num1);
			}
			System.out.println("\n\n");
			
			
			rs.close();
			smt.close();
			con.close();
			
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			
			try{
				if(smt!=null)
					smt.close();
			}catch(SQLException se2){
				se2.printStackTrace();
			}
			try{
				if(con!=null)
					con.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
		
	}
}
