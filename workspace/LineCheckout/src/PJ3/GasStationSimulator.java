package PJ3;

import java.util.*;
import java.io.*;

// You may add new functions or data in this class 
// You may modify any functions or data members here
// You must use Car, GasPump and GasStation
// to implement your simulator

class GasStationSimulator {
	// NEW DATA FIELDS
	boolean random = false;
	int totalFreeTime = 0;
	GasPump tempPump;
	Car tempCar;

	// input parameters
	private int numGasPumps, carQLimit;
	private int simulationTime, dataSource;
	private int chancesOfArrival, maxDuration;

	// statistical data
	private int numGoaway, numServed, totalWaitingTime;

	// internal data
	private int carIDCounter;
	private GasStation service; // Gas station object
	private Scanner dataFile; // get car data from file
	private Random dataRandom; // get car data using random function

	// most recent car arrival info, see getCarData()
	private boolean anyNewArrival;
	private int serviceDuration;

	// initialize data fields
	private GasStationSimulator() {
		// add statement

		// set data fields to 0 and booleans to false
		anyNewArrival = false;
		carIDCounter = 0;
		numServed = 0;
		numGoaway = 0;
		totalWaitingTime = 0;

	}

	private void setupParameters() {
		// add statements, read input parameters
		// setup dataFile or dataRandom

		// initialize scanner
		Scanner input = new Scanner(System.in);

		// Prompt user for simulation time.
		System.out.print("Enter simulation time (positive integer): ");
		simulationTime = input.nextInt();
		// loop if number is invalid
		while (simulationTime > 10000 || simulationTime <= 0) {
			System.out
					.print("Number needs to be less than or equal to 10000 and greater "
							+ "than zero: ");
			simulationTime = input.nextInt();
		}

		// Service Duration
		System.out.print("Enter maximum service duration of cars: ");
		maxDuration = input.nextInt();
		while (maxDuration > 500 || maxDuration <= 0) {
			System.out
					.print("Number needs to be less than or equal 500 and greater than"
							+ " zero: ");
			maxDuration = input.nextInt();
		}

		// Chances of arrival
		System.out.print("Enter chances (0% < & <= 100%) of new car: ");
		chancesOfArrival = input.nextInt();
		while (chancesOfArrival > 100 || chancesOfArrival < 1) {
			System.out
					.print("Number needs to be less than or equal to 100 and greater than"
							+ " zero: ");
			chancesOfArrival = input.nextInt();
		}

		// Service Pumps
		System.out.print("Enter the number of service pumps: ");
		numGasPumps = input.nextInt();
		while (numGasPumps > 10 || numGasPumps < 1) {
			System.out
					.print("Number needs to be less than or equal 10 and greater than"
							+ " zero: ");
			numGasPumps = input.nextInt();
		}

		// Que Limit
		System.out.print("Enter car waiting queue limit : ");
		carQLimit = input.nextInt();
		while (carQLimit > 50 || carQLimit < 1) {
			System.out
					.print("Number needs to be less than or equal 50 or greater than"
							+ " zero: ");
			carQLimit = input.nextInt();
		}

		// Prompt user for data file or random data
		System.out.print("Enter 1/0 to get data from file/Random: ");
		dataSource = input.nextInt();

		switch (dataSource) {

		case 0:
			random = true;
			dataRandom = new Random();
			break;

		case 1:

			System.out.print("Enter a filename : ");
			String fileName = input.next();
			File file = new File(fileName);

			// attempt to read file from project directory
			try {
				dataFile = new Scanner(file);
			} catch (Exception e) {
				System.out.println("File is not valid");
			}
			random = false;
			break;

		default:
			System.out.println("Input is invalid reenter 1 or 0");
			System.exit(1);
		}

		// close scanner
		input.close();
	}

	private void getCarData() {
		// get next car data : from file or random number generator
		// set anyNewArrival and serviceDuration
		// add statements

		int data1, data2;

		if (random) {
			anyNewArrival = ((dataRandom.nextInt(100) + 1) <= chancesOfArrival);
			serviceDuration = dataRandom.nextInt(maxDuration) + 1;
			// System.out.println(anyNewArrival + " " + serviceDuration);
		} else {

			data1 = dataFile.nextInt();
			data2 = dataFile.nextInt();

			anyNewArrival = (((data1 % 100) + 1) <= chancesOfArrival);
			serviceDuration = (data2 % maxDuration) + 1;
		}
	}

