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
	
	private void buildPokedex()
	{
		
	}
	
	public void start()
	{
		
	}
}
