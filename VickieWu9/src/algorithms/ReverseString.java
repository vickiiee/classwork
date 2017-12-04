package algorithms;

public class ReverseString {
	 static String nums = "";
	
	 public static void main(String[] args) {
		reverseString("apple");
		System.out.println(nums);
	}

	public static String reverseString(String string) {
		if(string.length() ==1) {
			nums+= string; //if the string only has one letter, add it to nums.
			System.out.println(nums);
		}else {
			nums += string.substring(string.length()-1, string.length()) + reverseString(string.substring(0,string.length()-1));
			//^ add the last letter of string and call method again but this time, the parameter is the string without the last letter
			System.out.println(nums);
		}
		return nums;
		
	}
}