package PJ3;

import java.util.*;
import java.io.*;

// You may add new functions or data in this class 
// You may modify any functions or data members here
// You must use Customer, Cashier and CheckoutArea
// to implement your simulator

class CheckoutAreaSimulator {
	
	//added data fields
	boolean random = false;
	int totalFreeTime = 0;
	Cashier tempCashier;
	Customer tempCustomer;

  // input parameters
  private int numCashiers, customerQLimit;
  private int simulationTime, dataSource;
  private int chancesOfArrival, maxCheckoutTime;

  // statistical data
  private int numGoaway, numServed, totalWaitingTime;

  // internal data
  private int customerIDCounter;
  private CheckoutArea checkoutarea; // checkout area object
  private Scanner dataFile;	     // get customer data from file
  private Random dataRandom;	     // get customer data using random function

  // most recent customer arrival info, see getCustomerData()
  private boolean anyNewArrival;  
  private int checkoutTime;

  // initialize data fields
  private CheckoutAreaSimulator()
  {
	// add statements
		// set data fields to 0 and booleans to false
		anyNewArrival = false;
		customerIDCounter = 0;
		numServed = 0;
		numGoaway = 0;
		totalWaitingTime = 0;
  }

  private void setupParameters()
  {
	// add statements, read input parameters
	// setup dataFile or dataRandom
	// initialize scanner
			Scanner input = new Scanner(System.in);

			// Prompt user for simulation time.
			System.out.print("Enter simulation time (positive integer): ");
			simulationTime = input.nextInt();
			// loop if number is invalid
			while (simulationTime > 10000 || simulationTime <= 0) 
			{
				System.out.print("Number needs to be less than or equal to 10000 and greater "
								+ "than zero: ");
				simulationTime = input.nextInt();
			}

			// Service Duration
			System.out.print("Enter maximum checkout time of customers: ");
			maxCheckoutTime = input.nextInt();
			while (maxCheckoutTime > 500 || maxCheckoutTime <= 0) 
			{
				System.out.print("Number needs to be less than or equal 500 and greater than"
								+ " zero: ");
				maxCheckoutTime = input.nextInt();
			}

			// Chances of arrival
			System.out.print("Enter chances (0% < & <= 100%) of new customer: ");
			chancesOfArrival = input.nextInt();
			while (chancesOfArrival > 100 || chancesOfArrival < 1) {
				System.out.print("Number needs to be less than or equal to 100 and greater than"
								+ " zero: ");
				chancesOfArrival = input.nextInt();
			}

			// Cashiers
			System.out.print("Enter the number of cashiers: ");
			numCashiers = input.nextInt();
			while (numCashiers > 10 || numCashiers < 1) 
			{
				System.out.print("Number needs to be less than or equal 10 and greater than"
								+ " zero: ");
				numCashiers = input.nextInt();
			}

			// Que Limit
			System.out.print("Enter customer queue limit : ");
			customerQLimit = input.nextInt();
			while (customerQLimit > 50 || customerQLimit < 1) 
			{
				System.out.print("Number needs to be less than or equal 50 or greater than"
								+ " zero: ");
				customerQLimit = input.nextInt();
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

				// read file from project directory (or attempt to)
				try 
				{
					dataFile = new Scanner(file);
				} catch (Exception e) 
				{
					System.out.println("Invalid File");
				}
				random = false;
				break;

			default:
				System.out.println("Input is invalid re-enter 1 or 0");
				System.exit(1);
			}

			// close scanner
			input.close();
  }

  private void getCustomerData()
  {
	// get next customer data : from file or random number generator
	// set anyNewArrival and checkoutTime
	// add statements
		int data1, data2;

		if (random) 
		{
			anyNewArrival = ((dataRandom.nextInt(100) + 1) <= chancesOfArrival);
			checkoutTime = dataRandom.nextInt(maxCheckoutTime) + 1;
		} 
		else 
		{

			data1 = dataFile.nextInt();
			data2 = dataFile.nextInt();

			anyNewArrival = (((data1 % 100) + 1) <= chancesOfArrival);
			checkoutTime = (data2 % maxCheckoutTime) + 1;
		}
  }

