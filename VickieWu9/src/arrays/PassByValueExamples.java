package arrays;

import java.util.Arrays;

public class PassByValueExamples {

	public static void main(String[] args) {
		String s= "Hello";
		Person p = new Person("Random", "Dude", Borough.NY_BOROUGHS[0]);
		int x = 5;
		int [] arr = {1,2,3};
		//test1(p,x,arr);
		//test2(p);
		test3(arr);
		//changeEVERYTHING(s,x,arr);
		System.out.println("p is now " + p + ", x is now " + x + ", arr is now "+ Arrays.toString(arr));

	}

	private static void test1(Person p, int x, int[] arr) {
		String name = p.getFirstName();
		name= "Original";
		
		/*
		 * It is not possible to change an original reference via a local variable 
		 * as in the example below
		 */
	}

	private static void test2(Person p) {
		p.setFirstName("Original");
		
		/*
		 * You can change an object's reference via its SETTERS (methods that set fields)
		 */
	}
	
	private static void test3(int[] arr)
	{
		//this is how you can change arrays via the local variable 
		/*
		 * through its references (i.e indices)
		 * b/c primitives don't reference other data (that's why they're called primitive
		 * it's not possible to change them via a local variable
		 * like we did with Objects and arrays
		 */
		
		arr[0] = 999;
		arr[1] = 998;
	}
	private static void changeEVERYTHING(String s, int x, int[] arr) {
		s = "Goodbye";
		x = -5; 
		arr = new int[5];
		arr[0] = -1;
		arr[1] = -2;	
	}

}
