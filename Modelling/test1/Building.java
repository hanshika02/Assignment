package test;


public class Building{
	private String buildingName;
	private int sqft; // fixed sqft floor space
	private int nf;	//no. of floors
	private Floor[] floor;
	
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public void setSqft(int sqft) {
		this.sqft = sqft;
	}
	
	public void setFloorFilled(int f,boolean n){
		floor[f-1].setFilled(n);
	}
	
	public void setTenantName(String name,int n){
		floor[n-1].setTenantName(name);
	}

	
	public Building(String name,int nf){
		this.buildingName=name;
		this.nf=nf;
		floor=new Floor[nf];
	}
	
	public Building(String name){
		this.buildingName=name;
	}
	
	public String getBuildingName() {
		return buildingName;
	}

	public int getSqft() {
		return sqft;
	}
	
	public int getNf() {
		return nf;
	}
	
	public void getFloor(){
		for(int i=1;i<=nf;i++){
			System.out.println(floor[i].getFloorNum()+"\t"+floor[i-1].getTenantName());
		}
	}
	
	public boolean isFloorFilled(int n){
		return floor[n-1].isFilled();
	}
	
}