import java.io.BufferedWriter;
import java.io.Console;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class exhaustiveAlgorithm {
	public static int size = 4;
	public static int permutations = 0;
	
	public static int square[][] = new int[size][size];
	
	public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException, IOException {
		
		long startTime = System.currentTimeMillis();
		
		int squareSum = size*(size*size+1)/2;
		//Integer[] values = new Integer[size*size];
		List values1 = new ArrayList();

		//populate values array with correct numbers
		for (int i = 0; i < size*size ; i++){
			values1.add(i+1);
			//System.out.println(java.util.Arrays.toString(values1.toArray()));
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
		System.out.print("magic number: " + 3*(3*3+1)/2 + "\n");
		int squareMagic3[][] = new int[][]{
				{2,7,6},
				{9,5,1},
				{4,3,8}
			};
		if (isMagicSquare(squareMagic3,3)){
			print(squareMagic3,3);
		}
		System.out.print("test size 4\n");
		System.out.print("magic number: " + 4*(4*4+1)/2 + "\n");
		int squareMagic4[][] = new int[][]{
				{7,12,1,14},
				{2,13,8,11},
				{16,3,10,5},
				{9,6,15,4}
			};
		if (isMagicSquare(squareMagic4,4)){
			print(squareMagic4,4);
		}
		
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total runtime = " + totalTime +"ms");
		System.out.println("Total permutations = " + permutations);
	}
    static void permute(java.util.List<Integer> arr, int k) throws UnsupportedEncodingException, FileNotFoundException, IOException{
    	permutations++;
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
				printToFile("output.txt",square,size);
			}
        }
    }
	public static void printToFile(String filename,int[][] square, int size) throws UnsupportedEncodingException, FileNotFoundException, IOException{
		
		try (FileWriter fw = new FileWriter(filename, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw))
			{
			out.println("");
			
				for (int i= 0; i < size; i++){
					for (int j = 0; j < size; j++){
						out.print(square[i][j] + "\t");
					}
					out.println("\n");
				}

			} catch (IOException e) {
			    //exception handling left as an exercise for the reader
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
		//check diagonal forwards
		int dSum = 0;
		for (int i= 0; i < size; i++){
			dSum = dSum + square[i][i];
		}
		//check diagonal backwards
		int d2Sum = 0;
		int s2 = size-1;
		for (int i= 0; i < size; i++){
			d2Sum = d2Sum + square[i][s2];
			s2--;
		}
		if (hSum == squareSum && vSum == squareSum && dSum == squareSum && d2Sum == squareSum) retval = true;
		return retval;
		
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
