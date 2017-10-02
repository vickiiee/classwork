package testingStrings;

public class Testing {
public testing{
		
		if( keywordIsIsolated(4,"good","i'm good") && keywordIsIsolated(0,"good","good. how are you?") 
				&& !keywordIsIsolated(4,"good","goodbye. i hope you feel good") && keywordIsIsolated(25,"good","goodbye. i hope you feel good")){
			print("You passed all the keywordIsIsolated tests.");
		}
		
		}

	

	public static boolean keywordIsIsolated(int position ,String keyword ,String s)//keywordIsIsolated(4,"good","i'm good")

	{
		//boolean keywordIso = false; 
		int numofS = s.indexOf(keyword); //4
		
		if (numofS == -1)
		{
			return false;
		}
		
		for (int i = 0; i < s.length() - 1; i++)
		{
			String letterOne = keyword.substring(0,1); //g
			String letterTwo = s.substring(i, i+1); //g if i = 4
			if(letterOne.equals(letterTwo) && numofS == 0) //if the first letter matches with any of the first 
				//letters of the word
			{
				int key = keyword.length();
				String restKeyword = keyword.substring(1,key);
				
				if (restKeyword.equals(s.substring(i+1, key)) && )
				{
					return true;
				}
				
				
			}
				else(s.substring(i-1, i).equals(" "))
				{
					//if there's a space before it 
					if(s.substring(s.length(),s.length() + 1 ).compareTo("a") < 0)
					{
						//any punctuation 
						return true; 
					}
					
					
				
				}
			}
			
		}
		return false; 
	}
	}

}
}
