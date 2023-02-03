package names;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Using names.txt, a 46K text file containing over five-thousand first names, 
 * begin by sorting it into alphabetical order. 
 * Then working out the alphabetical value for each name, 
 * multiply this value by its alphabetical position in the list to obtain a name score.
 *
 * For example, when the list is sorted into alphabetical order, COLIN, 
 * which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. 
 * So, COLIN would obtain a score of 938 × 53 = 49714.
 *
 * What is the total of all the name scores in the file?
 * 
 * @since 2013-07-16
 * @author st477134
 *
 */
public class NameScores {
	
	int total;
	
	public NameScores(){  }
	
	public static void main(String [] args){
		
		NameScores ns = new NameScores();
		ns.run();
		
		System.out.println(ns.getTotal());
		
	}
	
	public void run(){
		
		int nameScore;
		
		try{
			
			File f = new File(System.getProperty("user.dir") + "\\" + "src\\names" + "\\" + "names.txt");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			
			String names;
			
			names = br.readLine();
			
			br.close();
			
			String [] nameArr = names.split("\"*\",");
			
			for(int i = 0; i < nameArr.length; i++){
				nameArr[i] = nameArr[i].replaceAll("\"", "");
			}
			
			nameArr = bubbleSort(nameArr);
			
			for(int i = 0; i < nameArr.length; i++){
				nameScore = (i+1) * findNameWorth(nameArr[i]);
				total += nameScore;
			}
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
			System.exit(1);
		}catch(IOException e){
			e.printStackTrace();
			System.exit(1);
		}
		
	}
	
	private int findNameWorth(String name){
		
		char substr;
		int worth = 0;
		
		for(int i = 0; i < name.length(); i++){
			substr = name.charAt(i);
			worth += substr - 64; //converts from the decimal value of the ascii to (a = 1, b = 2, ..., z = 26)
		}
		
		return worth;
		
	}

	private String [] bubbleSort(String [] sortList){
		
		String temp;
		
		for(int i = sortList.length; i > 0; i--){
			for(int j = 0; j+1 < i; j++){
				if(sortList[j].compareTo(sortList[j+1]) > 0){
					temp = sortList[j];
					sortList[j] = sortList[j+1];
					sortList[j+1] = temp;
				}
			}
		}
		
		return sortList;
		
	}
	
	public int getTotal(){
		return total;
	}
}
