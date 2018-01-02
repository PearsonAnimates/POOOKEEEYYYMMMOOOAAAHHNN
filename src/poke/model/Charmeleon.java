package poke.model;

public class Charmeleon extends Pokemon implements Fire, FireStormDefense
{

	public Charmeleon(int number, String name)
	{
		super(0, "Not so OP pokemon");
	}

	public int burnStrength(int BUS)
	{
		BUS = 40;
		return BUS;
	}

	public int biteStrength(int BIS)
	{
		BIS = 95;
		return BIS;
	}

	public boolean canDodge(boolean CD)
	{
		CD = true;
		return CD;
	}

	public boolean canMakeFireStorm(boolean FS)
	{
		FS = true;
		return FS;
	}

	public int FireStormStrength(int FTS)
	{
		FTS = 10;
		return FTS;
	}
}
