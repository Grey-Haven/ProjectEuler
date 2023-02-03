package problem041;

import java.util.ArrayList;

import base.EulerTools;

/**
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once. 
 * For example, 2143 is a 4-digit pandigital and is also prime.
 *
 * What is the largest n-digit pandigital prime that exists?
 * 
 * Answer: 7652413
 *
 * @since Jul 25, 2013 10:38:12 AM
 * @author st477134
 *
 */
public class PandigitalPrime {
	
	ArrayList<Integer> panPrimes;
	
	public PandigitalPrime(){ }
	
	public static void main(String [] args){
		
		PandigitalPrime pp = new PandigitalPrime();
		pp.run();
		
		ArrayList<Integer> panPrimes = pp.getPanPrimes();
		System.out.println(panPrimes.get(panPrimes.size()-1));
		
	}
	
	public void run(){
		
		ArrayList<String> arrList = new ArrayList<String>();
		final String base = "1";
		
		arrList.add(base);
		ArrayList<String> permutations = null;
		ArrayList<String> permPrimes = new ArrayList<String>();;
		
		for(int i = 1; i <= 9; i++){
			
			permutations = buildPermutArrayList(new ArrayList<String>(arrList), i);
			for(int j = 0; j < permutations.size(); j++){
				if(EulerTools.isPrime(Integer.parseInt(permutations.get(j)))){
					permPrimes.add(permutations.get(j));
				}
			}
		}
		ArrayList<String> sortPermPrimes = EulerTools.bubbleSort(new ArrayList<String>(permPrimes));
		ArrayList<Integer> pandigitalPrimes = convertStringToIntArrList(sortPermPrimes);
		
		this.panPrimes = new ArrayList<Integer>(pandigitalPrimes);
		
	}
	
	private ArrayList<String> buildPermutArrayList(ArrayList<String> arrList, int length){
		
		int size;
		
		ArrayList <String> tempList = new ArrayList<String>();
		
		for(int a = 1; a < length; a++){
			
			size = arrList.size();
			
			for(int i = 0; i < size; i++){
				if(!tempList.contains(arrList.get(i)) && arrList.get(i).trim().length() == a){
					tempList.add(arrList.get(i));
				}
			}
			
			size = tempList.size();
			
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
				s = s.substring(0, k) + Integer.toString(a+1) + s.substring(k);
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
					s = s.substring(0, k) + Integer.toString(a+1) + s.substring(k);
					arrList.set(i,s);
					add = false;
				}
				if(k == 0){
					i++;
					s = arrList.get(i);
					s = s.substring(0, k) + Integer.toString(a+1) + s.substring(k);
					arrList.set(i,s);
					add = true;
				}
			}
		}
		
		return new ArrayList<String>(arrList);
		
	}

	private ArrayList<Integer> convertStringToIntArrList(ArrayList<String> conList){
		
		ArrayList<Integer> convertedList = new ArrayList<Integer>();
		
		for(int i = 0; i < conList.size(); i++){
			convertedList.add(Integer.parseInt(conList.get(i)));
		}
		
		return new ArrayList<Integer>(convertedList);		
	}
	
	public ArrayList<Integer> getPanPrimes(){
		return panPrimes;
	}
	
}
