package Algorithm;

import java.awt.Color;
import java.awt.Cursor;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import gov.nasa.worldwind.WorldWindow;
import gov.nasa.worldwind.data.DataRaster;
import gov.nasa.worldwind.geom.Angle;
import gov.nasa.worldwind.geom.Sector;
import gov.nasa.worldwind.layers.CompassLayer;
import gov.nasa.worldwind.layers.Layer;
import gov.nasa.worldwind.layers.LayerList;
import gov.nasa.worldwind.layers.SurfaceImageLayer;
import gov.nasa.worldwind.render.SurfaceImage;
import gov.nasa.worldwindx.examples.ApplicationTemplate;
import gov.nasa.worldwindx.examples.util.ExampleUtil;

public class Imagery extends ImplementationOfAlgorithm {
	public static class AppFrame extends ApplicationTemplate.AppFrame
    {
		public AppFrame()
        {
            // Show the WAIT cursor because the import may take a while.
            this.setCursor(new Cursor(Cursor.WAIT_CURSOR));

            // Import the imagery on a thread other than the event-dispatch thread to avoid freezing the UI.
            Thread t = new Thread(new Runnable()
            {
                public void run()
                {
                    setImagiery(null, null);

                    // Restore the cursor.
                    setCursor(Cursor.getDefaultCursor());
                }
            });

            t.start();
        }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		public void setImagiery(String[][] waterDirection, ArrayList<Integer> list2) {
			
			Display disp = new Display();
			
			Integer[][] netMap3 = disp.NetMap();
			Object objectNetMap3 = netMap3;
			DataRaster rasters =  (DataRaster) objectNetMap3;
			Color colorBlue = new Color(0, 0, 255, 150);
			Color colorTransparent = new Color(0, 0, 0, 50);
			Angle angle = new Angle(null);
			
			DataRaster raster = (DataRaster) objectNetMap3;
	//		raster =  netMap3[][];
			
	//		DataRaster[] rasters = netMap3[][];
	//		DataRaster raster = rasters [0];
			Sector sector = new Sector(angle.fromDegrees(disp.rtwsp_geo_lat), angle.fromDegrees(disp.lbwsp_geo_lat), angle.fromDegrees(disp.rtwsp_geo_lon), angle.fromDegrees(disp.lbwsp_geo_lon));
//			Sector sector = (Sector) raster.getValue(String.valueOf(netMap3.length));
			
			int width = disp.width_tab;
			int height = disp.length_tab;
			
			DataRaster subRaster = raster.getSubRaster(width, height, sector, null);
			raster.dispose();
			
//			BufferedImage image = ((BufferedImageRaster) subRaster).getBufferedImage();
//			subRaster.dispose();
			SurfaceImage surfaceImageBlue = new SurfaceImage(colorBlue, sector);
			SurfaceImage surfaceImageTransparent = new SurfaceImage(colorTransparent, sector);
			
			
			
			
			SwingUtilities.invokeLater(new Runnable()
            {
                public void run()
                {
                	// Add the SurfaceImage to a layer.
                	SurfaceImageLayer layer = new SurfaceImageLayer();
                	for(int i = 0; i < waterDirection.length; i++) {
        				if(waterDirection[disp.slat - list2.get(i)][disp.slon - list2.get(i + 1)] == "#") {
        					layer.addRenderable(surfaceImageBlue);
        				} else {
        					layer.addRenderable(surfaceImageTransparent);
        				}
        			}

                    // Add the layer to the model and update the application's layer panel.
                    insertBeforeCompass(AppFrame.this.getWwd(), layer);

                    // Set the view to look at the imported image.
                    ExampleUtil.goTo(getWwd(), sector);
                }

                
				private void insertBeforeCompass(WorldWindow wwd, SurfaceImageLayer layer) {
					// Insert the layer into the layer list just before the compass.
			        int compassPosition = 0;
			        LayerList layers = wwd.getModel().getLayers();
			        for (Layer l : layers)
			        {
			            if (l instanceof CompassLayer)
			                compassPosition = layers.indexOf(l);
			        }
			        layers.add(compassPosition, layer);
					
				}
            });
			
			

		}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }
	
	public static void main(String[] args)
    {
        ApplicationTemplate.start("Imagery", Imagery.AppFrame.class);
    }

}
