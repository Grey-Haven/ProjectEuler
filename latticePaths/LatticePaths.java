package latticePaths;

/**
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.
 *
 * How many such routes are there through a 20×20 grid?
 * 
 * @since 2013-07-19
 * @author st477134
 *
 */
public class LatticePaths {
	
	int height;
	int width;
	
	int numPerm;
	
	public LatticePaths(){
		this(1,1);
	}
	
	public LatticePaths(int n){
		this(n,n);
	}
	
	public LatticePaths(int n, int m){
		this.height = n-1;
		this.width = m-1;
		numPerm = 0;
	}
	
	public static void main(String [] args){
		LatticePaths lp = new LatticePaths(12);
		lp.run();
	}
	
	public void run(){
		
		long [] [] gridArr = new long[height][width];
		
		gridArr[height-1][width-1] = 0;
		gridArr[height-2][width-1] = 1;
		gridArr[height-1][width-2] = 1;
		
		for(int i = gridArr.length-1; i >= 0; i--){
			for(int j = gridArr[i].length-1; j >= 0; j--){
				gridArr[height-2][width-1] = 1;
				gridArr[height-1][width-2] = 1;
				if(i == gridArr.length-1 && j == gridArr[i].length-1){
					gridArr[i][j] = 0;
				}
				else if(i == gridArr.length-1){
					gridArr[i][j] = 0 + gridArr[i][j+1];
				}
				else if(j == gridArr[i].length-1){
					gridArr[i][j] = gridArr[i+1][j] + 0;
				}
				else{
					gridArr[i][j] = gridArr[i+1][j] + gridArr[i][j+1];
				}
			}
		}
		
		printFinalArray(gridArr);
		
	}
	
	private int squarePermutations(){
		
		int totalPermutations = 0;
		
		String binary;
		int numOnes = 0;
		int numZeros = 0;
		
		boolean isValid = true;
		
		for(long i = (long) Math.pow(2, height)-1; i < Math.pow(2, (height+width)); i++){
			numOnes = 0;
			numZeros = 0;
			isValid = true;
			binary = formatBinString(Long.toBinaryString(i));
	//		System.out.println(binary);
		//	System.exit(0);
			for(int j = 0; j < binary.length(); j++){
				if(binary.substring(j, j+1).equals("1")){
					numOnes++;
				}
				if(binary.substring(j, j+1).equals("0")){
					numZeros++;
				}
				if(numZeros > height || numOnes > width){
					break; //the next boolean test will catch the discrepancy
				}
			}
			if(numZeros != height || numOnes != width){
				isValid = false;
			}
			if(isValid){
		//		System.out.println(binary);
				totalPermutations++;
			}
		}
		
		return totalPermutations;
	}
	
	private String formatBinString(String binStr){
		
		String tempStr = "";
		
		for(int i = binStr.length(); i < height + width; i++){
			tempStr += "0";
		}
		
		return tempStr + binStr;
		
	}

	private void printFinalArray(long [] [] finArr){
		
		String formatter = "%" + Long.toString(finArr[0][0]).length() + "d";
		
		for(int i = 0; i < finArr.length; i++){
			for(int j = 0; j < finArr[i].length; j++){
				System.out.print(String.format(formatter, finArr[i][j]) + " ");
			}
			System.out.println("");
		}
		
	}
}
