package random;

import java.util.Random;

public class RandomChars {

	int N = 20;
	char[] charArray = new char[N];

	public static void main(String args[]) {
		RandomChars randomChars = new RandomChars();

		randomChars.initialize();
		randomChars.print();

	}

	// print out the charArray
	private void print() {
// put code here
		for (int i = 0; i < N; ++i) {
			System.out.println(charArray[i]);
		}
}

	// set the elements of charArray to a random
	// char between 'A' and 'Z'
	private void initialize() {
		// put code here
		Random randomGenerator = new Random();
		int low = 65;
		int high = 91;
		for (int i = 0; i < 20; ++i) {
			int rand = randomGenerator.nextInt(high - low) + low;
			charArray[i] = (char) rand;
	}
	}
}
