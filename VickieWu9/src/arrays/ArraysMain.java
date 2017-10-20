package arrays;

import java.util.Arrays;

public class ArraysMain {
	
	private String[] suits;
	private String[] values;
	
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
	
	public ArraysMain() 
	{
		//testArray = new int[50];
		//populate1ToN(testArray);
		//countOccurences(testArray,2,12);
		//swap(testArray,0,1);
		//shuffle(testArray);
		//System.out.println(Arrays.toString(testArray));
		//warmUpMethods();
		wednesdayMethods();

	}
	
	private void wednesdayMethods() {
		int[] diceRolls = new int [1000];
		populate(diceRolls);
		longestConsecutiveSeqAndIndex(diceRolls);
		int[]data = longestConsecutiveSeqAndIndex(diceRolls);
		int max = 1;
		int longest = data[0];
		System.out.println("The longest sequence is " + longest + " rolls. IT HAPPENED ON ROLL #" + data[1] + " the sequence was:" + Arrays.toString(subArray(diceRolls,data[1],data[0])) + ".");
		
		/*while (longest!=11)
		{
			data = longestConsecutiveSeqAndIndex(diceRolls);
			longest = data[0];
			if(longest>max)
			{
				max = longest;
				System.out.println("The longest sequence is " + longest + " rolls. IT HAPPENED ON ROLL #" + data[1] + " the sequence was:" + Arrays.toString(subArray(diceRolls,data[1],data[0])) + ".");
			}
			}*/
	}
	
	/**
	 * BIG IDEA!
	 * usually a method returns ONE piece of data (i.e. 'int', 'boolean', etc.)
	 * if we ever want more than one piece of data, one way of doing so 
	 * is by using an array, as you see here, a method that returns the length
	 * of the sequence and its START position (both ints)
	 * @param arr
	 * @return
	 */
	private int[] longestConsecutiveSeqAndIndex(int[] arr) {
		
		int[] data = new int[2];
		
		data[0] = 1;
		int currentCount = 1;
		
		for (int i = 0; i < arr.length; i++)
		{
			while (i + currentCount < arr.length && isConsecutive(arr, i, i + currentCount))
			{
				isConsecutive(arr,i,i+currentCount);
				currentCount ++;
			}
			if (currentCount > data[0]) {
				data[0] = currentCount;
				//also store the index where this 
				data[1] = i;
			}
			i = i + currentCount -1 ;//saves time
			
			currentCount = 1;
		}
		return data;
	}
	
	
	private int longestConsecutiveSequence(int arr[]) {
		//return the length of the longest cons. sequence in the array
		//for EX:
		//{1,2,3,2,3,4,5,2,3,4)} -> 4
		// lCS({16,17,18,19,2,5,6,7,8,9,10}) -> 6
		
		int maxLength = 1;
		int currentCount = 1;
		
		for (int i = 0; i < arr.length; i++)
		{
			while (i + currentCount < arr.length && isConsecutive(arr, i, i + currentCount))
			{
				isConsecutive(arr,i,i+currentCount);
				currentCount ++;
			}
			if (currentCount > maxLength) {
				maxLength = currentCount;
			}
			i = i + currentCount -1 ;//saves time
			
			currentCount = 1;
		}
		return maxLength;
	}

	private void tuesdayMethods() {
		int [] orderTest = {1,2,3,4,5,6,7,8,9,10};
		//cycleThrough(orderTest,5);
		//frontToBack(orderTest);
		System.out.println(Arrays.toString(orderTest));
		System.out.println(longestConsecutiveSequence(orderTest) + " is the l.c.s");
	}
	
	
	
	private boolean isConsecutive(int[] arr, int start, int end)
	{//returns true if all the elements from start to end are increasing by one
		//ex: iC({1,7,3,6,7,8,12},3,5)
		
		for (int i = start; i < end; i++)
		{
			if( arr[i]+1 != arr[i + 1])
			{
				return false;
			}
		}return true;
	}

	
	
	private void cycleThrough(int[] arr, int n) {
		for (int i = 0; i< n; i ++)
		{
			frontToBack(arr);
		}
	}

	private void frontToBack(int[] arr) {
		//removes the element at index 0, pushes all other elements forward:
		//1 goes to 0, 2 goes to 1, ...
		//puts the element that was at index 0 at the end
		
		int placeHolder = arr[0];
		for(int i = 0; i < arr.length-1; i++)
		{
			arr[i] = arr[i+1];
		}
		arr[arr.length - 1] = placeHolder;
	}
	
	private void warmUpMethods()
	{
		int [] order = {1,2,3,4,5,6,7,8,9,10};
		reverseOrder(order);
		System.out.println(Arrays.toString(order));
		System.out.println(Arrays.toString(subArray(order,3,4)));
	}
	
	
	private int[] subArray(int[] arr, int psn, int length) {
		int [] sub = new int [length];
		for (int i = 0; i < length; i++)
		{
			sub[i] = arr[i +psn];
		}
		return sub;
	}
	
	public void reverseOrder(int[] arr)
	{	
		for (int i = 0; i< arr.length/2; i++)
		{
			swap(arr,i,arr.length-1-i);
		}
	}
	
	public void cardMethods()
	{
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
