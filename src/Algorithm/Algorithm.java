package Algorithm;


import java.util.ArrayList;
import static java.lang.Math.*;
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
	private Boolean[][] waterDirection;
	private ArrayList<Double> coordinateList;
	private ArrayList<Double> wetListCopy;
	private ArrayList<Double> listOfPointsCopy;
	private ArrayList<Double> wetList;
	private ArrayList<Integer> coordinateListInteger;
	private Double[][] netMap;
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
	
	
	public Double[][] getNetMap() {
		return netMap;
	}

	public ArrayList<Integer> getCoordinateListInteger() {
		return coordinateListInteger;
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

	public Boolean[][] getWaterDirections() {
		return waterDirection;
	}

	public ArrayList<Double> getWetList() {
		return wetList;
	}

	public ArrayList<Double> getCoordinateList() {
		return coordinateList;
	}

	public void calculation(ArrayList<Integer> coordinateListInteger, ArrayList<Double> wetList, ArrayList<Double> listOfPoints, Double[][] netMap3, ArrayList<Double> list2, ArrayList<Double> wetListInteger, Boolean[][] bolleanNetMap3, ArrayList<Double> listOfPointsInteger, Boolean[][] waterDirection2) {
		
		bolleanNetMap3[(int) abs(slat)][(int) abs(slon)] = true;
		waterDirection2[(int) abs(slat)][(int) abs(slon)] = true;
		
		for(int i = 0; i < list2.size(); i += 2) {
			
			if(netMap3[(int) (abs(slat) - coordinateListInteger.get(i)) ][(int) (abs(slon) - coordinateListInteger.get(i + 1)) ] < swsp_geo) {
				
				listOfPointsInteger.add(netMap3[(int) (abs(slat) - coordinateListInteger.get(i))][(int) (abs(slon) - coordinateListInteger.get(i + 1))]);
				wetListInteger.add((slat - coordinateListInteger.get(i)));	//wps. X nowego zalanego punktu
				wetListInteger.add((slon - coordinateListInteger.get(i + 1)));	//wsp. Y nowego zalanego punktu
				listOfPoints.add(netMap3[(int) (abs(slat) - coordinateListInteger.get(i))][(int) (abs(slon) - coordinateListInteger.get(i + 1))]);
				wetList.add((slat_source - list2.get(i)));	//wps. X nowego zalanego punktu
				wetList.add((slon_source - list2.get(i + 1)));	//wsp. Y nowego zalanego punktu
				bolleanNetMap3[(int) (abs(slat) - coordinateListInteger.get(i))][(int) (abs(slon) - coordinateListInteger.get(i + 1))] = true;
				waterDirection2[(int) (abs(slat) - coordinateListInteger.get(i))][(int) (abs(slon) - coordinateListInteger.get(i + 1))] = true;
									
			} else {
				bolleanNetMap3[(int) (abs(slat) - coordinateListInteger.get(i))][(int) (abs(slon) - coordinateListInteger.get(i + 1))] = true;
			}
		}
//		System.out.println(listOfPointsInteger + " Punkty zalane");
//		System.out.println(wetListInteger + " Wspolrzedne X i Y zalanych punktow");
//		System.out.println(" ");							

}

public void calculation2(ArrayList<Integer> coordinateListInteger, ArrayList<Double> wetList, ArrayList<Double> listOfPoints, Double[][] netMap3, ArrayList<Double> list2, ArrayList<Double> wetListInteger, Boolean[][] bolleanNetMap3, ArrayList<Double> listOfPointsInteger, Boolean[][] waterDirection2) {
	
	slat = wetListInteger.get(0);
	slon = wetListInteger.get(1);
	listOfPointsInteger.remove(0);
	wetListInteger.remove(1);
	wetListInteger.remove(0);

	
	for(int i = 0; i < list2.size(); i += 2) {
		try {
			if(bolleanNetMap3[(int) (abs(slat) - coordinateListInteger.get(i))][(int) (abs(slon) - coordinateListInteger.get(i + 1))] == false) {
				if(netMap3[(int) (abs(slat) - coordinateListInteger.get(i))][(int) (abs(slon) - coordinateListInteger.get(i + 1))] < swsp_geo) {
					
						listOfPointsInteger.add(netMap3[(int) (abs(slat) - coordinateListInteger.get(i))][(int) (abs(slon) - coordinateListInteger.get(i + 1))]);
						wetListInteger.add(slat - coordinateListInteger.get(i));
						wetListInteger.add(slon - coordinateListInteger.get(i + 1));
						listOfPoints.add(netMap3[(int) (abs(slat) - coordinateListInteger.get(i))][(int) (abs(slon) - coordinateListInteger.get(i + 1))]);
						wetList.add((slat_source - list2.get(i)));	//wps. X nowego zalanego punktu
						wetList.add((slon_source - list2.get(i + 1)));	//wsp. Y nowego zalanego punktu
						bolleanNetMap3[(int) (abs(slat) - coordinateListInteger.get(i))][(int) (abs(slon) - coordinateListInteger.get(i + 1))] = true;
						waterDirection2[(int) (abs(slat) - coordinateListInteger.get(i))][(int) (abs(slon) - coordinateListInteger.get(i + 1))] = true;
				} else {
					bolleanNetMap3[(int) (abs(slat) - coordinateListInteger.get(i))][(int) (abs(slon) - coordinateListInteger.get(i + 1))] = true;
				}
											
			} else {
				bolleanNetMap3[(int) (abs(slat) - coordinateListInteger.get(i))][(int) (abs(slon) - coordinateListInteger.get(i + 1))] = true;
			}
		}
			
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Wyszedles po za obszar!");		
			}
		}
	
//	System.out.println(listOfPointsInteger);
//	System.out.println(wetListInteger);
//	System.out.println(" ");

	
}

