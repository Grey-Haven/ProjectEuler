package problem040;

import java.math.BigDecimal;

import base.EulerTools;

/**
 * An irrational decimal fraction is created by concatenating the positive integers:
 * <br>
 * 0.123456789101112131415161718192021...
 * <br>
 * It can be seen that the 12th digit of the fractional part is 1.
 * <br>
 * If d(n) represents the nth digit of the fractional part, find the value of the following expression.
 * <br>
 * d(1) × d(10) × d(100) × d(1000) × d(10000) × d(100000) × d(1000000)
 * <br>
 * Answer: 210
 * 
 * @since Jul 24, 2013 4:59:12 PM
 * @author st477134
 *
 */
public class Champernowne {
	
	int precision;
	BigDecimal champernownesConstant;
	
	public Champernowne(){
		this(100);
	}
	
	public Champernowne(int precision){
		this.precision = precision;
	}
	
	public static void main(String [] args){
		
		Champernowne champ = new Champernowne(300000); //I just got a mathematician to roll over in his grave...
		champ.run();
		
	}
	
	public void run(){
		
		EulerTools.startTimer();
		
		StringBuilder champernownesConstantStr = new StringBuilder("");
		
		for(int i = 1; i <= precision; i++){
			champernownesConstantStr.append(Integer.toString(i));			
		}
		EulerTools.stopTimer();
		System.out.println("Done building");
		System.out.println(EulerTools.getTime());
		EulerTools.startTimer();
		champernownesConstant = new BigDecimal("0." + champernownesConstantStr.toString());
		EulerTools.stopTimer();
		System.out.println(EulerTools.getTime());
		EulerTools.startTimer();
		
	//	String s = champernownesConstant.toString();
	//	System.out.println("Done");
		String s = champernownesConstantStr.toString();
		
		int d1 = Integer.parseInt(s.substring(0, 1));
		int d10 = Integer.parseInt(s.substring(9, 10));
		int d100 = Integer.parseInt(s.substring(99, 100));
		int d1000 = Integer.parseInt(s.substring(999, 1000));
		int d10000 = Integer.parseInt(s.substring(9999, 10000));
		int d100000 = Integer.parseInt(s.substring(99999, 100000));
		int d1000000 = Integer.parseInt(s.substring(999999, 1000000));
		
		EulerTools.stopTimer();
		System.out.println(EulerTools.getTime());
		
		System.out.println(d1 + " " + d10 + " " + d100 + " " + d1000 + " " + d10000 + " " + d100000 + " " + d1000000);
		
		System.out.println(d1 * d10 * d100 * d1000 * d10000 * d100000 * d1000000);
		
	}
	
	public BigDecimal getConstant(){
		return new BigDecimal(champernownesConstant.toString());
	}

	public String toString(){
		return champernownesConstant.toString();
	}
	
}
