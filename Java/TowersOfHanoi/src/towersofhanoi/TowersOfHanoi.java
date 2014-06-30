

package towersofhanoi;
import java.util.*;


public class TowersOfHanoi 
{
    static Scanner console = new Scanner(System.in);
    private static Peg[] hanoiTable;
    
    public static void main(String[] args) 
    {
        int numberOfDisks = 0;
        System.out.println("How many disks?");
        numberOfDisks = console.nextInt();
        
        solveHanoi(numberOfDisks);
    }
        
    public static void solveHanoi(int numDisks)
    {
       //an array of pegs
       //4 can be changed to however many if solving for n
        //number of pegs
       hanoiTable = new Peg[4];
        
       
       //array index [0] is ignored, indexes 1-3 are used for easier computation
        hanoiTable[1] = new Peg("A");
        hanoiTable[2] = new Peg("B");
        hanoiTable[3] = new Peg("C");
        
        //fill first peg to begin computation
        for (int i = numDisks; i > 0;i--)   
        {
            hanoiTable[1].pegStack.push(new Disk(i));
        }
        
        //formatting
        System.out.print("Move");
        System.out.printf("%-36s","Peg Configuration");
        System.out.println();
        System.out.printf("%24s","A");
        System.out.printf("%13s","B");
        System.out.printf("%13s","C");
        System.out.println();
        //print initial state
        System.out.printf("init%22s",hanoiTable[1].showPegState());
        System.out.println();

        
        moveDisks(numDisks,1,2,3);
        
        
    }
        public static void moveDisks(int n, int a, int b, int c)
        {
         
        if (n > 0)
        {
            try
            { 
                moveDisks(n - 1, a, c, b);
                // move d from top of tower x
                Disk d = hanoiTable[a].pegStack.pop(); 
                
                // to top of tower y
                //tower[y].push(d); 
                hanoiTable[c].pegStack.push(new Disk(d.diskNumber));
                
                System.out.print(d.diskNumber 
                        + " from "+ hanoiTable[a].pegName + " to " +
                        hanoiTable[c].pegName);
                
                //spacing between move and peg config
                System.out.print("          ");
                showHanoiState();
                moveDisks(n - 1, b, a, c);
                
            } catch(Exception ex){}
        }
    }
        public static void showHanoiState()
        {
            for (int i =1; i < hanoiTable.length;i++)
            {
            System.out.printf("%-13s",hanoiTable[i].showPegState());
            }
            System.out.println();
        }

}
