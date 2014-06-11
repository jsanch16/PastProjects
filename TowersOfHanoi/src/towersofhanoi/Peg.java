/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package towersofhanoi;
import java.util.*;
/**
 *
 * @author Juan
 */
public class Peg 
{
    Stack<Disk> pegStack;
    String pegName;
    
    public Peg ()
    {
        pegStack = new Stack<Disk>();
        pegName = "";
        
    }
    
    public Peg(String PegName)
    {
        pegName = PegName;
        pegStack = new Stack<Disk>();
    }
    
       public Peg(int numberOfDisks, String PegName)
    {
        pegName = PegName;
        pegStack = new Stack<Disk>();
        for (int i = numberOfDisks; i > 0;i--)   
        {
            pegStack.push(new Disk(i));
        }
    }
       
        public  void fillPeg(int numberOfDisks)
    {
        pegStack = new Stack<Disk>();
        for (int i = numberOfDisks; i > 0;i--)   
        {
            pegStack.push(new Disk(i));
        }
    }
    
    
    public String showPegState()
    {
        String pegState = "";
        Stack<Disk> tempStack = new Stack<Disk>();
        tempStack = (Stack<Disk>)pegStack.clone();
        while (!tempStack.isEmpty())
        {
               pegState += tempStack.pop().diskNumber;
               
        }
        

     return pegState;
    }
    
}
