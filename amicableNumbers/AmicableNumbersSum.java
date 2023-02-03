package amicableNumbers;

import java.util.ArrayList;


/**
 * Let d(n) be defined as the sum of proper divisors of n 
 * (numbers less than n which divide evenly into n).
 * If d(a) = b and d(b) = a, where a != b, then a and b are an amicable pair 
 * and each of a and b are called amicable numbers.
 *
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; 
 * therefore d(220) = 284. 
 * The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 *
 * Evaluate the sum of all the amicable numbers under 10000.
 * 
 * 60011st person to solve
 * @author st477134
 *
 */
public class AmicableNumbersSum {
	
	int amiNum;
	int sumOfAmiNums;
	
	public AmicableNumbersSum(){
		this(0);
	}
	
	public AmicableNumbersSum(int amiNum){
		this.amiNum = amiNum;
	}
	
	public static void main(String [] args){
		AmicableNumbersSum amicable = new AmicableNumbersSum(10000);
		amicable.run();
		System.out.println(amicable.getSum());
	}
	
	public void run(){
		
		ArrayList <int []> arrList = new ArrayList<int []>();
		
		int sum = 0;
		
		for(int i = 2; i <= amiNum; i++){
			int numDivisors = findNumDivisors(i);
			int [] mapArr = {i,numDivisors};
			arrList.add(mapArr);
		}
		
		ArrayList<Integer> arr = findAmicableNumbers(arrList);
		
		sum = findSum(arr);
		
		this.sumOfAmiNums = sum;
		
	}
	
	private int findNumDivisors(int n){
		
		int sum = 0;
		
		for(int i = 1; i < n; i++){
			if(n % i == 0){
				sum += i;
			}
		}
		
		return sum;
	}
	
	private ArrayList<Integer> findAmicableNumbers(ArrayList <int []> arrList){
		
		ArrayList<Integer> amiNumbers = new ArrayList<Integer>();
		
		int testNum;
		
		for(int i = 0; i < arrList.size(); i++){
			testNum = arrList.get(i)[0];
			for(int j = 0; j < arrList.size(); j++){
				if(j == i){ continue; }
				if(arrList.get(j)[1] == testNum && arrList.get(j)[0] == arrList.get(i)[1]){
					amiNumbers.add(arrList.get(i)[0]);
				}
			}
		}
		
		return amiNumbers;
		
	}
	
	private int findSum(ArrayList <Integer> arrL){
		
		int sum = 0;
		
		for(int i = 0; i < arrL.size(); i++){
			sum += arrL.get(i);
		}
		
		return sum;
		
	}
	
	public int getSum(){
		return sumOfAmiNums;
	}

}
