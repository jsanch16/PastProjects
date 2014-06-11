/***
 * Juan Sanchez
 * CS 413
 * Barry Levine
 * Towers of Hanoi
 * 
 */

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
        
       
       //array index [0] is skipped, indexes 1-3 are 
       //used for easier reading
        hanoiTable[1] = new Peg("A");
        hanoiTable[2] = new Peg("B");
        hanoiTable[3] = new Peg("C");
        
        //fill first peg with desired number of disks to begin computation
        for (int i = numDisks; i > 0;i--)   
        {
            hanoiTable[1].push(new Disk(i));
        }
        
        
        //formatting
        System.out.println();
        System.out.print("Move");
        System.out.printf("%36s","Peg Configuration");
        System.out.println();
        System.out.printf("%24s","A");
        System.out.printf("%13s","B");
        System.out.printf("%13s","C");
        System.out.println();
        //print initial state
        System.out.printf("init%23s",hanoiTable[1].showPegState());
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
                Disk d = hanoiTable[a].pop(); 
                
                hanoiTable[c].push(new Disk(d.getDiskNumber()));
                
                System.out.print(d.getDiskNumber() 
                        + " from "+ hanoiTable[a].getPegName() + " to " +
                        hanoiTable[c].getPegName());
                
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

class Disk 
{
    private int diskNumber;
    
   public Disk ()
   {
       diskNumber = 1;
   }
   
   public Disk(int DiskNumber)
   {
       diskNumber = DiskNumber;
   }

    public int getDiskNumber() {
        return diskNumber;
    }

    public void setDiskNumber(int diskNumber) {
        this.diskNumber = diskNumber;
    }
}

class Peg extends Stack<Disk>
{
    private String pegName;
    
    public Peg ()
    {
        pegName = "";
        
    }
    
    public Peg(String PegName)
    {
        pegName = PegName;
    }
    
       public Peg(int numberOfDisks, String PegName)
    {
        pegName = PegName;
        for (int i = numberOfDisks; i > 0;i--)   
        {
            push(new Disk(i));
        }
    }
      
    //returns a string of what disks are in peg
    public String showPegState()
    {
        String pegState = "";
        Stack<Disk> tempStack = new Stack<Disk>();
        tempStack = (Stack<Disk>)clone();
        while (!tempStack.isEmpty())
        {
               pegState += tempStack.pop().getDiskNumber();
               
        }        
     return pegState;
    }

    public String getPegName() {
        return pegName;
    }

    public void setPegName(String pegName) {
        this.pegName = pegName;
    }
    
}

