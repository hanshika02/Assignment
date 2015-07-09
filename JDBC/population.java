package Assignments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class population {
	
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
			
			sql="SELECT p.Stateut AS Stateut,(a.y2006/p.Pop2011)*100000 AS cal FROM population p JOIN accidents a "
					+ "ON (a.StateUts=p.Stateut) WHERE p.Stateut<>'All India' ORDER BY cal desc LIMIT 0,3; ";
			ResultSet rs=smt.executeQuery(sql);
			System.out.println("\n\n");
			System.out.println("States & Union Territories   \t| Value for Most Accident Prone States per capita for year 2006");
			System.out.println("-----------------------------\t---------------------");
			while(rs.next()){
				String first=rs.getString("Stateut");
				double num1=rs.getDouble("cal");
				System.out.println(first+"\t\t\t| "+num1);
			}
			System.out.println("\n\n");
			
			
			sql="SELECT p.Stateut AS Stateut,(a.y2007/p.Pop2011)*100000 AS cal FROM population p JOIN accidents a "
					+ "ON (a.StateUts=p.Stateut) WHERE p.Stateut<>'All India' ORDER BY cal desc LIMIT 0,3; ";
			rs=smt.executeQuery(sql);
			System.out.println("\n\n");
			System.out.println("States & Union Territories   \t| Value for Most Accident Prone States per capita for year 2007"); 
			System.out.println("-----------------------------\t---------------------");
			while(rs.next()){
				String first=rs.getString("Stateut");
				double num1=rs.getDouble("cal");
				System.out.println(first+"\t\t\t| "+num1);
			}
			System.out.println("\n\n");
			
			sql="SELECT p.Stateut AS Stateut,(a.y2008/p.Pop2011)*100000 AS cal FROM population p JOIN accidents a "
					+ "ON (a.StateUts=p.Stateut) WHERE p.Stateut<>'All India' ORDER BY cal desc LIMIT 0,3; ";
			rs=smt.executeQuery(sql);
			System.out.println("\n\n");
			System.out.println("States & Union Territories   \t| Value for Most Accident Prone States per capita for year 2008"); 
			System.out.println("-----------------------------\t---------------------");
			while(rs.next()){
				String first=rs.getString("Stateut");
				double num1=rs.getDouble("cal");
				System.out.println(first+"\t\t\t| "+num1);
			}
			System.out.println("\n\n");
			
			sql="SELECT p.Stateut AS Stateut,(a.y2009/p.Pop2011)*100000 AS cal FROM population p JOIN accidents a "
					+ "ON (a.StateUts=p.Stateut) WHERE p.Stateut<>'All India' ORDER BY cal desc LIMIT 0,3; ";
			rs=smt.executeQuery(sql);
			System.out.println("\n\n");
			System.out.println("States & Union Territories   \t| Value for Most Accident Prone States per capita for year 2009"); 
			System.out.println("-----------------------------\t---------------------");
			while(rs.next()){
				String first=rs.getString("Stateut");
				double num1=rs.getDouble("cal");
				System.out.println(first+"\t\t\t| "+num1);
			}
			System.out.println("\n\n");
			
			sql="SELECT p.Stateut AS Stateut,(a.y2010/p.Pop2011)*100000 AS cal FROM population p JOIN accidents a "
					+ "ON (a.StateUts=p.Stateut) WHERE p.Stateut<>'All India' ORDER BY cal desc LIMIT 0,3; ";
			rs=smt.executeQuery(sql);
			System.out.println("\n\n");
			System.out.println("States & Union Territories   \t| Value for Most Accident Prone States per capita for year 2010"); 
			System.out.println("-----------------------------\t---------------------");
			while(rs.next()){
				String first=rs.getString("Stateut");
				double num1=rs.getDouble("cal");
				System.out.println(first+"\t\t\t| "+num1);
			}
			System.out.println("\n\n");
			
			sql="SELECT p.Stateut AS Stateut,(a.y2011/p.Pop2011)*100000 AS cal FROM population p JOIN accidents a "
					+ "ON (a.StateUts=p.Stateut) WHERE p.Stateut<>'All India' ORDER BY cal desc LIMIT 0,3; ";
			rs=smt.executeQuery(sql);
			System.out.println("\n\n");
			System.out.println("States & Union Territories   \t| Value for Most Accident Prone States per capita for year 2011"); 
			System.out.println("-----------------------------\t---------------------");
			while(rs.next()){
				String first=rs.getString("Stateut");
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
