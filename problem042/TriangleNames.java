package problem042;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * The nth term of the sequence of triangle numbers is given by, 
 * t(n) = (1/2)n(n+1); so the first ten triangle numbers are:
 * <br>
 * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 * <br>
 * By converting each letter in a word to a number corresponding to its alphabetical position 
 * and adding these values we form a word value. 
 * For example, the word value for SKY is 19 + 11 + 25 = 55 = t(10). 
 * If the word value is a triangle number then we shall call the word a triangle word.
 * <br>
 * Using words.txt, a 16K text file containing nearly 
 * two-thousand common English words, how many are triangle words?
 * <br>
 * Answer: 162
 * 
 * @since Jul 25, 2013 1:46:50 PM
 * @author Stephen White
 *
 */
public class TriangleNames {
	
	ArrayList<String> triWords;
	
	public TriangleNames(){ }
	
	public static void main(String [] args){
		
		TriangleNames tn = new TriangleNames();
		tn.run();
		
		System.out.println(tn.getTriangleWords().size());
		
	}
	
	public void run(){
		
		ArrayList<String>strList;
		ArrayList<String>triWords = new ArrayList<String>();
		String word;

		try{

			strList = getWords();
			
			for(int i = 0; i < strList.size(); i++){
				word = strList.get(i);
				if(isTriangleNumber(getWordValue(word))){
					triWords.add(word);
				}
			}
			
			this.triWords = new ArrayList<String>(triWords);

		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}

	}
	
	private ArrayList<String> getWords() throws FileNotFoundException, IOException{
		
		File f = new File("words.txt");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		
		String s = br.readLine();
		
		s = s.substring(1, s.length()-1); //eliminates the first and last quote
		
		br.close();
		
		String [] words = s.split("\",\"");
		
		ArrayList<String>strList = new ArrayList<String>();
		
		for(int i = 0; i < words.length; i++){
			strList.add(words[i]);
		}		
		
		return new ArrayList<String>(strList);
		
	}

	private int getWordValue(String s){
		
		int total = 0;
		char value;
		
		for(int i = 0; i < s.length(); i++){
			
			value = s.charAt(i);
			total += value - 64;
			
		}
		
		return total;
		
	}
	
	/**
	 * The nth term of the sequence of triangle numbers is given by, 
	 * t(n) = (1/2)n(n+1);
	 * @return
	 */
	private boolean isTriangleNumber(int n){
		
		for(int i = 0; i <= n; i++){
			
			int q = (int) ((i * (i+1)) * .5);
			
			if(n == q){
				return true;
			}
			
		}
		
		return false;
		
	}
		
	public ArrayList<String> getTriangleWords(){
		return triWords;
	}
	
}
