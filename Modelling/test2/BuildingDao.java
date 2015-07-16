package test2;

import java.util.List;

public interface BuildingDao {
	 public List<Building> getAllBuildings();
	 public List<Building> getBuildingList(String buildingName);
	 public Building getBuildingFloor(String buildingName,int floorNum);
}
