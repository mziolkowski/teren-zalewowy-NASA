package Algorithm;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import gov.nasa.worldwind.WorldWind;
import gov.nasa.worldwind.WorldWindow;
import gov.nasa.worldwind.avlist.AVKey;
import gov.nasa.worldwind.geom.Angle;
import gov.nasa.worldwind.geom.Position;
import gov.nasa.worldwind.geom.Sector;
import gov.nasa.worldwind.layers.CompassLayer;
import gov.nasa.worldwind.layers.Layer;
import gov.nasa.worldwind.layers.LayerList;
import gov.nasa.worldwind.layers.SurfaceImageLayer;
import gov.nasa.worldwind.render.Offset;
import gov.nasa.worldwind.render.PointPlacemark;
import gov.nasa.worldwind.render.PointPlacemarkAttributes;
import gov.nasa.worldwind.render.SurfaceImage;
import gov.nasa.worldwindx.examples.ApplicationTemplate;
import gov.nasa.worldwindx.examples.util.ExampleUtil;

public class Imagery {

	private static DataHolder dataHolder;

	public static class AppFrame extends ApplicationTemplate.AppFrame {

		private static int placemarkNr;

		public AppFrame() {
			// Show the WAIT cursor because the import may take a while.
			this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
			// this.elevation = new Elevation(dataHolder, this.getWwd());

			// Import the imagery on a thread other than the event-dispatch
			// thread to avoid freezing the UI.
			Thread t = new Thread(new Runnable() {
				public void run() {

					setImagiery();

					// Restore the cursor.
					setCursor(Cursor.getDefaultCursor());
				}
			});

			t.start();
		}

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		public void setImagiery() {
			try {
				if (dataHolder.getWaterPointLat() > dataHolder.getLengthTab()) {
					// Add the SurfaceImage to a layer.
					SurfaceImageLayer layer = new SurfaceImageLayer();
					layer.setName("Imported Surface Image");
					layer.setPickEnabled(false);

					putPlacemark(Position.fromDegrees(dataHolder.getMaxMinLatLon().getMin().getLat(),
							dataHolder.getMaxMinLatLon().getMin().getLon()), layer);
					putPlacemark(Position.fromDegrees(dataHolder.getMaxMinLatLon().getMax().getLat(),
							dataHolder.getMaxMinLatLon().getMax().getLon()), layer);
					Sector sector = new Sector(Angle.fromDegrees(dataHolder.getMaxMinLatLon().getMin().getLat()),
							Angle.fromDegrees(dataHolder.getMaxMinLatLon().getMax().getLat()),
							Angle.fromDegrees(dataHolder.getMaxMinLatLon().getMin().getLon()),
							Angle.fromDegrees(dataHolder.getMaxMinLatLon().getMax().getLon()));
					
					BufferedImage image = new BufferedImage(dataHolder.getWidthTab(), dataHolder.getLengthTab(),BufferedImage.TYPE_INT_ARGB);
					SurfaceImage surfaceImage = new SurfaceImage(image, sector);

				SwingUtilities.invokeLater(new Runnable() {

					public void run() {
						Color blueColor = new Color(0, 100, 250, 140);
						Color transparentColor = new Color(0, 0, 0, 0);

						Boolean[][] waterDirection = dataHolder.getWaterDirectionMap();
						
						for (int i = 0; i < waterDirection.length; i++) {
							for (int j = 0; j < waterDirection[i].length; j++) {
								if (waterDirection[i][waterDirection[i].length - 1 - j] == true) {
									image.setRGB(i, j, (blueColor.getRGB()));
								} else {
									image.setRGB(i, j, (transparentColor.getRGB()));
								}
							}
						}

			
						layer.addRenderable(surfaceImage);

						// Add the layer to the model and update the
						// application's layer panel.
						insertBeforeCompass(AppFrame.this.getWwd(), layer);

						// Set the view to look at the imported image.
						ExampleUtil.goTo(getWwd(), sector);

					}

					private void insertBeforeCompass(WorldWindow wwd, SurfaceImageLayer layer) {
						// Insert the layer into the layer list just before the
						// compass.
						int compassPosition = 0;
						LayerList layers = wwd.getModel().getLayers();
						for (Layer l : layers) {
							if (l instanceof CompassLayer)
								compassPosition = layers.indexOf(l);
						}
						layers.add(compassPosition, layer);

					}
				});
			} else {
				// Add the SurfaceImage to a layer.
				SurfaceImageLayer layer = new SurfaceImageLayer();
				layer.setName("Imported Surface Image");
				layer.setPickEnabled(false);

				putPlacemark(Position.fromDegrees(dataHolder.getMaxMinLatLon().getMin().getLat(),
						dataHolder.getMaxMinLatLon().getMin().getLon()), layer);
				putPlacemark(Position.fromDegrees(dataHolder.getMaxMinLatLon().getMax().getLat(),
						dataHolder.getMaxMinLatLon().getMax().getLon()), layer);
				Sector sector = new Sector(Angle.fromDegrees(dataHolder.getMaxMinLatLon().getMin().getLat()),
						Angle.fromDegrees(dataHolder.getMaxMinLatLon().getMax().getLat()),
						Angle.fromDegrees(dataHolder.getMaxMinLatLon().getMin().getLon()),
						Angle.fromDegrees(dataHolder.getMaxMinLatLon().getMax().getLon()));
				
				BufferedImage image = new BufferedImage(dataHolder.getLengthTab(), dataHolder.getWidthTab(),BufferedImage.TYPE_INT_ARGB);
				SurfaceImage surfaceImage = new SurfaceImage(image, sector);

			SwingUtilities.invokeLater(new Runnable() {

				public void run() {
					Color blueColor = new Color(0, 100, 250, 140);
					Color transparentColor = new Color(0, 0, 0, 0);

					Boolean[][] waterDirection = dataHolder.getWaterDirectionMap();
					
					for (int i = 0; i < waterDirection.length; i++) {
						for (int j = 0; j < waterDirection[i].length; j++) {
							if (waterDirection[i][waterDirection[i].length - 1 - j] == true) {
								image.setRGB(j, i, (blueColor.getRGB()));
							} else {
								image.setRGB(j, i, (transparentColor.getRGB()));
							}
						}
					}

		
					layer.addRenderable(surfaceImage);

					// Add the layer to the model and update the
					// application's layer panel.
					insertBeforeCompass(AppFrame.this.getWwd(), layer);

					// Set the view to look at the imported image.
					ExampleUtil.goTo(getWwd(), sector);

				}

				private void insertBeforeCompass(WorldWindow wwd, SurfaceImageLayer layer) {
					// Insert the layer into the layer list just before the
					// compass.
					int compassPosition = 0;
					LayerList layers = wwd.getModel().getLayers();
					for (Layer l : layers) {
						if (l instanceof CompassLayer)
							compassPosition = layers.indexOf(l);
					}
					layers.add(compassPosition, layer);

				}
			});
			}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		private void putPlacemark(Position position, SurfaceImageLayer layer) {

			PointPlacemark pp = new PointPlacemark(position);
			pp.setLabelText("Placemark " + ++placemarkNr);
			pp.setValue(AVKey.DISPLAY_NAME, "Clamp to ground, Label, Semi-transparent, Audio icon");
			pp.setLineEnabled(false);
			pp.setAltitudeMode(WorldWind.CLAMP_TO_GROUND);
			pp.setEnableLabelPicking(true); // enable label picking for this
											// placemark
			PointPlacemarkAttributes attrs = new PointPlacemarkAttributes();
			attrs.setImageAddress("gov/nasa/worldwindx/examples/images/plain-white.png");
			attrs.setImageColor(new Color(1f, 1f, 1f, 0.6f));
			attrs.setScale(0.6);
			// attrs.setImageOffset(new Offset(19d, 8d, AVKey.PIXELS,
			// AVKey.PIXELS));
			attrs.setLabelOffset(new Offset(0.9d, 0.6d, AVKey.FRACTION, AVKey.FRACTION));
			pp.setAttributes(attrs);
			layer.addRenderable(pp);
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		ImplementationOfAlgorithm algorithm = new ImplementationOfAlgorithm();
		dataHolder = algorithm.imp();
		ApplicationTemplate.start("Imagery", Imagery.AppFrame.class);
	}
	/*if (dataHolder.getWaterPointLat() > dataHolder.getLengthTab()) {
	for (int i = 0; i < waterDirection.length; i++) {
		for (int j = 0; j < waterDirection[i].length; j++) {
			if (waterDirection[i][waterDirection.length - 1 - j] == true) {
				image.setRGB(i, j, (blueColor.getRGB()));
			} else {
				image.setRGB(i, j, (transparentColor.getRGB()));
			}
		}
	}
} else {
	for (int i = 0; i < waterDirection.length; i++) {
		for (int j = 0; j < waterDirection[i].length; j++) {
			if (waterDirection[i][waterDirection.length - 1 - j] == true) {
				image.setRGB(i, j, (blueColor.getRGB()));
			} else {
				image.setRGB(i, j, (transparentColor.getRGB()));
			}
		}
	}
}*/
}