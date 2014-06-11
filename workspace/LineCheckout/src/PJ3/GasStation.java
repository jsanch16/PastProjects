package PJ3;

import java.util.*;

//--------------------------------------------------------------------------
//
// Define simulation queues in a gas station. Queues hold references to Car &
// GasPump objects
//
// Car (FIFO) queue is used to hold waiting cars. If the queue is too long
// (i.e. >  carQLimit), car goes away without entering car queue
//
// There are several gas pumps in a gas station. Use PriorityQueue to 
// hold BUSY gas pumps and FIFO queue to hold FREE gas pumps, 
// i.e. a pump that is FREE for the longest time should start be used first.
//
// To handle gasPump in PriorityQueue, we need to define comparator 
// for comparing 2 gasPump objects. Here is a constructor from Java API:
//
// 	PriorityQueue(int initialCapacity, Comparator<? super E> comparator) 
//
// For priority queue, the default compare function is "natural ordering"
// i.e. for numbers, minimum value is returned first
//
// User can define own comparator class for PriorityQueue.
// For gaspump objects, we like to have smallest end busy interval time first.
//
// The following class define compare() for two gas pumps :

class CompareGasPump implements Comparator<GasPump> {
	// overide compare() method
	public int compare(GasPump o1, GasPump o2) {
		return o1.getEndBusyIntervalTime() - o2.getEndBusyIntervalTime();
	}
}

// DO NOT ADD NEW METHODS OR DATA FIELDS
class GasStation {

	// Private data fields:

	// define one priority queue
	private PriorityQueue<GasPump> busyGasPumpQ;

	// define two FIFO queues
	private Queue<Car> carQ;
	private Queue<GasPump> freeGasPumpQ;

	// define carPtr queue limit
	private int carQLimit;

	// Constructor
	public GasStation() {
		// add statements
	}

	// Constructor
	public GasStation(int numGasPumps, int carQlimit, int startGasPumpID) {
		// use ArrayDeque to construct FIFO queue object
		carQ = new ArrayDeque<Car>();
		freeGasPumpQ = new ArrayDeque<GasPump>();

		// construct PriorityQueue object
		// overide compare() in Comparator to compare GasPump objects
		busyGasPumpQ = new PriorityQueue<GasPump>(numGasPumps,
				new CompareGasPump());

		// initialize carQlimit
		this.carQLimit = carQlimit;
		// Construct GasPump objects and insert into FreeGasPumpQ
		// add statements
		for (int i = 0; i < numGasPumps; i++, startGasPumpID++) {
			freeGasPumpQ.add(new GasPump(startGasPumpID));
		}

	}

	public GasPump removeFreeGasPumpQ() {
		// remove and return a free gasPump
		// Add statetments
		return freeGasPumpQ.poll();
	}

	public GasPump removeBusyGasPumpQ() {
		// remove and return a busy gasPump
		// Add statetments
		return busyGasPumpQ.poll();
	}

	public Car removeCarQ() {
		// remove and return a car
		// Add statetments
		return carQ.poll();
	}

	public void insertFreeGasPumpQ(GasPump gasPump) {
		// insert a free gasPump
		// Add statetments
		freeGasPumpQ.add(gasPump);
	}

	public void insertBusyGasPumpQ(GasPump gasPump) {
		// insert a busy gasPump
		// Add statetments
		busyGasPumpQ.add(gasPump);
	}

	public void insertCarQ(Car car) {
		// insert a car
		// Add statetments
		carQ.add(car);
	}

	public boolean emptyFreeGasPumpQ() {
		// is freeGasPumpQ empty?
		// Add statetments
		return freeGasPumpQ.isEmpty();
	}

	public boolean emptyBusyGasPumpQ() {
		// is busyGasPumpQ empty?
		// Add statetments
		return busyGasPumpQ.isEmpty();
	}

	public boolean emptyCarQ() {
		// is carQ empty?
		// Add statetments
		return carQ.isEmpty();
	}

	public int numFreeGasPumps() {
		// get number of free gasPumps
		// Add statetment
		if (freeGasPumpQ.isEmpty()) {
			return 0;
		} else {
			return freeGasPumpQ.size();
		}
	}

	public int numBusyGasPumps() {
		// get number of busy gasPumps
		// Add statetments
		return busyGasPumpQ.size();
	}

	public int numWaitingCars() {
		// get number of cars
		// Add statetments
		return carQ.size();
	}

	public GasPump getFrontBusyGasPumpQ() {
		// get front of busy gasPumps
		// "retrieve" but not "remove"
		// Add statetments
		return busyGasPumpQ.peek();
	}

	public boolean isCarQTooLong() {
		// is carQ too long?
		// Add statetments
		return (carQ.size() >= carQLimit);
	}

	public void printStatistics() {
		System.out.println("\t# waiting cars        : " + numWaitingCars());
		System.out.println("\t# busy gas pumps      : " + numBusyGasPumps());
		System.out.println("\t# free gas pumps      : " + numFreeGasPumps());
	}

	public static void main(String[] args) {

		// quick check

		GasStation sc = new GasStation(4, 5, 1001);
		Car c1 = new Car(1, 18, 10);
		Car c2 = new Car(2, 33, 10);
		Car c3 = new Car(3, 21, 10);
		Car c4 = new Car(4, 37, 10);
		sc.insertCarQ(c1);
		sc.insertCarQ(c2);
		sc.insertCarQ(c3);
		System.out.println("" + sc.carQ);
		System.out.println("Remove car:" + sc.removeCarQ());
		System.out.println("Remove car:" + sc.removeCarQ());
		System.out.println("Remove car:" + sc.removeCarQ());

		System.out.println("" + sc.freeGasPumpQ);
		GasPump p1 = sc.removeFreeGasPumpQ();
		GasPump p2 = sc.removeFreeGasPumpQ();
		GasPump p3 = sc.removeFreeGasPumpQ();
		GasPump p4 = sc.removeFreeGasPumpQ();
		System.out.println("Remove free gas pump:" + p1);
		System.out.println("Remove free gas pump:" + p2);
		System.out.println("Remove free gas pump:" + p3);
		System.out.println("Remove free gas pump:" + p4);

		p1.freeToBusy(c1, 13);
		p2.freeToBusy(c2, 13);
		p3.freeToBusy(c3, 13);
		p4.freeToBusy(c4, 13);
		sc.insertBusyGasPumpQ(p1);
		sc.insertBusyGasPumpQ(p2);
		sc.insertBusyGasPumpQ(p3);
		sc.insertBusyGasPumpQ(p4);
		System.out.println("" + sc.busyGasPumpQ);
		p1 = sc.removeBusyGasPumpQ();
		p2 = sc.removeBusyGasPumpQ();
		p3 = sc.removeBusyGasPumpQ();
		p4 = sc.removeBusyGasPumpQ();
		System.out.println("Remove busy gas pump:" + p1);
		System.out.println("Remove busy gas pump:" + p2);
		System.out.println("Remove busy gas pump:" + p3);
		System.out.println("Remove busy gas pump:" + p4);

	}

};
