package random;

import java.util.Random;

public class RandomInt {
	public static void main(String args[]) {
		
		int[] array = new int[20];
		
		Random randomGenerator = new Random();
		int low = -40;
		// The low variable sets the minimum value that the random number can be, and is inclusive
		int high = 36;
		// The high variable states the maximum value that the random number can be but is high variable is exclusive

		for (int i = 0; i < 20; ++i) {
			int rand = randomGenerator.nextInt(high - low) + low;
			System.out.println(rand + " ");
			array[i] = rand;
		}
	}
}
