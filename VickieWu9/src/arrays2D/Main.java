package arrays2D;

public class Main {

	public static void main(String[] args) {
		//int [] arr = {4,3,2,1,0};
		//changeNeighbors(arr,2);
		
		Array2DSampler test = new Array2DSampler();

	}

	private static void changeNeighbors(int[] arr, int i) {
		/**
		 * PRECONDITION: i>=0 and i < arr.length
		 * increases the element at i by 1
		 * decreases the elements at i - 1 and i + 1, if they exist
		 * AVOIDS ArrayIndexOutOfBoundsException
		 * THIS IS SUCH A HEAVILY TESTED CONCEPT,
		 * 	ON EVERY EXAM, YOU SHOULD ALWAYS BE IN THE HABIT OF CHECKING FOR
		 * ArrayIndexOutOfBoundsException
		 * trust me, don't be the guy who lost a bazillion points
		 */
		 
		int element = arr[i];

		if(i == 0)
		{
			arr[i] = element +1;
			arr[i+1] = element -1;
		}
		if (i == arr.length-1)
		{
			arr[i] = element +1;
			arr[i -1] = element -1;
		}
			
		if (i < arr.length && i>=0)
		{
			arr[i] = element +1;
			arr[i -1] = element -1;
			arr[i+1] = element -1;
		}
		
	}

}
