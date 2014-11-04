package stringbot.view;

import javax.swing.JFrame;

import string.controller.StringAppController;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

// Referenced classes of package string.view:

//            ChatbotPanel

public class ChatbotFrame extends JFrame

{

	private ChatbotPanel basePanel;

	public ChatbotFrame(StringAppController baseController)

	{

		basePanel = new ChatbotPanel(baseController);
		SpringLayout springLayout = (SpringLayout) basePanel.getLayout();

		setupFrame();

	}

	private void setupFrame()

	{

		setContentPane(basePanel);

		setLocation(5, 6);

		setSize(400, 400);

		setResizable(false);

		setVisible(true);

	}
}
