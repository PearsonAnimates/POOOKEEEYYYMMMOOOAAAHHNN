package poke.model;

public class Charizard extends Charmeleon implements Flying
{

	public Charizard(int number, String name)
	{
		super(5, "DISTINGUISHED CHEATING HAXXOR FAGGOT!!!");
	}

	public boolean canFly(boolean canFly)
	{
		canFly = true;
		return canFly;
	}
	
	public int burnStrength(int BUS)
	{
		BUS = 0;
		return BUS;
	}
	
	public int biteStrength(int BIS)
	{
		BIS = 0;
		return BIS;
	}

	public boolean canDodge(boolean CD)
	{
		CD = false;
		return CD;
	}

	public boolean canMakeFireStorm(boolean FS)
	{
		FS = true;
		return FS;
	}

	public int FireStormStrength(int FTS)
	{
		FTS = 85;
		return FTS;
	}
}
