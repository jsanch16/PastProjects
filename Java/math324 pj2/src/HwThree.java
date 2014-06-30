//Juan Sanchez
//Tyrone Figuero
//Programming Homework 2
public class HwThree{

	public static void main(String[]args){
    
        //method call to event loop 
        eventLoop();
    
        }
	
        public static void eventLoop(){
        
            String message = "";//to display a message to the console 
        
            //data fields
            int simulations = 10000;//number of simulations
        
            int simulationCounter = 0;
        
            double loseCounter = 0.0;//keep track of loses 
            double winCounter  = 0.0;//keep track of wins
            double tossaADice = 0.0;//keep track of tosses 
		
            //event loop for 10000 simulations 
            while(simulationCounter < 10000){
			
                // create array of ints 
                int [] array = new int[simulations];
            
                int counter =0;
                int b = 0;
                int t = 0;
            
                //generate random numbers from 1 through 6 
                int dice1 = (int) (1+(Math.random()*6));
                int dice2 = (int) (1+(Math.random()*6));
            
                tossaADice++;//update tosses 
            
                //add dice1 and dice2 and store sum into array of ints 
                array[counter] = dice1 + dice2;
            
                //if dice1 equals dice2 update loseCounter 
                if(dice1 == dice2){
                    
                    //System.out.println("You lose!");
                    loseCounter++;
                }
            
                //while dice1 is not equals to dice2 keep tossing
                while(dice1 != dice2){
                
                    //create random numbers [1,6] for dice1 and dice2
                    dice1 = (int) (1+(Math.random()*6));
                    dice2 = (int) (1+(Math.random()*6));
                    
                    tossaADice++;//update tosses 
                    
                    counter++;
                    
                    //update array of ints with sum dice1 + dice2
                    array[counter] = dice1 + dice2;
                    
                        //if dice1 = dice2, you lose!
                        if(dice1 == dice2)
                        {
                            
                            //System.out.println("You lose!");
                            loseCounter++;
                            }
                    
                        else{
                            
                            //checkes whether existing sum matches new sum, if so you win 
                            while(t< counter)
                            {
                                if(array[t] == dice1 + dice2)
                                {
                                    winCounter++;//update winCounter
                                    //System.out.println("You win!");
                                    b = 10;
                                    t = counter;
                                }
                            t++;
                        }
                    }
                if(b == 10){
                    
                    dice1 = dice2;
                    }
                }
                simulationCounter++;//update simulations counter 
                }

            System.out.println();
            message = "The probability of losing is = " + (loseCounter/simulationCounter) + ".";
            System.out.println(message);
            System.out.println();
            
            message = "The probability of winning is = " + (winCounter/simulationCounter) + ".";
            System.out.println(message);
            System.out.println();
            
            message = "The expected number of tosses per game is = " + (tossaADice/simulationCounter) + ".";
            System.out.println(message);
            System.out.println();
        
        }
}