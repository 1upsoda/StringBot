package string.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

import stringbot.model.ChatBot;
import stringbot.view.ChatView;
import stringbot.view.ChatbotFrame;
import stringbot.view.ChatbotPanel;

public class StringAppController

{
/**
 * starts up the frame and view for the chatbot.
 */
	private static ChatView appView;
	private ChatBot notSoCleverBot;
	private String startMessage;
	private ChatbotFrame baseFrame;

/**
 * method to call the base frame
* @return
*/
	public ChatbotFrame getBaseFrame() 
	{
		return baseFrame;
	}
/**
 * sets up the base frame
 * @param baseFrame
 */
	public void setBaseFrame(ChatbotFrame baseFrame) 
	{
		this.baseFrame = baseFrame;
	}
/**
 * creates the start message, the name for the bot, the view, and the frame
 */
	public StringAppController()

	{

		appView = new ChatView(this);

		baseFrame = new ChatbotFrame(this);

		notSoCleverBot = new ChatBot("Mr. Not at all Clever");

		startMessage = "Welcome to the " + notSoCleverBot.getName() + ": le chatbot, type in your name.";

	}
/**
 * method to call the chatbot
 * @return
 */
	public ChatBot getNotSoCleverBot()

	{

		return notSoCleverBot;

	}
/**
 * sets up the panel for the frame and displays the start message
 */
	public void start()

	{
		ChatbotPanel myAppPanel = (ChatbotPanel) baseFrame.getContentPane();
		myAppPanel.displayTextToUser(startMessage);
		
	}
	
	public String readTextFromFile()
	{
		String fileText = "";
		String filePath = "C:/Users/tpar4829/Documents/";
		String fileName = filePath + "saved text.txt";
		File inputFile = new File(fileName);
		
		try
		{
			Scanner fileScanner = new Scanner(inputFile);
			
			while(fileScanner.hasNext())
			{
				fileText += fileScanner.next() + "\n";
			}
			
			fileScanner.close();
		}
		catch(FileNotFoundException fileException)
		{
			JOptionPane.showMessageDialog(baseFrame, "The file is not here");
		}
		
		return fileText;
	}
	
	public void saveText(String conversation, boolean appendToEnd)
	{
		String fileName = "/Users/tpar4829/Documents/saved text.txt";
		
		PrintWriter outputWriter;
		
		if(appendToEnd)
		{
			try
			{
				outputWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName, appendToEnd)));
				outputWriter.append(conversation);
				outputWriter.close();
			}
			catch(FileNotFoundException noExistingFile)
			{
				JOptionPane.showMessageDialog(baseFrame, "There is no file there");
				JOptionPane.showMessageDialog(baseFrame, noExistingFile.getMessage());
			}
			catch(IOException inputOutputError)
			{
				JOptionPane.showMessageDialog(baseFrame, "There is no file there");
				JOptionPane.showMessageDialog(baseFrame, inputOutputError.getMessage());
			}
			
		}
		else
		{
			try
			{
				outputWriter = new PrintWriter(fileName);
				outputWriter.println(conversation);
				outputWriter.close();
			}
			catch(FileNotFoundException noFileIsThere)
			{
				JOptionPane.showMessageDialog(baseFrame, "Thereis no file there");
			}
		}
	}
	
	
	
	
/**	
 * sets up the text that the user inputs
 * @param userInput the actual text from an input zone
 * @return the text the bot can use from the user
 */
	public String sendTextToChatBot(String userInput)
	{
		String respondText = "";
		
		respondText = notSoCleverBot.processText(userInput);
		
		return respondText;
	}
/**
 * when called, will display 1 of 3 random messages and then will close the program (un-used)
 */
	public static void quit()

	{

		int randomBye = (int) (Math.random() * 3);

		if (randomBye == 0)

			appView.displayInformation("see ya");

		else

		if (randomBye == 1)

			appView.displayInformation("Laters");

		else

			appView.displayInformation("Gooooooood Byyyyyeyeeeeeee");

		System.exit(0);

	}

}
