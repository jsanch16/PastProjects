
//Juan Sanchez
//Tyrone Figuero

public class question1 
{
public static void main(String[] args) {
        
        System.out.println("Question #1");
        System.out.println("-----------");
        System.out.println();
        firstCalculation();
        
        System.out.println("Question #2");
        System.out.println("-----------");
        System.out.println();
        secondCalculation();

    }
    
    /*
     * QUESTION 1------------------------------------------
     * This method calculates the probability, mean of the means, and 
     * standard deviation of the means of the first question.
     */
    public static void firstCalculation() {
        
        double[] sampleMeans = new double[225];
        double randomNumber;
     
        
        // Goes through each array index of the array and puts into
        // each array index the mean of the 22500  generated numbers
        for (int i = 0; i < sampleMeans.length; i++) {
        // Generates 22500  numbers for 225 and adds all those numbers
        	
        	double sumOfAllNumbers = 0.0;
            for (int j = 0; j < 22500; j++) {
                randomNumber = -1 + 2*Math.random();
                sumOfAllNumbers += randomNumber;
               
               
            }
            sampleMeans[i] = sumOfAllNumbers / 22500;
            System.out.println(sampleMeans[i]); 
        }
        
        double event = 0.0;
        double sumOfTheMeans = 0.0;
        
        // Goes through sampleMeans Array and counts all events.
        // this loop also adds all the means of the means
        for (int i = 0; i < sampleMeans.length; i++) {

            if (sampleMeans[i] >= 0 && sampleMeans[i] <= 0.2) {
                event++;
            }
            
            sumOfTheMeans += sampleMeans[i];
           
        }
        
        double sumOfTheMeansSquared = 0.0;
        
        // Goes through sampleMeans Array and adds the means squared.
        for(int i = 0; i < sampleMeans.length; i++) {
            
            sumOfTheMeansSquared += (sampleMeans[i] * sampleMeans[i]);
        }
        
        // Calculates the probability, mean, and SD of the 225 samples.
        double probability = event / sampleMeans.length;
        double meanOfTheMeans = sumOfTheMeans / sampleMeans.length;
        double variance = (sumOfTheMeansSquared - 
                ((sumOfTheMeans * sumOfTheMeans) / sampleMeans.length)) /
                (sampleMeans.length - 1);
        double standardDeviationOfTheMeans = Math.sqrt(variance);
        
        // Prints results to console.
        System.out.print("The simulated probability between 0 and 0.2"
                + " is: ");
        System.out.printf("%.4f\n", probability);
        
        System.out.print("The mean of all the means is: ");
        System.out.printf("%.4f\n", meanOfTheMeans);
        
        System.out.print("The standard deviation of the means is: ");
        System.out.printf("%.4f\n", standardDeviationOfTheMeans);
        System.out.println();
    }
    
    /*
     * QUESTION 2------------------------------------------------------
     * This method calculates the probability, mean of the means, and
     * standard deviation of the second question
     */
    public static void secondCalculation() {
    
    	double[] sampleMeans = new double[225];
		int randomNumbers;
		for (int i = 0; i < sampleMeans.length; i++) {
		    double sumOfAllNumbers = 0;
		        		
		       for(int j = 0; j < 22500; j++){
		        			
		          randomNumbers = (int)((Math.random() * 8) + 1);
		          //System.out.println(randomNumbers);
		          sumOfAllNumbers += randomNumbers;
		          
		            }
		            //double sum = sumOfAllNumbers;
		            sampleMeans[i] = sumOfAllNumbers / 22500; 
		            System.out.println(  sampleMeans[i]);
		        }
			
		        
		        // Goes through sampleMeans Array and counts all events.
		        // this loop also adds all the means of the means
		        double event = 0.0;
		        double sumOfTheMeans = 0.0;
		        for (int i = 0; i < sampleMeans.length; i++) {
		   
		            if (sampleMeans[i] >= 3.8 && sampleMeans[i] <= 4.0) {

		                event++;
		            }
		            
		            sumOfTheMeans += sampleMeans[i];
		            
		        }
		        
		        // Goes through sampleMeans Array and adds the means squared.
		        double sumOfTheMeansSquared = 0.0;
		        for(int i = 0; i < sampleMeans.length; i++) {
		            
		            sumOfTheMeansSquared += (sampleMeans[i] * sampleMeans[i]);
		        }
		        
		        // Calculates the probability, mean, and SD of the 225 samples.
		        double probability = event / sampleMeans.length;
		        //System.out.println("Probability is " + probability);
		        double meanOfTheMeans = sumOfTheMeans / sampleMeans.length;
		        double variance = (sumOfTheMeansSquared - 
		                ((sumOfTheMeans * sumOfTheMeans) / sampleMeans.length)) / 
		                (sampleMeans.length - 1);
		        double standardDeviationOfTheMeans = Math.sqrt(variance);
		        
		        // Prints results to console.
		        System.out.print("The simulated probability between 3.8 and 4.0"
		                + " is: ");
		        System.out.printf("%.2f\n", probability);
		        
		        System.out.print("The mean of all the means is: ");
		        System.out.printf("%.2f\n", meanOfTheMeans);
		        
		        System.out.print("The standard deviation of the means is: ");
		        System.out.printf("%.4f\n", standardDeviationOfTheMeans);
		        
			} 
       
}
