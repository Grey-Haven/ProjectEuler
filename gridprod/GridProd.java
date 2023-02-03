package gridProd;


/**
 * In the 20X20 grid below, four numbers along a diagonal line 26 * 63 * 78 * 14
 *
 *
 * Rows: i
 * Columns: j
 *
 * 08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08
 * 49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00
 * 81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65
 * 52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91
 * 22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80
 * 24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50
 * 32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70
 * 67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21
 * 24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72
 * 21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95
 * 78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92
 * 16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57
 * 86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58
 * 19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40
 * 04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66
 * 88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69
 * 04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36
 * 20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16
 * 20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54
 * 01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48
 * The product of these numbers is 26 * 63 * 78 * 14 = 1788696.
 *
 * What is the greatest product of four adjacent numbers in the same direction 
 * (up, down, left, right, or diagonally) in the 20X20 grid?
 *
 * @author st477134
 *
 */
public class GridProd {
	
	public GridProd(){ }

	public static void main(String [] args){
		GridProd gp = new GridProd();
		gp.run();
	}
	
	public void run(){
		
		int largest = 0;
		
		int largest_row = 0;
		int largest_column = 0;
		int largest_fdiag = 0;
		int largest_bdiag = 0;
		
		int product;
		
		int [] [] grid = setUpArray();
		
		//Rows
		for(int i = 0; i < 20; i++){
			for(int j = 0; j+3 < 20; j++){
				product = grid[i][j] * grid[i][j+1] * grid[i][j+2] * grid[i][j+3];
				largest_row = (product > largest_row) ? product : largest_row;
			}
		}
		
		System.out.println(largest_row);
		
		//Columns
		for(int i = 0; i+3 < 20; i++){
			for(int j = 0; j < 20; j++){
				product = grid[i][j] * grid[i+1][j] * grid[i+2][j] * grid[i+3][j];
				largest_column = (product > largest_column) ? product : largest_column;
			}
		}
		
		System.out.println(largest_column);
		
		//Diagonals facing forward
		for(int i = 0; i+3 < 20; i++){
			for(int j = 0; j+3 < 20; j++){
				product = grid[i][j] * grid[i+1][j+1] * grid[i+2][j+2] * grid[i+3][j+3];
				largest_fdiag = (product > largest_fdiag) ? product : largest_fdiag;
			}
		}
		
		System.out.println(largest_fdiag);
		
		//Diagonals facing backward
		for(int i = 0; i+3 < 20; i++){
			for(int j = 3; j < 20; j++){
				product = grid[i][j] * grid[i+1][j-1] * grid[i+2][j-2] * grid[i+3][j-3];
				largest_bdiag = (product > largest_bdiag) ? product : largest_bdiag;
			}
		}
		
		System.out.println(largest_bdiag);
		
		largest = getLargest(largest_row, largest_column, largest_fdiag, largest_bdiag);
		
		System.out.println(largest);
		
	}
	
	private int getLargest(int a, int b, int c, int d){
		
		int largest;
		
		largest = (a>b) ? a : b;
		largest = (largest > c) ? largest : c;
		largest = (largest > d) ? largest : d;
		
		return largest;
		
	}
	
	private int [] [] setUpArray(){
		int [] [] gridArr = new int [20][20];
		
		int [] tempArr0 = {8, 2, 22, 97, 38, 15, 0, 40, 0, 75, 4, 5, 7, 78, 52, 12, 50, 77, 91, 8};
		int [] tempArr1 = {49, 49, 99, 40, 17, 81, 18, 57, 60, 87, 17, 40, 98, 43, 69, 48, 4, 56, 62, 0};
		int [] tempArr2 = {81, 49, 31, 73, 55, 79, 14, 29, 93, 71, 40, 67, 53, 88, 30, 3, 49, 13, 36, 65};
		int [] tempArr3 = {52, 70, 95, 23, 04, 60, 11, 42, 69, 24, 68, 56, 01, 32, 56, 71, 37, 02, 36, 91};
		int [] tempArr4 = {22, 31, 16, 71, 51, 67, 63, 89, 41, 92, 36, 54, 22, 40, 40, 28, 66, 33, 13, 80};
		int [] tempArr5 = {24, 47, 32, 60, 99, 03, 45, 02, 44, 75, 33, 53, 78, 36, 84, 20, 35, 17, 12, 50};
		int [] tempArr6 = {32, 98, 81, 28, 64, 23, 67, 10, 26, 38, 40, 67, 59, 54, 70, 66, 18, 38, 64, 70};
		int [] tempArr7 = {67, 26, 20, 68, 02, 62, 12, 20, 95, 63, 94, 39, 63, 8, 40, 91, 66, 49, 94, 21};
		int [] tempArr8 = {24, 55, 58, 05, 66, 73, 99, 26, 97, 17, 78, 78, 96, 83, 14, 88, 34, 89, 63, 72};
		int [] tempArr9 = {21, 36, 23, 9, 75, 00, 76, 44, 20, 45, 35, 14, 00, 61, 33, 97, 34, 31, 33, 95};
		int [] tempArr10 = {78, 17, 53, 28, 22, 75, 31, 67, 15, 94, 03, 80, 04, 62, 16, 14, 9, 53, 56, 92};
		int [] tempArr11 = {16, 39, 05, 42, 96, 35, 31, 47, 55, 58, 88, 24, 00, 17, 54, 24, 36, 29, 85, 57};
		int [] tempArr12 = {86, 56, 00, 48, 35, 71, 89, 07, 05, 44, 44, 37, 44, 60, 21, 58, 51, 54, 17, 58};
		int [] tempArr13 = {19, 80, 81, 68, 05, 94, 47, 69, 28, 73, 92, 13, 86, 52, 17, 77, 04, 89, 55, 40};
		int [] tempArr14 = {04, 52, 8, 83, 97, 35, 99, 16, 07, 97, 57, 32, 16, 26, 26, 79, 33, 27, 98, 66};
		int [] tempArr15 = {88, 36, 68, 87, 57, 62, 20, 72, 03, 46, 33, 67, 46, 55, 12, 32, 63, 93, 53, 69};
		int [] tempArr16 = {04, 42, 16, 73, 38, 25, 39, 11, 24, 94, 72, 18, 8, 46, 29, 32, 40, 62, 76, 36};
		int [] tempArr17 = {20, 69, 36, 41, 72, 30, 23, 88, 34, 62, 99, 69, 82, 67, 59, 85, 74, 04, 36, 16};
		int [] tempArr18 = {20, 73, 35, 29, 78, 31, 90, 01, 74, 31, 49, 71, 48, 86, 81, 16, 23, 57, 05, 54};
		int [] tempArr19 = {01, 70, 54, 71, 83, 51, 54, 69, 16, 92, 33, 48, 61, 43, 52, 01, 89, 19, 67, 48};
		
		gridArr[0] = tempArr0;
		gridArr[1] = tempArr1;
		gridArr[2] = tempArr2;
		gridArr[3] = tempArr3;
		gridArr[4] = tempArr4;
		gridArr[5] = tempArr5;
		gridArr[6] = tempArr6;
		gridArr[7] = tempArr7;
		gridArr[8] = tempArr8;
		gridArr[9] = tempArr9;
		gridArr[10] = tempArr10;
		gridArr[11] = tempArr11;
		gridArr[12] = tempArr12;
		gridArr[13] = tempArr13;
		gridArr[14] = tempArr14;
		gridArr[15] = tempArr15;
		gridArr[16] = tempArr16;
		gridArr[17] = tempArr17;
		gridArr[18] = tempArr18;
		gridArr[19] = tempArr19;
		
		return gridArr;
	}
	
}
