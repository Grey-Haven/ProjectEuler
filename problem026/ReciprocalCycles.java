package problem026;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import base.EulerTools;

/**
 * A unit fraction contains 1 in the numerator. 
 * The decimal representation of the unit fractions with denominators 2 to 10 are given:
 *
 * 1/2	= 	0.5
 * 1/3	= 	0.(3)
 * 1/4	= 	0.25
 * 1/5	= 	0.2
 * 1/6	= 	0.1(6)
 * 1/7	= 	0.(142857)
 * 1/8	= 	0.125
 * 1/9	= 	0.(1)
 * 1/10	= 	0.1
 * 
 * Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. 
 * It can be seen that 1/7 has a 6-digit recurring cycle.
 *
 * Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
 *
 * @since Jul 23, 2013 9:34:58 AM
 * @author st477134
 * 
 * Answer: 983
 *
 */
public class ReciprocalCycles {
	
	int max;
	
	public ReciprocalCycles(){
		this(1);
	}
	
	public ReciprocalCycles(int max){
		this.max = max;
	}
	
	public static void main(String [] args){
		
		ReciprocalCycles rc = new ReciprocalCycles(1000);
		rc.run();
		
	}
	
	public void run(){
		
		EulerTools.startTimer();
		
		ArrayList<BigDecimal>bigDecs = buildDecs();
	//	EulerTools.outputList(bigDecs);
		ArrayList<String>strDecs = new ArrayList<String>();
		
		EulerTools.stopTimer();
		
		System.out.println(EulerTools.getTime()/1000);
		
		String temp;
		
		for(int i = 0; i < bigDecs.size(); i++){
			temp = bigDecs.get(i).toString().replaceFirst("^0\\.*", "");
			if(temp.length() > 20){
				temp = temp.substring(20, temp.length()-2);
			}
			strDecs.add(temp);
		}
		
		EulerTools.stopTimer();
		
		System.out.println(EulerTools.getTime()/1000);
		
		EulerTools.startTimer();
		
		String pattern;
		int largestRepeat = 0;
		int numOfRepeat = 0;
		for(int i = 0; i < strDecs.size(); i++){
			pattern = findRepeat(strDecs.get(i));
//			System.out.println(i + " strDecs: " + strDecs.get(i) + " pattern: " + pattern);
			if(pattern.length() > largestRepeat){
				numOfRepeat = i + 2;
				largestRepeat = pattern.length();
			}
		}
		
		EulerTools.stopTimer();
		
		System.out.println(EulerTools.getTime()/1000);
		
		System.out.println("Longest Repeat: " + largestRepeat);
		System.out.println("Denominator: " + numOfRepeat);
		
	}
	
	private ArrayList<BigDecimal>buildDecs(){
		
		ArrayList<BigDecimal>decList = new ArrayList<BigDecimal>(max);
		
		for(int i = 2; i <= max; i++){
			
			BigDecimal bd = new BigDecimal(1);
			bd = bd.divide(new BigDecimal(i), 10000, RoundingMode.HALF_UP );
			bd = new BigDecimal(bd.toString().replaceAll("0+$", ""));
			
			decList.add(bd);
			
		}
		
		return decList;
		
	}

	private String findRepeat(String s){
		
//		System.out.println(s);
		
		ArrayList<String>patterns = new ArrayList<String>();
		
		boolean isPattern = false;
		
		int length = 0;
		
		String superHolder = "";
		String holder = "";
		String substr = "";
		
		try{
			for(int i = 1; i < s.length(); i++){
				
				holder = s.substring(s.length() - i);
				substr = s.substring(s.length() - (2*i), s.length() - i);
				
				if(substr.equals(holder)){
					length = holder.length();
					isPattern = true;
					if(holder.substring(0, holder.length()/2).equals(holder.substring(holder.length()/2))){
						return superHolder;
					}
						if(!superHolder.equals(holder) && !patterns.contains(holder)){
							patterns.add(holder);
//							System.out.println(superHolder + " " + holder);
							superHolder = holder;
						}
					}
//					holder = "";
//					substr = "";
//					length = 0;
				holder = substr + holder;
			}
		}catch(IndexOutOfBoundsException e){
			
			if(length >= s.length()/2){
				return s.substring(s.length()-1);
			}
			
			if(isPattern){
				return superHolder;
			}
			return "";
		}
		
		if(length >= s.length() - 2){
			return s.substring(s.length()-1);
		}
		
		return superHolder;
		
	}
	
}
