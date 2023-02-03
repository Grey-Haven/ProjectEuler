package problem033;

import java.util.ArrayList;

/**
 * The fraction 49/98 is a curious fraction, 
 * as an inexperienced mathematician in attempting to simplify 
 * it may incorrectly believe that 49/98 = 4/8, which is correct, 
 * is obtained by canceling the 9s.
 *
 * We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
 *
 * There are exactly four non-trivial examples of this type of fraction, 
 * less than one in value, and containing two digits in the numerator and denominator.
 *
 * If the product of these four fractions is given in its lowest common terms, 
 * find the value of the denominator.
 * 
 * @since 2013-07-22
 * @author st477134
 *
 */
public class DigitCancelingFractions {

	public DigitCancelingFractions(){ }

	public static void main(String [] args){

		DigitCancelingFractions dcf = new DigitCancelingFractions();
		dcf.run();

	}

	public void run(){

		double dividen;
		double subDividen;
		int subI;
		int subJ;
		
		ArrayList<String>nonTrivialList = new ArrayList<String>();

		for(int i = 11; i < 99; i++){
			for(int j = 11; j < i; j++){

				if(i % 10 == 0 && j % 10 == 0){
					continue;
				}
				
				if(hasSimilarDigits(i,j) != 0){
					subI = removeDigits(i, hasSimilarDigits(i,j));
					subJ = removeDigits(j, hasSimilarDigits(i,j));
					
					if(subI == 0 || subJ == 0){
						continue;
					}
					
					dividen = (double)j / i;
					subDividen = (double)subJ / subI;
					
					if(dividen == subDividen){
						nonTrivialList.add(Integer.toString(j) + "/" + Integer.toString(i));
					}
				}
			}
		}
		
		int numProd = 1;
		int denProd = 1;
		int gcd;
		
		for(int i = 0; i < nonTrivialList.size(); i++){
			numProd *= Integer.parseInt(nonTrivialList.get(i).substring(0,2));
			denProd *= Integer.parseInt(nonTrivialList.get(i).substring(3,5));
			System.out.println(nonTrivialList.get(i));
		}
		
		gcd = gcd(numProd, denProd);
		
		System.out.println();
		System.out.println(numProd + "/" + denProd);
		System.out.println(numProd/gcd + "/" + denProd/gcd);

	}

	private int hasSimilarDigits(int i, int j){

		int i1;
		int i2;
		int j1;
		int j2;

		i1 = Integer.parseInt(Integer.toString(i).substring(0,1));
		i2 = Integer.parseInt(Integer.toString(i).substring(1,2));
		j1 = Integer.parseInt(Integer.toString(j).substring(0,1));
		j2 = Integer.parseInt(Integer.toString(j).substring(1,2));

		if(i1 == j1 || i1 == j2){
			return i1;
		}
		if(i2 == j1 || i2 == j2){
			return i2;
		}
		
		return 0;

	}

	private int removeDigits(int i, int removeInt){
		
		String numStr = Integer.toString(i);
		
		if(numStr.substring(0,1).equals(Integer.toString(removeInt))){
			return Integer.parseInt(numStr.substring(1,2));
		}
		if(numStr.substring(1,2).equals(Integer.toString(removeInt))){
			return Integer.parseInt(numStr.substring(0,1));
		}
		
		return 0;		
	}
	
	private int gcd(int a, int b){
		
		while(a != b){
			if(a > b){
				a = a - b;
			}
			else{
				b = b - a;
			}
		}
		
		return a;
		
	}
	
}
