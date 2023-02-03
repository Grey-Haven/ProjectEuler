package sumSquareDiff;


/**
 * The sum of the squares of the first ten natural numbers is,
 * 1^2 + 2^2 + ... + 10^2 = 385
 * The square of the sum of the first ten natural numbers is,
 * (1 + 2 + ... + 10)^2 = 552 = 3025
 * Hence the difference between the sum of the squares of the 
 * first ten natural numbers and the square of the sum is 3025 - 385 = 2640.
 * 
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 * @author st477134
 *
 */
public class SumSquareDiff {
	
	public SumSquareDiff(){	}
	
	public static void main(String [] args){
		
		SumSquareDiff diff = new SumSquareDiff();
		diff.run();
		
	}
	
	public void run(){
		
		int sumSquares = 0;
		int squareSums = 0;
		
		for(int i = 1; i <= 100; i++){
			sumSquares += (i*i);
		}
		
		for(int i = 1; i <= 100; i++){
			squareSums += i;
		}
		squareSums = squareSums * squareSums;
		
		System.out.println(squareSums - sumSquares);
	}

}
