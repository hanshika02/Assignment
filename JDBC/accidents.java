package Assignments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class accidents {
	
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
			sql="SELECT StateUts,y2006 FROM accidents ORDER BY y2006 DESC LIMIT 0,3;";
			ResultSet rs=smt.executeQuery(sql);
			
			
			System.out.println("For year 2006");
			System.out.println("+--------\t+-------+");
			System.out.println("|StateUts\t| y2006 |");
			System.out.println("+--------\t+-------+");
			while(rs.next()){
				String first=rs.getString("StateUts");
				int num=rs.getInt("y2006");
				System.out.println("|"+first+"\t| "+num+" |");
			}
			System.out.println("+--------\t+-------+");
			System.out.println("\n\n");
			
			sql="SELECT StateUts,y2007 FROM accidents ORDER BY y2007 DESC LIMIT 0,3;";
			rs=smt.executeQuery(sql);
			
			System.out.println("For year 2007");
			System.out.println("+--------\t+-------+");
			System.out.println("|StateUts\t| y2007 |");
			System.out.println("+--------\t+-------+");
			while(rs.next()){
				String first=rs.getString("StateUts");
				int num=rs.getInt("y2007");
				System.out.println("|"+first+"\t| "+num+" |");
			}
			System.out.println("+--------\t+-------+");
			System.out.println("\n\n");
			
			sql="SELECT StateUts,y2008 FROM accidents ORDER BY y2008 DESC LIMIT 0,3;";
			rs=smt.executeQuery(sql);
			
			System.out.println("For year 2008");
			System.out.println("+--------\t+-------+");
			System.out.println("|StateUts\t| y2008 |");
			System.out.println("+--------\t+-------+");
			while(rs.next()){
				String first=rs.getString("StateUts");
				int num=rs.getInt("y2008");
				System.out.println("|"+first+"\t| "+num+" |");
			}
			System.out.println("+--------\t+-------+");
			System.out.println("\n\n");
			
			sql="SELECT StateUts,y2009 FROM accidents ORDER BY y2009 DESC LIMIT 0,3;";
			rs=smt.executeQuery(sql);
			
			System.out.println("For year 2009");
			System.out.println("+--------\t+-------+");
			System.out.println("|StateUts\t| y2009 |");
			System.out.println("+--------\t+-------+");
			while(rs.next()){
				String first=rs.getString("StateUts");
				int num=rs.getInt("y2009");
				System.out.println("|"+first+"\t| "+num+" |");
			}
			System.out.println("+--------\t+-------+");
			System.out.println("\n\n");
			
			sql="SELECT StateUts,y2010 FROM accidents ORDER BY y2010 DESC LIMIT 0,3;";
			rs=smt.executeQuery(sql);
			
			System.out.println("For year 2010");
			System.out.println("+--------\t+-------+");
			System.out.println("|StateUts\t| y2010 |");
			System.out.println("+--------\t+-------+");
			while(rs.next()){
				String first=rs.getString("StateUts");
				int num=rs.getInt("y2010");
				System.out.println("|"+first+"\t| "+num+" |");
			}
			System.out.println("+--------\t+-------+");
			System.out.println("\n\n");
			
			sql="SELECT StateUts,y2011 FROM accidents ORDER BY y2011 DESC LIMIT 0,3;";
			rs=smt.executeQuery(sql);
			
			System.out.println("For year 2011");
			System.out.println("+--------\t+-------+");
			System.out.println("|StateUts\t| y2011 |");
			System.out.println("+--------\t+-------+");
			while(rs.next()){
				String first=rs.getString("StateUts");
				int num=rs.getInt("y2011");
				System.out.println("|"+first+"\t| "+num+" |");
			}
			System.out.println("+--------\t+-------+");
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
