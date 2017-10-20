package arrays2D;

public class Array2DSampler {
	
	private String[][] pic;
	
	public void Array2dSampler() {
		pic = new String[10][20];
		print(pic);
	}
	
	private void print(String[][] pic2) {
		//Standard for loop for 2D Array
		
		for (int row = 0; row<pic.length; row++)
		{
			//Special note: Thesse for loops get you test points!
			for (int col = 0; col<pic[row].length; col++)
			{
				System.out.println(pic[row][col]);
			}
			//line break
			System.out.println("");
		}
		//for each style:
		//for each row...
		for(String[] row: pic)
		{//for each column in that row
			for(String col: row)
			{
				System.out.println(col);
			}
			//line break
			System.out.println("");
		}
	}

	
}
