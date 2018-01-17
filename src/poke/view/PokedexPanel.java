package poke.view;

import poke.model.Pokemon;
import poke.controller.PokemonController;
import javax.swing.*;
import java.awt.Color;
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
	private JLabel evolvableLabel;
	private JLabel modifierLabel;
	private JLabel iconLabel;
	
	private JCheckBox evolvableBox;
	private JTextField nameField;
	private JTextField numberField;
	private JTextField attackField;
	private JTextField healthField;
	private JTextField modifierField;
	
	private JTextArea descriptionArea;
	private JTextArea typeArea;
	
	private JButton saveButton;
	private JButton clearButton;
	private JComboBox pokedexDropdown;
	
	private JPanel firstType;
	private JPanel secondType;
	private JPanel thirdType;
	private JPanel fourthType;
	
	public PokedexPanel(PokemonController appController)
	{
		super();
		this.appController = appController;
		
		appLayout = new SpringLayout();
		
		evolvableBox = new JCheckBox();
		nameField = new JTextField("name");
		numberField = new JTextField("##");
		attackField = new JTextField("ap");
		healthField = new JTextField("hp");
		modifierField = new JTextField("mod");
		
		iconLabel = new JLabel("", new ImageIcon(getClass().getResource("/pokemon/view/images/Pokeball noice.png")), JLabel.CENTER);

		nameLabel = new JLabel("new");
		evolvableLabel = new JLabel("evolvable");
		numberLabel = new JLabel("number");
		attackLabel = new JLabel("attack");
		modifierLabel = new JLabel("modifier");

		pokedexDropdown = new JComboBox();
		clearButton = new JButton("clear");
		saveButton = new JButton("save");

		descriptionArea = new JTextArea(5,10);
		typeArea = new JTextArea(4,15);

		firstType = new JPanel();
		secondType = new JPanel();
		thirdType = new JPanel();
		fourthType = new JPanel();

		setupComboBox();
		setupTypePanels();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	public String[] getPokemonTypes()
	{
		String [] types = null;
		ArrayList<String> parentType = new ArrayList<String>();
		Class<?> currentClass = this.getClass();
		
		while(currentClass.getSuperclass() != null)
		{
			Class<?> [] pokemonTypes = currentClass.getInterfaces();
			types = new String[pokemonTypes.length];
			
			for(int index = 0; index < types.length; index++)
			{
				String currentInterface = pokemonTypes[index].getCanonicalName();
				currentInterface = currentInterface.replace(this.getClass().getPackage().getName() + ".", "");
				if(!parentType.contains(currentInterface))
				{
					parentType.add(currentInterface);
				}
			}
			currentClass = currentClass.getSuperclass();
		}
		
		types = new String [parentType.size()];
		
		for(int index = 0; index < parentType.size(); index++)
		{
			types[index] = parentType.get(index);
		}
		
		return types;
	}
	
	private void updatePokedexInfo(int index)
	{
		nameField.setText(appController.getPokedex().get(index).getName());
		evolvableBox.setSelected(appController.getPokedex().get(index).isCanEvolve());
		numberField.setText(appController.getPokedex().get(index).getNumber() + "");
		attackField.setText(appController.getPokedex().get(index).getAttackPoints() + "");
		attackField.setText(appController.getPokedex().get(index).getHealthPoints() + "");
		modifierField.setText(appController.getPokedex().get(index).getEnhancementModifier() + "");
		
		descriptionArea.setText(appController.getPokedex().get(index).toString());
		typeArea.setText("");
		
		for(String current : appController.getPokedex().get(index).getPokemonTypes())
		{
			typeArea.append(current + "\n");
		}
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
	
	private void setupPanel()
	{
		
	}
	
	private void updateImage()
	{
		String path = "/pokemon/view/images/";
		String defaultName = "logo";
		String name = pokedexDropdown.getSelectedItem().toString();
		String extension = ".png";
		ImageIcon pokemonIcon;
		
		try
		{
			pokemonIcon = new ImageIcon(getClass().getResource(path + name + extension));
		}
		catch(NullPointerException missingImageFile)
		{
			pokemonIcon = new ImageIcon(getClass().getResource(path + defaultName + extension));
		}
		
		iconLabel.setIcon(pokemonIcon);
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
	
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{
		pokedexDropdown.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent selection)
			{
				int selectedPokemonIndex = pokedexDropdown.getSelectedIndex();
				updatePokedexInfo(selectedPokemonIndex);
				updateImage();
				updateTypePanels();
				repaint();
			}
		});	
	
		saveButton.addActionListener(new ActionListener()
		{
				public void actionPerformed(ActionEvent click)
				{
					if(appController.isValidInteger(attackField.getText()) 
							&& appController.isValidInteger(healthField.getText()) 
							&& appController.isValidDouble(modifierField.getText()))
					{
						int selected = pokedexDropdown.getSelectedIndex();
						int health = Integer.parseInt(healthField.getText());
						int attack = Integer.parseInt(attackField.getText());
						double modifier = Double.parseDouble(modifierField.getText());
						String name = nameField.getText();
						boolean evolvable = evolvableBox.isSelected();
						
						appController.updateSelected(selected, health, attack, evolvable, modifier, name);
					}
				}
		});
	}
}
