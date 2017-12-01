package algorithms;

public class Exercises {

	
	
	private static int counter = 0;

	public static void main(String[] args){
		 int value = 20;
		 System.out.println(value+"! is equal to "+factorial(value));
		 System.out.println(value+ " has "+countPrimeFactors(value, 2)+" prime factors.");
		 }

		 public static int countPrimeFactors(int value, int testPrime) {
			
			/*if(value%testPrime ==0) {
				counter ++;
				int num = value/testPrime;
				countPrimeFactors(num,testPrime);
			}
			return counter;*/
			 
			 if(testPrime ==value) {
				 return 1;
			 }
			 else if(value%testPrime ==0)
				 return countPrimeFactors(value / testPrime, testPrime) +1;
			 else return countPrimeFactors(value, testPrime +1);
		 }

		 public static int factorial(int value) {
			if(value <= 1) {
				return value;
			}
		 }

}
