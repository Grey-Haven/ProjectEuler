package problem037;

import java.util.ArrayList;

import base.EulerTools;

/**
 *
 * The number 3797 has an interesting property. 
 * Being prime itself, it is possible to continuously remove digits from left to right, 
 * and remain prime at each stage: 3797, 797, 97, and 7. 
 * Similarly we can work from right to left: 3797, 379, 37, and 3.
 *
 * Find the sum of the only eleven primes that are both truncatable from left to right and right to left.
 * 
 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 *
 * @since Jul 22, 2013 3:22:43 PM
 * @author st477134
 *
 */
public class TruncatablePrimes {
	
	private int sum;
	private ArrayList<Integer>truncPrimes;
	
	public TruncatablePrimes(){ }
	
	public static void main(String [] args){
		
		TruncatablePrimes tp = new TruncatablePrimes();
		tp.run();
		
		EulerTools.outputList(tp.getTruncPrimes());
		System.out.println("Sum: " + tp.getSum());
		
	}
	
	public void run(){
		
		ArrayList<Integer>truncPrimes = new ArrayList<Integer>();
		int sum = 0;
		
		for(int i = 11; i < 999999; i++){
			if(EulerTools.isPrime(i)){
				if(isTruncPrime(i)){
					truncPrimes.add(i);
					sum += i;
				}
			}
		}
		
		this.truncPrimes = new ArrayList<Integer>(truncPrimes);
		this.sum = sum;
	}
	
	private boolean isTruncPrime(int num){
		
		String numStr = Integer.toString(num);
		String testStr;
		
		//Truncating from the left
		for(int i = 1; i < numStr.length(); i++){
			testStr = numStr.substring(i);
			if(!EulerTools.isPrime(Integer.parseInt(testStr))){
				return false;
			}
		}
		for(int i = numStr.length()-1; i > 0; i--){
			testStr = numStr.substring(0, i);
			if(!EulerTools.isPrime(Integer.parseInt(testStr))){
				return false;
			}
		}
		
		return true;
		
	}

	public int getSum(){
		return sum;
	}
	
	public ArrayList<Integer>getTruncPrimes(){
		return truncPrimes;
	}
	
}
