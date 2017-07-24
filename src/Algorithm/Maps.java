package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import gov.nasa.worldwind.WorldWindow;
import gov.nasa.worldwind.geom.Angle;

public class Maps {

	DataSource data;
	WorldWindow wwd;
	SectorData sectorData;

	public Maps(DataSource data, WorldWindow wwd) {
		super();
		this.data = data;
		this.wwd = wwd;
	}

	public static ArrayList<Double> CoordinateList() {
		ArrayList<Double> list1 = new ArrayList<Double>(16);

		list1.add(-0.001); // wiersz
		list1.add(-0.001); // kolumna

		list1.add(-0.001);
		list1.add(0.000);

		list1.add(-0.001);
		list1.add(0.001);
		///////////////////////////////
		list1.add(0.000);
		list1.add(-0.001);

		list1.add(0.000);
		list1.add(0.001);
		///////////////////////////////
		list1.add(0.001);
		list1.add(-0.001);

		list1.add(0.001);
		list1.add(0.000);

		list1.add(0.001);
		list1.add(0.001);

		return list1;
	}
	
	public static ArrayList<Integer> CoordinateListInteger() {
		ArrayList<Integer> coordinateListInteger = new ArrayList<Integer>(16);

		coordinateListInteger.add(-1); // wiersz
		coordinateListInteger.add(-1); // kolumna

		coordinateListInteger.add(-1);
		coordinateListInteger.add(0);

		coordinateListInteger.add(-1);
		coordinateListInteger.add(1);
		///////////////////////////////
		coordinateListInteger.add(0);
		coordinateListInteger.add(-1);

		coordinateListInteger.add(0);
		coordinateListInteger.add(1);
		///////////////////////////////
		coordinateListInteger.add(1);
		coordinateListInteger.add(-1);

		coordinateListInteger.add(1);
		coordinateListInteger.add(0);

		coordinateListInteger.add(1);
		coordinateListInteger.add(1);

		return coordinateListInteger;
	}

	// Tablica przechowywujaca zalane punkty (wartosc punktu)wsp. punktow zalanych
	protected ArrayList<Double> wetPoints() {
		ArrayList<Double> wetList = new ArrayList<Double>(16);
		return wetList;
	}

	// Tablica przechowywujaca wsp. punktow zalanych
	protected ArrayList<Double> listOfPoints() {
		ArrayList<Double> listOfPoints = new ArrayList<Double>(16);
		return listOfPoints;
	}
	
	
	protected ArrayList<Double> wetPointsCopy() {
		ArrayList<Double> wetListCopy = new ArrayList<Double>(16);
		return wetListCopy;
	}


	protected ArrayList<Double> listOfPointsCopy() {
		ArrayList<Double> listOfPointsCopy = new ArrayList<Double>(16);
		return listOfPointsCopy;
	}

	public Double[][] netMap() {

		Double[][] netMap = new Double[data.length_tab - 1][data.width_tab - 1];

		for (double i = 0, a = 0; i <= netMap.length - 1; i++, a += 0.001) {
			for (double j = 0, b = 0; j <= netMap.length - 1; j++, b += 0.001) {
				netMap[(int) i][(int) j] = this.wwd.getModel().getGlobe().getElevation(Angle.fromDegrees(data.lbwsp_geo_lat_source + a),
						Angle.fromDegrees(data.lbwsp_geo_lon_source + b));
			}
		}

		return netMap;
	}

	protected Boolean[][] booleanNetMap() {
		Boolean[][] booleanNetMap = new Boolean[data.length_tab - 1][data.width_tab - 1];

		for (int i = 0; i <= booleanNetMap.length - 1; i++) {
			for (int j = 0; j <= booleanNetMap.length - 1; j++) {
				booleanNetMap[i][j] = false;
			}
		}
		return booleanNetMap;
	}

	public String[][] createWaterTab() {
		String[][] waterDirection = new String[data.length_tab - 1][data.width_tab - 1];

		for (int i = 0; i <= waterDirection.length - 1; i++) {
			for (int j = 0; j <= waterDirection.length - 1; j++) {
				waterDirection[i][j] = "-";
			}
		}
		return waterDirection;
	}

}