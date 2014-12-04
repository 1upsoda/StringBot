package stringbot.model;

import java.util.ArrayList;

import java.util.Iterator;

/**
 * Model for the bot
 * @author tyler Parsons
 * v1.2.7
 */
public class ChatBot

{
/**
 * the name of the user
 */
	private String name;
/**
 * the amount of times the user has entered a message
 */
	private int numberOfChats;
/**
 * a list holding memes that can be called if the user enters one from the list	
 */
	
	private ArrayList<String> userInputList;
	
	private ArrayList<String> memeList;
/**
 * a list holding the names of MLP characters that the program can recognize from user input
 */
	private ArrayList<String> ponyList;
	private User myUser;
	/**
	 * sets up the name, the lists, so they can be used later
	 * @param name
	 */
	public ChatBot(String name)

	{

		this.name = name;

		numberOfChats = 0;

		myUser = new User();
		memeList = new ArrayList<String>();

		fillTheMemeList();

		ponyList = new ArrayList<String>();

		fillThePonyList();
		
		userInputList = new ArrayList<String>();

	}
/**
 * a method to call the name if needed
 * @return
 */
	public String getName()

	{

		return name;

	}
/**
 * a method to call the number of times the user has entered a chat if needed, (example: to see if they have entered >100 chats
 * @return
 */
	public int getNumberOfChats()

	{

		return numberOfChats;

	}
/**
 * sets up the name string so it can be used later
 * @param name
 */
	public void setName(String name)

	{

		this.name = name;

	}
/**
 * adds 1 to the amount of times the user entered a chat when called (is called always after a chat is entered in the latter code)
 */
	public void incrementChats()

	{

		numberOfChats++;

	}
/**
 * fills the meme list with the following memes
 */
	private void fillTheMemeList()

	{

		memeList.add("u mad bro?");

		memeList.add("Ganondorf");

		memeList.add("I sell propane and propane accessories");

		memeList.add("Jawn Trawn");

		memeList.add("Falcon Punch");

		memeList.add("How do I shot web?");

	}
/**
 * fills the pony list with the following names
 */
	private void fillThePonyList()

	{

		ponyList.add("Rainbow Dash");

		ponyList.add("Pinkie Pie");

		ponyList.add("Fluttershy");

		ponyList.add("Twilight Sparkle");

		ponyList.add("Applejack");

		ponyList.add("Rarity");

	}
/**
 * after the info from the user is gathered from the first 10 chats, it offers up random topics to converse about.
 * @param userText
 * @return
 */
	public String processText(String userText)

	{

		String processedText = "";

		

		int randomChoice = (int) (Math.random() * 7);

		if (userText != null && userText.length() > 0)
		{
			if(numberOfChats < 4)
			{
				if(numberOfChats == 0)
				{
			
					myUser.setUserName(userText);
					processedText = "Hello " +myUser.getUserName() + ". How old are you?";
					
				}
				else if(numberOfChats == 1)
				{
					int age = Integer.parseInt(userText);
					myUser.setAgeNumber(age);
					processedText = "Man, you are " +myUser.getAgeNumber() + " years old? That is really old for someone named " +myUser.getUserName()+ ".";
					processedText += "\nWhat is your favorite Animal?";
				}
				else if(numberOfChats == 2)
				{
					myUser.setFavoriteAnimal(userText);
					processedText = "A " +myUser.getFavoriteAnimal()+ " is a pretty cool animal. By the way do you like ponies?";
				}
				else if(numberOfChats == 3)
				{
					if(userText.equalsIgnoreCase("sure") || userText.equalsIgnoreCase("yeah") || userText.equalsIgnoreCase("yes"))
					{
						myUser.setLikesPonies(true);
						processedText = "Oh, nice";
					}
					else
					{
						myUser.setLikesPonies(false);
						processedText = "Oh, okay";
					}
				}
			}
			else
				
		

				
			if (randomChoice == 0)

			{

				if (stringChecker(userText))

					processedText = "Too long. Didn't read...";

				else

				if (bestPonyChecker(userText))

				{

					int randomPony = (int) (Math.random() * 6D);

					processedText = (String) ponyList.get(randomPony);

				}
				else

				{

					processedText = "That is a pretty short text";

				}

			}
			else

			if (randomChoice == 1)

			{

				if (contentChecker(userText))

					processedText = "I like ponies";

				else

					processedText = "I know one thing about your text: It didn't contain ''pony''";

			}
			else

			if (randomChoice == 2)
			{

				if (memeChecker(userText))

				{

					processedText = (new StringBuilder("hey, you found a meme: ")).append(userText).toString();

					processedText = (new StringBuilder(String.valueOf(processedText))).append(" isn't that cool.").toString();

				}
				else

				if (ponyChecker(userText))

				{

					processedText = (new StringBuilder("The Pony: ")).append(userText).toString();

					processedText = (new StringBuilder(String.valueOf(processedText))).append(" is pretty cool...").toString();

				}
				else

				{

					int randomMeme = (int) (Math.random() * 6);

					processedText = (String) memeList.get(randomMeme);

				}
			}
			else
			if(randomChoice == 3)
			{
				processedText = "" +myUser.getUserName()+ ", you are " +myUser.getAgeNumber()+ ", your favorite animal is " +myUser.getFavoriteAnimal()+ ". Acording to you...";
			}

			else
			if(randomChoice == 4)
			{
				//userinput list add
				userInputList.add(0, userText);
				processedText = "I will remember this, " +myUser.getUserName()+ ".";
			}
			else
			if(randomChoice == 5)
			{
				if(userInputChecker(userText))
				{
					processedText = "Stop repeating yourself";
				}
				else
				{
					processedText = "That is something I don't remember you saying!";
				}
			}
			else
			if(randomChoice == 6)
			{
				if(chatbotNameChecker(userText))
				{
					processedText = chatbotNameConversation(userText);
				}
				else
				{
					processedText = noNameConversation(userText);
				}
			}
		}
		else
		{
			numberOfChats--;
			processedText = "hello?";
		}
		incrementChats();
		return processedText;

	}
	
