
public class HW2TEST {

    public static void main(String[] args) {
        
    	System.out.println("Question A: ");
    	System.out.println("------");
    	firstSimulation();
    	System.out.println("Question B: ");
    	System.out.println("------");
    	secondSimulation();
    
    }	
    	public static void firstSimulation() {
    	
    	// initialize variables
    	int iteration = 10000;
    	double randomNumbers = 0.0;
        double sumOfNumbers = 0.0;
        double sum1 = 0.0; 
       
        double[] array = new double[iteration]; // set up array

        int index = 0;
        for (int i = 0; i < array.length; i++) { //for loop goes through 10000 iterations
            index = 0; // reset index to 0
            sumOfNumbers = 0; // reset sumOfNumbers to 0

            while (sumOfNumbers <= 1.0) { // while loop generates random numbers and adds them up to < 1
                randomNumbers = 0.0 + 1 * Math.random();
                sumOfNumbers += randomNumbers;
                index += 1;

                //System.out.println("SumOfNumbers = " + sumOfNumbers + " and index is " + index);

            }
            array[i] = index; //store array into index
            sum1 += array[i]; //store array into sum



            //System.out.println("Array[i] is : " + array[i]);

        }
        double result = sum1 / 10000; //calculate average

        System.out.println("E(M) is: " + result);
        System.out.println();
    	}
    

        public static void secondSimulation() { 
        	
        	int iteration = 10; 
            int counter = 2; 
            double n = 0.0; 
            double sum2 = 0.0; 
            double nPlusOne = 0.0;
            
            double[] newArray = new double[iteration];
            
        	for (int i = 0; i < iteration; i++) { // for loop goes through 10000 iterations
        		
                n = 0.0 + 1 * Math.random();
                System.out.println("+nis "  + n);
        		nPlusOne = 0.0 + 1 * Math.random();
                System.out.println("nPlusOne is " + nPlusOne);
        		// System.out.println(n);

        		if (n > nPlusOne) {
        			counter++;
        			n = nPlusOne;
        			nPlusOne = 0.0 + 1 * Math.random();

        		 // System.out.println("Number: " + counter);
        		}
            
        	newArray[i] = counter;
            sum2 += newArray[i];
            counter = 2;

        	}
        	double answer = sum2 / iteration;
        	System.out.println("E(N) is: " + answer);
    }
}
