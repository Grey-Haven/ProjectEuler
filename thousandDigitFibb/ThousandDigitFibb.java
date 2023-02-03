package thousandDigitFibb;

import java.math.BigInteger;

public class ThousandDigitFibb {
	
	BigInteger thousandFibb;
	int terms;
	
	public ThousandDigitFibb(){ }
	
	public static void main(String [] args){
		ThousandDigitFibb tdf = new ThousandDigitFibb();
		tdf.run();
		System.out.println(tdf.getThousandFibb());
		System.out.println(tdf.getNumberOfTerms());
	}
	
	public void run(){
		
		int term = 2; //Counts for the first subfibb and fibb
		
		BigInteger bigFibb = new BigInteger("1");
		BigInteger bigSubFibb = new BigInteger("1");
		
		while(bigFibb.toString().length() < 1000){
			
			bigFibb = bigFibb.add(bigSubFibb);
			bigSubFibb = bigFibb.subtract(bigSubFibb);
			term++;
			
		}
		
		thousandFibb = bigFibb;
		terms = term;
		
	}
	
	public BigInteger getThousandFibb(){
		return thousandFibb;
	}
	
	public int getNumberOfTerms(){
		return terms;
	}

}
