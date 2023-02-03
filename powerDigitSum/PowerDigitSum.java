package powerDigitSum;

import java.math.BigInteger;

/**
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * What is the sum of the digits of the number 2^1000?
 * 
 * @author st477134
 *
 */
public class PowerDigitSum {
	
	public PowerDigitSum(){ }
	
	public static void main(String [] args){
		PowerDigitSum pds = new PowerDigitSum();
		pds.run();
	}
	
	public void run(){
		
		BigInteger big = new BigInteger("2");
		
		for(int i = 1; i < 1000; i++){
			big = big.multiply(new BigInteger("2"));
		}
		
		System.out.println("Power Digit: ");
		System.out.println(big);
		
		int total = 0;
		
		String bigString = big.toString();
		
		for(int i = 0; i < bigString.length(); i++){
			
			total += Integer.parseInt(bigString.substring(i, i+1));
			
		}
		
		System.out.println("Sum of digits: " + total);
		
	}

}
