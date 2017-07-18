package Algorithm;


import java.util.ArrayList;

import gov.nasa.worldwind.geom.LatLon;

public class Algorithm {
	
	private Maps maps;
	private DataSource data;
	private ArrayList<LatLon> elev;
	private int slat; 						
	private int slon;	
	private int swsp_geo;
	private int lengthTab;						
	private int widthTab;
	private String[][] waterDirection;
	private ArrayList<Integer> coordinateList;
	private int maxGeoLat;
	private int minGeoLat;
	private int maxGeoLon;
	private int minGeoLon;
	
	public Algorithm() {
		super();
		init();
	}
	
	private void init() {
		data = new DataSource();
		data.makeData();
		this.maps = new Maps(data);
		slat = data.slat;
		slon = data.slon;
		lengthTab = data.length_tab;
		widthTab = data.width_tab;
		swsp_geo = data.swsp_geo;
	}
	
	public int getLengthTab() {
		return lengthTab;
	}

	public int getWidthTab() {
		return widthTab;
	}

	public PositionHolder getStartPosition() {
		return new PositionHolder(slat, slon);
	}

	public String[][] getWaterDirections() {
		return waterDirection;
	}

	public ArrayList<Integer> getCoordinateList() {
		return coordinateList;
	}

	public void calculation(Integer[][] netMap3, ArrayList<Integer> list2, ArrayList<Integer> wetList2, Boolean[][] bolleanNetMap3, ArrayList<Integer> listOfPoints2, String[][] waterDirection2) {
		
		bolleanNetMap3[(int) slat][(int) slon] = true;
		waterDirection2[(int) slat][(int) slon] = "$";
		
		for(int i = 0; i < list2.size(); i += 2) {
			
			if(netMap3[(slat - list2.get(i))][(slon - list2.get(i + 1))] < swsp_geo) {
				
				listOfPoints2.add(netMap3[(slat - list2.get(i))][(slon - list2.get(i + 1))]);
				wetList2.add((slat - list2.get(i)));	//wps. X nowego zalanego punktu
				wetList2.add((slon - list2.get(i + 1)));	//wsp. Y nowego zalanego punktu
				bolleanNetMap3[(slat - list2.get(i))][(slon - list2.get(i + 1))] = true;
				waterDirection2[(slat - list2.get(i))][(slon - list2.get(i + 1))] = "#";
									
			} else {
				bolleanNetMap3[(slat - list2.get(i))][(slon - list2.get(i + 1))] = true;
			}
		}
		System.out.println(listOfPoints2 + " Punkty zalane");
		System.out.println(wetList2 + " Wspolrzedne X i Y zalanych punktow");
		System.out.println(" ");			
					

}

public void calculation2(Integer[][] netMap3, ArrayList<Integer> list2, ArrayList<Integer> wetList2, Boolean[][] bolleanNetMap3, ArrayList<Integer> listOfPoints2, String[][] waterDirection2) {
	
	slat = wetList2.get(0);
	slon = wetList2.get(1);
	listOfPoints2.remove(0);
	wetList2.remove(1);
	wetList2.remove(0);

	
	for(int i = 0; i < list2.size(); i += 2) {
		try {
			if(bolleanNetMap3[slat - list2.get(i)][slon - list2.get(i + 1)] == false) {
				if(netMap3[slat - list2.get(i)][slon - list2.get(i + 1)] < swsp_geo) {
					
						listOfPoints2.add(netMap3[slat - list2.get(i)][slon - list2.get(i + 1)]);
						wetList2.add(slat - list2.get(i));
						wetList2.add(slon - list2.get(i + 1));
						bolleanNetMap3[slat - list2.get(i)][slon - list2.get(i + 1)] = true;
						waterDirection2[slat - list2.get(i)][slon - list2.get(i + 1)] = "#";
				} else {
					bolleanNetMap3[slat - list2.get(i)][slon - list2.get(i + 1)] = true;
				}
											
			} else {
				bolleanNetMap3[slat - list2.get(i)][slon - list2.get(i + 1)] = true;
			}
		}
			
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Wyszedles po za obszar!");		
			}
		}
	
	System.out.println(listOfPoints2);
	System.out.println(wetList2);
	System.out.println(" ");
	
}

public void startCalculation() {
	Integer[][] netMap3 = maps.netMap();
	ArrayList<Integer> list2 = maps.CoordinateList();
	ArrayList<Integer> wetList2 = maps.wetPoints();
	Boolean[][] bolleanNetMap3 = maps.booleanNetMap();
	ArrayList<Integer> listOfPoints2 = maps.listOfPoints();
	String[][] waterDirection2 = maps.createWaterTab();
	
	calculation(netMap3, list2, wetList2, bolleanNetMap3, listOfPoints2, waterDirection2);
	do {
	calculation2(netMap3, list2, wetList2, bolleanNetMap3, listOfPoints2, waterDirection2);
	} while (listOfPoints2.isEmpty() == false && wetList2.isEmpty() == false);
	
	waterDirection = waterDirection2;
	coordinateList = list2;
}

public SectorData maxMinLatLon() {
	
	if (data.rtwsp_geo_lat_source > data.lbwsp_geo_lat_source) {
		maxGeoLat = data.rtwsp_geo_lat_source;
		minGeoLat = data.lbwsp_geo_lat_source;
	} else {
		maxGeoLat = data.lbwsp_geo_lat_source;
		minGeoLat = data.rtwsp_geo_lat_source;
	}

	if (data.rtwsp_geo_lon_source > data.lbwsp_geo_lon_source) {
		maxGeoLon = data.rtwsp_geo_lon_source;
		minGeoLon = data.lbwsp_geo_lon_source;
	} else {
		maxGeoLon = data.lbwsp_geo_lon_source;
		minGeoLon = data.rtwsp_geo_lon_source;
	}
	return new SectorData(new PositionHolder(minGeoLat, minGeoLon), new PositionHolder(maxGeoLat, maxGeoLon));
	
}


}