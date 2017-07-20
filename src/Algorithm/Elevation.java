package Algorithm;

import java.util.ArrayList;

import gov.nasa.worldwind.WorldWindow;
import gov.nasa.worldwind.geom.Angle;
import gov.nasa.worldwind.geom.LatLon;
import gov.nasa.worldwind.geom.Sector;
import gov.nasa.worldwind.util.Logging;

public class Elevation {

	private DataHolder dataHolder;
	private WorldWindow wwd;
	private double swsp_geo;

	public Elevation(DataHolder dataHolder, WorldWindow wwd) {
		super();
		this.dataHolder = dataHolder;
		this.wwd = wwd;
		ElevationMap();
	}

	public void ElevationMap() {
		ArrayList<LatLon> latlons = new ArrayList<LatLon>();
		Double[][] sourceWaterLatLon = new Double[dataHolder.getWidth_tab() - 1][dataHolder.getLength_tab() - 1];

		for (int i = 0; i < dataHolder.getLength_tab(); i++) {
			for (int j = 0; j < dataHolder.getWidth_tab(); j++) {

				latlons.add(LatLon.fromDegrees(dataHolder.getMaxMinLatLon().getMin().getLat() + i,
						dataHolder.getMaxMinLatLon().getMin().getLon() + j));
			}
		}

		Sector sector = Sector.fromDegrees(dataHolder.getMaxMinLatLon().getMin().getLat(),
				dataHolder.getMaxMinLatLon().getMax().getLat(), dataHolder.getMaxMinLatLon().getMin().getLon(),
				dataHolder.getMaxMinLatLon().getMax().getLon());

		double[] elevations = new double[latlons.size()];

		double targetResolution = Angle.fromDegrees(1d).radians / 3600;

		double resolutionAchieved = this.wwd.getModel().getGlobe().getElevationModel().getElevations(sector, latlons,
				targetResolution, elevations);

		StringBuffer sb = new StringBuffer();
		for (double e : elevations) {
			sb.append("\n").append(e);
		}

		Logging.logger().info(sb.toString());
	}

}
