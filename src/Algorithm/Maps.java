package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import gov.nasa.worldwind.WorldWindow;
import gov.nasa.worldwind.geom.Angle;
import gov.nasa.worldwind.geom.LatLon;
import gov.nasa.worldwind.geom.Sector;
import gov.nasa.worldwind.globes.Globe;
import gov.nasa.worldwindx.examples.ApplicationTemplate;

public class Maps  extends ApplicationTemplate.AppFrame{

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
		ArrayList<LatLon> latlons = new ArrayList<LatLon>();
		Globe globe = this.getWwd().getModel().getGlobe();
        Double[][] netMap = new Double[data.length_tab - 1][data.width_tab];
        
        for (double i = 0, a = 0; i < data.length_tab; i++, a += 0.001) {
			for (double j = 0, b = 0; j < data.width_tab; j++, b += 0.001) {

				latlons.add(LatLon.fromDegrees(data.minGeoLat + a,
						data.minGeoLon + b));
			}
		}
        
//        Sector sector = Sector.fromDegrees(data.minGeoLat,
//				data.maxGeoLat, data.minGeoLon,
//				data.maxGeoLon);
        Sector sector = Sector.boundingSector(latlons);
        double[] elevations = new double[latlons.size()];
        // Iterate until the best resolution is achieved. Use the elevation model to determine the best elevation.
        double targetResolution = globe.getElevationModel().getBestResolution(sector);
        double actualResolution = Double.MAX_VALUE;
        
        double a = 0;
        double b = 0;
        
        
		for (int i = 0; i <= netMap.length - 1; i++, a += 0.001) {
			b = 0;
			for (int j = 0; j <= netMap[i].length - 1; j++, b += 0.001) {
				while (actualResolution > targetResolution) {
					actualResolution = globe.getElevations(sector, latlons, targetResolution, elevations);
					// Uncomment the two lines below if you want to watch the
					// resolution converge
//					System.out.printf("Target resolution = %s, Actual resolution = %s\n",
//							Double.toString(targetResolution), Double.toString(actualResolution));
					try {
						Thread.sleep(2); // give the system a chance to
											// retrieve data from the disk cache
											// or the server
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				netMap[i][j] = this.wwd.getModel().getGlobe().getElevation(Angle.fromDegrees(data.minGeoLat + b),
						Angle.fromDegrees(data.minGeoLon + a));
			}
		}

        return netMap;
	}

	protected Boolean[][] booleanNetMap() {
		Boolean[][] booleanNetMap = new Boolean[data.length_tab - 1][data.width_tab];

		for (int i = 0; i <= booleanNetMap.length - 1; i++) {
			for (int j = 0; j <= booleanNetMap[i].length - 1; j++) {
				booleanNetMap[i][j] = false;
			}
		}
		return booleanNetMap;
	}

	public Boolean[][] createWaterTab() {	
		Boolean[][] waterDirection = new Boolean[data.length_tab - 1][data.width_tab];

		for (int i = 0; i <= waterDirection.length - 1; i++) {
			for (int j = 0; j <= waterDirection[i].length - 1; j++) {
				waterDirection[i][j] = false;
			}
		}
		return waterDirection;
	}

}