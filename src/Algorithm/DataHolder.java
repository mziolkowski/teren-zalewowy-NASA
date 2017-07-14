package Algorithm;

import java.util.ArrayList;

public class DataHolder {
	private SectorData maxMinLatLon;
	private PositionHolder startPosition;
	private String[][] wetPoints;
	private ArrayList<Integer> coordinateList;
	private int length_tab;
	private int width_tab;
	
	
	
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

	public String[][] getWetPoints() {
		return wetPoints;
	}

	public void setMaxMinLatLon(SectorData maxMinLatLon) {
		this.maxMinLatLon = maxMinLatLon;
	}

	public void setStartPosition(PositionHolder startPosition) {
		this.startPosition = startPosition;
	}

	public void setWetPoints(String[][] wetPoints) {
		this.wetPoints = wetPoints;
	}
	

}
