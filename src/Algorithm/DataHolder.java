package Algorithm;

import java.util.ArrayList;

public class DataHolder {
	private SectorData maxMinLatLon;
	private PositionHolder startPosition;
	private String[][] waterDirection;
	private ArrayList<Integer> coordinateList;
	private int length_tab;
	private int width_tab;
	private int slatInter;
	private int slonInter;
	private int slat_source;
	private int slon_source;
	
	
	public int getSlat_source() {
		return slat_source;
	}

	public void setSlat_source(int slat_source) {
		this.slat_source = slat_source;
	}

	public int getSlon_source() {
		return slon_source;
	}

	public void setSlon_source(int slon_source) {
		this.slon_source = slon_source;
	}

	public int getSlatInter() {
		return slatInter;
	}

	public void setSlatInter(int slatInter) {
		this.slatInter = slatInter;
	}

	public int getSlonInter() {
		return slonInter;
	}

	public void setSlonInter(int slonInter) {
		this.slonInter = slonInter;
	}

	public ArrayList<Integer> getCoordinateList() {
		return coordinateList;
	}

	public void setCoordinateList(ArrayList<Integer> coordinateList) {
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
