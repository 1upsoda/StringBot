package string.controller;

import stringbot.model.ChatBot;
import stringbot.view.ChatView;
import stringbot.view.ChatbotFrame;
import stringbot.view.ChatbotPanel;

public class StringAppController

{

	private ChatView appView;

	private ChatBot notSoCleverBot;

	private String startMessage;

	private ChatbotFrame baseFrame;

	public ChatbotFrame getBaseFrame() 
	{
		return baseFrame;
	}

	public void setBaseFrame(ChatbotFrame baseFrame) 
	{
		this.baseFrame = baseFrame;
	}

	public StringAppController()

	{

		appView = new ChatView(this);

		baseFrame = new ChatbotFrame(this);

		notSoCleverBot = new ChatBot("Mr. Not at all Clever:");

		startMessage = "Welcome to the " + notSoCleverBot.getName() + " chatbot, type in your name.";

	}

	public ChatBot getNotSoCleverBot()

	{

		return notSoCleverBot;

	}

	public void start()

	{

		

		ChatbotPanel myAppPanel = (ChatbotPanel) baseFrame.getContentPane();
		myAppPanel.displayTextToUser(startMessage);
		
	}
	
	public String sendTextToChatBot(String userInput)
	{
		String respondText = "";
		
		respondText = notSoCleverBot.processText(userInput);
		
		return respondText;
	}

	private void quit()

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
