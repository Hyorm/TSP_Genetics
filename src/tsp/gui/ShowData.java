package tsp.gui;

import tsp.evolution.*;

import java.util.*;
import java.awt.*;
import javax.swing.* ;

import org.jfree.chart.* ; 
import org.jfree.chart.plot.* ; 
import org.jfree.chart.renderer.xy.XYDotRenderer ; 
import org.jfree.data.* ; 
import org.jfree.data.statistics.* ; 
import org.jfree.data.xy.XYDataset ; 
import org.jfree.ui.ApplicationFrame ; 

public class ShowData{

	public Generation[] allGeneration = new Generation[100];

	public ShowData(){}

	public ShowData(Generation[] generation){

		this.allGeneration = generation;
	
	}
	
	public void showMinWeight() {

		ApplicationFrame frame = new ApplicationFrame("Min"); 
 
 		double [] minWeight = new double[100]; 
 	 
 		int i = 0; 
		for(Generation gen : this.allGeneration){ 
 			minWeight[i] = gen.getMinWeight(); 
 			i++; 
 		}
 		HistogramDataset dataset = new HistogramDataset(); 
 		dataset.setType(HistogramType.RELATIVE_FREQUENCY); 
 		dataset.addSeries("Histogram", minWeight, 10); 
 		JFreeChart chart = ChartFactory.createHistogram("Generation Min Weight", 
 		        "Weight", "Generation", dataset, PlotOrientation.VERTICAL, false, false, false);  
		JPanel panel = new ChartPanel(chart);
 		frame.setContentPane(panel); 
 		frame.pack(); 
 		frame.setVisible(true); 
 
 	} 

        public void showAllWeight() {

                ApplicationFrame frame = new ApplicationFrame("All");

                double [] allWeight = new double[100];

                int i = 0;
                for(Generation gen : this.allGeneration){
               	       	allWeight[i] = gen.getAllWeight();
                       	i++;
		}
                HistogramDataset dataset = new HistogramDataset();
                dataset.setType(HistogramType.RELATIVE_FREQUENCY);
                dataset.addSeries("Histogram", allWeight, 100);
                JFreeChart chart = ChartFactory.createHistogram("Generation All Weight",
                        "Weight", "Generation", dataset, PlotOrientation.VERTICAL, false, false, false);
                JPanel panel = new ChartPanel(chart);
                frame.setContentPane(panel);
                frame.pack();
                frame.setVisible(true);


        }
}
