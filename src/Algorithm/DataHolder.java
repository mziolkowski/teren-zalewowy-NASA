package Algorithm;

import java.util.ArrayList;

public class DataHolder {
	private SectorData maxMinLatLon;
	private PositionHolder startPosition;
	private String[][] waterDirection;
	private ArrayList<Double> wetListInteger;
	private ArrayList<Double> wetList;
	private ArrayList<Double> listOfPoints;
	private ArrayList<Double> listOfPointsCopy;
	private ArrayList<Double> coordinateList;
	private ArrayList<Integer> coordinateListInteger;
	private Double[][] netMap;
	private int length_tab;
	private int width_tab;
	private double slatInter;
	private double slonInter;
	private double slat_source;
	private double slon_source;
	private double swsp_geo;
		
	
	public Double[][] getNetMap() {
		return netMap;
	}

	public void setNetMap(Double[][] netMap) {
		this.netMap = netMap;
	}

	public ArrayList<Integer> getCoordinateListInteger() {
		return coordinateListInteger;
	}

	public void setCoordinateListInteger(ArrayList<Integer> coordinateListInteger) {
		this.coordinateListInteger = coordinateListInteger;
	}

	public ArrayList<Double> getWetListCopy() {
		return wetList;
	}

	public void setWetListCopy(ArrayList<Double> wetListCopy) {
		this.wetList = wetListCopy;
	}

	public ArrayList<Double> getListOfPointsCopy() {
		return listOfPointsCopy;
	}

	public void setListOfPointsCopy(ArrayList<Double> listOfPointsCopy) {
		this.listOfPointsCopy = listOfPointsCopy;
	}

	public ArrayList<Double> getWetList() {
		return wetListInteger;
	}

	public void setWetList(ArrayList<Double> wetList) {
		this.wetListInteger = wetList;
	}

	public double getSwsp_geo() {
		return swsp_geo;
	}

	public void setSwsp_geo(Double swsp_geo) {
		this.swsp_geo = swsp_geo;
	}

	public double getSlat_source() {
		return slat_source;
	}

	public void setSlat_source(Double slat_source) {
		this.slat_source = slat_source;
	}

	public double getSlon_source() {
		return slon_source;
	}

	public void setSlon_source(Double slon_source) {
		this.slon_source = slon_source;
	}

	public Double getSlatInter() {
		return slatInter;
	}

	public void setSlatInter(Double slatInter) {
		this.slatInter = slatInter;
	}

	public Double getSlonInter() {
		return slonInter;
	}

	public void setSlonInter(Double slonInter) {
		this.slonInter = slonInter;
	}

	public ArrayList<Double> getCoordinateList() {
		return coordinateList;
	}

	public void setCoordinateList(ArrayList<Double> coordinateList) {
		this.coordinateList = coordinateList;
	}

	public int getLength_tab() {
		return length_tab;
	}

	public void setLength_tab(int length_tab) {
		this.length_tab = length_tab;
	}

	public int getWidth_tab() {
		return width_tab;
	}

	public void setWidth_tab(int width_tab) {
		this.width_tab = width_tab;
	}

	public SectorData getMaxMinLatLon() {
		return maxMinLatLon;
	}

	public PositionHolder getStartPosition() {
		return startPosition;
	}

	public String[][] getWaterDirections() {
		return waterDirection;
	}

	public void setMaxMinLatLon(SectorData maxMinLatLon) {
		this.maxMinLatLon = maxMinLatLon;
	}

	public void setStartPosition(PositionHolder startPosition) {
		this.startPosition = startPosition;
	}

	public void setWaterDirection(String[][] waterDirection) {
		this.waterDirection = waterDirection;
	}
	
	

}
