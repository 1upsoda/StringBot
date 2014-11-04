package stringbot.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import string.controller.StringAppController;
import java.awt.Font;

public class ChatbotPanel extends JPanel

{

	private StringAppController baseController;

	private JButton sampleButton, randomButton, btnEnter, btnMeme;

	private JTextField sampleField;

	
	private JTextArea chatArea;
	private JScrollPane chatPane;
	private SpringLayout baseLayout;
	private JLabel lblCrapBot, lblBeta, lblNumberOfChats;

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

		baseLayout = new SpringLayout();
		btnMeme = new JButton("Meme");
		lblBeta = new JLabel("beta 1.2.7");
		lblCrapBot = new JLabel("Crap Bot");
		lblNumberOfChats = new JLabel("Number Of Chats: 0");
		btnEnter = new JButton("Enter");

		setupPanel();

		setupLayout();

		setupListeners();
		setupScrollPane();

	}

	private void setupScrollPane()
	{
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
	}

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
		this.add(btnMeme);
		this.add(lblNumberOfChats);
		this.add(lblCrapBot);
		

		
	}

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

		baseLayout.putConstraint(SpringLayout.NORTH, btnMeme, 0, SpringLayout.NORTH, sampleButton);
		baseLayout.putConstraint(SpringLayout.EAST, btnMeme, -29, SpringLayout.WEST, randomButton);
		
		
		
		lblBeta.setForeground(Color.BLACK);
		baseLayout.putConstraint(SpringLayout.SOUTH, lblBeta, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, lblBeta, -10, SpringLayout.EAST, this);
		
		
		
		baseLayout.putConstraint(SpringLayout.NORTH, lblCrapBot, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, lblCrapBot, 107, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, lblCrapBot, -6, SpringLayout.NORTH, chatPane);
		baseLayout.putConstraint(SpringLayout.EAST, lblCrapBot, 30, SpringLayout.EAST, randomButton);
		lblCrapBot.setFont(new Font("Jing Jing", Font.BOLD, 34));
		
		
		
		baseLayout.putConstraint(SpringLayout.WEST, lblNumberOfChats, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, lblNumberOfChats, 0, SpringLayout.SOUTH, lblBeta);
		
		
		
		baseLayout.putConstraint(SpringLayout.SOUTH, btnEnter, -6, SpringLayout.NORTH, sampleField);
		baseLayout.putConstraint(SpringLayout.EAST, btnEnter, -1, SpringLayout.EAST, btnMeme);
		

	}

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
			}
		});
		
		randomButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{

			}
		});

	}
	
	public void displayTextToUser(String input)
	{
		chatArea.append("\n" + input);
	}
}
