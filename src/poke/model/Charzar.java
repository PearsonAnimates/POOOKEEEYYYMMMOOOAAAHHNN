package poke.model;

public class Charzar extends Pokemon implements Fire
{
	public Charzar()
	{
		super(387, "Not so OP pokemon");
		setup();
	}

	public Charzar(String name)
	{
		super(387, name);
		setup();
	}
	
	public Charzar(int number, String name)
	{
		super(number, name);
		setup();
	}
	
	protected void setup()
	{
		this.setEnhancementModifier(.89);
		this.setAttackPoints(10);
		this.setHealthPoints(60);
	}
	
	public int burnStrength(int BUS)
	{
		BUS = 20;
		return BUS;
	}

	public int biteStrength(int BIS)
	{
		BIS = 42;
		return BIS;
	}

	public boolean canDodge(boolean CD)
	{
		CD = true;
		return CD;
	}
}
