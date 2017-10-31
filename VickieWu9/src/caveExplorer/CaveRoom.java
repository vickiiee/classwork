package caveExplorer;

public class CaveRoom {
	
	private String description;
	private String direction; // tells you which door can be used
	private String contents; // a symbol showing you what is in the room... 'X' when you are in the room
	private String defaultContents; //what is in the room when you aren't in the room

	private CaveRoom[] borderingRooms;
	private Door[] doors;
	
	//constants
	public static final int NORTH = 0; //final = can't be changed
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;
	
	
	public CaveRoom(String description){
		this.description = description;
		setdefaultContents(" ");
		contents = defaultContents;
		//NOTE: Arrays are instantiated with ' null' values
		borderingRooms = new CaveRoom[4];
		doors = new Door[4];
		setDirections();
	}

	/***
	 * for every Door in doors [] that is not null,
	 * this method appends a String describing the door and where it is
	 * 	There is a (passage) to (the North)
	 * 	there is a (passage) to (the east)
	 * 
	 * If there are no doors that are not null, this sets directions to
	 * 	"There is no way out. You are trapped in this room"
	 */
	public void setDirections() {
		//hint: to check if a door is null, use:
		//doors[0] == null OR USE doors[0] != null
		
		direction = "";
		boolean doorFound = false;
		
		for(int i = 0; i < doors.length; i++) {
			if (doors[i] != null)
			{
				doorFound = true;
				direction += "There is a " + doors[i].getDescription() + " to the " + toDirection(i)+ ". " + doors[i].getDetails();
			}
		}
		if (!doorFound)
		{
			direction = "There is no way out. You are trapped in this room.";
			
		}
	}

	/**
	 * converts an int to a direction:
	 * 	0 -> "the North"
	 * 	1 -> "the East"
	 * hint: complete this method without using an if statement
	 * @param dir
	 * @return
	 */
	public static String toDirection(int dir)
	{
		String [] direction = {"the North", "the East", "the South", "the West"};
		//Note: when I say "no long if-else" statements,
		//this is how you should be thinking
		return direction[dir];
	}
	
	
	public void enter()
	{
		contents = "X";
	}
	
	public void leave()
	{
		contents = defaultContents;
	}
	
	
	/**
	 * This is how we join rooms together.
	 * It gives this room access to anotherRoom and vice-versa
	 * It also puts the door between both rooms
	 * @param direction
	 * @param anotherRoom
	 * @param door
	 */
	public void setConnection(int direction, CaveRoom anotherRoom, Door door)
	{
		addRoom(direction, anotherRoom, door);
		anotherRoom.addRoom(oppositeDirection(direction), this, door);
	}

	

	public void addRoom(int dir, CaveRoom caveRoom, Door door) {
		borderingRooms[dir] = caveRoom;
		doors[dir] = door;
		setDirections();//updates the directions
		
	}
	
	public void interpretInput(String input)
	{
		while (!isValid(input))
		{
			printValidMoves();
			input = caveExplorer.in.nextLine();
		}
		
		/*
		 * convert w,a,s,d to direction, 0,3,2,1,
		 */
		
		int direction = validMoves().indexOf(input);
		if (direction < 4) {
			goToRoom(direction);
			}
		else {
			performAction(direction);
		}
		
	}

	/**
	 * override to create response of keys other than wdsa
	 * @param direction
	 */
	public void performAction(int direction) {
		caveExplorer.print("That key does nothing.");	
	}

	/**
	 * overide to change description of possible moves
	 */
	public void printValidMoves() {
		System.out.println("You can only enter a 'w', 'a', 's', 'd'." );
	}

	/**
	 * override to add more moves
	 * @return
	 */
	public String validMoves()
	{
		return "wdsa";
	}
	/**
	 * returns true if w,a,s, or d is the input (NO IF STATEMENTS)
	 * @param input
	 * @return
	 */
	private boolean isValid(String input) {
		//String paths = "wdsa";
		return validMoves().indexOf(input) > -1 && input.length() == 1;  
	}

	/**
	 * THIS IS WHERE YOU EDIT YOUR CAVES
	 */
	public static void setUpCaves()
	{
		//1. Determine size of caves
		caveExplorer.caves = new CaveRoom[5][5];
		CaveRoom[][] c = caveExplorer.caves;//create a shortcut for accessing CaveExplorer.caves
		//2. populate with default caves
		for(int row = 0; row < c.length; row++)
		{
			for(int col = 0; col < c[row].length; col++)
			{
				c[row][col] = new CaveRoom("This cave has coordinates " + row+  ", "+col);
			}
		}
		//3. replace some default rooms with custom rooms(SAVE FOR LATER)
		
		//4. set Starting room
		caveExplorer.currentRoom = c[0][1];
		caveExplorer.currentRoom.enter();
		
		//5. Set up doors
		c[0][1].setConnection(SOUTH, c[1][1], new Door());
		c[1][1].setConnection(EAST, c[1][2], new Door());
	}
	
	public void goToRoom(int direction) {
		//make sure there is room to go to:
		if (borderingRooms[direction] != null && doors[direction] != null && doors[direction].isOpen())
		{
			caveExplorer.currentRoom.leave();
			caveExplorer.currentRoom = borderingRooms[direction];
			caveExplorer.currentRoom.enter();
			caveExplorer.inventory.updateMap();
		}else
		{
			//print red text:
			System.err.println("You can't do that!");
		}
	}

	/**
	 * returns the OPPOSITE direction
	 * oD(0) returns 2 
	 * oD(1) returns 3
	 * @param dir
	 * @return
	 */
	public static int oppositeDirection(int dir)
	{
		int [] opposite = {2, 3, 0, 1};
		return opposite[dir];
	}
	
	
	public void setdefaultContents(String defaultContents) {
		this.defaultContents = defaultContents;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getDirection() {
		return direction;
	}


	public void setDirection(String direction) {
		this.direction = direction;
	}


	public String getContents() {
		return contents;
	}


	public void setContents(String contents) {
		this.contents = contents;
	}

	public Door getDoor(int direction) {
		return doors[direction];
	}
}
