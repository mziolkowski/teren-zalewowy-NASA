package Algorithm;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferInt;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import gov.nasa.worldwind.WorldWindow;
import gov.nasa.worldwind.data.BufferedImageRaster;
import gov.nasa.worldwind.geom.Angle;
import gov.nasa.worldwind.geom.Sector;
import gov.nasa.worldwind.layers.CompassLayer;
import gov.nasa.worldwind.layers.Layer;
import gov.nasa.worldwind.layers.LayerList;
import gov.nasa.worldwind.layers.SurfaceImageLayer;
import gov.nasa.worldwind.render.SurfaceImage;
import gov.nasa.worldwindx.examples.ApplicationTemplate;
import gov.nasa.worldwindx.examples.util.ExampleUtil;

public class Imagery {
	
	private static  DataHolder dataHolder;
	
	public static class AppFrame extends ApplicationTemplate.AppFrame {

		public AppFrame() {
			// Show the WAIT cursor because the import may take a while.
			this.setCursor(new Cursor(Cursor.WAIT_CURSOR));

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
				
				Sector sector = new Sector(Angle.fromDegrees(dataHolder.getMaxMinLatLon().getMin().getLat()),
						Angle.fromDegrees(dataHolder.getMaxMinLatLon().getMax().getLat()),
						Angle.fromDegrees(dataHolder.getMaxMinLatLon().getMin().getLon()),
						Angle.fromDegrees(dataHolder.getMaxMinLatLon().getMax().getLon()));
				
				int width = dataHolder.getWidth_tab();
				int height = dataHolder.getLength_tab();
				
				BufferedImage image = new BufferedImage(15, 15, BufferedImage.TYPE_INT_ARGB);
				SurfaceImage surfaceImage = new SurfaceImage(image, sector);

				SwingUtilities.invokeLater(new Runnable() {
					
					public void run() {
						
						String[][] waterDirection = dataHolder.getWaterDirections();
						ArrayList<Integer> list2 = dataHolder.getCoordinateList();
					
						// Add the SurfaceImage to a layer.
						SurfaceImageLayer layer = new SurfaceImageLayer();
						layer.setName("Imported Surface Image");
						layer.setPickEnabled(false);
						image.setRGB(dataHolder.getStartPosition().getLat(),dataHolder.getStartPosition().getLon(),(Color.red.getRGB()));
						layer.addRenderable(surfaceImage);
						
						for (int i = 0; i <= waterDirection.length; i++) {
							if (waterDirection[dataHolder.getStartPosition().getLat() - list2.get(i)][dataHolder.getStartPosition().getLon() - list2.get(i + 1)] == "#") {
								image.setRGB(dataHolder.getStartPosition().getLat() - list2.get(i),dataHolder.getStartPosition().getLon() - list2.get(i + 1),(Color.blue.getRGB()));
								layer.addRenderable(surfaceImage);
							} else {
//								layer.addRenderable(surfaceImage);
							}
						}

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
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	}

	public static void main(String[] args) throws FileNotFoundException {
		ImplementationOfAlgorithm algorithm = new ImplementationOfAlgorithm();
		dataHolder = algorithm.imp();
		ApplicationTemplate.start("Imagery", Imagery.AppFrame.class);
	}

}
