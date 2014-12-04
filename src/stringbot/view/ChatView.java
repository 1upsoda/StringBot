package stringbot.view;

import javax.swing.JOptionPane;

import string.controller.StringAppController;

import stringbot.model.ChatBot;

public class ChatView

{

	private StringAppController baseController;
/**
 * connects this page with all others
 * @param baseController
 */
	public ChatView(StringAppController baseController)

	{

		this.baseController = baseController;

	}
/**
 * allows the history of the chatbot to be seen
 * @param input
 * @return
 */
	public String displayChatbotConversations(String input)

	{

		String output = "";

		output = JOptionPane.showInputDialog(null, (new StringBuilder(String.valueOf(baseController.getNotSoCleverBot().getName()))).append(" ").append(input).toString());

		return output;

	}
/**
 * allows the user input to be seen
 * @param input
 */
	public void displayInformation(String input)

	{

		JOptionPane.showMessageDialog(null, input);

	}

}
