package reciprocalCycles;

public class ReciprocalCycles {
	
	int maxInt;
	
	public ReciprocalCycles(){
		this(1);
	}
	
	public ReciprocalCycles(int n){
		this.maxInt = n;
	}
	
	public static void main(String [] args){
		ReciprocalCycles rc = new ReciprocalCycles(1000);
		rc.run();
	}
	
	public void run(){
		
		double dec;
		String strDec;
		
		for(double i = 1; i < maxInt; i++){
			dec = 1/i;
			strDec = Double.toString(dec).substring(2, Double.toString(dec).length()); //chops of the decimal and to the left
			
			for(int j = 0; j < strDec.length()/2; j++){
				for(int k = 0; k < j; k++){
					
				}
			}
			
			System.out.println(i + " " + strDec);
		}
		
	}

}
