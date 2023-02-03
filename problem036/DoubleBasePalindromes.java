package problem036;

import java.util.ArrayList;

import base.EulerTools;

/**
 * The decimal number, 585 = 10010010012 (binary), is palindromic in both bases.
 *
 * Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
 *
 * (Please note that the palindromic number, in either base, may not include leading zeros.)
 * 
 * @since 2013-07-22
 * @author st477134
 *
 */
public class DoubleBasePalindromes {
	
	int max;
	int sum;
	private ArrayList<Integer>palinNums;
	
	public DoubleBasePalindromes() { 
		this(1);
	}
	
	public DoubleBasePalindromes(int max){
		this.max = max;
	}
	
	public static void main(String [] args){
		
		DoubleBasePalindromes dbs = new DoubleBasePalindromes(1000000);
		dbs.run();
		
		EulerTools.outputList(dbs.getPalinList());
		System.out.println("Sum: " + dbs.getSum());
		
	}
	
	public void run(){
		
		ArrayList<Integer>palinNums = new ArrayList<Integer>();
		int sum = 0;
		
		for(int i = 1; i <= max; i++){
			
			if(isPalindromic(Integer.toString(i)) && 
			   isPalindromic(Integer.toBinaryString(i))){
				palinNums.add(i);
			}
		}
		this.palinNums = new ArrayList<Integer>(palinNums);
		for(int i = 0; i < palinNums.size(); i++){
			sum += palinNums.get(i);
		}
		this.sum = sum;
	}
	
	private boolean isPalindromic(String num){
		StringBuilder strBuild = new StringBuilder(num);
		return num.equals(strBuild.reverse().toString());
	}

	public ArrayList<Integer> getPalinList(){
		return new ArrayList<Integer>(palinNums);
	}
	
	public int getSum(){
		return sum;
	}
	
}
