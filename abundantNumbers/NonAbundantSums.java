package abundantNumbers;

import java.util.ArrayList;
import java.util.Date;

/**
 * A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. 
 * For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, 
 * which means that 28 is a perfect number.
 *
 * A number n is called deficient if the sum of its proper divisors is less than n and 
 * it is called abundant if this sum exceeds n.
 *
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, 
 * the smallest number that can be written as the sum of two abundant numbers is 24. 
 * By mathematical analysis, it can be shown that all integers greater than 28123 
 * can be written as the sum of two abundant numbers. However, this upper limit 
 * cannot be reduced any further by analysis even though it is known that the 
 * greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.
 *
 * Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
 * @author st477134
 *
 */
public class NonAbundantSums {
	
	int maxAbundantNumber;
	int total;
	
	public NonAbundantSums(){ 
		this(0);
	}
	
	public NonAbundantSums(int max){
		this.maxAbundantNumber = max;
	}
	
	public static void main(String [] args){
		NonAbundantSums nas = new NonAbundantSums(28123);
		nas.run();
		System.out.println(nas.getTotal());
	}
	
	public void run(){
		
		ArrayList <Integer> abNums = findAbNums();
		ArrayList <Integer> sumNums = findSumNums(abNums);
		ArrayList <Integer> noSums = findNoSum(sumNums);
		int total = findSumOfNoSums(noSums);
		
		this.total = total;
		
	}
	
	private boolean isAbundantNumber(int n){
		
		int total = 0;
		
		for(int i = 1; i < n; i++){
			if(n % i == 0){
				total += i;
			}
		}
		
		return total > n;
	}
	
	private ArrayList<Integer> findNoSum(ArrayList<Integer> sumNums){
		
		ArrayList <Integer> noSums = new ArrayList<Integer>();
		
		for(int i = 1; i <= maxAbundantNumber; i++){
			if(!sumNums.contains(i)){
				noSums.add(i);
			}
		}
		
		return noSums;
		
	}
	
	private ArrayList<Integer> findAbNums(){
		
		ArrayList <Integer> abNums = new ArrayList<Integer>();
		
		for(int i = 1; i <= maxAbundantNumber; i++){
			if(isAbundantNumber(i)){
				abNums.add(i);
			}
		}
		return abNums;
	}
	
	private ArrayList<Integer> findSumNums(ArrayList<Integer> abNums){
		
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		
		int num1;
		int num2;
		
		for(int i = 0; i < abNums.size(); i++){
			num1 = abNums.get(i);
			for(int j = 0; j < abNums.size(); j++){
				num2 = abNums.get(j);
				if(num1 + num2 > maxAbundantNumber){
					break;
				}
				if(!arrList.contains(num1 + num2)){
					arrList.add(num1 + num2);	
				}
			}
		}		
		
		return arrList;
	}
	
	private int findSumOfNoSums(ArrayList<Integer> noSums){
		
		int total = 0;
		
		for(int i = 0; i < noSums.size(); i++){
			total += noSums.get(i);
		}
		
		return total;
		
	}

	public int getTotal(){
		return total;
	}
}
