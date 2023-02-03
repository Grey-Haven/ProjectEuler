package smallestMultiple;

/**
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 * 
 * @author st477134
 */
public class SmallestMultiple {

	public SmallestMultiple(){	}

	public static void main(String [] args){

		SmallestMultiple sm = new SmallestMultiple();
		sm.run();

	}

	public void run(){

		int num = 0;

		boolean fin;

		while(true){
			fin = true;
			num++;

			for(int i = 20; i > 0; i--){
				if(num % i != 0){
					fin = false;
					break;
				}
			}
			if(fin){
				break;
			}			
		}

		System.out.println(num);
	}

}
