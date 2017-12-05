package algorithms;

public class TowersOfHanoi {

		   public static void solve(int n, String start, String helper, String end) {
		       if (n == 1) {
		           System.out.println(start + " -> " + end);
		       } else {
		           solve(n - 1, start, end, helper);
		           //move discs from start to helper in order to get to the biggest disc
		           System.out.println(start + " -> " + end);
		           solve(n - 1, helper, start, end);
		           //move discs from helper, to the end
		       }
		   }

		   public static void main(String[] args) {
			   solve(5,"A", "B", "C");
		   }

}
