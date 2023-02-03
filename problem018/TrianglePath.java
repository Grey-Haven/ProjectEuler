package problem018;

import java.util.ArrayList;

import eulerClass.EulerTools;

/**
 * By starting at the top of the triangle below and moving to adjacent numbers on the row below, 
 * the maximum total from top to bottom is 23.
 *
 *    3
 *   7 4
 *  2 4 6
 * 8 5 9 3
 *
 * That is, 3 + 7 + 4 + 9 = 23.
 *
 * Find the maximum total from top to bottom of the triangle below:
 *
 *               75
 *              95 64
 *             17 47 82
 *            18 35 87 10
 *           20 04 82 47 65
 *          19 01 23 75 03 34
 *         88 02 77 73 07 63 67
 *        99 65 04 28 06 16 70 92
 *       41 41 26 56 83 40 80 70 33
 *      41 48 72 33 47 32 37 16 94 29
 *     53 71 44 65 25 43 91 52 97 51 14
 *    70 11 33 28 77 73 17 78 39 68 17 57
 *   91 71 52 38 17 14 91 43 58 50 27 29 48
 *  63 66 04 68 89 53 67 30 73 16 69 87 40 31
 * 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
 *
 * NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route. 
 * However, Problem 67, is the same challenge with a triangle containing one-hundred rows; 
 * it cannot be solved by brute force, and requires a clever method! ;o)
 *
 * @since 2013-07-21
 * @author Stephen
 *
 */
public class TrianglePath extends EulerTools {

	int [] [] triangle;
	int total;
	ArrayList <Integer> path;

	public TrianglePath(int [] [] triangle){
		this.triangle = triangle;
	}

	public static void main(String[] args) {

		int [] [] triArr = new int [15] []; 

		int [] layer0  = {75};
		int [] layer1  = {95, 64};
		int [] layer2  = {17, 47, 82};
		int [] layer3  = {18, 35, 87, 10};
		int [] layer4  = {20, 04, 82, 47, 65};
		int [] layer5  = {19, 01, 23, 75, 03, 34};
		int [] layer6  = {88, 02, 77, 73, 07, 63, 67};
		int [] layer7  = {99, 65, 04, 28, 06, 16, 70, 92};
		int [] layer8  = {41, 41, 26, 56, 83, 40, 80, 70, 33};
		int [] layer9  = {41, 48, 72, 33, 47, 32, 37, 16, 94, 29};
		int [] layer10 = {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14};
		int [] layer11 = {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57};
		int [] layer12 = {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48};
		int [] layer13 = {63, 66, 04, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31};
		int [] layer14 = {04, 62, 98, 27, 23,  9, 70, 98, 73, 93, 38, 53, 60, 04, 23};

		triArr[0] = layer0;
		triArr[1] = layer1;
		triArr[2] = layer2;
		triArr[3] = layer3;
		triArr[4] = layer4;
		triArr[5] = layer5;
		triArr[6] = layer6;
		triArr[7] = layer7;
		triArr[8] = layer8;
		triArr[9] = layer9;
		triArr[10] = layer10;
		triArr[11] = layer11;
		triArr[12] = layer12;
		triArr[13] = layer13;
		triArr[14] = layer14;

		TrianglePath ts = new TrianglePath(triArr);
		ts.run();

		System.out.println("Total: " + ts.getTotal());
	}

	public void run(){

		int [] [] triArr = triangle;
		ArrayList <Integer> path = new ArrayList <Integer>();
		
		int leftSum;
		int rightSum;

		int totalSum = 0;
		try{
			while(true){
				
				totalSum += triArr[0][0];
				path.add(triArr[0][0]);

				int [] [] leftTri = formulateTriangle(triArr.clone(), true);
				int [] [] rightTri = formulateTriangle(triArr.clone(), false);
				
				leftSum = sumTriangle(leftTri);
				rightSum = sumTriangle(rightTri);
				
				triArr = leftSum > rightSum ? leftTri.clone() : rightTri.clone();
				
			}
		}catch(IndexOutOfBoundsException e){}

		this.total = totalSum;
		this.path = path;
		
		outputList(path);

	}

	private int sumTriangle(int [] [] triangle){

		int total = 0;

		for(int i = 0; i < triangle.length; i++){
			for(int j = 0; j < triangle[i].length; j++){
				total += triangle[i][j];
			}
		}
		return total;
	}

	private int [] [] formulateTriangle(int [] [] triangle, boolean goLeft){

		int [] [] newTriangle = new int [triangle.length-1][];

		if(goLeft){
			for(int i = 0; i < triangle.length-1; i++){
				newTriangle[i] = new int[triangle[i+1].length-1]; 
				for(int j = 0; j < triangle[i+1].length-1; j++){
					newTriangle[i][j] = triangle[i+1][j];
				}
			}
		}
		else{
			for(int i = 0; i < triangle.length-1; i++){
				newTriangle[i] = new int[triangle[i+1].length-1]; 
				for(int j = 0; j < triangle[i+1].length-1; j++){
					newTriangle[i][j] = triangle[i+1][j+1];
				}
			}
		}
		return newTriangle;
	}

	public int getTotal(){
		return total;
	}
	
	public ArrayList<Integer> getPath(){
		return path;
	}
	
}
