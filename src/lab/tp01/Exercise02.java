package lab.tp01;

import java.util.Arrays;
import lab.Util;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RefineryUtilities;

/**
 * 2. Implementar un programa que cree un arreglo de N números al azar, los ordene utilizando el
 *	método de burbujeo, e imprima por consola el tiempo que tardó en realizarse el ordenamiento. El
 *	valor de N debe recibirse por línea de comandos. Determinar la complejidad temporal y verificarla
 *	experimentalmente ejecutando el programa con distintos valores de N.
 * 
 * @author Qcho
 */
public class Exercise02 {

    private static final int MAX_ARRAY = 500;

    public static void main(String[] args) {

	XYSeries bSortComp = new XYSeries("bubbleSort Comparations");
	XYSeries bSortOptComp = new XYSeries("bubbleSortOptimized Comparations");
	XYSeries quadratic = new XYSeries("Quadratic");

	XYSeries bSortMilliseconds = new XYSeries("bubbleSort Milliseconds");
	XYSeries bSortOptMilliseconds = new XYSeries("bubbleSortOptimized Milliseconds");

	System.out.println("calculating");

	// TODO: preguntar si las comparaciones estan bien.
	System.out.print("Creating random Array: " + MAX_ARRAY + "...");
	long randomStart = System.currentTimeMillis();
	Integer[] baseArray = Util.getRandomIntegerArray(MAX_ARRAY);
	long randomEnd = System.currentTimeMillis();
	System.out.println(" Created. (" + (randomEnd - randomStart) + " ms.)");

	for (int size = 0; size < MAX_ARRAY; size++) {
	    System.out.print("Calculating array :" + size + "...");
	    quadratic.add(size, Math.pow(size, 2));
	    Integer[] array1 = Arrays.copyOfRange(baseArray, 0, size);
	    Integer[] array2 = Arrays.copyOfRange(baseArray, 0, size);

	    long bSortCompStart = System.currentTimeMillis();
	    bSortComp.add(size, Exercise02.bubbleSort(array1));
	    long bSortCompEnd = System.currentTimeMillis();
	    bSortOptComp.add(size, Exercise02.bubbleSortOptimized(array2));
	    long bSortOptCompEnd = System.currentTimeMillis();
	    //System.out.println("array (" + comparations + "): " + Arrays.toString(array));

	    bSortMilliseconds.add(size, bSortCompEnd - bSortCompStart);
	    bSortOptMilliseconds.add(size, bSortOptCompEnd - bSortCompEnd);
	    System.out.println(" Calculated.(" + (bSortOptCompEnd - bSortCompStart) + " ms.)");

	}
	System.out.println("Plotting...");

	XYSeriesCollection dataset1 = new XYSeriesCollection();
	dataset1.addSeries(bSortComp);
	dataset1.addSeries(bSortOptComp);
	dataset1.addSeries(quadratic);

	XYSeriesCollection dataset2 = new XYSeriesCollection();
	dataset2.addSeries(bSortMilliseconds);
	dataset2.addSeries(bSortOptMilliseconds);


	// create the chart...
	ChartFactory.setChartTheme(StandardChartTheme.createDarknessTheme());

	JFreeChart chart1 = ChartFactory.createXYLineChart("Bubble Sort times", "number of elements", "comparations", dataset1, PlotOrientation.VERTICAL, true, true, true);
	JFreeChart chart2 = ChartFactory.createXYLineChart("Bubble Sort times", "number of elements", "milliseconds", dataset2, PlotOrientation.VERTICAL, true, true, true);

	// create and display a frame...
	ChartFrame frame1 = new ChartFrame("Exercise02 1", chart1);
	frame1.pack();
	RefineryUtilities.centerFrameOnScreen(frame1);

	frame1.setLocation(frame1.getLocation().x - (frame1.getSize().width / 2 + 10), frame1.getLocation().y);
	frame1.setVisible(true);

	ChartFrame frame2 = new ChartFrame("Exercise02 2", chart2);
	frame2.pack();
	RefineryUtilities.centerFrameOnScreen(frame2);
	frame2.setLocation(frame2.getLocation().x + (frame2.getSize().width / 2 + 10), frame2.getLocation().y);
	frame2.setVisible(true);
    }

    /**
     * BubbleSort for generic arrays.
     *
     * @param <T> any Comparable class.
     * @param array the array to be sorted.
     * @return the number of comparations made. Useful for Order Calculation.
     */
    public static <T extends Comparable<? super T>> int bubbleSort(T[] array) {
	boolean swapped;
	int comparations = 0;
	do {
	    swapped = false;
	    for (int i = 0; i < array.length - 1; i++) {
		if (array[i].compareTo(array[i + 1]) > 0) {
		    Util.swap(array, i, i + 1);
		    swapped = true;
		    comparations++;
		}
		comparations++;
	    }
	    comparations++;
	} while (swapped);
	//System.out.println(comparations);
	return comparations;
    }

    /**
     * Optimized BubbleSort for generic arrays.
     *
     * @param <T> any Comparable class.
     * @param array the array to be sorted.
     * @return the number of comparations made. Useful for Order Calculation.
     */
    public static <T extends Comparable<? super T>> int bubbleSortOptimized(T[] array) {
	int n = array.length;
	int newn;
	int comparations = 0;
	do {
	    newn = 0;
	    for (int i = 0; i < n - 1; i++) {
		if (array[i].compareTo(array[i + 1]) > 0) {
		    Util.swap(array, i, i + 1);
		    newn = i + 1;
		    comparations++;
		}
		comparations++;
	    }
	    n = newn;
	    comparations++;
	} while (n>1);
	//System.out.println(comparations);
	return comparations;
    }
}
