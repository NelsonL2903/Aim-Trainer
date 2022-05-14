package arrays1d;

import java.util.Random;

public class LinearIntSearch {

	int[] array;

	public static void main(String[] args) {
		int N = 50;
		LinearIntSearch ls = new LinearIntSearch();
		ls.initializeRandom(N);
		int searchInt = 66;

		ls.dump();
		int idx = ls.find(searchInt);
		if (idx == -1) {
			System.out.println(searchInt + " not found in array.");
		} else {
			System.out.println(searchInt + " found in array at index = " + idx);
		}
	}

	public void initializeRandom(int N) {
		array = new int[N];
		Random ran = new Random();
		for (int i = 0; i < array.length; ++i) {
			// add a random character between A and Z
			array[i] = (ran.nextInt(101));
		}
	}




	// look for searchInt in array.
	// return index of searchInt in array
	// otherwise return -1 if searchInt is not in array
	public int find(int searchInt) {
		int index = -1; // -1 is an illegal index into an array
		for (int i = 0; i < array.length; ++i) {
			if (array[i] == searchInt) {
				index = i; // remember the index we are at
				break; // we have found searchChar, exit loop
			}
		}
		return index; //
	}

	public void dump() {
		for (int i = 0; i < array.length; ++i) {
			System.out.println(array[i] + " ");
		}
		System.out.println();
	}

}
