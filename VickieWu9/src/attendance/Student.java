package attendance;

public class Student implements Attendee
{

	/**In addition to the following methods, please create a class called 
	 * 'Student' that implements the Attendee interface and include a 
	 * constructor that takes two parameters: firstName and lastName.
	 * Use these values to instantiate corresponding fields.
	 * @return
	 */
	
	private String firstName;
	private String lastName;
	private boolean present;
	
	public Student( String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public boolean isPresent() 
	{
		//returns true if the student has been marked present, false otherwise
		return present;
	}

	public void setPresent(boolean present) 
	{
		//sets whether the student has been marked present
		
	}


	public String getFirstName() 
	{
		//returns the firstName
		return null;
	}


	public String getLastName()
	{
		//returns the lastNameName
		return null;
	}

	public boolean mathces(String first, String last)
	{
		//returns true if 'first' and 'last' match this Attendee's firstName and lastName. 
		//This should NOT be case sensitive. 
		return false;
	}

	public boolean matches(String last)
	{
		//returns true if 'first' matches this Attendee's firstName. 
		//This should NOT be case sensitive.
		return false;
	}

	
	public String getReportString() 
	{
		//returns three words separated by 20 spaces: 
		//at index 0, the last name
		//at index 20, the first name
		//at index 40, the word PRESENT or ABSENT
		//ADDED CHALLENGE:
		//if last name or first name is longer than 20 characters, 
		//cut off the last three letters and replace with "..."
		return null;
	}
}
