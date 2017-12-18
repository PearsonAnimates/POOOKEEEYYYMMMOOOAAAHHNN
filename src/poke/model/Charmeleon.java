package poke.model;

public class Charmeleon extends Pokemon implements Fire, FireStormDefense
{

	public Charmeleon(int number, String name)
	{
		super(0, "Not so OP pokemon");
	}

	public int burnStrength(int BUS)
	{
		
		return 0;
	}

	public int biteStrength(int BIS)
	{
		return 0;
	}

	public boolean canDodge(boolean CD)
	{
		return false;
	}

	public boolean canMakeFireStorm(boolean FS)
	{
		return false;
	}

	public int FireStormStrength(int FTS)
	{
		return 0;
	}

}
