package Algorithm;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import gov.nasa.worldwind.WorldWindow;
import gov.nasa.worldwind.WorldWindowImpl;
import gov.nasa.worldwind.geom.LatLon;
import gov.nasa.worldwindx.examples.ApplicationTemplate;

public class ImplementationOfAlgorithm {

	public DataHolder imp() throws FileNotFoundException {

		Algorithm algorithm = new Algorithm();
		DataHolder dataHolder = new DataHolder();
		Elevation elevations = new Elevation(dataHolder);
		
		dataHolder.setStartPosition(algorithm.getStartPosition());
		dataHolder.setWaterDirection(algorithm.getWaterDirections());
		dataHolder.setMaxMinLatLon(algorithm.maxMinLatLon());
		
		algorithm.startCalculation();
		dataHolder.setWaterDirection(algorithm.getWaterDirections());
		dataHolder.setCoordinateList(algorithm.getCoordinateList());
		dataHolder.setLength_tab(algorithm.getLengthTab());
		dataHolder.setWidth_tab(algorithm.getWidthTab());
		ArrayList<Integer> coordinateList = algorithm.getCoordinateList();
		String[][] waterDirection2 = algorithm.getWaterDirections();
		elevations.ElevationMap();
			
		return dataHolder;

	}

}