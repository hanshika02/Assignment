package test2;

import java.util.ArrayList;
import java.util.List;


public class RentalService extends Demo{

	private ArrayList<Integer> alot=new ArrayList<>();
	private boolean unalotted=false;
	private boolean alotted=false;
	BuildingDaoImpl impl;
	
	public RentalService(){
		impl=new BuildingDaoImpl();
	}
	
	public ArrayList<Integer> getAlot() {
		if(alotted){
			return alot;
		}
		else
			return null;
	}
	
	public boolean rentFloor(int sqft,String buildingName,String tenant) throws RentalUnavailableException{
		List<Building> bl=impl.getBuildingList(buildingName);
		int nf=bl.size();
		int bsqft=bl.get(0).getSqft();
		if(sqft>bsqft){
			int s=0;
			for(int i=1;i<=nf;i++){
				if((bl.get(i).isFilled()==0) && (s>=sqft)){
					alot.add(i);
					if(s==sqft){ break; }
					else { s+=bsqft; }
					this.alotted=true;
				}
			}
		}
		else
		{
			for(int i=1;i<=nf;i++){
				if(bl.get(i).isFilled()==0){
					alot.add(i+1);
					bl.get(i).setTenantName(tenant);
					this.alotted=true;
				}
			}
		}
		if(!alotted){
			throw new RentalUnavailableException();
		}
		return alotted;
	}
	
	public boolean vacateFloor(String tenant,String building,int floorNum){
		Building b=impl.getBuildingFloor(building, floorNum);
		if(b.isFilled()==1){
			unalotted=true;
			b.setFilled(0);
		}
		return unalotted;
	}
	
	public void listOccupancy(){
		List<Building> result = impl.getAllBuildings();
		System.out.println("S.No. | Building Name       | Floor No. | Tenant's Name      | Floor area (in units of sqft)");
		for(int i=0;i<result.size();i++){
			System.out.println((i+1)+"|"+result.get(i).getBuildingName()+"|"+result.get(i).getFloorNo()+"|"+result.get(i).getTenantName()+"|"+result.get(i).getSqft());
		}
	}
}
