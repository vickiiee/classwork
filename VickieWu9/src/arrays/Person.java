package arrays;

public class Person {
	
	public static final String []FIRST_MIDDLE = {"is", "ebos", "anna"};
	public static final String []FIRST_START = {"Chr", "Ar", "Vick"};
	public static final String []FIRST_END = {"na", "" };
	
	
	public static final String[] LAST_START = null;
	public static final String[] LAST_MIDDLE = null;
	public static final String[] LAST_END = null;
	
	private String firstName;
	private String lastName;
	private Borough home;

	public Person(String first, String last, Borough home)
	{
		this.firstName = first;
		this.lastName = last;
		this.home = home;
	}
	
	public String toString()
	{
		return "My name is " + firstName + " " + lastName + "and i am from " + home + ".";
	}
}