	private void doSimulation() {
		// add statements
		GasPump currentGasPump = null;
		Car newCar = null;
		Car queCar = null;

		// Initialize GasStation
		service = new GasStation(this.numGasPumps, this.carQLimit, 1);

		// Time driver simulation loop
		for (int currentTime = 0; currentTime < simulationTime; currentTime++) {

			// Step 1: any new car enters the gas station?
			getCarData();
			System.out.println("Time: " + currentTime);

			if (anyNewArrival) {
				// Step 1.1: setup car data
				// New Car has arrived
				carIDCounter++;
				newCar = new Car(carIDCounter, serviceDuration, currentTime);
				System.out.println("\tCar #" + carIDCounter
						+ " has arrived with a duration of " + serviceDuration
						+ " unit(s)\t");

				// Step 1.2: check car waiting queue too long?

				if (!service.isCarQTooLong()) {
					// Place car in que if room.
					service.insertCarQ(newCar);
					System.out.println("\tCar #" + carIDCounter
							+ " is now in Car que\t");
				} else {
					// If car goes away from long que
					System.out.println("\tCar #" + carIDCounter
							+ " goes away due to long car que\t");
					this.numGoaway++;
				}
			} else {
				System.out.println("\tNo new car!");
			}

			// Step 2: free busy pumps, add to free pumpQ
			for (int i = 0; i < service.numBusyGasPumps(); i++) {

				if (service.getFrontBusyGasPumpQ().getEndBusyIntervalTime() == currentTime) {
					// Set pump busy to free
					tempCar = service.getFrontBusyGasPumpQ().busyToFree();
					// Remove busy pump place in free que
					tempPump = service.removeBusyGasPumpQ();
					service.insertFreeGasPumpQ(tempPump);

					// Prompt user car was Served and pump is now free
					System.out.println("\tCar #" + tempCar.getID()
							+ " has beed serviced\t");
					System.out.println("\tPump #" + tempPump.getGasPumpID()
							+ " is now free\t");
				}
			}

			// Step 3: get free pumps to serve waiting cars

			for (int i = 0; i < service.numFreeGasPumps(); i++) {

				if (service.numFreeGasPumps() != 0 && !service.emptyCarQ()) {

					// Set current pump to freepump
					currentGasPump = service.removeFreeGasPumpQ();

					// Remove car from Que
					queCar = service.removeCarQ();

					// update total waiting time
					totalWaitingTime += (currentTime - queCar.getArrive());

					// insert pump to busy que
					currentGasPump.freeToBusy(queCar, currentTime);
					service.insertBusyGasPumpQ(currentGasPump);
					numServed++;

					// Prompt User car is being served
					System.out.println("\tPump #"
							+ currentGasPump.getGasPumpID()
							+ " is now serving Car #" + queCar.getID()
							+ " for " + queCar.getDuration() + " unit(s)\t");

				}
			}
		}// end simulation loop
		// clean Up
		
		// close dataFile
		if (dataSource == 1) {
			this.dataFile.close();
		}
	}

	private void printStatistics() {
		// add statements into this method!
		// print out simulation results
		// see the given example in project statement
		// you need to display all free and busy gas pumps
		// print out simulation results
		// see the given example in project statement
		System.out.printf("\n\n");
		System.out.println("End of simulation report:");
		System.out.println();

		System.out.println("\t#total arrival cars\t:" + this.carIDCounter);
		System.out.println("\t#cars gone-away\t\t:" + numGoaway);
		System.out.println("\t#cars served\t\t:" + numServed);

		System.out.println();
		System.out.println("Current Gas Pumps info");
		System.out.println();

		System.out.println("\t#waiting cars\t:" + service.numWaitingCars());
		System.out.println("\t#busy pumps\t:" + service.numBusyGasPumps());
		System.out.println("\t#free pumps\t:" + service.numFreeGasPumps());

		System.out.println();
		System.out.println("Total waiting time\t:" + totalWaitingTime);
		if (numServed != 0) {
			System.out.printf("Average waiting time\t:"
					+ (double) totalWaitingTime / numServed);
		} else
			System.out.printf("Average waiting time\t:" + totalWaitingTime);

		System.out.println();
		System.out.println();
		System.out.println("Busy Gas Pump Info: ");
		System.out.println();
		for (int i = 0; i <= service.numBusyGasPumps(); i++) {
			if (service.numBusyGasPumps() != 0) {
				GasPump currentGasPump = service.removeBusyGasPumpQ();
				currentGasPump.setEndServiceTime(simulationTime, GasPump.BUSY);
				currentGasPump.printStatistics();
			}
		}

	}

	// *** main method to run simulation ****

	public static void main(String[] args) {
		GasStationSimulator gas_station_simulator = new GasStationSimulator();
		gas_station_simulator.setupParameters();
		gas_station_simulator.doSimulation();
		gas_station_simulator.printStatistics();
	}

}
