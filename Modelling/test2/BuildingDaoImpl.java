package test2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class BuildingDaoImpl implements BuildingDao {

	List<Building> Buildings;
	final String JDBC_DRIVER="com.mysql.jdbc.Driver";
	final String url="jdbc:mysql://localhost/assignment";
	final String user="root";
	final String password="12345";

	public BuildingDaoImpl(){
	      Buildings = new ArrayList<Building>();
	      Connection con = null;
	      Statement smt=null;
			try{
				Class.forName(JDBC_DRIVER);
				con=DriverManager.getConnection(url, user, password);
				String sql;
				sql="SELECT * FROM building";
				smt=con.createStatement();
				ResultSet rs=smt.executeQuery(sql);
				while(rs.next()){
					Building b=new Building();
					String name=rs.getString("name");
					int floorNo=rs.getInt("floorNo");
					String tenant=rs.getString("tenantName");
					int isFilled=rs.getInt("isFilled");
					int sqft=rs.getInt("sqft");
					b.setBuildingName(name);
					b.setFloorNo(floorNo);
					b.setTenantName(tenant);
					b.setFilled(isFilled);
					b.setSqft(sqft);
					Buildings.add(b);
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
	public List<Building> getAllBuildings() {
		// TODO Auto-generated method stub
		return Buildings;
	}

	@Override
	public List<Building> getBuildingList(String buildingName) {
		List<Building> bl=new ArrayList<>();
		for(Building b:Buildings){
			if(b.getBuildingName().equalsIgnoreCase(buildingName)){
				bl.add(b);
			}
		}
		return bl;
	}

	@Override
	public Building getBuildingFloor(String buildingName,int floorNum) {
		for(Building b:Buildings){
			if(b.getBuildingName().equalsIgnoreCase(buildingName) && (b.getFloorNo()==floorNum) ){
				return b;
			}
		}
		return null;
	}

}
