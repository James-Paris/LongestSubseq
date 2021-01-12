import java.util.Scanner;

public class MyApp {

	public static void main(String[] args) {

		int numNums = 0;
		
		
		do {
			Scanner scan = new Scanner(System.in);
			System.out.println("Please enter a number 1-100 for number of numbers to select.");
			numNums = scan.nextInt();
		} while (numNums < 1 || numNums > 100);
		
		LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
		Integer[] result = longestIncreasingSubsequence.getLongestIncreasingSubsequence(numNums);	        
		System.out.println("Winning sequence is");	        
		for (Integer i : result)
			System.out.println("Win Seq: " + i);	            
		System.out.println("End of sequence");

	}
	
}
