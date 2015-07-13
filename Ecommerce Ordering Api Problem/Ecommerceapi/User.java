package Ecommerceapi;

import java.rmi.server.UID;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User extends demo{
	
	public boolean isUexist() {
		return uexist;
	}

	public String getUuid() {
		return uuid;
	}

	private UID uid;
	private String uuid;
	@SuppressWarnings("unused")
	private String fname;
	@SuppressWarnings("unused")
	private String lname;
	@SuppressWarnings("unused")
	private String gender;
	@SuppressWarnings("unused")
	private int age;
	private String addr;
	private long cont;
	private boolean uexist=false;
	
	User(){
		uid=new UID();
		uuid=uid.toString();
		System.out.println("User with id: "+uuid+" generated!");
	}
	
	User(String uid,int n){
		if(uid!=null) { uuid=uid.toString(); }
		this.uuid=uid;
		Connection con=null;
		PreparedStatement pst=null;
		try{
			Class.forName(JDBC_DRIVER);
			con=DriverManager.getConnection(url, user, password);
			String sql;
			sql="SELECT * FROM User WHERE Uid=?";
			pst=con.prepareStatement(sql);
			pst.setString(1,uuid);
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
					this.fname=rs.getString("FirstName");
					this.lname=rs.getString("LastName");
					this.gender=rs.getString("gender");
					this.age=rs.getInt("Age");
					this.addr=rs.getString("Address");
					this.cont=rs.getLong("ContactInfo");
					this.uexist=true;
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
	
	
	User(String uname){
		this.fname=uname;
		Connection con=null;
		PreparedStatement pst=null;
		try{
			Class.forName(JDBC_DRIVER);
			con=DriverManager.getConnection(url, user, password);
			String sql;
			sql="SELECT * FROM User WHERE FirstName=?";
			pst=con.prepareStatement(sql);
			pst.setString(1,uname);
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
					this.uuid=rs.getString("Uid");
					this.fname=rs.getString("FirstName");
					this.lname=rs.getString("LastName");
					this.gender=rs.getString("gender");
					this.age=rs.getInt("Age");
					this.addr=rs.getString("Address");
					this.cont=rs.getLong("ContactInfo");
					this.uexist=true;
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
	
	public String getAddr() {
		return this.addr;
	}

	public long getCont() {
		return this.cont;
	}
	

}
	

