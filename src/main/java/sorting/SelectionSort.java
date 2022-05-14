package sorting;

import java.util.Random;

// A selection sort works by determining the lowest value in an array and then swapping
// the first value in the array with the smallest value in the array so that the smallest
// value is at the start of the array. This process is then repeated but now excluding the
// first value of the array. This process is continually repeated until all of the numbers
// in the array are in numerical order.
public class SelectionSort {

public static void main(String[] args) {
SelectionSort selectionSort = new SelectionSort();
int[] array = new int[20];
selectionSort.initialize(array);
selectionSort.print(array);
selectionSort.sort(array);
selectionSort.print(array);
}
private void initialize(int[] array) {
	// create an array of random integers
	Random ran = new Random();
	// for each value of the array, assigns a random number between 0 and 100
	for (int i = 0; i < array.length; ++i) {
		array[i] = (ran.nextInt(101));
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
private void sort(int[] array) {
	// you'll need a nested loop to implement selection sort
	for (int i = 0; i < array.length-1; ++i) {
		int minidx = i;
		for (int j = i + 1; j < array.length; ++j) {
			// if the current value of array[j] is less than the value of array[minidx],
			// than minidx is set equal to the value of j, this process will repeat
			// until the smallest value of the array has been found, and then the
			// smallest value will be swapped with the first value in the array
			if (array[j] < array[minidx]) {
			minidx = j;
			}
		}
		swap(array, i, minidx);
	}
}

}
