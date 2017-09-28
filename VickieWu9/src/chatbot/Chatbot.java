package chatbot;

public class Chatbot {

	private String username;
	private boolean chatting;
	private Topic vickie;
	
	public Chatbot() {
		vickie = new ChatbotVickie();
		username = "unkown user";
		chatting = true;
	}

	public void startChatting() 
	{
		//whenever you print or get method, use these methods
		ChatbotMain.print("Hi! I am an intelligent machine that can respond to your input. Tell me your name");
		username = ChatbotMain.getInput();
		
		while(chatting)
		{
			ChatbotMain.print("What would you like to talk about?");
			String response = ChatbotMain.getInput();
			
			if (vickie.isTriggered(response))
			{
				chatting = false; //exits the while loop. IMPORTANT bc you get graded for this!
				vickie.talk(response);
			}
				else
				{
					ChatbotMain.print("I'm sorry! I don't understand. I never said I was perfect.");
				}
		}
	}

}
