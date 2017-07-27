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

	public static ArrayList<Double> setCoordinateListDouble() {
		ArrayList<Double> coordinateListDouble = new ArrayList<Double>(16);

		coordinateListDouble.add(-0.001); // wiersz
		coordinateListDouble.add(-0.001); // kolumna

		coordinateListDouble.add(-0.001);
		coordinateListDouble.add(0.000);

		coordinateListDouble.add(-0.001);
		coordinateListDouble.add(0.001);
		///////////////////////////////
		coordinateListDouble.add(0.000);
		coordinateListDouble.add(-0.001);

		coordinateListDouble.add(0.000);
		coordinateListDouble.add(0.001);
		///////////////////////////////
		coordinateListDouble.add(0.001);
		coordinateListDouble.add(-0.001);

		coordinateListDouble.add(0.001);
		coordinateListDouble.add(0.000);

		coordinateListDouble.add(0.001);
		coordinateListDouble.add(0.001);

		return coordinateListDouble;
	}
	
	public static ArrayList<Integer> setCoordinateListInteger() {
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

	// Tablica przechowywujaca zalane punkty (wartosc punktu) wsp. punktow zalanych
	protected ArrayList<Double> listOfFloodValue() {
		ArrayList<Double> listOfFloodValue = new ArrayList<Double>(16);
		return listOfFloodValue;
	}

	// Tablica przechowywujaca wsp. punktow zalanych
	protected ArrayList<Double> listOfFloodCoordinate() {
		ArrayList<Double> listOfFloodCoordinate = new ArrayList<Double>(16);
		return listOfFloodCoordinate;
	}

	public Double[][] elevationsMap() {
		ArrayList<LatLon> latlons = new ArrayList<LatLon>();
		Globe globe = this.getWwd().getModel().getGlobe();
//        Double[][] elevationsMap = new Double[data.getLengthTab() - 1][data.getWidthTab()];
//        Double[][] elevationsMap2 = new Double[data.getWidthTab() - 1][data.getLengthTab()];

        for (double i = 0, a = 0; i < data.getLengthTab(); i++, a += 0.001) {
			for (double j = 0, b = 0; j < data.getWidthTab(); j++, b += 0.001) {

				latlons.add(LatLon.fromDegrees(data.getMinGeoLat() + a,
						data.getMinGeoLon() + b));
			}
		}
        
        Sector sector = Sector.boundingSector(latlons);
        double[] elevations = new double[latlons.size()];
        // Iterate until the best resolution is achieved. Use the elevation model to determine the best elevation.
        double targetResolution = globe.getElevationModel().getBestResolution(sector);
        double actualResolution = Double.MAX_VALUE;
        
        double a = 0;
        double b = 0;
        
        if(data.getWaterPointLat() > data.getLengthTab()) {
            Double[][] elevationsMap = new Double[data.getWidthTab() - 1][data.getLengthTab()];
            for (int i = 0; i <= elevationsMap.length - 1; i++, a += 0.001) {
    			b = 0;
    			for (int j = 0; j <= elevationsMap[i].length - 1; j++, b += 0.001) {
    				while (actualResolution > targetResolution) {
    					actualResolution = globe.getElevations(sector, latlons, targetResolution, elevations);
    					// Uncomment the two lines below if you want to watch the
    					// resolution converge
    					System.out.printf("Target resolution = %s, Actual resolution = %s\n",
    					Double.toString(targetResolution), Double.toString(actualResolution));
    					try {
    						Thread.sleep(2); // give the system a chance to
    											// retrieve data from the disk cache
    											// or the server
    					} catch (InterruptedException e) {
    						e.printStackTrace();
    					}
    				}
    				elevationsMap[i][j] = this.wwd.getModel().getGlobe().getElevation(Angle.fromDegrees(data.getMinGeoLat() + b),
    						Angle.fromDegrees(data.getMinGeoLon() + a));
    			}
    		}
            return elevationsMap;
        
        } else {
            Double[][] elevationsMap = new Double[data.getLengthTab() - 1][data.getWidthTab()];
        	for (int i = 0; i <= elevationsMap.length - 1; i++, a += 0.001) {
        		b = 0;
        		for (int j = 0; j <= elevationsMap[i].length - 1; j++, b += 0.001) {
        			while (actualResolution > targetResolution) {
        				actualResolution = globe.getElevations(sector, latlons, targetResolution, elevations);
        				// Uncomment the two lines below if you want to watch the
        				// resolution converge
        				System.out.printf("Target resolution = %s, Actual resolution = %s\n",
        						Double.toString(targetResolution), Double.toString(actualResolution));
        				try {
        					Thread.sleep(2); // give the system a chance to
        					// retrieve data from the disk cache
        					// or the server
        				} catch (InterruptedException e) {
        					e.printStackTrace();
        				}
        			}
        			elevationsMap[i][j] = this.wwd.getModel().getGlobe().getElevation(Angle.fromDegrees(data.getMinGeoLat() + b),
        					Angle.fromDegrees(data.getMinGeoLon() + a));
        		}
        	}
        	return elevationsMap;
        }
	}

	protected Boolean[][] booleanElevationsMap() {
		
		if(data.getWaterPointLat() > data.getLengthTab()) {
			Boolean[][] booleanElevationsMap = new Boolean[data.getWidthTab()][data.getLengthTab()];
			for (int i = 0; i <= booleanElevationsMap.length - 1; i++) {
				for (int j = 0; j <= booleanElevationsMap[i].length - 1; j++) {
					booleanElevationsMap[i][j] = false;
				}
			}
			return booleanElevationsMap;
			
		} else {
			Boolean[][] booleanElevationsMap = new Boolean[data.getLengthTab() - 1][data.getWidthTab()];
			for (int i = 0; i <= booleanElevationsMap.length - 1; i++) {
				for (int j = 0; j <= booleanElevationsMap[i].length - 1; j++) {
					booleanElevationsMap[i][j] = false;
				}
			}
			return booleanElevationsMap;
		}
		
	}

	public Boolean[][] waterDirectionMap() {	
		
		if(data.getWaterPointLat() > data.getLengthTab()) {
			Boolean[][] waterDirectionMap = new Boolean[data.getWidthTab() - 1][data.getLengthTab()];
			for (int i = 0; i <= waterDirectionMap.length - 1; i++) {
				for (int j = 0; j <= waterDirectionMap[i].length - 1; j++) {
					waterDirectionMap[i][j] = false;
				}
			}
			return waterDirectionMap;
			
		} else {
			Boolean[][] waterDirectionMap = new Boolean[data.getLengthTab() - 1][data.getWidthTab()];
			for (int i = 0; i <= waterDirectionMap.length - 1; i++) {
				for (int j = 0; j <= waterDirectionMap[i].length - 1; j++) {
					waterDirectionMap[i][j] = false;
				}
			}
			return waterDirectionMap;
		}
		
	}

}