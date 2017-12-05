package algorithms;

public class FibonacciNumbers {
	
	//private String nums = "";
	//or make array
	private int[]numbers;
	
	public static  int fib(int num) {
		//1,1,2,3,5,8,13,21,34,...........
		
		if(num <= 1) {
			return 1;
		}else {
			return fib(num-1)+fib(num-2);
		}
	}

	public static void main(String[] args) {
		int numbers[] = new int[9];
		System.out.print(fib(9));

	}
	


}
