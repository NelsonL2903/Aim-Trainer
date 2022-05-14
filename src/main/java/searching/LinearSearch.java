package searching;

import java.util.Random;
import java.util.Scanner;

public class LinearSearch {

	public static void main(String[] args) {

		// get arraySize from keyboard
		int arraySize;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter the array length");
		arraySize = keyboard.nextInt();

		int[] array = new int[arraySize];

		LinearSearch ls = new LinearSearch();
		ls.initializeRandom(array, arraySize);
		ls.dump(array);

		int searchInt;
		// get searchInt from keyboard
		System.out.println("Please enter the integer you would like to search for");
		searchInt = keyboard.nextInt();

		int idx = ls.find(array, searchInt, arraySize);
		if (idx == -1) {
			System.out.println(searchInt + " not found in array.");
		} else {
			System.out.println(searchInt + " found in array at index = " + idx);
		}
	}

	public void initializeRandom(int[] array, int arraySize) {
		// initialize array to random integers
		// between 0 and array.length

		Random rand = new Random();
		for (int i = 0; i < arraySize; ++i) {
			array[i] = rand.nextInt(arraySize + 1);
		}

	}

	// look for searchInt in array.
	// return index of searchInt in array
	// otherwise return -1 if searchInt is not in array
	public int find(int[] array, int searchInt, int arraySize) {
		// initialize
		int index = -1;
		for (int i = 0; i < arraySize; ++i) {
			if (array[i] == searchInt) {
				index = i;
				break;
			}
		}

		// loop through array
		// search for searchInt
		return index;
	}

	// print out the array
	public void dump(int[] array) {
		for (int i = 0; i < array.length; ++i) {
			System.out.println(array[i] + " ");
		}
		System.out.println();
	}

}
