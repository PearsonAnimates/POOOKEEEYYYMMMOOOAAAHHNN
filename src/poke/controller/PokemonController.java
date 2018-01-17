 package poke.controller;

import poke.model.*;
import poke.view.*;

import java.util.List;
import java.util.ArrayList;
 
public class PokemonController
{
	
	private List<Pokemon> pokedex;
	private PokemonFrame appFrame;
	
	public PokemonController()
	{
		pokedex = new ArrayList<Pokemon>();
		buildPokedex();
		
		appFrame = new PokemonFrame(this);
	}
	
	public List<Pokemon> getPokedex()
	{
		return pokedex;
	}
	
	public boolean isValidInteger(String input)
	{
		return false;
	}
	
	public boolean isValidDouble(String input)
	{
		return false;
	}
	
//	public String [] convertPokede()
//	{
//		String [] 
//	}
	
	private void buildPokedex()
	{
		
	}
	
	public void start()
	{
		
	}
	
	public void updateSelecte(int selection, int health, int attack, boolean evolve, double modify, String name)
	{
		Pokemon selected = pokedex.get(selection);
		
		selected.setAttackPoints(attack);
		selected.setCanEvolve(evolve);
		selected.setEnhancementModifier(modify);
		selected.setName(name);
		selected.setHealthPoints(health);
		
		FileController.savePokemonToFile((ArrayList<Pokemon>) pokedex);
	}
}
