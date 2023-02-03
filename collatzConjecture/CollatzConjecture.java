package collatzConjecture;

/**
 * The following iterative sequence is defined for the set of positive integers:
 *
 * n -> n/2 (n is even)
 * n -> 3n + 1 (n is odd)
 * 
 * Using the rule above and starting with 13, we generate the following sequence:
 *
 * 13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. 
 * Although it has not been proved yet (Collatz Problem), 
 * it is thought that all starting numbers finish at 1.
 *
 * Which starting number, under one million, produces the longest chain?
 *
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 *
 * @author st477134
 *
 *
 * Note: I was the 88600th person to solve this problem on ProjectEuler!
 */
public class CollatzConjecture {
	
	int max;
	
	public CollatzConjecture(){ 
		this(1000);
	}
	
	public CollatzConjecture(int max){
		this.max = max;
	}
	
	public static void main(String [] args){
		CollatzConjecture collatz = new CollatzConjecture(1000000);
		collatz.run();
	}
	
	public void run(){
		
		long maxSteps = 0;
		long subSteps = 0;
		long longestNum = 0;
		long holder = 0;
		
		for(long i = 1; i <= max; i++){
			System.out.println(i);
			holder = i;
			while(holder != 1){
		//		System.out.println(holder);
				subSteps++;
				if(holder % 2 == 0){
					holder = holder/2;
				}
				else{
					holder = (3*holder) + 1;
				}
			}
			if(subSteps > maxSteps){
//				System.out.println("         i: " + i);
//				System.out.println("longestNum: " + longestNum);
				longestNum = i;
				maxSteps = subSteps;
			}
			subSteps = 0;
		}
		
		System.out.println(maxSteps);
		System.out.println(longestNum);
		
	}

}
