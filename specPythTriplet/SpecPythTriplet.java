package specPythTriplet;

import java.math.BigDecimal;

/**
 * 
 * A Pythagorean triplet is a set of three natural numbers, 
 * a < b < c, for which, a^2 + b^2 = c^2
 * <br />
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 * <br />
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 * 
 * @author st477134
 *
 */
public class SpecPythTriplet {
	
	int total;
	
	public SpecPythTriplet(){
		this(1000);
	}
	
	public SpecPythTriplet(int num){
		this.total = num;
	}
	
	public static void main(String [] args){
		SpecPythTriplet spt = new SpecPythTriplet(1000);
		spt.run();
	}
	
	public void run(){
		
		final int total = this.total;
		int csq;
		int c;
		int product = 0;
		int sub_tot;
		
		for(int a = 1; a < total; a++){
			for(int b = 1; b < a; b++){
				csq = (a * a) + (b * b);
				if(!isDouble(Math.sqrt(csq))){
					c = (int) Math.sqrt(csq);
					sub_tot = a+b+c;
					if(sub_tot == 1000){
						System.out.println(a + " + " + b + " + " + c + " = " + sub_tot);
						product = a*b*c;
						System.out.println(product);
						System.exit(0);
					}
				}
			}
		}
		System.out.println(product);
		
	}
	
	private boolean isDouble(double testDoub){
		
		BigDecimal bd = new BigDecimal(testDoub);
		String test = bd.stripTrailingZeros().toString();
		
		if(test.contains(".")){
			return true;
		}
		
		return false;
	}

}
