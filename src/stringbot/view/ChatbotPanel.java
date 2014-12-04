package stringbot.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import stringbot.model.ChatBot;
import string.controller.StringAppController;

import java.awt.Font;

public class ChatbotPanel extends JPanel

{
	private int numberOfEntered;
/**
 * implements the controller so it can run
 */
	private StringAppController baseController;
/**
 * creates the buttons that the program will use
 */
	private JButton sampleButton, randomButton, btnEnter;
/**
 * creates the text field the user can type in
 */
	private JTextField sampleField;
	private ArrayList<String> randomKnowledge;
/**
 * creates the area the user can chat in	
 */
	private JTextArea chatArea;
/**
 * creates a pane for the previous chats to inhabit
 */
	private JScrollPane chatPane;
/**
 * creates the way everything will behave in the frame
 */
	private SpringLayout baseLayout;
/**	 
 * creates the 3 labels on the layout
 */
	private JLabel lblCrapBot, lblBeta, lblNumberOfChats;
/**
 * creates the button, label, chat box objects
 * @param baseController
 */
	public ChatbotPanel(StringAppController baseController)

	{

		this.baseController = baseController;

		sampleButton = new JButton(":0 omg");

		randomButton = new JButton("Random");
		randomButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		randomButton.setForeground(Color.WHITE);
		randomButton.setBackground(Color.RED);
		sampleField = new JTextField(25);
		chatArea = new JTextArea(5, 25);
		chatPane = new JScrollPane(chatArea);

		randomKnowledge = new ArrayList<String>();
		baseLayout = new SpringLayout();
		lblBeta = new JLabel("beta 1.2.7");
		lblCrapBot = new JLabel("Crap Bot");
		lblNumberOfChats = new JLabel("Number Of Times Enter Was Pushed:");
		baseLayout.putConstraint(SpringLayout.NORTH, lblNumberOfChats, 0, SpringLayout.NORTH, lblBeta);
		baseLayout.putConstraint(SpringLayout.WEST, lblNumberOfChats, 10, SpringLayout.WEST, this);
		btnEnter = new JButton("Enter");
		baseLayout.putConstraint(SpringLayout.WEST, btnEnter, 150, SpringLayout.WEST, this);
		numberOfEntered = 0;

		setupPanel();

		setupLayout();

		setupListeners();
		setupScrollPane();
		fillTheKnowledgeList();

	}
	
	private void fillTheKnowledgeList()
	{
		randomKnowledge.add("Knowing ledges will keep you from falling");
		randomKnowledge.add("You can always eat sausage...");
		randomKnowledge.add("It is not illegal if the world no longer exists");
		randomKnowledge.add("Always bathe");
		randomKnowledge.add("1upsoda is delicious");
		randomKnowledge.add("All your thoughts are belong to quantum");
		randomKnowledge.add("You have taken 1 damage from this quote");
	}
/**
 * sets the parameters for how the chat pane will work
 */
	private void setupScrollPane()
	{
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		chatArea.setEditable(false);
	}
/**
 * adds all of the buttons, labels, chat boxes to the panel to be used
 */
	private void setupPanel()

	{

		setBackground(Color.YELLOW);

		setLayout(baseLayout);

		this.add(sampleButton);

		this.add(randomButton);
		this.add(chatPane);
		this.add(sampleField);
		this.add(lblBeta);
		this.add(btnEnter);
		this.add(lblNumberOfChats);
		this.add(lblCrapBot);
		

		
	}
/**
 * puts all of the buttons, chat boxes, labels, everything from the GUI in the right places
 */
	private void setupLayout()

	{
		baseLayout.putConstraint(SpringLayout.WEST, chatPane, 60, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, randomButton, 0, SpringLayout.NORTH, sampleButton);
		baseLayout.putConstraint(SpringLayout.EAST, randomButton, 0, SpringLayout.EAST, chatPane);
		baseLayout.putConstraint(SpringLayout.WEST, sampleButton, 0, SpringLayout.WEST, chatPane);

		baseLayout.putConstraint(SpringLayout.SOUTH, sampleButton, -59, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, sampleField, -11, SpringLayout.NORTH, sampleButton);
		baseLayout.putConstraint(SpringLayout.EAST, sampleField, 0, SpringLayout.EAST, randomButton);
		baseLayout.putConstraint(SpringLayout.NORTH, chatPane, 75, SpringLayout.NORTH, this);
		
		
		
		lblBeta.setForeground(Color.BLACK);
		baseLayout.putConstraint(SpringLayout.SOUTH, lblBeta, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, lblBeta, -10, SpringLayout.EAST, this);
		
		
		
		baseLayout.putConstraint(SpringLayout.NORTH, lblCrapBot, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, lblCrapBot, 107, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, lblCrapBot, -6, SpringLayout.NORTH, chatPane);
		baseLayout.putConstraint(SpringLayout.EAST, lblCrapBot, 30, SpringLayout.EAST, randomButton);
		lblCrapBot.setFont(new Font("Jing Jing", Font.BOLD, 34));
		
		
		
		baseLayout.putConstraint(SpringLayout.SOUTH, btnEnter, -6, SpringLayout.NORTH, sampleField);
		

	}
/**
 * sets up all of the buttons so that when they are pressed, they actually do stuff
 */
	private void setupListeners()

	{

		sampleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				sampleField.setText(sampleField.getText() + " :0 omg");
				
			}
		});

		btnEnter.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
				String userTypedText = sampleField.getText();
				String chatbotResponse = baseController.sendTextToChatBot(userTypedText);
				displayTextToUser(userTypedText);
				displayTextToUser(chatbotResponse);
				sampleField.setText("");
				numberOfEntered++;
				lblNumberOfChats.setText("Number Of Times Enter Was Pushed: " +numberOfEntered);
				
			}
		});
		
		randomButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{

				int randomKnow = (int) (Math.random() * 7);
				sampleField.setText(sampleField.getText() + randomKnowledge.get(randomKnow));
				
			}
		});
		
	}
	
	public void displayTextToUser(String input)
	{
		chatArea.append("\n" + input);
	}
}
