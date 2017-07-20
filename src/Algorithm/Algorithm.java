package Algorithm;


import java.util.ArrayList;

import gov.nasa.worldwind.WorldWindow;
import gov.nasa.worldwind.geom.LatLon;
import gov.nasa.worldwindx.examples.ApplicationTemplate;

public class Algorithm extends ApplicationTemplate.AppFrame{
	
	private Maps maps;
	private DataSource data;
	private WorldWindow wwd;
	private double slat; 						
	private double slon;	
	private double swsp_geo;
	private int lengthTab;						
	private int widthTab;
	private String[][] waterDirection;
	private ArrayList<Double> coordinateList;
	private ArrayList<Double> wetListCopy;
	private ArrayList<Double> listOfPointsCopy;
	private ArrayList<Double> wetList;
	private double maxGeoLat;
	private double minGeoLat;
	private double maxGeoLon;
	private double minGeoLon;
	private double slat_source;
	private double slon_source;
	
	public Algorithm() {
		super();
		init();
	}
	
	private void init() {
		data = new DataSource();
		data.makeData();
		this.maps = new Maps(data, this.getWwd());
		slat = data.slat;
		slon = data.slon;
		lengthTab = data.length_tab;
		widthTab = data.width_tab;
		slat_source = data.slat_source;
		slon_source = data.slon_source;
		swsp_geo = data.swsp_geo;
	}
	
	
	public ArrayList<Double> getWetListCopy() {
		return wetListCopy;
	}

	public ArrayList<Double> getListOfPointsCopy() {
		return listOfPointsCopy;
	}

	public double getSlat_source() {
		return slat_source;
	}

	public double getSlon_source() {
		return slon_source;
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

	public ArrayList<Double> getWetList() {
		return wetList;
	}

	public ArrayList<Double> getCoordinateList() {
		return coordinateList;
	}

	public void calculation(ArrayList<Double> wetListCopy, ArrayList<Double> listOfPointsCopy, Double[][] netMap3, ArrayList<Double> list2, ArrayList<Double> wetList2, Boolean[][] bolleanNetMap3, ArrayList<Double> listOfPoints2, String[][] waterDirection2) {
		
		bolleanNetMap3[(int) slat - 1][(int) slon - 1] = true;
//		waterDirection2[(int) slat][(int) slon] = "$";
		
		for(int i = 0; i < list2.size(); i += 2) {
			
			if(netMap3[(int) (slat - list2.get(i)) - 1][(int) (slon - list2.get(i + 1)) - 1] < swsp_geo) {
				
				listOfPoints2.add(netMap3[(int) (slat - list2.get(i)) - 1][(int) (slon - list2.get(i + 1)) - 1]);
				wetList2.add((slat - list2.get(i)));	//wps. X nowego zalanego punktu
				wetList2.add((slon - list2.get(i + 1)));	//wsp. Y nowego zalanego punktu
				listOfPointsCopy.add(netMap3[(int) (slat - list2.get(i)) - 1][(int) (slon - list2.get(i + 1)) - 1]);
				wetListCopy.add((slat - list2.get(i)));	//wps. X nowego zalanego punktu
				wetListCopy.add((slon - list2.get(i + 1)));	//wsp. Y nowego zalanego punktu
				bolleanNetMap3[(int) (slat - list2.get(i)) - 1][(int) (slon - list2.get(i + 1)) - 1] = true;
//				waterDirection2[(int) (slat - list2.get(i))][(int) (slon - list2.get(i + 1))] = "#";
									
			} else {
				bolleanNetMap3[(int) (slat - list2.get(i)) - 1][(int) (slon - list2.get(i + 1)) - 1] = true;
			}
		}
		System.out.println(listOfPoints2 + " Punkty zalane");
		System.out.println(wetList2 + " Wspolrzedne X i Y zalanych punktow");
		System.out.println(" ");			
					

}

public void calculation2(ArrayList<Double> wetListCopy, ArrayList<Double> listOfPointsCopy, Double[][] netMap3, ArrayList<Double> list2, ArrayList<Double> wetList2, Boolean[][] bolleanNetMap3, ArrayList<Double> listOfPoints2, String[][] waterDirection2) {
	
	slat = wetList2.get(0);
	slon = wetList2.get(1);
	listOfPoints2.remove(0);
	wetList2.remove(1);
	wetList2.remove(0);

	
	for(int i = 0; i < list2.size(); i += 2) {
		try {
			if(bolleanNetMap3[(int) (slat - list2.get(i)) - 1][(int) (slon - list2.get(i + 1)) - 1] == false) {
				if(netMap3[(int) (slat - list2.get(i)) - 1][(int) (slon - list2.get(i + 1)) - 1] < swsp_geo) {
					
						listOfPoints2.add(netMap3[(int) (slat - list2.get(i)) - 1][(int) (slon - list2.get(i + 1)) - 1]);
						wetList2.add(slat - list2.get(i));
						wetList2.add(slon - list2.get(i + 1));
						listOfPointsCopy.add(netMap3[(int) (slat - list2.get(i)) - 1][(int) (slon - list2.get(i + 1)) - 1]);
						wetListCopy.add((slat - list2.get(i)));	//wps. X nowego zalanego punktu
						wetListCopy.add((slon - list2.get(i + 1)));	//wsp. Y nowego zalanego punktu
						bolleanNetMap3[(int) (slat - list2.get(i)) - 1][(int) (slon - list2.get(i + 1)) - 1] = true;
//						waterDirection2[(int) (slat - list2.get(i))][(int) (slon - list2.get(i + 1))] = "#";
				} else {
					bolleanNetMap3[(int) (slat - list2.get(i))][(int) (slon - list2.get(i + 1))] = true;
				}
											
			} else {
				bolleanNetMap3[(int) (slat - list2.get(i))][(int) (slon - list2.get(i + 1))] = true;
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
	Double[][] netMap3 = maps.netMap();
	ArrayList<Double> list2 = maps.CoordinateList();
	ArrayList<Double> wetListCopy2 = maps.wetPointsCopy();
	ArrayList<Double> listOfPointsCopy2 = maps.listOfPointsCopy();
	ArrayList<Double> wetList2 = maps.wetPoints();
	Boolean[][] bolleanNetMap3 = maps.booleanNetMap();
	ArrayList<Double> listOfPoints2 = maps.listOfPoints();
	String[][] waterDirection2 = maps.createWaterTab();
	
	calculation(listOfPointsCopy2, wetListCopy2, netMap3, list2, wetList2, bolleanNetMap3, listOfPoints2, waterDirection2);
	do {
	calculation2(listOfPointsCopy2, wetListCopy2, netMap3, list2, wetList2, bolleanNetMap3, listOfPoints2, waterDirection2);
	} while (listOfPoints2.isEmpty() == false && wetList2.isEmpty() == false);
	
	waterDirection = waterDirection2;
	coordinateList = list2;
	wetList = wetList2;
	wetListCopy = wetListCopy2;
	listOfPointsCopy = listOfPointsCopy2;
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