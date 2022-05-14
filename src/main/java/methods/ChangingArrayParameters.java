package methods;

public class ChangingArrayParameters {

	public static void main(String[] args) {
		ChangingArrayParameters cpInstance = new ChangingArrayParameters();

		int[] myArray = { 3, 4, 5 };
		System.out.println("in main, myArray is ");
		cpInstance.printArray(myArray);

		cpInstance.method1(myArray);
		System.out.println("back from method1, now in main, myArray is ");
		cpInstance.printArray(myArray);

		cpInstance.method2(myArray);
		System.out.println("back from method2, now in main, myArray is ");
		cpInstance.printArray(myArray);

		cpInstance.method3(myArray);
		System.out.println("back from method3, now in main, myArray is ");
		cpInstance.printArray (myArray);

	}

	private void printArray(int[] array) {
		for (int a : array) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	private void method1(int[] a) {
		a[0] = 42;
		a[1] = 42;
		a[2] = 42;
		System.out.println("in method1, a is ");
		printArray(a);
	}

	private void method2(int[] arrayxyz) {
		arrayxyz = new int[] { 16, 17, 19, 200 };
		System.out.println("in method2, myArray is ");
		printArray(arrayxyz);
	}

	private void method3(int[] array123) {
		array123 = new int[10];
		for (int i = 0; i < array123.length; ++i) {
			array123[i] = 2 * i + 113;
		}
		System.out.println("in method3, array is ");
		printArray(array123);
	}

}