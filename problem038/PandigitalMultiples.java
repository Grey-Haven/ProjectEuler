package problem038;

import java.util.ArrayList;

/**
 * Take the number 192 and multiply it by each of 1, 2, and 3:
 * <br>
 * 192 × 1 = 192 <br>
 * 192 × 2 = 384 <br>
 * 192 × 3 = 576 <br>
 * By concatenating each product we get the 1 to 9 pandigital, 192384576. 
 * We will call 192384576 the concatenated product of 192 and (1,2,3)
 * <br>
 * The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5, 
 * giving the pandigital, 918273645, which is the concatenated product of 9 and (1,2,3,4,5).
 * <br>
 * What is the largest 1 to 9 pandigital 9-digit number that can be formed as 
 * the concatenated product of an integer with (1,2, ... , n) where n > 1?
 * <br>
 * Answer: 932718654
 *
 * @since Jul 24, 2013 8:32:17 AM
 * @author st477134
 *
 */
public class PandigitalMultiples {
	
	int max;
	int largestPandigital;
	ArrayList<Integer>panList;
	
	public PandigitalMultiples(){
		this(1);
	}
	
	public PandigitalMultiples(int max){
		this.max = max;
	}
	
	public static void main(String [] args){
		
		PandigitalMultiples pm = new PandigitalMultiples(100000);
		pm.run();
		System.out.println(pm.getLargestPandigital());
		
	}
	
	public void run(){
		
		String concatStr;
		
		ArrayList<Integer>panList = new ArrayList<Integer>();
		
		for(int i = 2; i <= max; i++){
			
			concatStr = "";
			
			for(int j = 1; j <= 9; j++){
				concatStr += Integer.toString(j*i);
				if(concatStr.length() > 9){
					break;
				}
				if(isPandigital(concatStr)){
					panList.add(Integer.parseInt(concatStr));
					break;
				}
			}
		}
		
		this.panList = new ArrayList<Integer>(panList);
		largestPandigital = getLargest(panList);
		
	}
	
	private int getLargest(ArrayList<Integer>arrList){
		
		int largest = 0;
		
		for(int i = 0; i < arrList.size(); i++){
			if(arrList.get(i) > largest){
				largest = arrList.get(i);
			}
		}
		
		return largest;
		
	}
	
	private boolean isPandigital(String strPan){
		
		if(strPan.length() != 9){
			return false;
		}
		
		ArrayList <String> sArrList = new ArrayList<String>();
		for(int i = 0; i < strPan.length(); i++){
			sArrList.add(strPan.substring(i, i+1));
		}
		
		for(int i = 1; i <= 9; i++){
			if(!sArrList.contains(Integer.toString(i))){
				return false;
			}
		}
		
		return true;
		
	}

	public int getLargestPandigital(){
		return largestPandigital;
	}
	
	public ArrayList<Integer> getPandigitalList(){
		return new ArrayList<Integer>(panList);
	}
	
}
