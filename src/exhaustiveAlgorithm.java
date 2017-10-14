import java.io.Console;
import java.util.Arrays;
import java.util.Collections;


public class exhaustiveAlgorithm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int size = 3;
		int squareSum = size*(size*size+1)/2;
		Integer[] values = new Integer[size*size];
		int square[][] = new int[3][3];
		
		//populate values array with correct numbers
		for (int i = 0; i < values.length ; i++){
			values[i] = i+1;
			
		}
		
		//create loop that shuffles array and load data into matrix
		//test each matrix to determine if it is a valid magic circle
		//option randomly shuffle to test other functions...

		
		int count = 0;
		while (count < 10){
			Collections.shuffle(Arrays.asList(values));
			for (int i = 0; i < values.length ; i++){
				//System.out.print(values[i]+ "\n");
			}
			//populate
			int index = 0;
			for (int x=0; x < size; x++){
				for (int y=0; y < size; y++){
					square[x][y] = values[index];
					index++;
				}
			}
			
			
			print(square,size);

			count++;
		}

		
	}
	
	int[] permute(){
		int[] retValues;
		
		
		return retValues;
	}
	//need function to print
	static void print(int[][] square, int size){
		
		for (int i= 0; i < size; i++){
			for (int j = 0; j < size; j++){
				
				System.out.print(square[i][j]);
				//System.out.print("i: " + i);
				
			}
			System.out.print("\n");
		}
		System.out.print("\n");

		
	}
}