	private boolean chatbotNameChecker(String currentInput)
	{
		boolean hasName = false;
		
		if(currentInput.indexOf(this.getName()) > -1)
		{
			hasName = true;
		}
		
		return hasName;
	}
	private boolean userInputChecker(String input)
	{
		boolean matchesInput = false;
		
		if(userInputList.size() > 0)
		{
			for(int loopCount = 0; loopCount < userInputList.size(); loopCount++)
			{
				if(input.equalsIgnoreCase(userInputList.get(loopCount)))
				{
					matchesInput = true;
					userInputList.remove(loopCount);
					loopCount--;
				}
			}
		}
		return matchesInput;
	}
/**
 * checks to see if the message is >20 characters long
 * @param input
 * @return
 */
	private boolean stringChecker(String input)

	{

		boolean lengthText = false;

		if (input.length() >= 20)

			lengthText = true;

		return lengthText;

	}
/**
 * checks to see if the content has anything to do with ponies
 * @param input
 * @return
 */
	private boolean contentChecker(String input)

	{

		boolean hasPony = false;

		if (input.contains("pony") || input.contains("rainbow dash") || input.contains("fluttershy") || input.contains("pwn13z") || input.contains("PWN13Z") || input.contains("rarity") || input.contains("twilight sparkle"))

			hasPony = true;

		return hasPony;

	}
/**
 * checks to see if the user has asked who the best pony is
 * @param input
 * @return
 */
	private boolean bestPonyChecker(String input)

	{

		boolean hasBestPony = false;

		if (input.contains("who is best pony?") || input.contains("who is the best pony?") || input.contains("best pony?"))

			hasBestPony = true;

		return hasBestPony;

	}
/**
 * checks to see if they have mentioned a meme from the meme list
 * @param currentText
 * @return
 */
	private boolean memeChecker(String currentText)

	{

		boolean isAMeme = false;

		for (Iterator iterator = memeList.iterator(); iterator.hasNext();)

		{

			String currentMeme = (String) iterator.next();

			if (currentMeme.equalsIgnoreCase(currentText))

				isAMeme = true;

		}

		return isAMeme;

	}
/**
 * checks to see if they have mentioned a pony from the pony list
 * @param currentText
 * @return
 */
	private boolean ponyChecker(String currentText)

	{

		boolean isAPony = false;

		for (Iterator iterator = ponyList.iterator(); iterator.hasNext();)

		{

			String currentPony = (String) iterator.next();

			if (currentPony.equalsIgnoreCase(currentText))

				isAPony = true;

		}

		return isAPony;

	}
/**
 * checks to see if they have entered something that would make the program close ("dont continue")
 * @param input
 * @return
 */
	public boolean quitChecker(String input)

	{

		boolean okToQuit = false;

		if (input != null && (input.equalsIgnoreCase("Don't Continue") || input.equalsIgnoreCase("dont continue")))

			okToQuit = true;

		return okToQuit;

	}
	private String chatbotNameConversation(String currentInput)
	{
		String nameConversation = "This is what you typed after my name: ";
		
		nameConversation += currentInput.substring(currentInput.indexOf(this.getName()) + this.getName().length() - 1);
		// .concat() is the same as +=
		return nameConversation;
	}
	
	private String noNameConversation(String currentInput)
	{
		String notNamed ="";
		
		int smallRandom = (int) (Math.random() * currentInput.length() / 2);
		int largerRandom = (int) (smallRandom + (Math.random() * (currentInput.length() / 2)) + 1 );
		
		notNamed = "You didn't say my name so here is a special phrase: " + currentInput.substring(smallRandom, largerRandom);
		
		return notNamed;
	}
	
}
