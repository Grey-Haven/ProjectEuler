package evenFibb;

/**
 * Each new term in the Fibonacci sequence is generated by adding the previous two terms. 
 * By starting with 1 and 2, the first 10 terms will be:
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 * By considering the terms in the Fibonacci sequence whose values do not exceed four million, 
 * find the sum of the even-valued terms.
 * 
 * @author st477134
 */
public class EvenFibb {
	
	public EvenFibb(){ }
	
	public static void main(String [] args){
		
		EvenFibb ef = new EvenFibb();
		ef.run();
		
	}
	
	public void run(){
		
		int fibb = 1;
		int sub_fibb = 1;
		
		int sum = 0;
		
		System.out.println(1); //The first fibb number
		
		while(fibb <= 4000000){
			
			System.out.println(fibb);
			
			if(fibb % 2 == 0){
				sum += fibb;
			}
			
			fibb += sub_fibb;
			sub_fibb = fibb - sub_fibb;
			
		}
		
		System.out.println(sum);
		
	}

}
