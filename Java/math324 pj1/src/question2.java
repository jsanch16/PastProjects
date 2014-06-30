

public class question2 {
   
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
     * This method calculates the probability, mean of the means, and 
     * standard deviation of the means of the first question.
     */
    public static void firstCalculation() 
    {
        
        double[] sampleMeans = new double[729];
        double randomNumber;
        
        // Goes through each array index of the array sampleMeans and put into
        // each array index the mean of the 40000  generated numbers
        for (int i = 0; i < sampleMeans.length; i++) {
        // Generates 40000  numbers for 729 and adds all those numbers
        	
        	double sumOfAllNumbers = 0.0;
            for (int j = 0; j < 40000; j++) {
                randomNumber = 7.0 + 3*Math.random() ;
                sumOfAllNumbers += randomNumber;
               
            }
            sampleMeans[i] = sumOfAllNumbers / 40000;
            //System.out.println(  sampleMeans[i]);    
        }
        
        double event = 0.0;
        double sumOfTheMeans = 0.0;
        
        // Goes through sampleMeans Array and counts all events.
        // this loop also adds all the means of the means
        for (int i = 0; i < sampleMeans.length; i++) {

            if (sampleMeans[i] >= 8.47 && sampleMeans[i] <= 8.51) {
                event++;
            }
            
            sumOfTheMeans += sampleMeans[i];
           
        }
        
        double sumOfTheMeansSquared = 0.0;
        
        // Goes through sampleMeans Array and adds the means squared.
        for(int i = 0; i < sampleMeans.length; i++) {
            
            sumOfTheMeansSquared += (sampleMeans[i] * sampleMeans[i]);
        }
        
        // Calculates the probability, mean, and SD of the 729 samples.
        double probability = event / sampleMeans.length;
        double meanOfTheMeans = sumOfTheMeans / sampleMeans.length;
        double variance = (sumOfTheMeansSquared - 
                ((sumOfTheMeans * sumOfTheMeans) / sampleMeans.length)) /
                (sampleMeans.length - 1);
        double standardDeviationOfTheMeans = Math.sqrt(variance);
        
        // Prints results to console.
        System.out.print("The simulated probability between 8.47 and 8.51"
                + " is: ");
        System.out.printf("%.4f\n", probability);
        
        System.out.print("The mean of all the means is: ");
        System.out.printf("%.4f\n", meanOfTheMeans);
        
        System.out.print("The standard deviation of the means is: ");
        System.out.printf("%.4f\n", standardDeviationOfTheMeans);
        System.out.println();
    }
    
    /*
     * This method calculates the probability, mean of the means, and
     * standard deviation of the second question
     */
    public static void secondCalculation() {
    
    	double[] sampleMeans = new double[729];
		int randomNumbers;
		for (int i = 0; i < sampleMeans.length; i++) {
		    double sumOfAllNumbers = 0;
		        		
		       for(int j = 0; j < 40000; j++){
		        			
		          randomNumbers = (int) ((Math.random() * 6) + 1);
		          sumOfAllNumbers += randomNumbers;
		          
		            }
		            //double sum = sumOfAllNumbers;
		            sampleMeans[i] = sumOfAllNumbers / 40000; 
		            //System.out.println(  sampleMeans[i]);
		        }
			
		        
		        // Goes through sampleMeans Array and counts all events.
		        // this loop also adds all the means of the means
		        double event = 0.0;
		        double sumOfTheMeans = 0.0;
		        for (int i = 0; i < sampleMeans.length; i++) {
		   
		            if (sampleMeans[i] >= 3.0 && sampleMeans[i] <= 3.3) {

		                event++;
		            }
		            
		            sumOfTheMeans += sampleMeans[i];
		            
		        }
		        
		        // Goes through sampleMeans Array and adds the means squared.
		        double sumOfTheMeansSquared = 0.0;
		        for(int i = 0; i < sampleMeans.length; i++) {
		            
		            sumOfTheMeansSquared += (sampleMeans[i] * sampleMeans[i]);
		        }
		        
		        // Calculates the probability, mean, and SD of the 729 samples.
		        double probability = event / sampleMeans.length;
		        //System.out.println("Probability is " + probability);
		        double meanOfTheMeans = sumOfTheMeans / sampleMeans.length;
		        double variance = (sumOfTheMeansSquared - 
		                ((sumOfTheMeans * sumOfTheMeans) / sampleMeans.length)) / 
		                (sampleMeans.length - 1);
		        double standardDeviationOfTheMeans = Math.sqrt(variance);
		        
		        // Prints results to console.
		        System.out.print("The simulated probability between 3.0 and 3.3"
		                + " is: ");
		        System.out.printf("%.2f\n", probability);
		        
		        System.out.print("The mean of all the means is: ");
		        System.out.printf("%.2f\n", meanOfTheMeans);
		        
		        System.out.print("The standard deviation of the means is: ");
		        System.out.printf("%.4f\n", standardDeviationOfTheMeans);
		        
			} 
       
    }


