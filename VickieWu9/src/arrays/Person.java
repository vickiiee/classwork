package arrays;

public class Person {
	
	public static final String []FIRST_MIDDLE = {"is", "ebos", "anna"};
	public static final String []FIRST_START = {"Chr", "Ar", "Vick", "Jack"};
	public static final String []FIRST_END = {"na", "" };
	
	
	public static final String[] LAST_START = {""};
	public static final String[] LAST_MIDDLE = {""};
	public static final String[] LAST_END = {""};
	
	private String firstName;
	private String lastName;
	private Borough home;
	private Hobby hobby;
	private Person[] friends;

	public Person(String first, String last, Borough home)
	{
		this.firstName = first;
		this.lastName = last;
		this.home = home;
		friends = new Person[3];
		hobby = Hobby.randomHobby();
	}
	
	public void setInFirstPlace(Person f) {
		//go backward through an array
		for (int i = friends.length - 1; i > 0; i--)
		{
			friends[i] = friends[i-1]; //CHECK
		}
		friends[0]= f;
	}
	public void mingle(Person[] peers) {
			for(Person p : peers) {
				//you cannot friend yourself
				if(p!=this) {
					setInFirstPlace(p);
				}
			}
	}
	public void statYourFriends() {
			String statement = "My friends are ";
			/*
			 * When called, states "My friends are..."
			 * and lists all Persons in friends, separated by
			 */
					
			for (int i = 0; i < friends.length; i++)
			{
				statement += friends[i].firstName + " " + friends[i].lastName + ","; 
			}
			statement += "and"
	}
	public String toString()
	{
		return "My name is " + firstName + " " + lastName + "and i am from " + home + ".";
	}
	
}
