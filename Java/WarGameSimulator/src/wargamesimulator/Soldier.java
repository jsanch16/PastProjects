package wargamesimulator;

public class Soldier
{
	String unitType;
	int unitHealth;
	int unitDamage;
	int unitCost;
	
	Soldier()
	{
		unitType = "";
		unitHealth = 0;
		unitDamage = 0;
		unitCost = 0;
		
	}
	
	Soldier(String type, int health,int damage, int cost)
	{
		unitType = type;
		unitHealth = health;
		unitDamage = damage;
		unitCost = cost;
		
	}
}
