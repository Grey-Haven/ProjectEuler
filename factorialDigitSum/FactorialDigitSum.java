package factorialDigitSum;

import java.math.BigInteger;

public class FactorialDigitSum {

	int factorial;
	int sumOfDigits;
	
	public FactorialDigitSum(){
		this(0);
	}

	public FactorialDigitSum(int factorial){
		this.factorial = factorial;
	}
	
	public static void main(String [] args){
		FactorialDigitSum fds = new FactorialDigitSum(100);
		fds.run();
		System.out.println(fds.getSum());
	}
	
	public void run(){
		
		BigInteger total = new BigInteger("1");
		
		for(int i = 1; i <= factorial; i++){
			total = total.multiply(new BigInteger(Integer.toString(i)));
		}
		
		String strTotal = total.toString();
		
		int sum = 0;
		
		for(int i = 0; i < total.toString().length(); i++){
			sum += Integer.parseInt(strTotal.substring(i, i+1));
		}
		
		sumOfDigits = sum;
		
	}
	
	public int getSum(){
		return sumOfDigits;
	}
}
