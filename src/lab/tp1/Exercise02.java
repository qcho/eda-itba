package lab.tp1;


import lab.Util;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Exercise02 {

    public static void main(String[] args) {

	XYSeries comparations = new XYSeries("Comparations");
	XYSeries milliseconds = new XYSeries("Milliseconds");

	for (int i = 0; i < 100; i++) {
	    Integer[] array = Util.getRandomIntegerArray(i);
	    long startTime = System.currentTimeMillis();
	    comparations.add(i,Util.bubbleSort(array));
	    //System.out.println("array (" + comparations + "): " + Arrays.toString(array));
	    long endTime = System.currentTimeMillis();
	    milliseconds.add(i, endTime - startTime);
	}
	System.out.println("plotting...");

	XYSeriesCollection dataset = new XYSeriesCollection();
	dataset.addSeries(comparations);
	//dataset.addSeries(milliseconds);

	// create the chart...
	ChartFactory.setChartTheme(StandardChartTheme.createDarknessTheme());
	JFreeChart chart = ChartFactory.createXYLineChart("Bubble Sort times", "number of elements", "comparations", dataset, PlotOrientation.VERTICAL, true, true, true);
	// create and display a frame...
	ChartFrame frame = new ChartFrame("Test", chart);
	frame.pack();
	frame.setVisible(true);
    }
}
