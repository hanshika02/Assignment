package Ecommerceapi;

import java.rmi.server.UID;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Product extends demo{

	public boolean isPexist() {
		return pexist;
	}

	public String getPuid() {
		return psid;
	}

	private UID pid;
	private String psid;
	@SuppressWarnings("unused")
	private String Pname;
	@SuppressWarnings("unused")
	private String cat;
	@SuppressWarnings("unused")
	private String seller;
	@SuppressWarnings("unused")
	private int cost;
	private boolean pexist=false;
	
	Product(){
		pid=new UID();
		psid=pid.toString();
		System.out.println("Product with id: "+pid+" generated!");
	}
	
	Product(String pid,int n){
		this.psid=pid;
		Connection con=null;
		PreparedStatement pst=null;
		try{
			Class.forName(JDBC_DRIVER);
			con=DriverManager.getConnection(url, user, password);
			String sql;
			sql="SELECT * FROM Product WHERE Puid=?";
			pst=con.prepareStatement(sql);
			pst.setString(1,psid);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
					this.Pname=rs.getString("ProductName");
					this.cat=rs.getString("ProductCategory");
					this.seller=rs.getString("Seller");
					this.cost=rs.getInt("Cost");
					this.pexist=true;
			}
			rs.close();
			con.close();
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				if(con!=null)
					con.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
		
	}
	
	Product(String pname){
		this.Pname=pname;
		Connection con=null;
		PreparedStatement pst=null;
		try{
			Class.forName(JDBC_DRIVER);
			con=DriverManager.getConnection(url, user, password);
			String sql;
			sql="SELECT * FROM Product WHERE ProductName=?";
			pst=con.prepareStatement(sql);
			pst.setString(1,pname);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
					this.psid=rs.getString("Puid");
					this.Pname=rs.getString("ProductName");
					this.cat=rs.getString("ProductCategory");
					this.seller=rs.getString("Seller");
					this.cost=rs.getInt("Cost");
					this.pexist=true;
			}
			rs.close();
			con.close();
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				if(con!=null)
					con.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
		
	}
	
	
}
