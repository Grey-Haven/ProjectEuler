package primeSums;

import java.util.ArrayList;
import java.util.Date;

/**
 * Find the sum of the prime numbers 
 * less than two million
 * 
 * @author Stephen
 *
 */
public class PrimeSums {

	int max;
	
	public PrimeSums(){
		this(100);
	}

	public PrimeSums(int max){
		this.max = max;
	}

	public static void main(String[] args) {
		PrimeSums ps = new PrimeSums(2000000);
		ps.run();
	}

	public void run(){

		final int max = this.max;

		ArrayList <Long> primes = new ArrayList<Long>((int) max);

		long total = 0;

		long potentialPrime;
		long numPrimes = 0;

		primes.add((long) 2);
		primes.add((long) 3);
		numPrimes += 2;

		total += 5;

		boolean isPrime;

		Date start = new Date();

		for(potentialPrime = 5; potentialPrime < max; potentialPrime+=2){

			isPrime = true;

			for(int i = 0; i < potentialPrime; i++){

				if(primes.get(i) > Math.sqrt(potentialPrime)){
					break;
				}
				if(potentialPrime % primes.get(i) == 0){
					isPrime = false;
					break;
				}

			}

			if(isPrime){
				total += potentialPrime;
				primes.add(potentialPrime);
				numPrimes++;
			}

		}

		Date end = new Date();

		String [] output = {" Seconds", " Minutes", " Hours"};

		int j = 0;

		int mils = (int) (end.getTime() - start.getTime());
		int time = mils / 1000;
		int remainder = mils % 1000;

		while(time > 60){
			time = time / 60;
			remainder = time % 60;
			j++;
		}
		try{
			System.out.println(time + "." + remainder + output[j]);
		}catch(IndexOutOfBoundsException e){
			System.err.println(time + "." + remainder);
		}

		System.out.println("The number of Primes: " + numPrimes);

		System.out.println("Total Sum: " + total);
	}

}
