package lab.tp03;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 5. Escribir un programa que permita simular la performance de un servidor de
 * impresión.
 * 
 * El servidor recibe solicitudes de impresión desde distintas terminales, y las
 * procesa en el orden en el que las recibe. Si se encuentra ocupado, los
 * trabajos son encolados.
 * 
 * La probabilidad de que en una unidad de tiempo arribe un trabajo al servidor
 * está dada por el parámetro arrivalProbability.
 * 
 * El tiempo que tarda el servidor en procesar un trabajo está uniformemente
 * distribuido entre los parámetros minServiceTime y maxServiceTime.
 * 
 * El tiempo total de la simulación está dado por el parámetro simulationTime.
 * 
 * En función de estos parámetros, el programa debe imprimir como resultado la
 * cantidad total de trabajos atendidos, el tiempo promedio de espera y la
 * cantidad promedio de trabajos en cola.
 */

public class Ex05 {
	public static Random randomizer = new Random();

	private double arrivalProbability; // 0 -> 1
	private int minServiceTime; // seconds
	private int maxServiceTime; // seconds
	private int simulationTime; // seconds
	private double printSum;
	
	private int jobsPrinted = 0;
	private List<Integer> serviceTimes = new ArrayList<Integer>();

	public class Print implements Simulation {
		int serviceTime;

		public Print(int serviceTime) {
			this.serviceTime = serviceTime;
		}

		@Override
		public void nextStep() {
			serviceTime--;
		}

		@Override
		public boolean hasNextStep() {
			return serviceTime > 0;
		}

	}

	public Ex05(double arrivalProbability, int minServiceTime, int maxServiceTime, int simulationTime) {
		this.arrivalProbability = arrivalProbability;
		this.minServiceTime = minServiceTime;
		this.maxServiceTime = maxServiceTime;
		this.simulationTime = simulationTime;
	}

	public Ex05() {
		this(0.2, 1, 20, 100000);
	}

	public static void main(String[] args) {
		Ex05 simulation = new Ex05();
		simulation.run();
		
		System.out.println("jobs printed: " + simulation.getJobsPrinted());
		System.out.println("avg print time: " + simulation.getAvgTimes());
		System.out.println("avg print queue: " + simulation.getPrintAvg());
	}

	private double getAvgTimes() {
		double sum = 0;
		for (int time: this.serviceTimes){
			sum = sum + time; 
		}
		return sum/this.serviceTimes.size();
	}

	private int getJobsPrinted() {
		return this.jobsPrinted;
	}
	public double getPrintAvg(){
		return this.printSum/this.simulationTime;
	}

	public void run() {
		Queue<Print> printQueue = new LinkedBlockingQueue<Print>();
		Print current = null;
		for (int i = 1; i < this.simulationTime; i++) {

			if (randomizer.nextDouble() < this.arrivalProbability) {
				printQueue.add(newRandomPrint());
				System.out.println("Print added.");
			} else {
				System.out.println("Print not added.");
			}
			System.out.println("queue: " + printQueue.size());

			if (current != null && current.hasNextStep()) {
				current.nextStep();
				System.out.println("printing...");
			} else {
				if (current != null) {
					System.out.println("priting done.");
					jobsPrinted++;
				} else {
					System.out.println("no prints in queue");
				}
				if (!printQueue.isEmpty()) {
					current = printQueue.remove();
				}
			}
			
			printSum = printSum + printQueue.size();
		}
	}

	public Print newRandomPrint() {
		int serviceTime = randomizer.nextInt((maxServiceTime - minServiceTime + 1)) + minServiceTime;
		serviceTimes.add(serviceTime);
		return new Print(serviceTime);
	}

}
