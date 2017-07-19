package Algorithm;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ImplementationOfAlgorithm {

	public DataHolder imp() throws FileNotFoundException {
		
		Algorithm algorithm = new Algorithm();
		DataHolder dataHolder = new DataHolder();
		
		dataHolder.setStartPosition(algorithm.getStartPosition());
		dataHolder.setWaterDirection(algorithm.getWaterDirections());
		dataHolder.setMaxMinLatLon(algorithm.maxMinLatLon());
		
		algorithm.startCalculation();
		dataHolder.setWaterDirection(algorithm.getWaterDirections());
		dataHolder.setCoordinateList(algorithm.getCoordinateList());
		dataHolder.setLength_tab(algorithm.getLengthTab());
		dataHolder.setWidth_tab(algorithm.getWidthTab());
		dataHolder.setSlat_source(algorithm.getSlat_source());
		dataHolder.setSlon_source(algorithm.getSlon_source());
		ArrayList<Integer> coordinateList = algorithm.getCoordinateList();
		String[][] waterDirection2 = algorithm.getWaterDirections();
			
		return dataHolder;

	}

}