package tenThousandFirstPrime;

import java.util.Date;

public class TenThousandFirstPrime {
	
	public TenThousandFirstPrime(){ }
	
	public static void main(String [] args){
		TenThousandFirstPrime ttfp = new TenThousandFirstPrime();
		ttfp.run();
	}

	public void run(){
		
		int x = 5;
		int y;
		int max = 104743; //the 10001st prime
		int prime_no = 2; //skip 2 and 3
		boolean prime;
		
			Date start = new Date();
			
			while(x <= max){
					prime = true;
					y = 3;
					while(y <= Math.sqrt(x)){
						if(x % y == 0){
							prime = false;
							break;
						}
					    y+=2;
					}
					if(prime){
						prime_no++;
						if(prime_no == 10001){
							System.out.println("10,001st Prime: " + x);
							break;
						}
					}
				x+=2;
			}
			
			Date end = new Date();
			
			double time = end.getTime() - start.getTime();
			int minutes;
			int seconds;
			
			time = time / 1000;
			
			if(time >= 60){
				minutes = (int) (time / 60);
				seconds = (int) (time % 60);
				
				System.out.println("minutes: " + minutes);
				System.out.println("seconds: " + seconds);
			}
			else{
				System.out.println(time + " seconds");
			}
	}
	
}
