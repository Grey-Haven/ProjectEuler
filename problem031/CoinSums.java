package problem031;

import java.util.ArrayList;

public class CoinSums {
	
	int maxAmt;
	int total;
	
	public CoinSums(){
		this(1);
	}
	
	public CoinSums(int maxAmt){
		this.maxAmt = maxAmt;
	}
	
	public static void main(String [] args){
		
		CoinSums cs = new CoinSums(200);
		cs.run();
		System.out.println(cs.getTotal());
	}
	
	public void run(){
		
		ArrayList<String>combos = new ArrayList<String>();
		String combo;
		
		for(int i = 0; i <= maxAmt; i+=200){
			for(int j = 0; i+j <= maxAmt; j+=100){
				for(int k = 0; i+j+k <= maxAmt; k+=50){
					for(int l = 0; i+j+k+l <= maxAmt; l+=20){
						for(int m = 0; i+j+k+l+m <= maxAmt; m+=10){
							for(int n = 0; i+j+k+l+m+n <= maxAmt; n+=5){
								for(int o = 0; i+j+k+l+m+n+o <= maxAmt; o+=2){
									for(int p = 0; i+j+k+l+m+n+o+p <= maxAmt; p+=1){
										if(i+j+k+l+m+n+o+p == maxAmt){
											combo = "200p: " + i/200 + " 100p: " + j/100 + " 50p: " + k/50 + 
													" 20p: " + l/20 + " 10p: " + m/10 + " 5p: " + n/5 + 
													" 2p: " + o/2 + " 1p: " + p;
											combos.add(combo);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		outputList(combos);
		this.total = combos.size();
	}
	
	private void outputList(ArrayList<String> arrList){
		for(int i = 0; i < arrList.size(); i++){
			System.out.println(arrList.get(i));
		}
	}
	
	public int getTotal(){
		return total;
	}

}
