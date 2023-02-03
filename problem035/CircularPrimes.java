package problem035;

import java.util.ArrayList;

import base.EulerTools;

/**
 * 
 * The number, 197, is called a circular prime because all rotations of the digits: 
 * 197, 971, and 719, are themselves prime.
 *
 * There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
 * 
 * How many circular primes are there below one million?
 * 
 * @since 2013-07-22
 * @author st477134
 *
 */
public class CircularPrimes {
	
	int max;
	
	ArrayList<Integer>circularPrimesList;
	
	public CircularPrimes(){ 
		this(1);
	}
	
	public CircularPrimes(int max){
		this.max = max;
	}
	
	public static void main(String [] args){
		
		CircularPrimes cp = new CircularPrimes(1000000);
		cp.run();
		
		EulerTools.outputList(cp.getCircPrimesList());
		
		System.out.println("Size: " + cp.getCircPrimesList().size());
		
	}
	
	public void run(){
		
		ArrayList<Integer>circPrimesList = new ArrayList<Integer>();
		
		for(int i = 1; i <= max; i++){
			if(isCircularPrime(i)){
				circPrimesList.add(i);
			}
		}
		
		this.circularPrimesList = circPrimesList;
		
	}
	
	private boolean isCircularPrime(int num){
		
		String numStr = Integer.toString(num);
		
		for(int i = 0; i < numStr.length(); i++){
			
			numStr = numStr.substring(numStr.length()-1) + numStr.substring(0,numStr.length()-1);
			
			if(!EulerTools.isPrime(Integer.parseInt(numStr))){
				return false;
			}
			
		}
		
		return true;
		
	}

	public ArrayList<Integer> getCircPrimesList(){
		return circularPrimesList;
	}
	
}
