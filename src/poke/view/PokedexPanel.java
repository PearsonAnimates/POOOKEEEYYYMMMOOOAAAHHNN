package poke.view;

import java.awt.Color;
import javax.swing.*;
import poke.model.Pokemon;
import poke.controller.PokemonController;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PokedexPanel
{
	private PokemonController appController;
	private SpringLayout appLayout;
	
	private JLabel healthLabel;
	private JLabel attackLabel;
	private JLabel nameLabel;
	private JLabel numberLabel;
	private JLabel evolveLabel;
	private JLabel modifierLabel;
	private JLabel iconLabel;
	
	private JCheckBox evolveableBox;
	private JTextField nameField;
	private JTextField attackField;
	private JTextField healthFielld;
	private JTextField modifierField;
	
	private JTextArea descriptionArea;
	private JTextArea typeArea;
	
	private JButton saveButton;
	private JButton clearButton;
	private JComboBox pokedexDropDown;
	
	private JPanel firstType;
	private JPanel secondType;
	private JPanel thirdType;
	private JPanel fourthType;
	
	private void updatePokedexInfo(int index)
	{
		nameField.setText(appController.getPokedex().get(index).getName());
		evolveableBox.setSelected(appController.getPokedex().get(index).isCanEvolve());
		numberField.setText(appController.getPokedex().get(index).getNumber() + "");
		attackField.setText(appController.getPokedex().get(index).getAttackPoints() + "");
		attackField.setText(appController.getPokedex().get(index).getHealthPoints() + "");
		modifierField.setText(appController.getPokedex().get(index).getEnchancementModifier() + "");
		
//		descriptionArea.setText(appController.getPokedex().get(index).toString());
//		typeArea.setText("");
//		for(String current : )
//		{
//			typeArea.append(current + "\n");
//		}
	}
	
	private void setupComboBox()
	{
		DefaultComboBoxModel pokemonModel = new DefaultComboBoxModel(appController.convertPokedex());
		pokedexDropdown.setModel(pokemonModel);
	}
	
	private void setupTypePanels()
	{
		firstType.setSize(50, 50);
		secondType.setSize(50, 50);
		thirdType.setSize(50, 50);
		fourthType.setSize(50, 50);
	}
	
	private void updateTypePanels()
	{
		String[] types = appController.getPokedex().get(pokedexDropdown.getSelectedIndex()).getPokemonTypes();
		
		if(types[0].equals("Electric"))
		{
			firstType.setBackground(Color.YELLOW);
		}
		else if(types[0].equals("Fire"))
		{
			firstType.setBackground(Color.ORANGE);
		}
		else if(types[0].equals("Flying"))
		{
			firstType.setBackground(Color.CYAN);
		}
		else
		{
			firstType.setBackground(Color.WHITE);
		}
		if (types.length > 1)
		{
			if(types[1].equals("Electric"))
			{
				secondType.setBackground(Color.YELLOW);
			}
			
			if (types.length == 3)
			{
				if (types[2].equals("Electric"))
				{
					thirdType.setBackground(Color.GRAY);
				}
			}
		}
	}
	
	public PokedexPanel(PokemonController appController)
	{
		iconLabel = new JLabel("", new ImageIcon(getClass().getResource("/pokemon/view/images/Pokeball noice.png")), JLabel.CENTER);
		
	}
	
	private void setupListeners()
	{
		pokedexDropdown.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent selection)
			{
				int selectedPokemonIndex = pokedexDropDown.getSelectedIndex();
				updatePokedexInfor(selectedPokemonIndex);
				updateImage();
				updateTypePanels();
				repaint();
			}
		});
		
	}
}
