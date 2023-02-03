package numberSpirals;


/**
 * Starting with the number 1 and moving to the right in a clockwise direction 
 * a 5 by 5 spiral is formed as follows:
 *
 * 21 22 23 24 25
 * 20  7  8  9 10
 * 19  6  1  2 11
 * 18  5  4  3 12
 * 17 16 15 14 13
 * 
 * It can be verified that the sum of the numbers on the diagonals is 101.
 * 
 * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
 * 
 * @since 7/5/2013
 * @author st477134
 *
 */
public class NumberSpiralDiagonals {
	
	int dimension;
	
	public NumberSpiralDiagonals(){
		this(5);
	}
	
	public NumberSpiralDiagonals(int n){
		dimension = n;
	}
	
	public static void main(String [] args){
		NumberSpiralDiagonals nsd = new NumberSpiralDiagonals(1001);
		nsd.run();
	}
	
	public void run(){
		
		int sum = 0;
		
		int total = 1;
		int k = 1;
		
		for(int i = 1; i <= dimension; i += 2){
			k = 1;
			
			for(int j = total; j <= i*i; j++){ //i is squared since it represents the size of the square
				
				k++;
				
				if(k == i){
					k = 1;
					System.out.print('-'); //Helps visualize which numbers are the diagonals
					sum += j;
				}
				
				System.out.println(j);
				total++;
				
				
			}
			
			
		}
		
		System.out.println(sum + 1); // accounts for the 1 at the center of the square
		
	}

}