  private void doSimulation()
  {
	// add statements
		Cashier currentCashier = null;
		Customer newCustomer = null;
		Customer queCustomer = null;

	// Initialize CheckoutArea
		checkoutarea = new CheckoutArea(this.numCashiers, this.customerQLimit, 1);

	// Time driver simulation loop
  	for (int currentTime = 0; currentTime < simulationTime; currentTime++) {

    		// Step 1: any new customer enters the checkout area?
    		getCustomerData();
    		System.out.println("Time: " + currentTime);

    		if (anyNewArrival) 
    		{

      		    // Step 1.1: setup customer data
    			// New Customer has arrived
				customerIDCounter++;
				newCustomer = new Customer(customerIDCounter, checkoutTime, currentTime);
				System.out.println("\tCustomer #" + customerIDCounter
						+ " has arrived with a duration of " + checkoutTime
						+ " unit(s)\t");
      		    // Step 1.2: check customer waiting queue too long?
				if (!checkoutarea.isCustomerQTooLong()) {
					// Place customer in queue if there is room.
					checkoutarea.insertCustomerQ(newCustomer);
					System.out.println("\tCustomerr #" + customerIDCounter
							+ " is now in Customer queue\t");
				} 
				else 
				{
					// If customer goes away from long queue
					System.out.println("\tCustomer #" + customerIDCounter
							+ " goes away due to long customer queue\t");
					this.numGoaway++;
				}
    		} 
    		else 
    		{
      		    System.out.println("\tNo new customer.");
    		}

    		// Step 2: free busy cashiers, add to free cashierQ
    		for (int i = 0; i < checkoutarea.numBusyCashiers(); i++) {

				if (checkoutarea.getFrontBusyCashierQ().getEndBusyIntervalTime() == currentTime) {
					// Set busy cashier to free
					tempCustomer = checkoutarea.getFrontBusyCashierQ().busyToFree();
					// delete busy cashier in free queue
					tempCashier = checkoutarea.removeBusyCashierQ();
					checkoutarea.insertFreeCashierQ(tempCashier);

					// Tell user customer was served and cashier is now free
					System.out.println("\tCustomer #" + tempCustomer.getCustomerID()
							+ " has beed serviced\t");
					System.out.println("\tCashier #" + tempCashier.getCashierID()
							+ " is now free\t");
				}
			}

    		// Step 3: get free cashiers to serve waiting customers 
    		for (int i = 0; i < checkoutarea.numFreeCashiers(); i++) {

				if (checkoutarea.numFreeCashiers() != 0 && !checkoutarea.emptyCustomerQ()) {

					// Set current cashier to free
					currentCashier = checkoutarea.removeFreeCashierQ();

					// Remove customer from queue
					queCustomer = checkoutarea.removeCustomerQ();

					// update total waiting time
					totalWaitingTime += (currentTime - queCustomer.getArrivalTime());

					// add busy cashier to busy queue
					currentCashier.freeToBusy(queCustomer, currentTime);
					checkoutarea.insertBusyCashierQ(currentCashier);
					numServed++;

					// Prompt user customer is being served
					System.out.println("\tCashier #"
							+ currentCashier.getCashierID()
							+ " is now serving Customer #" + queCustomer.getCustomerID()
							+ " for " + queCustomer.getCheckoutDuration() + " unit(s)\t");

				}
			}
    		
  	} // end simulation loop

  	// clean-up
	// close dataFile
	if (dataSource == 1) {
		this.dataFile.close();
	}
  }

  private void printStatistics()
  {
	// add statements into this method!
	// print out simulation results
	// see the given example in project statement
        // you need to display all free and busy cashiers
	  System.out.printf("\n\n");
		System.out.println("End of simulation report:");
		System.out.println();

		System.out.println("\t#total arrival customers\t:" + this.customerIDCounter);
		System.out.println("\t#customers gone-away\t\t:" + numGoaway);
		System.out.println("\t#customers served\t\t:" + numServed);

		System.out.println();
		System.out.println("Current Cashiers info");
		System.out.println();

		System.out.println("\t#waiting customers\t:" + checkoutarea.numWaitingCustomers());
		System.out.println("\t#busy cashiers\t:" + checkoutarea.numBusyCashiers());
		System.out.println("\t#free cashiers\t:" + checkoutarea.numFreeCashiers());

		System.out.println();
		System.out.println("Total waiting time\t:" + totalWaitingTime);
		if (numServed != 0) {
			System.out.printf("Average waiting time\t:"
					+ (double) totalWaitingTime / numServed);
		} else
			System.out.printf("Average waiting time\t:" + totalWaitingTime);

		System.out.println();
		System.out.println();
		System.out.println("Busy Cashier Info: ");
		System.out.println();
		for (int i = 0; i <= checkoutarea.numBusyCashiers(); i++) {
			if (checkoutarea.numBusyCashiers() != 0) {
				Cashier currentCashier = checkoutarea.removeBusyCashierQ();
				currentCashier.setEndIntervalTime(simulationTime, Cashier.BUSY);
				currentCashier.printStatistics();
			}
		}

		System.out.println();
		System.out.println();
		System.out.println("Free Cashiers Info: ");
		System.out.println();
		for (int i = 0; i <= checkoutarea.numFreeCashiers(); i++) {
			if (checkoutarea.numFreeCashiers() != 0) {
				Cashier currentCashier = checkoutarea.removeFreeCashierQ();
				currentCashier.setEndIntervalTime(simulationTime, Cashier.FREE);
				currentCashier.printStatistics();
			}
		}
  }

  // *** main method to run simulation ****

  public static void main(String[] args) {
   	CheckoutAreaSimulator runCheckoutAreaSimulator=new CheckoutAreaSimulator();
   	runCheckoutAreaSimulator.setupParameters();
   	runCheckoutAreaSimulator.doSimulation();
   	runCheckoutAreaSimulator.printStatistics();
  }

}
