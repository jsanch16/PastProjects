
package wargamesimulator;

import java.util.*;


/**
 *
 * @author juan
 */
public class WarGameSimulator {
    
            Scanner console = new Scanner(System.in);
            int fundsCheck = 0;
            int health = 0;
            int damage = 0;
            String winner;
            String loser;
            int armySize;

           public static void main(String[] args) 
           {
                   WarGameSimulator game = new WarGameSimulator();
                   System.out.println("--------------------Welcome to 'War: The Game'--------------------------");
                   System.out.println("Build your army and defeat your enemy! ");
                   System.out.println("------------------------------------------------------------------------");
                   // TODO Auto-generated method stub
                   System.out.println("enter maximum Funds: ");
                   int maxMoney = game.console.nextInt();

                   System.out.println("Player 1, Enter your name: ");
                   String player1Name = game.console.next();
                   General player1 = new General(player1Name, maxMoney);
                   System.out.println("Player 2, Enter your name: ");
                   String player2Name = game.console.next();
                   General player2 = new General(player2Name, maxMoney);

                   System.out.println(player1.name + ", build your army!");
                   game.buildArmy(player1);

                   System.out.println(player2.name + ", build your army!");
                   game.buildArmy(player2);

                   System.out.println(player1.name + "'s army:------------------------------");
                   System.out.println("Army Size: " + player1.army.size() + " soldiers.");
                   System.out.println("---------------------------------");

                   System.out.println(player2.name + "'s army:------------------------------");
                   System.out.println("Army Size: " + player2.army.size() + " soldiers.");
                   System.out.println("---------------------------------");
                   System.out.println();


                   game.simulate(player1, player2);



           }

           public void simulate(General player1, General player2)
           {
                   while (!player1.army.isEmpty() && !player2.army.isEmpty())
                   {
                           if (!player1.army.isEmpty() && !player2.army.isEmpty())
                                   attack(player1,player2);
                           if(!player1.army.isEmpty() && !player2.army.isEmpty())
                                   attack(player2,player1);
                   }

                   if (player1.army.isEmpty())
                   {
                           winner = player2.name;
                           loser = player1.name;
                   }
                   if(player2.army.isEmpty())
                   {
                           winner = player1.name;
                           loser = player2.name;
                   }

                   System.out.println(winner + ", YOU WIN!");
                   System.out.println(loser +  ", YOU LOST!");
                   //System.out.println("--------Battle Summary------");
           }

           public void attack(General attacker, General defender)
           {
                   health = defender.army.peek().unitHealth;
                   damage = attacker.army.peek().unitDamage;

                   defender.army.peek().unitHealth = defender.army.peek().unitHealth - damage;

                   if (defender.army.peek().unitHealth <= 0)
                   {
                           defender.army.remove();
                   }
           }

           public void buildArmy(General currentGeneral)
           {

                   System.out.println("    Unit Type       |   Unit Size   |  Health  |  Damage  |  Cost");
                   System.out.println("-----------------------------------------------------------------");
                   System.out.println("     Knight           100 soldiers       150        80       $500"); 
                   System.out.println("-----------------------------------------------------------------");
                   System.out.println("     Archer            50 soldiers       60        110       $200");
                   System.out.println("-----------------------------------------------------------------");
                   System.out.println("   Infantryman        100 soldiers       100        60       $250");
                   System.out.println("-----------------------------------------------------------------");
           while (currentGeneral.availableMoney > 0)
           {
                   System.out.println("Current Funds: " + currentGeneral.availableMoney);
                   System.out.println("Type 'k' to purchase knight unit");
                   System.out.println("Type 'a' for archer unit");
                   System.out.println("Type 'i' for infrantryman");
                   System.out.println("Type 'x' to finsh");

                   String choice = console.next();

                   if (choice.equals("k"))
                           recruitKnight(currentGeneral);
                   else if (choice.equals("a"))
                           recruitArcher(currentGeneral);
                   else if (choice.equals("i"))
                           recruitInfantryman(currentGeneral);
                   else if (choice.equals("x"))
                           currentGeneral.availableMoney = 0;
                   else
                   {
                           System.out.print("wrong choice selected.");
                   }


                           System.out.println(" New Funds: " + currentGeneral.availableMoney);
                           System.out.println("Army Size:" + currentGeneral.army.size());
                           System.out.println();
                           System.out.println();
                           System.out.println();
           }


           }//end method

           public void recruitKnight(General currentGeneral)
           {
                   fundsCheck = currentGeneral.availableMoney - 500;

                   if (fundsCheck >= 0)
                   {

                           Soldier recruitedSoldier = new Soldier("Knight", 150,80,500);
                           currentGeneral.availableMoney = currentGeneral.availableMoney - recruitedSoldier.unitCost;


                           for (int i = 0; i < 100; i++)
                           {
                                   currentGeneral.army.add(recruitedSoldier);
                           }
                   }
                   else
                           System.out.println("Insufficient funds.");

           }

           public void recruitArcher(General currentGeneral)
           {
                   fundsCheck = currentGeneral.availableMoney - 200;
                   if (fundsCheck >= 0)
                   {
                           Soldier recruitedSoldier = new Soldier("Archer",60,110,200);
                           currentGeneral.availableMoney = currentGeneral.availableMoney - recruitedSoldier.unitCost;


                           for (int i = 0; i < 50; i++)
                           {
                           currentGeneral.army.add(recruitedSoldier);
                           }
                   }
                   else
                           System.out.println("Insufficient Funds.");


           }

           public void recruitInfantryman(General currentGeneral)
           {
                   fundsCheck = currentGeneral.availableMoney - 250;
                   if (fundsCheck >= 0)
                   {
                           Soldier recruitedSoldier = new Soldier("Infantryman",100,60,250);
                           currentGeneral.availableMoney = currentGeneral.availableMoney - recruitedSoldier.unitCost;


                           for (int i = 0; i < 100; i++)
                           {
                           currentGeneral.army.add(recruitedSoldier);
                           }	
                   }
                   else
                           System.out.println("Insufficient Funds.");


           }

  
}
