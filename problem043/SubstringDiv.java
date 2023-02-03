package problem043;

import java.util.ArrayList;

import base.EulerTools;

/**
 * The number, 1406357289, is a 0 to 9 pandigital number 
 * because it is made up of each of the digits 0 to 9 in some order, 
 * but it also has a rather interesting sub-string divisibility property.
 * <br>
 * Let d(1) be the 1st digit, d(2) be the 2nd digit, and so on. In this way, we note the following:
 * <br>
 * d(2)d(3)d(4)=406 is divisible by 2 <br>
 * d(3)d(4)d(5)=063 is divisible by 3 <br>
 * d(4)d(5)d(6)=635 is divisible by 5 <br>
 * d(5)d(6)d(7)=357 is divisible by 7 <br>
 * d(6)d(7)d(8)=572 is divisible by 11 <br>
 * d(7)d(8)d(9)=728 is divisible by 13 <br>
 * d(8)d(9)d(10)=289 is divisible by 17 <br>
 * Find the sum of all 0 to 9 pandigital numbers with this property.
 * <br>
 * Answer: 16695334890
 * 
 * @since Jul 30, 2013 9:14:17 AM
 * @author Stephen White
 *
 */
public class SubstringDiv {

	public SubstringDiv(){ }

	public static void main(String [] args){

		SubstringDiv sd = new SubstringDiv();
		sd.run();

	}

	public void run(){

		ArrayList<String> base = new ArrayList<String>();
		base.add("0");
		ArrayList<String> perms = buildArrayList(base);
		ArrayList<Long> hasProps = new ArrayList<Long>();

		for(int i = 0; i < perms.size(); i++){

			if(hasProperty(perms.get(i))){

				hasProps.add(Long.parseLong(perms.get(i)));

			}

		}
		long sum = 0;
		for(int i = 0; i < hasProps.size(); i++){
			sum += hasProps.get(i);
		}

		System.out.println(sum);

	}

	private ArrayList<String> buildArrayList(ArrayList<String> arrList){

		int size;

		ArrayList <String> tempList = new ArrayList<String>();

		for(int a = 1; a <= 9; a++){

			size = arrList.size();

			for(int i = 0; i < size; i++){
				if(!tempList.contains(arrList.get(i).trim()) && arrList.get(i).trim().length() == a){
					tempList.add(arrList.get(i));
				}
			}
			
			arrList.clear();

			for(int i = 0; i < size; i++){
				for(int j = 0; j <= a; j++){
					arrList.add(tempList.get(i));
				}
			}
			
			tempList.clear();

			String s;
			boolean add = true;
			int k = 0;
			for(int i = 0; i < arrList.size(); i++){
				s = arrList.get(i);
				s = s.substring(0, k) + Integer.toString(a) + s.substring(k);
				arrList.set(i,s);

				if(add){
					k++;
				}
				else{
					k--;
				}
				if(k == s.length()-1){
					i++;
					s = arrList.get(i);
					s = s.substring(0, k) + Integer.toString(a) + s.substring(k);
					arrList.set(i,s);
					add = false;
				}
				if(k == 0){
					i++;
					s = arrList.get(i);
					s = s.substring(0, k) + Integer.toString(a) + s.substring(k);
					arrList.set(i,s);
					add = true;
				}
			}
		}
		return new ArrayList<String>(arrList);
	}

	/**
	 * Returns true if: 			        <br>
	 * d(2)d(3)d(4)  is divisible by 2  and <br>
	 * d(3)d(4)d(5)  is divisible by 3  and <br>
	 * d(4)d(5)d(6)  is divisible by 5  and <br>
	 * d(5)d(6)d(7)  is divisible by 7  and <br>
	 * d(6)d(7)d(8)  is divisible by 11 and <br>
	 * d(7)d(8)d(9)  is divisible by 13 and <br>
	 * d(8)d(9)d(10) is divisible by 17
	 * @param n
	 * @return boolean hasProperty
	 */
	private boolean hasProperty(String n){

		String d2 = "";
		String d3 = "";
		String d4 = "";
		String d5 = "";
		String d6 = "";
		String d7 = "";
		String d8 = "";
		String d9 = "";
		String d10 = "";

		try{
			d2  = n.substring(1,2);
			d3  = n.substring(2,3);
			d4  = n.substring(3,4);
			d5  = n.substring(4,5);
			d6  = n.substring(5,6);
			d7  = n.substring(6,7);
			d8  = n.substring(7,8);
			d9  = n.substring(8,9);
			d10 = n.substring(9,10);
		}catch(StringIndexOutOfBoundsException e){
			System.err.println(n);
		}

		if(Integer.parseInt((d2 + d3 + d4)) % 2 != 0){
			return false;
		}
		if(Integer.parseInt((d3 + d4 + d5)) % 3 != 0){
			return false;
		}
		if(Integer.parseInt((d4 + d5 + d6)) % 5 != 0){
			return false;
		}
		if(Integer.parseInt((d5 + d6 + d7)) % 7 != 0){
			return false;
		}
		if(Integer.parseInt((d6 + d7 + d8)) % 11 != 0){
			return false;
		}
		if(Integer.parseInt((d7 + d8 + d9)) % 13 != 0){
			return false;
		}
		if(Integer.parseInt((d8 + d9 + d10)) % 17 != 0){
			return false;
		}

		return true;

	}

}
