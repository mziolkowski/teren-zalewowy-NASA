/*
 * Copyright (C) 2012 United States Government as represented by the Administrator of the
 * National Aeronautics and Space Administration.
 * All Rights Reserved.
 */

package gov.nasa.worldwindx.examples;

import gov.nasa.worldwind.BasicModel;
import gov.nasa.worldwind.WorldWindow;
import gov.nasa.worldwind.awt.WorldWindowGLCanvas;
import gov.nasa.worldwind.layers.GARSGraticuleLayer;
import gov.nasa.worldwind.layers.Layer;
import gov.nasa.worldwind.layers.LayerList;
import gov.nasa.worldwind.layers.placename.PlaceNameLayer;
import gov.nasa.worldwindx.examples.ApplicationTemplate.AppFrame;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;

/**
 * This example demonstrates the simplest possible way to create a WorldWind application.
 *
 * @version $Id: SimplestPossibleExample.java 1171 2013-02-11 21:45:02Z dcollins $
 */

public class SimplestPossibleExample extends JFrame
{
    public SimplestPossibleExample()
    {
        WorldWindowGLCanvas wwd = new WorldWindowGLCanvas();
        wwd.setPreferredSize(new java.awt.Dimension(1000, 800));
        this.getContentPane().add(wwd, java.awt.BorderLayout.CENTER);
        wwd.setModel(new BasicModel());
    }

    public static void main(String[] args)
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
//                JFrame frame = new SimplestPossibleExample();
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                frame.pack();
//                frame.setVisible(true);
                ApplicationTemplate.start("World Wind Application", AppFrame.class);

            }
        });
        
        
    }

    
//************************************************************************************************************************************
    
    public static class AppFrame extends ApplicationTemplate.AppFrame
    {
    	
        public AppFrame() throws IllegalAccessException, InstantiationException, ClassNotFoundException
        {
            super(true, true, false);

            GARSGraticuleLayer layer = new GARSGraticuleLayer();

            layer.setGraticuleLineColor(Color.WHITE, GARSGraticuleLayer.GRATICULE_GARS_LEVEL_0);
            layer.setGraticuleLineColor(Color.YELLOW, GARSGraticuleLayer.GRATICULE_GARS_LEVEL_1);
            layer.setGraticuleLineColor(Color.GREEN, GARSGraticuleLayer.GRATICULE_GARS_LEVEL_2);
            layer.setGraticuleLineColor(Color.CYAN, GARSGraticuleLayer.GRATICULE_GARS_LEVEL_3);

            layer.set30MinuteThreshold(1200e3);
            layer.set15MinuteThreshold(600e3);
            layer.set5MinuteThreshold(180e3);

            insertBeforePlacenames(this.getWwd(), layer);
            // Dodanie pola do wpisywania lat/lon, zipCode, name
            this.getContentPane().add(new GazetteerPanel(this.getWwd(), null), BorderLayout.SOUTH);
        }

		private void insertBeforePlacenames(WorldWindow wwd, GARSGraticuleLayer layer) {
				// Insert the layer into the layer list just before the placenames.
			    int compassPosition = 0;
			    LayerList layers = wwd.getModel().getLayers();
			    for (Layer l : layers)
			    {
			        if (l instanceof PlaceNameLayer)
			            compassPosition = layers.indexOf(l);
			    }
			    layers.add(compassPosition, layer);				
		}
    }
    
}


