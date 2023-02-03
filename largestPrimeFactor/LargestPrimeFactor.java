package largestPrimeFactor;

public class LargestPrimeFactor {
	
	public LargestPrimeFactor(){ }
	
	public static void main(String [] args){
		LargestPrimeFactor lpf = new LargestPrimeFactor();
		lpf.run();
	}

	public void run(){
		System.out.println(isPrime(1471));
		
		long num = 600851475143L;
		int largest_num = 0;
		
		for(int i = 3; i < num; i++){
			if(!isPrime(i)){
				continue;
			}
			if(isPrime(num)){
				break;
			}
			if(num % i == 0){
				System.out.println(i);
				num = num / i;
				if(i > largest_num){
					largest_num = i;
				}
				i = 3;
			}
		}
		if(num > largest_num){
			largest_num = (int) num;
		}
		System.out.println(largest_num);
		
	}
	
	private static boolean isPrime(long num){
		
		if(num % 2 == 0){
			return false;
		}
		
		int y = 3;
		while(y <= Math.sqrt(num)){
			if(num % y == 0){
				return false;
			}
		    y+=2;
		}
		return true;
	}	
}
