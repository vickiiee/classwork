package arrays;

import java.util.Arrays;

public class ArraysMain {
	
	//private int[] testArray;
	private String[]suits;
	private String[] values;
	
	public ArraysMain() 
	{
		//testArray = new int[50];
		//populate1ToN(testArray);
		//countOccurences(testArray,2,12);
		//swap(testArray,0,1);
		//shuffle(testArray);
		//System.out.println(Arrays.toString(testArray));
		
		suits = new String[4];
		suits[0] = "Clubs";
		suits[1] = "Hearts";
		suits[2] = "Diamonds";
		suits[3] = "Spades";
		
		values = new String[13];
		for (int i = 0; i < values.length; i++)
		{
			values[i] = "" + (i+1);
		}
		
		values[0] = "Ace";
		values[12] = "King";
		values[11] = "Queen";
		values[10] = "Jack";
		printDeck();
				
	}
	
	private String[] printDeck() {
		String[] deck = new String[52];
		int index = 0;
		for (String suit:suits)
		{
			for (String value: values)
			{
				deck[index] = value + " of " + suit;
				index ++;
			}
		}
		return deck;
	}

	private void shuffle(int[] arr) {
		for (int i = 0; i < arr.length; i++)
		{
			swap(arr,i,(int)(Math.random() * arr.length));
		}
		
	}

	private void swap(int[] arr, int i, int j) {
		//swaps elements at i and j
		
		int placeHolder = arr[i];
		
		arr[i] = arr[j];
		arr[j] = placeHolder;
	}

	private void populate1ToN(int[] arr) {
		//populate arr with numbers from 1 to arr.length, in order
		
		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = (i+1);
		}
		
	}

	private void countOccurences(int[] arr, int start, int end) {
		//why create an array with this length?
		// 11 outcomes, 11 spaces
		int[] counter = new int [end - start + 1];
		
		for (int value : arr) {
			//why value - start?
			//
			counter[value - start] ++;	
		}
		for(int i = 0; i< counter.length; i++)
		{
			System.out.println("The value " + (i+start) + " was rolled " + counter[i] + " times.");
		}
	}

	private void populate(int[] arr) 
	{//this method populates arr with results from rolling 2 dice
		
		//correct way
		
		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = diceRoll(2);
		}
		
		//incorrect way: (does nothing)
		/*for (int value: arr)
		{
			value = diceRoll(2);
		}
		*/
		
	}

	public void arrayNotes()
	{
		//two ways to construct an array :
		
				int [] firstWay = {0,1,2,3,4,5};
				//this way will only work with the declaration. 
				//will not work:
				//firstWay = {6,7,8,9,10};
				
				String[] secondWay = new String[5];
				//secondWay[0] = 1;
				//secondWay[1] = 10;
				
				//primitive arrays will always default to 0
				
				
				//TWO WAYS TO ITERATE AN ARRAY:
				for (int i = 0; i < secondWay.length; i++)
				{
					System.out.println("The #" + i + " element is " + secondWay[i]);
				}
				
				
				//"FOR EACH int in secondWay
				for (String value: secondWay)
				{
					System.out.println("Element is " + value);
				}
				
				//NOTE : primitive arrays are automatically- populated with 0s
				//Object arrays are not populated (null)
	}
	
	public static void main(String[] args) 
	{
		ArraysMain sample = new ArraysMain();
		//1. Arrays are collections of primitives and Objects
		//SPECIAL NOTE: This is the ONLY collection of primitives
		
		//2. Size cannot be edited
		
		/*3. Elements of an array are REFERENCES to objects.
		 *  in other words, changing an element of an array changes the reference, not the object.
		 */
		
	}

	
	public int diceRoll(int n)
	{
		//returns the result after rolling n number of dice
		int sum = 0;
		for (int i = 0; i < n; i++)
		{
			int dieRoll = (int)(Math.random()*6) + 1; //range 1-6
			sum += dieRoll;
		}
		return sum;
	}
}
