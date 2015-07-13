package Ecommerceapi;

import java.util.Scanner;

public class demo {
	
	final String JDBC_DRIVER="com.mysql.jdbc.Driver";
	final String url="jdbc:mysql://localhost/assignment";
	final String user="root";
	final String password="12345";
	public static void main(String[] args){
		String method="Credit Card";
		String ProductName="Eraser";
		String UserName="Hanshika";
		Product p=new Product(ProductName);
		User u=new User(UserName);
		Orders o=new Orders(p.getPuid(),u.getUuid());
		if(!p.isPexist()){
			System.out.println("Invalid Product Name. Order cancelled!");
			System.exit(1);
		}
		else if(!u.isUexist()){
			System.out.println("Invalid User Name. Order cancelled!");
			System.exit(1);
		}
		else if(o.isOexist()){
			System.out.println("Order already exist. Do you want to still place it?");
			Scanner in = new Scanner(System.in);
			boolean ans=false;
			ans=in.nextBoolean();
			if(ans){
				o.insert(p.getPuid(),u.getUuid(),method);
			}
			else
			{
				System.out.println("No order placed!");
			}
			in.close();
		}
		else
		{
			o.insert(p.getPuid(),u.getUuid(),method);
		}
		
	}	
	
}
