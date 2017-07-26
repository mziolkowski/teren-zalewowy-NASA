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
		getElevationMap();
	}

	public double[] getElevationMap() {
		ArrayList<LatLon> latlons = new ArrayList<LatLon>();

		for (double i = 0, a = 0; i < dataHolder.getLengthTab(); i++, a += 0.001) {
			for (double j = 0, b = 0; j < dataHolder.getWidthTab(); j++, b += 0.001) {

				latlons.add(LatLon.fromDegrees(dataHolder.getMaxMinLatLon().getMin().getLat() + a,
						dataHolder.getMaxMinLatLon().getMin().getLon() + b));
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

//		Logging.logger().info(sb.toString());
		
		return elevations;
	}

}
