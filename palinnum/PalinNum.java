package palinNum;

/**
 * A palindromic number reads the same both ways. 
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91*99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * 
 * @author st477134
 */
public class PalinNum {
	
	public PalinNum(){ }
	
	public static void main(String [] args){
		PalinNum pn = new PalinNum();
		pn.run();
	}
	
	public void run(){
		
		int largest = 0;
		int num;
		String numStr;		
		
		for(int i = 1; i <= 999; i++){
			for(int j = 1; j <= 999; j++){
				num = j*i;
				numStr = Integer.toString(num);
				if(numStr.equals(new StringBuffer(numStr).reverse().toString())){
					if(num > largest){
						largest = num;
					}
				}
			}
		}
		
		System.out.println(largest);
		
	}

}
