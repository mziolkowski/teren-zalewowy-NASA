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
		
}
