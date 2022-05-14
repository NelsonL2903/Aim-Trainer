package searching;

import java.util.Random;
import java.util.Scanner;

public class LinearSearchEfficiency {
	int comparisons = 0;

	public static void main(String[] args) {

		LinearSearchEfficiency ls = new LinearSearchEfficiency();
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("enter the array size");
		int arraySize = keyboard.nextInt();
		int[] array = new int[arraySize];

		int sum = 0;
		System.out.println("enter the number of loops");
		int numberOfLoops = keyboard.nextInt();
		for (int i = 0; i < numberOfLoops; ++i) {
			ls.comparisons = 0;
			ls.initializeRandom(array, arraySize);
			ls.search(array, 42);
			sum += ls.comparisons;
		}
		System.out.println("Array size is " + arraySize);

// why is numberOfLoops cast to a double?
		// the numberOfLoops is cast to a double because, if it wasn't cast,
		// then the code would be dividing two int values, which would result 
		// in an integer answer with no decimal places which would then be 
		// converted to a double value and end up as a whole number followed by .0
		// by casting the array size to a double, you are then dividing an int
		// value by a double value which would result in the answer having decimal
		// values and not being rounded.
		double mean = sum / (double)numberOfLoops;
		System.out.println(sum + " comparisons performed in " + numberOfLoops + " loops");
		System.out.println("mean value is " + mean);
		// On average, the number of comparisons is about 60% of the array size.
		// This means that on average the code would have to compare the key to
		// about 60% of the array values before finding the key in the array.

	}

	public int getComparisons() {
		return comparisons;
	}

	public void setComparisons(int comparisons) {
		this.comparisons = comparisons;
	}

	// search for key within array
	// return the index of the key if key is in array
	// return -1 if key is not in array
	public int search(int[] array, int key) {
		// in the loop for the search,
		// increment the comparisons variable
		int index = -1;
		for (int i = 0; i < array.length; ++i) {
			++comparisons;
			if (array[i] == key) {
				index = i;
				break;
			}
		}
		return index;
	}

	private void initializeRandom(int[] array, int N) {
		// initialize the array to a random integer between 0 and N
		// where N is the array length
		Random rand = new Random();
		for (int i = 0; i < N; ++i) {
			array[i] = rand.nextInt((N + 1));
	}
	}
}
