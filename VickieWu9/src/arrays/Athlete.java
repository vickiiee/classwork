package arrays;

public class Athlete extends Person{

	private int money;
	
	public Athlete(String first, String last, Borough home, int money) {
		
		// the first line must call a superC constructor
		//Think: A person must exist before an athlete can exist
		super(first, last, home);
		this.money = money;
	}
	
	public String toString()
	{
		//to call superClass methods, use super.
		return super.toString() + "I also have $" + money + "!";
	}

}
