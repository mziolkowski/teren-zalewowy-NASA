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
	private double waterPointLat; 						
	private double waterPointLon;	
	private double sourceWaterHeight;
	private int lengthTab;						
	private int widthTab;
	private Boolean[][] waterDirectionMap;
	private ArrayList<Double> coordinateListDouble;
	private ArrayList<Double> listOfFloodValueCopy;
	private ArrayList<Double> listOfFloodCoordinateCopy;
	private ArrayList<Double> listOfFloodValue;
	private ArrayList<Integer> coordinateListInteger;
	private Double[][] elevationsMap;
	private double maxGeoLat;
	private double minGeoLat;
	private double maxGeoLon;
	private double minGeoLon;
	private double waterSourcePointLat;
	private double waterSourcePointLon;
	
	public Algorithm() {
		super();
		init();
	}
	
	private void init() {
		data = new DataSource();
		data.makeData();
		this.maps = new Maps(data, this.getWwd());
		waterPointLat = data.getWaterPointLat();
		waterPointLon = data.getWaterPointLon();
		lengthTab = data.getLengthTab();
		widthTab = data.getWidthTab();
		waterSourcePointLat = data.getWaterSourcePointLat();
		waterSourcePointLon = data.getWaterSourcePointLon();
		sourceWaterHeight = data.getSourceWaterHeight();
	}
	
	
	public Double[][] getElevationsMap() {
		return elevationsMap;
	}

	public ArrayList<Integer> getCoordinateListInteger() {
		return coordinateListInteger;
	}

	public ArrayList<Double> getListOfFloodValueCopy() {
		return listOfFloodValueCopy;
	}

	public ArrayList<Double> getListOfFloodCoordinateCopy() {
		return listOfFloodCoordinateCopy;
	}

	public double getWaterSourcePointLat() {
		return waterSourcePointLat;
	}

	public double getWaterSourcePointLon() {
		return waterSourcePointLon;
	}

	public int getLengthTab() {
		return lengthTab;
	}

	public int getWidthTab() {
		return widthTab;
	}

	public PositionHolder getStartPosition() {
		return new PositionHolder(waterPointLat, waterPointLon);
	}

	public Boolean[][] getWaterDirectionMap() {
		return waterDirectionMap;
	}

	public ArrayList<Double> getListOfFloodValue() {
		return listOfFloodValue;
	}

	public ArrayList<Double> getCoordinateListDouble() {
		return coordinateListDouble;
	}

	public void calculation(ArrayList<Integer> coordinateListInteger, Double[][] elevationsMap, ArrayList<Double> coordinateListDouble, ArrayList<Double> listOfFloodValue, Boolean[][] booleanElevationsMap, ArrayList<Double> listOfFloodCoordinate, Boolean[][] waterDirectionMap) {
		booleanElevationsMap[(int) abs(waterPointLat)][(int) abs(waterPointLon)] = true;
		waterDirectionMap[(int) abs(waterPointLat)][(int) abs(waterPointLon)] = true;
		
		for(int i = 0; i < coordinateListDouble.size(); i += 2) {
			
			if(elevationsMap[(int) (abs(waterPointLat) - coordinateListInteger.get(i)) ][(int) (abs(waterPointLon) - coordinateListInteger.get(i + 1)) ] < sourceWaterHeight) {
				
				listOfFloodCoordinate.add(elevationsMap[(int) (abs(waterPointLat) - coordinateListInteger.get(i))][(int) (abs(waterPointLon) - coordinateListInteger.get(i + 1))]);
				listOfFloodValue.add((waterPointLat - coordinateListInteger.get(i)));	//wps. X nowego zalanego punktu
				listOfFloodValue.add((waterPointLon - coordinateListInteger.get(i + 1)));	//wsp. Y nowego zalanego punktu
				listOfFloodCoordinate.add(elevationsMap[(int) (abs(waterPointLat) - coordinateListInteger.get(i))][(int) (abs(waterPointLon) - coordinateListInteger.get(i + 1))]);
				listOfFloodValue.add((waterSourcePointLat - coordinateListDouble.get(i)));	//wps. X nowego zalanego punktu
				listOfFloodValue.add((waterSourcePointLon - coordinateListDouble.get(i + 1)));	//wsp. Y nowego zalanego punktu
				booleanElevationsMap[(int) (abs(waterPointLat) - coordinateListInteger.get(i))][(int) (abs(waterPointLon) - coordinateListInteger.get(i + 1))] = true;
				waterDirectionMap[(int) (abs(waterPointLat) - coordinateListInteger.get(i))][(int) (abs(waterPointLon) - coordinateListInteger.get(i + 1))] = true;
									
			} else {
				booleanElevationsMap[(int) (abs(waterPointLat) - coordinateListInteger.get(i))][(int) (abs(waterPointLon) - coordinateListInteger.get(i + 1))] = true;
			}
		}
//		System.out.println(listOfPointsInteger + " Punkty zalane");
//		System.out.println(wetListInteger + " Wspolrzedne X i Y zalanych punktow");
//		System.out.println(" ");							

}

