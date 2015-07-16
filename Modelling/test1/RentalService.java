package test;

import java.util.ArrayList;


public class RentalService {

	Building b;
	private ArrayList<Integer> alot=new ArrayList<>();
	private boolean unalotted=false;
	private boolean alotted=false;


	public ArrayList<Integer> getAlot() {
		return alot;
	}
	
	public boolean rentFloor(int sqft,String buildingName,String tenant) throws RentalUnavailableException{
		int nf=1;
		b=new Building(buildingName,nf); // this can make database connection and retrieve all buildings data by its name
		if(sqft>b.getSqft()){
			int s=0;
			for(int i=1;i<=nf;i++){
				if((!b.isFloorFilled(i)) && (s>=sqft)){
					alot.add(i);
					s+=b.getSqft();
					this.alotted=true;
				}
			}
		}
		else
		{
			for(int i=1;i<=nf;i++){
				if(!b.isFloorFilled(i)){
					alot.add(i);
					b.setTenantName(tenant, i);
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
		b=new Building(building);
		if(b.isFloorFilled(floorNum)){
			unalotted=true;
			b.setFloorFilled(floorNum, false);
		}
		return unalotted;
	}
	
	public void listOccupancy(){
		ArrayList<Building> blist=new ArrayList<>();
		for(int i=0;i<blist.size();i++){
			blist.get(i).getFloor();
		}
	}
}
