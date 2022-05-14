package typesizes;

public class TypeSize {

	public static void main(String[] arg) {

		TypeSize.biggestInt();
		System.out.println(" ");
		TypeSize.biggestDouble();
		System.out.println(" ");
		TypeSize.smallestDouble();
	}

	private static void biggestInt() {
		System.out.println("=== biggest int ===");
		int i = 1;
		while (i < i + 1) { // does this line make sense?
			i = i + 1;
		}
		System.out.println("biggest int is " + i);
	}

	private static void biggestDouble() {
		System.out.println("=== biggest double ===");
		double i = 1;
		while (i == (i * 2) - i) {
			i = i * 2;
		}
		System.out.println("biggest double is " + i);
	}

	private static void smallestDouble() {
		System.out.println("=== smallest double ===");
		double epsilon = 1;
		while (1.0 != 1 + epsilon) {
			epsilon = epsilon * 0.99;
		}
		System.out.println("double epsilon = " + epsilon);
	}

}