public void startCalculation() {
	Double[][] netMap3 = maps.netMap();
	ArrayList<Double> list2 = maps.CoordinateList();
	ArrayList<Double> wetListCopy2 = maps.wetPointsCopy();
	ArrayList<Double> listOfPointsCopy2 = maps.listOfPointsCopy();
	ArrayList<Double> wetList2 = maps.wetPoints();
	Boolean[][] bolleanNetMap3 = maps.booleanNetMap();
	ArrayList<Double> listOfPoints2 = maps.listOfPoints();
	Boolean[][] waterDirection2 = maps.createWaterTab();
	ArrayList<Integer> coordinateListInteger = maps.CoordinateListInteger();
	
	calculation(coordinateListInteger, listOfPointsCopy2, wetListCopy2, netMap3, list2, wetList2, bolleanNetMap3, listOfPoints2, waterDirection2);
	do {
	calculation2(coordinateListInteger, listOfPointsCopy2, wetListCopy2, netMap3, list2, wetList2, bolleanNetMap3, listOfPoints2, waterDirection2);
	} while (listOfPoints2.isEmpty() == false && wetList2.isEmpty() == false);
	
	waterDirection = waterDirection2;
	coordinateList = list2;
	wetList = wetList2;
	listOfPointsCopy = listOfPointsCopy2;
	wetListCopy = wetListCopy2;
	netMap = netMap3;
	
//	for(int m = 0; m < waterDirection2.length; m++) {
//		for(int n = 0; n < waterDirection2[m].length; n++) 
//			System.out.print(waterDirection2[m][n]?"#":"-" + " ");
//			System.out.println(" ");
//		
//	}
	
//	for(int m = 0; m < netMap3.length; m++) {
//		for(int n = 0; n < netMap3[m].length; n++) 
//			System.out.print(netMap3[m][n] + " ");
//			System.out.println(" ");
//		
//	}
}

public SectorData getMaxMinLatLon() {
	
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