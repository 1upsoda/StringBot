package stringbot.view;

import javax.swing.JOptionPane;

import string.controller.StringAppController;

import stringbot.model.ChatBot;

public class ChatView

{

	private StringAppController baseController;

	public ChatView(StringAppController baseController)

	{

		this.baseController = baseController;

	}

	public String displayChatbotConversations(String input)

	{

		String output = "";

		output = JOptionPane.showInputDialog(null, (new StringBuilder(String.valueOf(baseController.getNotSoCleverBot().getName()))).append(" ").append(input).toString());

		return output;

	}

	public void displayInformation(String input)

	{

		JOptionPane.showMessageDialog(null, input);

	}

}
