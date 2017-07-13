package Algorithm;

import java.awt.Cursor;

import gov.nasa.worldwind.data.DataRaster;
import gov.nasa.worldwind.geom.Sector;
import gov.nasa.worldwindx.examples.ApplicationTemplate;
import gov.nasa.worldwindx.examples.dataimport.ImportImagery;

public class Imagery extends ImplementationOfAlgorithm{
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
                    setImagiery();

                    // Restore the cursor.
                    setCursor(Cursor.getDefaultCursor());
                }
            });

            t.start();
        }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		public void setImagiery() {
			
			Display disp = new Display();
			
			Integer[][] netMap3 = disp.NetMap();
			DataRaster[][] rasters;
			Object objectNetMap3 = netMap3;
			rasters = (DataRaster[][]) objectNetMap3;
			
			DataRaster raster = (DataRaster) objectNetMap3;
	//		raster =  netMap3[][];
			
	//		DataRaster[] rasters = netMap3[][];
	//		DataRaster raster = rasters [0];
			
			Sector sector =  (Sector) raster.getValue(String.valueOf(netMap3.length));
			
			int width = disp.width_tab;
			int height = disp.length_tab;
			
			DataRaster subRaster = raster.getSubRaster(width, height, sector, null);
			
		}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }
	
	public static void main(String[] args)
    {
        ApplicationTemplate.start("Imagery", Imagery.AppFrame.class);
    }

}
