package numberLetterCount;

public class NumberToWord {

	int intNum;
	String strNum;

	public NumberToWord(){
		this(0);
	}

	public NumberToWord(int number){
		this.intNum = number;
		convert();
	}
	
	private void convert(){
		
		String num_to_string = Integer.toString(intNum);
		String total = "";
		
		if(num_to_string.length() == 4){
			if(!num_to_string.substring(0,1).equals("0")){
				total += findDigitString(Integer.parseInt(num_to_string.substring(0,1)));
				total += " thousand ";
			}
			if(!num_to_string.substring(1,2).equals("0")){
				total += findDigitString(Integer.parseInt(num_to_string.substring(1,2)));
				total += " hundred ";
			}
			if(!num_to_string.substring(2,3).equals("0")){
				total += " and ";
				if(num_to_string.subSequence(2, 3).equals("1")){
					total += findTeenString(Integer.parseInt(num_to_string.substring(2,4)));
				}
				else{
					total += findTensString(Integer.parseInt(num_to_string.substring(2,3)));
					total += " ";
					if(!num_to_string.substring(3,4).equals("0")){
						total += findDigitString(Integer.parseInt(num_to_string.substring(3,4)));
					}
				}
			}//end if(!num_to_string.substring(2,3).equals("0"))
			else{
				if(!num_to_string.substring(3,4).equals("0")){
					total += " and ";
					total += findDigitString(Integer.parseInt(num_to_string.substring(3,4)));
				}
			}
			
		}
		
		
		if(num_to_string.length() == 3){
			if(!num_to_string.substring(0,1).equals("0")){
				total += findDigitString(Integer.parseInt(num_to_string.substring(0,1)));
				total += " hundred ";
			}
			if(!num_to_string.substring(1,2).equals("0")){
				total += " and ";
				if(num_to_string.subSequence(1,2).equals("1")){
					total += findTeenString(Integer.parseInt(num_to_string.substring(1,3)));
				}
				else{
					total += findTensString(Integer.parseInt(num_to_string.substring(1,2)));
					total += " ";
					if(!num_to_string.substring(2,3).equals("0")){
						total += findDigitString(Integer.parseInt(num_to_string.substring(2,3)));
					}
				}
			}//end if(!num_to_string.substring(1,2).equals("0"))
			else{
				if(!num_to_string.substring(2,3).equals("0")){
					total += " and ";
					total += findDigitString(Integer.parseInt(num_to_string.substring(2,3)));
				}
			}			
		}
		
		
		if(num_to_string.length() == 2){
			if(!num_to_string.substring(0,1).equals("0")){
				if(num_to_string.subSequence(0, 1).equals("1")){
					total += findTeenString(Integer.parseInt(num_to_string.substring(0,2)));
				}
				else{
					total += findTensString(Integer.parseInt(num_to_string.substring(0,1)));
					total += " ";
					if(!num_to_string.substring(1,2).equals("0")){
						total += findDigitString(Integer.parseInt(num_to_string.substring(1,2)));
					}	
				}
			}		
		}
		
	
		if(num_to_string.length() == 1){
			total += findDigitString(Integer.parseInt(num_to_string.substring(0,1)));
		}
		
		strNum = total;
	}
	
	private String findDigitString(int n){
		
		switch(n){
		
		case 0: return "zero";
		case 1: return "one";
		case 2: return "two";
		case 3: return "three";
		case 4: return "four";
		case 5: return "five";
		case 6: return "six";
		case 7: return "seven";
		case 8: return "eight";
		case 9: return "nine";
		
		}
		
		return null;
		
	}
	
	private String findTensString(int n){
		
		switch(n){
		
		case 0: return "zero";
		case 2: return "twenty";
		case 3: return "thirty";
		case 4: return "forty";
		case 5: return "fifty";
		case 6: return "sixty";
		case 7: return "seventy";
		case 8: return "eighty";
		case 9: return "ninety";
		
		}
		
		return null;
	}
	
	private String findTeenString(int n){
		
		switch(n){
		
		case 10: return "ten";
		case 11: return "eleven";
		case 12: return "twelve";
		case 13: return "thirteen";
		case 14: return "fourteen";
		case 15: return "fifteen";
		case 16: return "sixteen";
		case 17: return "seventeen";
		case 18: return "eighteen";
		case 19: return "nineteen";
		
		}
		
		return null;
		
	}
	
	public void setNum(int intNum){
		this.intNum = intNum;
		convert();
	}
	
	public int getNum(){
		return intNum;
	}
	
	public String getWord(){
		return strNum;
	}
	
}


