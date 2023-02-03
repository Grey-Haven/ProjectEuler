package problem034;

import java.util.ArrayList;

/**
 * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
 *
 * Find the sum of all numbers which are equal to the sum of the factorial of their digits.
 * 
 * Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 * 
 * @since 2013-07-22
 * @author st477134
 *
 */
public class DigitFactorials {

	public DigitFactorials(){ }
	
	public static void main(String [] args){
		
		DigitFactorials df = new DigitFactorials();
		df.run();
		
	}
	
	public void run(){
		
		ArrayList<Integer>digitFacts = new ArrayList<Integer>();
		int total = 0;
		
		for(int i = 3; i < 999999; i++){
			
			if(i == findSubFactorials(i)){
				digitFacts.add(i);
			}
			
		}
		
		for(int i = 0; i < digitFacts.size(); i++){
			total += digitFacts.get(i);
			System.out.println(digitFacts.get(i));
		}
		System.out.println();
		System.out.println("Total: " + total);
		
	}
	
	private int factorial(int n){
		
		if(n == 0 || n == 1){
			return 1;
		}
		else{
			return n * factorial(n-1);
		}
		
	}
	
	private int findSubFactorials(int num){
		
		String numStr = Integer.toString(num);
		int totalFactorials = 0;
		
		for(int i = 0; i < numStr.length(); i++){
			
			totalFactorials += factorial(Integer.parseInt(numStr.substring(i,i+1)));
			
		}
		
		return totalFactorials;
		
	}
	
}
