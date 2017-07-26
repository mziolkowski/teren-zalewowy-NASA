package Algorithm;

import java.util.ArrayList;

public class DataHolder {
	private SectorData maxMinLatLon;
	private PositionHolder startPosition;
	private Boolean[][] waterDirectionMap;
	private ArrayList<Double> listOfFloodValueCopy;
	private ArrayList<Double> listOfFloodValue;
	private ArrayList<Double> listOfFloodCoordinate;
	private ArrayList<Double> listOfFloodCoordinateCopy;
	private ArrayList<Double> coordinateListDouble;
	private ArrayList<Integer> coordinateListInteger;
	private Double[][] elevationsMap;
	private int lengthTab;
	private int widthTab;
	private double slatIteration;
	private double slonIteration;
	private double waterSourcePointLat;
	private double waterSourcePointLon;
	private double waterPointLat;
	private double waterPointLon;
	private double sourceWaterHeight;
	public SectorData getMaxMinLatLon() {
		return maxMinLatLon;
	}
	public void setMaxMinLatLon(SectorData maxMinLatLon) {
		this.maxMinLatLon = maxMinLatLon;
	}
	public PositionHolder getStartPosition() {
		return startPosition;
	}
	public void setStartPosition(PositionHolder startPosition) {
		this.startPosition = startPosition;
	}
	public Boolean[][] getWaterDirectionMap() {
		return waterDirectionMap;
	}
	public void setWaterDirectionMap(Boolean[][] waterDirectionMap) {
		this.waterDirectionMap = waterDirectionMap;
	}
	public ArrayList<Double> getListOfFloodValueCopy() {
		return listOfFloodValueCopy;
	}
	public void setListOfFloodValueCopy(ArrayList<Double> listOfFloodValueCopy) {
		this.listOfFloodValueCopy = listOfFloodValueCopy;
	}
	public ArrayList<Double> getListOfFloodValue() {
		return listOfFloodValue;
	}
	public void setListOfFloodValue(ArrayList<Double> listOfFloodValue) {
		this.listOfFloodValue = listOfFloodValue;
	}
	public ArrayList<Double> getListOfFloodCoordinate() {
		return listOfFloodCoordinate;
	}
	public void setListOfFloodCoordinate(ArrayList<Double> listOfFloodCoordinate) {
		this.listOfFloodCoordinate = listOfFloodCoordinate;
	}
	public ArrayList<Double> getListOfFloodCoordinateCopy() {
		return listOfFloodCoordinateCopy;
	}
	public void setListOfFloodCoordinateCopy(ArrayList<Double> listOfFloodCoordinateCopy) {
		this.listOfFloodCoordinateCopy = listOfFloodCoordinateCopy;
	}
	public ArrayList<Double> getCoordinateListDouble() {
		return coordinateListDouble;
	}
	public void setCoordinateListDouble(ArrayList<Double> coordinateListDouble) {
		this.coordinateListDouble = coordinateListDouble;
	}
	public ArrayList<Integer> getCoordinateListInteger() {
		return coordinateListInteger;
	}
	public void setCoordinateListInteger(ArrayList<Integer> coordinateListInteger) {
		this.coordinateListInteger = coordinateListInteger;
	}
	public Double[][] getElevationsMap() {
		return elevationsMap;
	}
	public void setElevationsMap(Double[][] elevationsMap) {
		this.elevationsMap = elevationsMap;
	}
	public int getLengthTab() {
		return lengthTab;
	}
	public void setLengthTab(int lengthTab) {
		this.lengthTab = lengthTab;
	}
	public int getWidthTab() {
		return widthTab;
	}
	public void setWidthTab(int widthTab) {
		this.widthTab = widthTab;
	}
	public double getSlatIteration() {
		return slatIteration;
	}
	public void setSlatIteration(double slatIteration) {
		this.slatIteration = slatIteration;
	}
	public double getSlonIteration() {
		return slonIteration;
	}
	public void setSlonIteration(double slonIteration) {
		this.slonIteration = slonIteration;
	}
	public double getWaterSourcePointLat() {
		return waterSourcePointLat;
	}
	public void setWaterSourcePointLat(double waterSourcePointLat) {
		this.waterSourcePointLat = waterSourcePointLat;
	}
	public double getWaterSourcePointLon() {
		return waterSourcePointLon;
	}
	public void setWaterSourcePointLon(double waterSourcePointLon) {
		this.waterSourcePointLon = waterSourcePointLon;
	}
	public double getWaterPointLat() {
		return waterPointLat;
	}
	public void setWaterPointLat(double waterPointLat) {
		this.waterPointLat = waterPointLat;
	}
	public double getWaterPointLon() {
		return waterPointLon;
	}
	public void setWaterPointLon(double waterPointLon) {
		this.waterPointLon = waterPointLon;
	}
	public double getSourceWaterHeight() {
		return sourceWaterHeight;
	}
	public void setSourceWaterHeight(double sourceWaterHeight) {
		this.sourceWaterHeight = sourceWaterHeight;
	}
		
	
	/*public double getSlat() {
		return waterPointLat;
	}

	public void setSlat(double slat) {
		this.waterPointLat = slat;
	}

	public double getSlon() {
		return waterPointLon;
	}

	public void setSlon(double slon) {
		this.waterPointLon = slon;
	}

	public Double[][] getElevationsMap() {
		return elevationsMap;
	}

	public void setElevationsMap(Double[][] elevationsMap) {
		this.elevationsMap = elevationsMap;
	}

	public ArrayList<Integer> getCoordinateListInteger() {
		return coordinateListInteger;
	}

	public void setCoordinateListInteger(ArrayList<Integer> coordinateListInteger) {
		this.coordinateListInteger = coordinateListInteger;
	}

	public ArrayList<Double> getListOfFloodValueCopy() {
		return listOfFloodValue;
	}

	public void setListOfFloodValueCopy(ArrayList<Double> listOfFloodValueCopy) {
		this.listOfFloodValue = listOfFloodValueCopy;
	}

	public ArrayList<Double> getListOfFloodCoordinateCopy() {
		return listOfFloodCoordinateCopy;
	}

	public void setListOfFloodCoordinateCopy(ArrayList<Double> listOfFloodCoordinateCopy) {
		this.listOfFloodCoordinateCopy = listOfFloodCoordinateCopy;
	}

	public ArrayList<Double> getListOfFloodValue() {
		return listOfFloodValueCopy;
	}

	public void setListOfFloodValue(ArrayList<Double> listOfFloodValue) {
		this.listOfFloodValueCopy = listOfFloodValue;
	}

	public double getSourceWaterHeight() {
		return sourceWaterHeight;
	}

	public void setSourceWaterHeight(Double sourceWaterHeight) {
		this.sourceWaterHeight = sourceWaterHeight;
	}

	public void setSlat_source(Double slat_source) {
		this.waterSourcePointLat = slat_source;
	}

	public double getSlon_source() {
		return waterSourcePointLon;
	}

	public void setSlon_source(Double slon_source) {
		this.waterSourcePointLon = slon_source;
	}

	public Double getSlatInter() {
		return slatIteration;
	}

	public void setSlatInter(Double slatInter) {
		this.slatIteration = slatInter;
	}

	public Double getSlonInter() {
		return slonIteration;
	}

	public void setSlonInter(Double slonInter) {
		this.slonIteration = slonInter;
	}

	public ArrayList<Double> getCoordinateList() {
		return coordinateListDouble;
	}

	public void setCoordinateList(ArrayList<Double> coordinateList) {
		this.coordinateListDouble = coordinateList;
	}

	public int getLength_tab() {
		return lengthTab;
	}

	public void setLength_tab(int length_tab) {
		this.lengthTab = length_tab;
	}

	public int getWidth_tab() {
		return widthTab;
	}

	public void setWidth_tab(int width_tab) {
		this.widthTab = width_tab;
	}

	public SectorData getMaxMinLatLon() {
		return maxMinLatLon;
	}

	public PositionHolder getStartPosition() {
		return startPosition;
	}

	public Boolean[][] getWaterDirectionMap() {
		return waterDirectionMap;
	}

	public void setMaxMinLatLon(SectorData maxMinLatLon) {
		this.maxMinLatLon = maxMinLatLon;
	}

	public void setStartPosition(PositionHolder startPosition) {
		this.startPosition = startPosition;
	}

	public void setWaterDirectionMap(Boolean[][] waterDirectionMap) {
		this.waterDirectionMap = waterDirectionMap;
	}*/
	
	

}
