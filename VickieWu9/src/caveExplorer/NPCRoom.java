package caveExplorer;

public class NPCRoom extends CaveRoom {
	
	private NPC npc;

	public NPCRoom(String description) {
		super(description);
		
	}

	public boolean canEnter()
	{
		return npc == null;
	}
	
	public void enterNPC(NPC n)
	{
		this.npc = n;
	}
	
	public void leaveNPC() {
		this.npc = null;
	}
	
	public boolean containsNPC()
	{
		return npc != null;
	}
	
	/*
	 * Everything above is a NEW function of a CaveRoom, 
	 * the methods below REPLACE original CaveRoom methods
	 */
	
	public void printValidMoves() {
		System.out.println("You can only enter a 'w', 'a', 's', 'd' to move" + "or you can press 'e' to interact");
	}

	/**
	 * override to add more moves
	 * @return
	 */
	public String validMoves()
	{
		return "wdsae";
	}
	
	public void performAction(int direction) {
		if(direction == 4)
		{
			if(npc != null && npc.isActive())
			{
				npc.interact();
			}else
			{
				caveExplorer.print("There is nothing to interact with.");
			}
		}else
		{
			caveExplorer.print("That key does nothing");
		}
	}
	
	public String getContents() {
		if(containsNPC() && npc.isActive())
		{
			return npc.getSymbol();
		}else
		{
			return super.getContents();
		}
	}
	
	public String getDescription()
	{
		if(containsNPC() && npc.isActive())
		{
			return super.getDescription() + "\n" + npc.getDescription();
		}else if(containsNPC() && !npc.isActive())
		{
			return super.getDescription() + "\n" + npc.getInactiveDescription();
		}else {
			return super.getDescription();
		}
	}
}
