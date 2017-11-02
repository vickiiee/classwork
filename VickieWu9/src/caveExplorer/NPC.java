package caveExplorer;

public class NPC {
	
	//fields needed to program navigation
	private CaveRoom[][] floor;//area where NPC roams
	private int currentRow;
	private int currentCol;
	private NPCRoom currentRoom;
	
	//these fields are about interaction with NPC
	private boolean active;
	private String activeDescription;
	private String inactiveDescription;
	//You might later add fields to make your NPC behave like a chatbot
	
	//default
	public NPC() {
		this.floor = caveExplorer.caves;
		this.activeDescription = "There is a person standing in the room," + "waiting to talk to you. Press 'e' to talk.";
		this.inactiveDescription = "The person you spoke to earlier is " + "standing here.";
		//by default, NPC does not have a position,
		//to indicate this, use coordinates -1,-1
		this.currentCol = -1;
		this.currentRow = -1;
		currentRoom = null;
		active = true;
	}

	public boolean isActive() {
		return active;
	}

	public void interact() {
		caveExplorer.print("Lets's interact! Type 'bye' to stop.");
		String s = caveExplorer.in.nextLine();
		while(!s.equalsIgnoreCase("bye")) {
			caveExplorer.print("Yeah.... I don't do that a whole lot.");
			s = caveExplorer.in.nextLine();
		}
		caveExplorer.print("Later, friend!");
		active = false;
		
	}

	public String getDescription() {
		return activeDescription;
	}

	public String getInactiveDescription() {
		return inactiveDescription;
	}
	
	public String getSymbol() {
		return "P";
	}

	public void setPosition(int row, int col) {
		//check to avoid ArrayOutOfBoundsException
		if(row >= 0 && row<floor.length && col>=0 && col<floor[row].length && floor[row][col] instanceof NPCRoom)
		{
			if(currentRoom != null)
			{
				currentRoom.leaveNPC();
			}
			
			currentRow = row;
			currentCol = col;
			currentRoom = (NPCRoom)floor[row][col]; //cast (NPCRoom) surrentRoom to NPCRoom
			currentRoom.enterNPC(this);
		}
			
	}

	public void autoMove() {
		if(active)
		{
			int[] move = calculateMove();
			int newRow = move[0];
			int newCol = move[1];
			setPosition(newRow, newCol);
		}
		
	}

	private int[] calculateMove() {
		int[][] possibleMoves = {{-1,0}, {0,1}, {1,0}, {0,-1}};
		int index = (int) (Math.random() * possibleMoves.length);
		int[] newPosition = new int[2];
		newPosition[0] = currentRow + possibleMoves[index][0];
		newPosition[1] = currentCol + possibleMoves[index][1];
		while(currentRoom.getDoor(index) == null || !(caveExplorer.caves[newPosition[0]][newPosition[1]] instanceof NPCRoom)) // instanceof:
		{
			index = (int) (Math.random() * possibleMoves.length);
			newPosition[0] = currentRow + possibleMoves[index][0];
			newPosition[1] = currentCol + possibleMoves[index][1];
		}
		return newPosition;
	}

}