public void calculation2(ArrayList<Integer> coordinateListInteger, Double[][] elevationsMap, ArrayList<Double> coordinateListDouble, ArrayList<Double> listOfFloodValue, Boolean[][] booleanElevationsMap, ArrayList<Double> listOfFloodCoordinate, Boolean[][] waterDirectionMap) {
	
	waterPointLat = listOfFloodValue.get(0);
	waterPointLon = listOfFloodValue.get(1);
	listOfFloodCoordinate.remove(0);
	listOfFloodValue.remove(1);
	listOfFloodValue.remove(0);

	
	for(int i = 0; i < coordinateListDouble.size(); i += 2) {
		try {
			if(booleanElevationsMap[(int) (abs(waterPointLat) - coordinateListInteger.get(i))][(int) (abs(waterPointLon) - coordinateListInteger.get(i + 1))] == false) {
				if(elevationsMap[(int) (abs(waterPointLat) - coordinateListInteger.get(i))][(int) (abs(waterPointLon) - coordinateListInteger.get(i + 1))] < sourceWaterHeight) {
					
						listOfFloodCoordinate.add(elevationsMap[(int) (abs(waterPointLat) - coordinateListInteger.get(i))][(int) (abs(waterPointLon) - coordinateListInteger.get(i + 1))]);
						listOfFloodValue.add(waterPointLat - coordinateListInteger.get(i));
						listOfFloodValue.add(waterPointLon - coordinateListInteger.get(i + 1));
						listOfFloodCoordinate.add(elevationsMap[(int) (abs(waterPointLat) - coordinateListInteger.get(i))][(int) (abs(waterPointLon) - coordinateListInteger.get(i + 1))]);
						listOfFloodValue.add((waterSourcePointLat - coordinateListDouble.get(i)));	//wps. X nowego zalanego punktu
						listOfFloodValue.add((waterSourcePointLon - coordinateListDouble.get(i + 1)));	//wsp. Y nowego zalanego punktu
						booleanElevationsMap[(int) (abs(waterPointLat) - coordinateListInteger.get(i))][(int) (abs(waterPointLon) - coordinateListInteger.get(i + 1))] = true;
						waterDirectionMap[(int) (abs(waterPointLat) - coordinateListInteger.get(i))][(int) (abs(waterPointLon) - coordinateListInteger.get(i + 1))] = true;
				} else {
					booleanElevationsMap[(int) (abs(waterPointLat) - coordinateListInteger.get(i))][(int) (abs(waterPointLon) - coordinateListInteger.get(i + 1))] = true;
				}
											
			} else {
				booleanElevationsMap[(int) (abs(waterPointLat) - coordinateListInteger.get(i))][(int) (abs(waterPointLon) - coordinateListInteger.get(i + 1))] = true;
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
	Double[][] elevationsMap = maps.elevationsMap();
	ArrayList<Double> coordinateListDouble = maps.setCoordinateListDouble();
	ArrayList<Double> listOfFloodValue = maps.listOfFloodValue();
	Boolean[][] booleanElevationsMap = maps.booleanElevationsMap();
	ArrayList<Double> listOfFloodCoordinate = maps.listOfFloodCoordinate();
	Boolean[][] waterDirectionMap = maps.waterDirectionMap();
	ArrayList<Integer> CoordinateListInteger = maps.setCoordinateListInteger();
	
	calculation(CoordinateListInteger, elevationsMap, coordinateListDouble, listOfFloodValue, booleanElevationsMap, listOfFloodCoordinate, waterDirectionMap);
	do {
	calculation2(CoordinateListInteger, elevationsMap, coordinateListDouble, listOfFloodValue, booleanElevationsMap, listOfFloodCoordinate, waterDirectionMap);
	} while (listOfFloodCoordinate.isEmpty() == false && listOfFloodValue.isEmpty() == false);
	
	this.waterDirectionMap = waterDirectionMap;
	this.coordinateListDouble = coordinateListDouble;
	this.listOfFloodValue = listOfFloodValue;
	this.elevationsMap = elevationsMap;
	
}

public SectorData getMaxMinLatLon() {
	
	if (data.getRightTopPointLatSource() > data.getLeftBottomPointLatSource()) {
		maxGeoLat = data.getRightTopPointLatSource();
		minGeoLat = data.getLeftBottomPointLatSource();
	} else {
		maxGeoLat = data.getLeftBottomPointLatSource();
		minGeoLat = data.getRightTopPointLatSource();
	}

	if (data.getRightTopPointLonSource() > data.getLeftBottomPointLonSource()) {
		maxGeoLon = data.getRightTopPointLonSource();
		minGeoLon = data.getLeftBottomPointLonSource();
	} else {
		maxGeoLon = data.getLeftBottomPointLonSource();
		minGeoLon = data.getRightTopPointLonSource();
	}
	return new SectorData(new PositionHolder(minGeoLat, minGeoLon), new PositionHolder(maxGeoLat, maxGeoLon));
	
}


}