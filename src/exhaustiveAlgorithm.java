import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class exhaustiveAlgorithm {
	public static int size = 4;
	public static int square[][] = new int[size][size];
	
	public static void main(String[] args) {
		

		int squareSum = size*(size*size+1)/2;
		//Integer[] values = new Integer[size*size];
		List values1 = new ArrayList();

		//populate values array with correct numbers
		for (int i = 0; i < size*size ; i++){
			values1.add(i+1);
			System.out.println(java.util.Arrays.toString(values1.toArray()));
		}
		/*
		//populate values array with correct numbers
		for (int i = 0; i < values.length ; i++){
			values[i] = i+1;
			//System.out.print(values[i] + "\n");
		}
		*/
		//create loop that shuffles array and load data into matrix
		//test each matrix to determine if it is a valid magic circle
		
		//option randomly shuffle to test other functions...
		System.out.print("testing exhaustive search\n");
		permute(values1,0);
		
		
		/*
		 * 
		for (int i = 0; i < size*size; i++){
			for( int j = 0; j < size*size; j++){
				//swap to create every version
				int temp =  values[j];
				values[j] = values[i];
				values[i] = temp;
				
				for (int k = 0; k < values.length ; k++){
					System.out.print(values[k]);
				}
				System.out.print("\n");
				//populate
				int index = 0;
				for (int x=0; x < size; x++){
					for (int y=0; y < size; y++){
						//System.out.print(values[index] + " \n inded:" + index + "\n");
						square[x][y] = values[index];
						index++;
					}
				}
				if (isMagicSquare(square,size)){
					print(square,size);
				}
			}
		}
		*/
		/*
		System.out.print("testing random search\n");
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
					//System.out.print(values[index] + " \n inded:" + index + "\n");
					square[x][y] = values[index];
					index++;
				}
			}
			if (isMagicSquare(square,size)){
				print(square,size);
			}

			
			count++;
		}
		
		*/
		
		
		
		System.out.print("test size 3\n");
		int squareMagic3[][] = new int[][]{
				{2,7,6},
				{9,5,1},
				{4,3,8}
			};
		if (isMagicSquare(squareMagic3,3)){
			print(squareMagic3,3);
		}
		System.out.print("test size 4\n");
		int squareMagic4[][] = new int[][]{
				{7,12,1,14},
				{2,13,8,11},
				{16,3,10,5},
				{9,6,15,4}
			};
		if (isMagicSquare(squareMagic4,4)){
			print(squareMagic4,4);
		}
		
		
	}
    static void permute(java.util.List<Integer> arr, int k){
        for(int i = k; i < arr.size(); i++){
            java.util.Collections.swap(arr, i, k);
            permute(arr, k+1);
            java.util.Collections.swap(arr, k, i);
        }
        if (k == arr.size() -1){
            //System.out.println(java.util.Arrays.toString(arr.toArray()));
			//populate
			int index = 0;
			for (int x=0; x < size; x++){
				for (int y=0; y < size; y++){
					//System.out.print(values[index] + " \n inded:" + index + "\n");
					square[x][y] = arr.get(index);
					index++;
				}
			}
			if (isMagicSquare(square,size)){
				print(square,size);
			}
			
            
        }
    }
	static boolean isMagicSquare(int[][] square, int size){
		boolean retval = false;
		int hSum = 0;
		int vSum = 0;
		int squareSum = size*(size*size+1)/2;
		//check horizontal
		for (int i= 0; i < size; i++){
			hSum = 0;
			for (int j = 0; j < size; j++){
				if (j == 0) hSum = square[i][j];
				else{
					hSum = hSum + square[i][j];
				}
			}
			if (hSum != squareSum) break;
		}
		
		//check vertical
		for (int i= 0; i < size; i++){
			vSum = 0;
			for (int j = 0; j < size; j++){
				if (j == 0) vSum = square[j][i];
				else{
					vSum = vSum + square[j][i];
				}
			}
			if (vSum != squareSum) break;
		}
		
		if (hSum == squareSum && vSum == squareSum) retval = true;
		return retval;
		
	}
	int[] permute(){
		int[] retValues;
		
		
		return retValues;
	}
	
	//need function to print
	static void print(int[][] square, int size){
		
		for (int i= 0; i < size; i++){
			for (int j = 0; j < size; j++){
				
				System.out.print(square[i][j] + "\t");
				//System.out.print("i: " + i);
				
			}
			System.out.print("\n");
		}
		System.out.print("\n");

		
	}
}
