package sorting;

import java.util.Random;

public class BubbleSort {

	public static void main(String[] args) {
	
		// The bubble sort works by swapping values in an array so that the values in the array are in numerical order.
		// The code will compare the first and second values of an array and if the first is larger than the second,
		// it swaps them. The code will then compare the second and third values, and if the second value is bigger
		// than the third, the two values will be swapped. This pattern is continued until the code has compared all
		// the values of the array. This process is then repeated but compares one less value, as the largest value
		// will now be in place at the end of the array. This whole process is continually repeated until the array is
		// in numerical order.
		BubbleSort bubbleSort = new BubbleSort();
		int[] array = new int[20];
		bubbleSort.initialize(array);
		bubbleSort.print(array);
		bubbleSort.sort(array);
		bubbleSort.print(array);

	}

	private void initialize(int[] array) {
		// create an array of random integers
		Random ran = new Random();
		// for each value of the array, assigns a random number between 0 and 100
		for (int i = 0; i < array.length; ++i) {
			array[i] = (ran.nextInt(101));
		}
	}
	
	public void sort(int[] array) {
		// you'll need a nested loop to implement bubble sort
		// call the first loop index i
		// i will go from 0 to array.length-1
		// call the second loop index j
		// j will go from 0 to array.length-i-1
		
		// compare array[j] and array[j+1]
		// if array[j+1] is smaller than array[j]
		// swap the array[j+1] and array[j]
		
		for (int i = 0; i < (array.length - 1); ++i) {
			for (int j = 0; j < (array.length - i - 1); ++j) {
				// compares the two adjacent values in the array and if the first is bigger than the second,
				// calls the swap method to swap the two values
				if (array[j] > array[j+1]) {
					swap(array, j, (j+1));
				}
			}
		}
		
	}

	private void swap(int[] array, int a, int b) {
		// swap array[a] and array[b]
		int store = array[a];
		array[a] = array[b];
		array[b] = store;
	}
	
	private void print(int[] array) {
		// print the array
		for (int i = 0; i < array.length; ++i) {
			System.out.print(array[i] + " ");
		}
		System.out.println("");
	}

}
