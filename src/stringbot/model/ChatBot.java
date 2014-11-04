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

	private String name;

	private int numberOfChats;

	private ArrayList<String> memeList;

	private ArrayList<String> ponyList;

	private User myUser;
	
	public ChatBot(String name)

	{

		this.name = name;

		numberOfChats = 0;

		myUser = new User();
		memeList = new ArrayList<String>();

		fillTheMemeList();

		ponyList = new ArrayList<String>();

		fillThePonyList();

	}

	public String getName()

	{

		return name;

	}

	public int getNumberOfChats()

	{

		return numberOfChats;

	}

	public void setName(String name)

	{

		this.name = name;

	}

	public void incrementChats()

	{

		numberOfChats++;

	}

	private void fillTheMemeList()

	{

		memeList.add("u mad bro?");

		memeList.add("Ganondorf");

		memeList.add("I sell propane and propane accessories");

		memeList.add("Jawn Trawn");

		memeList.add("Falcon Punch");

		memeList.add("How do I shot web?");

	}

	private void fillThePonyList()

	{

		ponyList.add("Rainbow Dash");

		ponyList.add("Pinkie Pie");

		ponyList.add("Fluttershy");

		ponyList.add("Twilight Sparkle");

		ponyList.add("Applejack");

		ponyList.add("Rarity");

	}

	public String processText(String userText)

	{

		String processedText = "";

		incrementChats();

		int randomChoice = (int) (Math.random() * 4);

		if (userText != null)
			if(numberOfChats < 10)
			{
				
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

					int randomMeme = (int) (Math.random() * 6D);

					processedText = (String) memeList.get(randomMeme);

				}
			}
			else
			{
				//user based talking
			}

		return processedText;

	}

	
	
	private boolean stringChecker(String input)

	{

		boolean lengthText = false;

		if (input.length() >= 20)

			lengthText = true;

		return lengthText;

	}

	private boolean contentChecker(String input)

	{

		boolean hasPony = false;

		if (input.contains("pony") || input.contains("rainbow dash") || input.contains("fluttershy") || input.contains("pwn13z") || input.contains("PWN13Z") || input.contains("rarity") || input.contains("twilight sparkle"))

			hasPony = true;

		return hasPony;

	}

	private boolean bestPonyChecker(String input)

	{

		boolean hasBestPony = false;

		if (input.contains("who is best pony?") || input.contains("who is the best pony?") || input.contains("best pony?"))

			hasBestPony = true;

		return hasBestPony;

	}

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

	public boolean quitChecker(String input)

	{

		boolean okToQuit = false;

		if (input != null && (input.equalsIgnoreCase("Don't Continue") || input.equalsIgnoreCase("dont continue")))

			okToQuit = true;

		return okToQuit;

	}

}
