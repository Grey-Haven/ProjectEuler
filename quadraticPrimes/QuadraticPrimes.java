package quadraticPrimes;

import java.util.Date;

/**
 * Euler discovered the remarkable quadratic formula:
 * n² + n + 41
 *
 * It turns out that the formula will produce 40 primes for the consecutive values n = 0 to 39. 
 * However, when n = 40, 402 + 40 + 41 = 40(40 + 1) + 41 is divisible by 41, 
 * and certainly when n = 41, 41² + 41 + 41 is clearly divisible by 41.
 *
 * The incredible formula  n² - 79n + 1601 was discovered, 
 * which produces 80 primes for the consecutive values n = 0 to 79. 
 * The product of the coefficients, -79 and 1601, is -126479.
 *
 * Considering quadratics of the form:
 *
 * n² + an + b, where |a| < 1000 and |b| < 1000
 *
 * where |n| is the modulus/absolute value of n
 * e.g. |11| = 11 and |4| = 4
 * Find the product of the coefficients, a and b, 
 * for the quadratic expression that produces the maximum number of primes 
 * for consecutive values of n, starting with n = 0.
 * @author st477134
 *
 */
public class QuadraticPrimes {

	public QuadraticPrimes(){ }

	public static void main(String [] args){
		QuadraticPrimes qp = new QuadraticPrimes();
		qp.run();
	}

	public void run(){
		
		Date start = new Date();
		int longestRun = 0;
		int bigA = 0;
		int bigB = 0;
		int n = 0;
		
		for(int a = -999; a <= 999; a++){
			for(int b = -999; b <= 999; b++){
				n = 0;
				while(isPrime((n*n) + a*n + b)){
					n++;
				}
				if(n > longestRun){
					longestRun = n;
					bigA = a;
					bigB = b;
				}
			}
		}
		
		Date end = new Date();
		
		System.out.println("Time: " + (end.getTime() - start.getTime()));
		System.out.println(longestRun);
		System.out.println("a: " + bigA + " b: " + bigB);
		System.out.println(bigA * bigB);
		
	}

	private boolean isPrime(int num){
		
		num = Math.abs(num);
		
		if(num % 2 == 0){
			return false;
		}
		
		for(int i = 3; i < Math.sqrt(num); i+=2){
			if(num % i == 0){
				return false;
			}
		}
		return true;
	}

}
