// DO NOT ADD NEW METHODS OR DATA FIELDS!

package PJ3;

class GasPump {

	// define constants for representing intervals
	static int BUSY = 1;
	static int FREE = 0;

	// start time and end time of current interval
	private int startTime;
	private int endTime;

	// pump id and current car which is served by this gas pump
	private int pumpID;
	private Car currentCar;

	// for keeping statistical data
	private int totalFreeTime;
	private int totalBusyTime;
	private int totalCars;

	// Constructor
	GasPump() {
		// add statements
		startTime = 0;
		endTime = 0;
		totalFreeTime = 0;
		totalBusyTime = 0;
		totalCars = 0;
		pumpID = 0;
	}

	// Constructor with gas pump id
	GasPump(int gasPumpId) {
		// add statements
		pumpID = gasPumpId;
		startTime = 0;
		endTime = 0;
		totalFreeTime = 0;
		totalBusyTime = 0;
		totalCars = 0;
	}

	// accessor methods
	int getGasPumpID() {
		return pumpID;
	}

	Car getCurrentCar() {
		// add statements
		return currentCar;
	}

	// need this to setup priority queue
	int getEndBusyIntervalTime() {
		// return end time of busy interval
		// add statements
		return endTime;
	}

	// functions for state transition
	// FREE -> BUSY :
	void freeToBusy(Car currentCar, int currentTime) {
		// Main goal : switch from free interval to busy interval
		//
		// end free interval, start busy interval
		// steps : update totalFreeTime
		// set startTime, endTime, currentCar,
		// update totalCars

		// add statement
		totalFreeTime += currentTime - startTime;
		startTime = currentTime;
		endTime = currentTime + currentCar.getDuration();
		totalCars++;
		this.currentCar = currentCar;
	}

	// BUSY -> FREE :
	Car busyToFree() {
		// Main goal : switch from busy interval to free interval
		//
		// steps : update totalBusyTime
		// set startTime
		// return currentCar

		// add statement
		totalBusyTime += endTime - startTime;
		startTime = endTime;
		return currentCar;
	}

	// need this method at the end of simulation to update gas pump data
	void setEndServiceTime(int endsimulationtime, int intervalType) {
		// for end of simulation
		// set endTime,
		// for FREE interval, update totalFreeTime
		// for BUSY interval, update totalBusyTime

		// add statements
		// set endTime to endsimulationtime
		endTime = endsimulationtime;
		if (intervalType == FREE) {
			totalFreeTime += endTime - startTime;
		} else
			totalBusyTime += endTime - startTime;

	}

	// functions for printing statistics :
	void printStatistics() {
		// print gasPump statistics, see project statement

		System.out.println("\t\tGasPump ID           : " + pumpID);
		System.out.println("\t\tTotal free time      : " + totalFreeTime);
		System.out.println("\t\tTotal service time   : " + totalBusyTime);
		System.out.println("\t\tTotal # of cars      : " + totalCars);
		if (totalCars > 0)
			System.out.format("\t\tAverage service time : %.2f%n\n",
					(totalBusyTime * 1.0) / totalCars);
	}

	public String toString() {
		return "GasPump:" + pumpID + ":" + startTime + "-" + endTime + ":Car:"
				+ currentCar;
	}

	public static void main(String[] args) {
		// quick check
		Car mycar = new Car(20, 30, 40);
		GasPump mypump = new GasPump(5);
		mypump.freeToBusy(mycar, 13);
		System.out.println(mypump);
		mypump.busyToFree();
		mypump.printStatistics();

	}

};
