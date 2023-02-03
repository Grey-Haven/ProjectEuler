package problem039;

import java.util.ArrayList;

/**
 * If p is the perimeter of a right angle triangle with integral length sides, 
 * {a,b,c}, there are exactly three solutions for p = 120.
 *
 * {20,48,52}, {24,45,51}, {30,40,50}
 *
 * For which value of p <= 1000, is the number of solutions maximized?
 *
 * Answer: 840
 *
 * @since Jul 24, 2013 1:18:24 PM
 * @author st477134
 *
 */
public class IntRightTriangle {
	
	int max;
	ArrayList<int []> maxCombos;
	
	public IntRightTriangle(){
		this(1);
	}
	
	public IntRightTriangle(int max){
		this.max = max;
	}
	
	public static void main(String [] args){
		
		IntRightTriangle irt = new IntRightTriangle(1000);
		irt.run();
		
		System.out.println(irt.getMaxCombos());
		System.out.println(irt.getMaxCombosPerim());
		
	}
	
	public void run(){
		
		ArrayList<int []>combos = new ArrayList<int []>();
		ArrayList<int []>maxCombos = new ArrayList<int []>();
		
		//perimeter size
		for(int p = 3; p <= max; p++){
			
			//side a
			for(int a = 1; a <= p/2; a++){
				
				//side b
				for(int b = 1; b <= max/2; b++){
					
					int aSq = a*a;
					int bSq = b*b;
					int cSq = aSq + bSq; //side c squared
					
					if(a + b + Math.sqrt(cSq) == p){
						int [] sides = {a, b, (int) Math.sqrt(cSq)};
						combos.add(sides);
					}
					
				}
				
			}
			if(combos.size() > maxCombos.size()){
				maxCombos = new ArrayList<int []>(combos);
			}
			combos = new ArrayList<int []>();
			
		}
		
		this.maxCombos = new ArrayList<int []>(maxCombos);
		
	}
	
	public int getMaxCombos(){
		return maxCombos.size();
	}
	
	public int getMaxCombosPerim(){
		return (maxCombos.get(0)[0] + maxCombos.get(0)[1] + maxCombos.get(0)[2]);
	}
	
	public ArrayList<int []> getMaxCombosList(){
		return new ArrayList<int []>(maxCombos);
	}

}
