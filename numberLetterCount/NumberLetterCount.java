package numberLetterCount;

public class NumberLetterCount {
	
	int totalLength;
	int countTo;

	public NumberLetterCount(){ 
		this(0);
	} 
	
	public NumberLetterCount(int countTo){
		this.totalLength = 0;
		this.countTo = countTo;
	}

	public static void main(String [] args){

		NumberLetterCount nlc = new NumberLetterCount(1000);
		nlc.run();
		System.out.println(nlc.getLength());

	}

	public void run(){

		NumberToWord numToWord = new NumberToWord();

		int total = 0;
		String result;

		for(int i = 1; i <= countTo; i++){
			numToWord.setNum(i);
			result = numToWord.getWord().replaceAll("\\s+", "");
			total += result.length(); //"\\s" is blank space			
		}
		
		totalLength = total;
	}
	
	public int getLength(){
		return totalLength;
	}

}
