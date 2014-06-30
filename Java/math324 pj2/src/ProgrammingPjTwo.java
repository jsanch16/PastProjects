//Juan Sanchez
//Tyrone Figuero
//Math 324
//Programming Project number 2

public class ProgrammingPjTwo {
	public static void main(String[] args) {
    
    
        System.out.println("Question #1");
        firstCalculation();
        System.out.println("-----------");
        System.out.println();
        
        System.out.println("Question #2");
        secondCalculation();
        System.out.println("-----------");
        System.out.println();
        
        }
	//1.A.------------------------------
    public static void firstCalculation(){
		int  iterations = 10000;//number of simulations
		double averageSumOfIndices = 0.0;//average sum of indices
		double array[] = new double[iterations];//array size 10000
		
        //control loop, iterates 10000
		for(int i=0; i < array.length; i++){
            
            //keep count of the indices that contain a sum <= 1
			int index =0;
			double sum =0.0;//sum of n random numbers
			
            // checks whether the sum is <=1
			while(sum <= 1.0){
				
                sum += Math.random();
			
                //populates array with indeces that contain a sum <=1 
                array[i] = ++index;
			}
            
            //average sum of all indices
			averageSumOfIndices += array[i]/array.length;
			
		}
		//display avergae to the console 
		System.out.print("E(M) by simulation is: ");
        System.out.printf("%.4f\n", averageSumOfIndices);
		
        }
    
    //1.B.--------------------------
    public static void secondCalculation(){
		int  iterations = 10000;//number of simulations
		int index= 2;//default index
		double previousNum = 0.0;
		double nextNum =0.0;
		double averageSumOfIndices = 0.0;//average sum of indices
		
		double array[] = new double[iterations];//array size 10000
		
        //control loop, iterates 10000
		for(int i=0; i < array.length; i++){
         	
                //generate first random number
				previousNum = 0.0 + 1 * Math.random();
            
                //generate second/next random number 
				nextNum = 0.0 + 1 * Math.random();
                
                //checks whether previous is less than or equal to nextNum
                //update index
                while(previousNum <= nextNum){
                	index++;
                	previousNum= nextNum;
                	nextNum = 0.0 + 1*Math.random();
                }
                
                array[i] = index;
            
                //display sum of indices 
                averageSumOfIndices += array[i] / array.length;
                index = 2;
              
		}
        //display average to the console 
		System.out.print("E(N) by simulation is: ");
        System.out.printf("%.4f\n", averageSumOfIndices);
    }
    
}