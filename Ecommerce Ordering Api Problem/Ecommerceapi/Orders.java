package Ecommerceapi;

import java.rmi.server.UID;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Random;


public class Orders extends demo implements app{
	 
	public boolean isOexist() {
		return oexist;
	}

	private UID oid;
	private String osid;
	@SuppressWarnings("unused")
	private UID pid;
	private String psid;
	@SuppressWarnings("unused")
	private UID uid;
	private String usid;
	private java.sql.Date del;
	private String method;
	private String addr;
	private long cont;
	private boolean oexist=false;
	@SuppressWarnings("unused")
	private Product p;
	private User u;
	
	Orders(String pid,String uid){
		oid=new UID();
		this.osid=oid.toString();
		System.out.println("Order with id: "+osid+" generated!");
		if(uid!=null) { osid=uid.toString(); }
		this.usid=uid;
		this.psid=pid;
		Connection con=null;
		PreparedStatement pst=null;
		try{
			Class.forName(JDBC_DRIVER);
			con=DriverManager.getConnection(url, user, password);
			String sql;
			sql="SELECT * FROM Orders WHERE Pid=? && Uid=?";
			pst=con.prepareStatement(sql);
			pst.setString(1,psid);
			pst.setString(2,usid);
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
					oexist=true;
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
	
	@Override
	public void insert(String pid,String uid,String method) {
		// TODO Auto-generated method stub
		this.psid=pid;
		this.usid=uid;
		if(oid!=null ) { this.osid=oid.toString(); }
		else{
			oid=new UID();
			osid=oid.toString();
		}
		this.method=method;
		p=new Product(pid,1);
		u=new User(uid,1);
		Connection con=null;
		PreparedStatement pst=null;
		try{
			Class.forName(JDBC_DRIVER);
			con=DriverManager.getConnection(url, user, password);
			String sql="INSERT INTO Orders VALUES(?,?,?,?,?,?,?)";
			pst=con.prepareStatement(sql);
			pst.setString(1,osid);
			pst.setString(2,psid);
			pst.setString(3,usid);
				
			Random rg=new Random();
			int n=rg.nextInt(10);
			this.del=getDelDate(n);
			
			pst.setDate(4, this.del);
			pst.setString(5,this.method);
			this.addr=u.getAddr();
			pst.setString(6, this.addr);
			this.cont=u.getCont();
			pst.setLong(7,this.cont);
			int rows=pst.executeUpdate();
			System.out.println("Rows :"+rows+" updated!");

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

	private Date getDelDate(int n) {
		// TODO Auto-generated method stub
		Calendar cal=Calendar.getInstance();
		cal.setTime(new java.util.Date());
		cal.add(Calendar.DATE, n);
		long d=cal.getTimeInMillis();
		java.sql.Date sqlDate = new java.sql.Date(d);
		return sqlDate;
	}
	
	
	
}
