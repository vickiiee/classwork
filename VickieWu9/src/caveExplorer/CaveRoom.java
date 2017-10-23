package caveExplorer;

public class CaveRoom {
	
	private String description;
	private String direction; // tells you which door can be used
	private String contents; // a symbol showing you what is in the room... 'X' when you are in the room
	private String defaultcontents; //what is in the room when you aren't in the room

	private CaveRoom[] borderingRooms;
	private Door[] doors;
	
	//constants
	public static final int NORTH = 0; //final = can't be changed
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;
	
	
	public CaveRoom(String description){
		this.description = description;
		setDefaultcontents(" ");
		contents = defaultcontents;
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

	public void setDefaultcontents(String defaultcontents) {
		this.defaultcontents = defaultcontents;
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
}
