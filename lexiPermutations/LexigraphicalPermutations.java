package lexiPermutations;

import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * A permutation is an ordered arrangement of objects. 
 * For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. 
 * If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. 
 * The lexicographic permutations of 0, 1 and 2 are:
 *
 * 012   021   102   120   201   210
 * 
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 * 
 * Answer: 2783915460
 * 
 * @since 7/5/2013
 * @author st477134
 *
 */
public class LexigraphicalPermutations {

	int maxSize;
	
	long [] sortedArray;
	
	String buildTime;
	String sortTime;
	String totalTime;

	public LexigraphicalPermutations(){
		this(1);
	}

	public LexigraphicalPermutations(int n){
		maxSize = n;
	}

	public static void main(String [] args){
		LexigraphicalPermutations lp = new LexigraphicalPermutations(10);
		lp.run();
		try{
			System.out.println("1,000,000th Permutation: " + lp.getSortedArr()[999999]);
		}catch(Exception e){   System.err.println(e);	}
		lp.outputTimes();
	}

	public void run(){
		
		Date startBuild = new Date();

		ArrayList<String> arrList = new ArrayList<String>();
		final String base = "0";
		
		arrList.add(base);

		arrList = buildArrayList(arrList);
		
		Date doneBuild = new Date();
		
		System.out.println("Done building");
		System.out.println("Now sorting");
		
		Date startSort = new Date();
		
//		for(int i = arrList.size(); i > 1; i--){
//			heapSort(arrList, i-1);
//		}
		
//		ArrayList<String> sortedList = bubbleSort(arrList);
		
		long [] longArr = convertStringToLong(arrList);
		
		quickSort(longArr, 0, longArr.length-1);
		
	//	outputList(arrList);
	//	outputList(longArr);
		
		System.out.println("1,000,000th Permutation: " + longArr[999999]);
		
		try{
			sortedArray = longArr.clone();			
		}catch(Exception e){ System.err.println(e);	}
		
		Date endSort = new Date();
		
		String buildTime = "Time to Build: " +((doneBuild.getTime() - startBuild.getTime())/1000) + " seconds";
		String sortTime = "Time to Sort: " +((endSort.getTime() - startSort.getTime())/1000) + " seconds";
		String totalTime = "Total Time: " +((endSort.getTime() - startBuild.getTime())/1000) + " seconds";
		
		this.buildTime = buildTime;
		this.sortTime = sortTime;
		this.totalTime = totalTime;
		
	}
	
	@SuppressWarnings("unchecked")
	private ArrayList<String> buildArrayList(ArrayList<String> arrList){
		
		int size;
		
		ArrayList <String> tempList = new ArrayList<String>();
		
		for(int a = 1; a < maxSize; a++){
			
			size = arrList.size();
			
			for(int i = 0; i < size; i++){
				if(!tempList.contains(arrList.get(i)) && arrList.get(i).trim().length() == a){
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
		
		return (ArrayList<String>) arrList.clone();
		
	}
	
	private long [] convertStringToLong(ArrayList<String> strList){
		
		long [] longArr = new long [strList.size()];
		
		for(int i = 0; i < strList.size(); i++){
			longArr[i] = Long.parseLong(strList.get(i));
		}
		
		return longArr;		
	}
	
	@SuppressWarnings("unchecked")
	private ArrayList<String> bubbleSort(ArrayList<String> arrList){
		String s;
		for(int i = arrList.size()-1; i >= 0; i--){
			System.out.println(i);
			for(int j = 0; j < i; j++){
				if(arrList.get(j).compareTo(arrList.get(j+1)) == 1){
					s = arrList.get(j+1);
					arrList.set(j+1, arrList.get(j));
					arrList.set(j, s);
				}
			}
		}
		return (ArrayList<String>) arrList.clone();
	}
	
	private void heapSort(ArrayList<String> arrList, int arr_ubound){
		
		int leftChild;
		int rightChild;
		int midChild;
		int root;
		String temp;
		
		root = (arr_ubound-1)/2;
		
		for(int o = root; o >= 0; o--){
			for(int i = root; i >= 0; i--){
				leftChild = (2*i) + 1;
				rightChild = (2*i) + 2;
				if((leftChild <= arr_ubound) && (rightChild <= arr_ubound)){
					if(Integer.parseInt(arrList.get(rightChild)) > Integer.parseInt(arrList.get(leftChild))){
						midChild = rightChild;
					}
					else{
						midChild = leftChild;
					}
				}
				else{
					if(rightChild > arr_ubound){
						midChild = leftChild;
					}
					else{
						midChild = rightChild;
					}
				}
				
				if(Integer.parseInt(arrList.get(i)) < Integer.parseInt(arrList.get(midChild))){
					temp = arrList.get(i);
					arrList.set(i, arrList.get(midChild));
					arrList.set(midChild, temp);
				}
				
			}
		}
		
		temp = arrList.get(0);
		arrList.set(0, arrList.get(arr_ubound));
		arrList.set(arr_ubound, temp);
		return;
		
	}
	
	private void quickSort(long arr[], int left, int right) {
	      int index = partition(arr, left, right);
	      if (left < index - 1)
	            quickSort(arr, left, index - 1);
	      if (index < right)
	            quickSort(arr, index, right);
	}

	private int partition(long arr[], int left, int right)
	{
	      int i = left;
	      int j = right;
	      long tmp;
	      long pivot = arr[(left + right) / 2];
	     
	      while (i <= j) {
	            while (arr[i] < pivot)
	                  i++;
	            while (arr[j] > pivot)
	                  j--;
	            if (i <= j) {
	                  tmp = arr[i];
	                  arr[i] = arr[j];
	                  arr[j] = tmp;
	                  i++;
	                  j--;
	            }
	      };
	     
	      return i;
	}
	
	private void outputList(ArrayList<String> sortedArr){
		for(int i = 0; i < sortedArr.size(); i++){
			System.out.println(sortedArr.get(i));
		}
	}
	
	private void outputList(long [] sortedArr){
		for(int i = 0; i < sortedArr.length; i++){
			System.out.println(sortedArr[i]);
		}
	}
	
	private void outputList(int [] sortedArr){
		for(int i = 0; i < sortedArr.length; i++){
			System.out.println(sortedArr[i]);
		}
	}
	
	public long[] getSortedArr(){
		return sortedArray;
	}
	
	public void outputTimes(){
		System.out.println(buildTime);
		System.out.println(sortTime);
		System.out.println(totalTime);
	}
	
}
