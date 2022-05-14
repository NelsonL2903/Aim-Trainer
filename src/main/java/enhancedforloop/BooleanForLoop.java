package enhancedforloop;

import java.util.Random;

public class BooleanForLoop {
	final int N = 50;
	Boolean boolArray[] = new Boolean[N];

	public static void main(String[] args) {
		BooleanForLoop bfl = new BooleanForLoop();
		bfl.initialize();
		bfl.print();
		System.out.println(" ");
		bfl.twoTrue();
	}

	/*
	 * Print out the boolArray using enhanced for loop.
	 */
	private void print() {
		for (Boolean b : boolArray) {
			System.out.println(b);
		}
	}

	/*
	 * Iterate over boolArray and print "two true" whenever two consecutive true
	 * values occur.
	 */
	private void twoTrue() {
		// previous stores previous value in array
		Boolean previous = null;

		for (Boolean b : boolArray) {
			System.out.println(b);
			if (previous != null && b == true && previous == true) {
				System.out.println("Two True");
			}
			previous = b;

		}

		// iterate over boolArray with enhanced for loop
	}

	/*
	 * Set boolArray to random values of true or false
	 */
	private void initialize() {
		Random rand = new Random();
		for (int i = 0; i < N; ++i) {
			boolArray[i] = rand.nextBoolean();
		}
	}
}
