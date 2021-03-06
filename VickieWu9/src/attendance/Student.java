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
		this.present = present;
	}


	public String getFirstName() 
	{
		//returns the firstName
		return firstName;
	}


	public String getLastName()
	{
		//returns the lastNameName
		return lastName;
	}

	public boolean mathces(String first, String last)
	{
		//returns true if 'first' and 'last' match this Attendee's firstName and lastName. 
		//This should NOT be case sensitive.
		//.toLowerCase makes it not case sensitive
		if (first.toLowerCase().equals(firstName.toLowerCase()) && last.toLowerCase().equals(lastName.toLowerCase()))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

	public boolean matches(String last)
	{
		//returns true if 'last' matches this Attendee's lastName. 
		//This should NOT be case sensitive.
		if (last.toLowerCase().equals(lastName.toLowerCase()))
		{
			return true;
		}
		else
		{
			return false;
		}
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
		
		String record = lastName;
		record = addSpaces(record, 20); //add spaces after last name but stop when it reaches 20
		
		record += firstName; // add the first name at index 20 after spaces
		
		record = addSpaces(record, 40); // add spaces after first name until it reaches index 40
		
		if ( present == true)
		{
			record += "PRESENT";// if the student is marked present, add present after spaces at index 40
		}
		else
		{
			record += "ABSENT";// if the student is marked absent, add present after spaces at index 40
		}
		
		return record;
	}
	
	public String addSpaces(String z , int length)
	{
		//spaces after the last name before length.
		
		
		while (z.length() < length)
		{
			z += " ";
		}
		return z;
		
	}
}
