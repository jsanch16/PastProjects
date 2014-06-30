package wargamesimulator;

import java.util.*;

public class General
{

	String name = "";
	int availableMoney = 0;
	Queue<Soldier> army;

	General()
	{
		availableMoney = 100000;
		name = "";
		army = new LinkedList<Soldier>();
	
		
	}
	
	General(String playername, int money)
	{
		name = playername;
		availableMoney = money;
		army = new LinkedList<Soldier>();
		
	}
	
	
	
}
