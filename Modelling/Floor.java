package test;

public class Floor {

	private int isFilled;
	private String tenantName;
	private int floorNum;
	
	Floor(String tenant,int floorNum){
		this.tenantName=tenant;
		this.floorNum=floorNum;
	}
	
	public int isFilled() {
		return this.isFilled;
	}
	
	public void setFilled(int isFilled) {
		this.isFilled = isFilled;
	}
	
	public String getTenantName() {
		return this.tenantName;
	}
	
	public int getFloorNum() {
		return this.floorNum;
	}
	
	public void setTenantName(String name) {
		this.tenantName=name;
	}
	
}
