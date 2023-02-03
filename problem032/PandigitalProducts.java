package problem032;

import java.util.ArrayList;

/**
 * We shall say that an n-digit number is pandigital if it 
 * makes use of all the digits 1 to n exactly once; for example, 
 * the 5-digit number, 15234, is 1 through 5 pandigital.
 *
 * The product 7254 is unusual, as the identity, 39 × 186 = 7254, 
 * containing multiplicand, multiplier, and product is 1 through 9 pandigital.
 * 
 * Find the sum of all products whose multiplicand/multiplier/product identity can 
 * be written as a 1 through 9 pandigital.
 *
 * HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.
 * 
 * @author st477134
 *
 */
public class PandigitalProducts {
	
	public PandigitalProducts(){}
	
	public static void main(String [] args){
		PandigitalProducts pp = new PandigitalProducts();
		pp.run();
	}
	
	public void run(){
		
		ArrayList<Integer>intArr = new ArrayList<Integer>();
		
		long totalSum = 0;
		int prod;
		
		for(int i = 0; i < 9999; i++){
			if(!isProbPandigit(Integer.toString(i))){  continue;  }
			for(int j = 0; j < 9999; j++){
				if(!isProbPandigit(Integer.toString(i))){	continue;	}
		//		System.out.println(i + " " + j);
				prod = i * j;
				if(isPandigital(Integer.toString(i) + Integer.toString(j) + Integer.toString(prod))){
					if(!intArr.contains(prod)){
						System.out.print(Integer.toString(i) + Integer.toString(j) + Integer.toString(prod));
						System.out.println(" " + prod);
						intArr.add(prod);
					}
				}
			}
		}
		for(int i = 0; i < intArr.size(); i++){
			totalSum += intArr.get(i);
		}
		System.out.println("Total: " + totalSum);
	}
	
	private boolean isProbPandigit(String strPan){
		
		ArrayList<String>sArrList = new ArrayList<String>();
		
		for(int i = 0; i < strPan.length(); i++){
			if(sArrList.contains(strPan.substring(i,i+1))){
				return false;
			}
			else{
				sArrList.add(strPan.substring(i,i+1));
			}
		}
		return true;		
	}
	
	private boolean isPandigital(String strPan){
		
		if(strPan.length() != 9){
			return false;
		}
		
		ArrayList <String> sArrList = new ArrayList<String>();
		for(int i = 0; i < strPan.length(); i++){
			sArrList.add(strPan.substring(i, i+1));
		}
		
		for(int i = 1; i <= 9; i++){
			if(!sArrList.contains(Integer.toString(i))){
				return false;
			}
		}
		
		return true;
		
	}

}
