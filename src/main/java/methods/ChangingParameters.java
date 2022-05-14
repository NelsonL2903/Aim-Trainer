package methods;

public class ChangingParameters {

	public static void main(String[] args) {
		ChangingParameters cpInstance = new ChangingParameters();

		int a = 3;
		String s = "hello";

		System.out.println("in main, a is " + a);

		cpInstance.method1(a);
		System.out.println("back from method1, now in main, a is " + a);

		cpInstance.method2(a);
		System.out.println("back from method2, now in main, a is " + a);

		System.out.println("in main, s is " + s);
		cpInstance.method3(s);
		System.out.println("back from method3, now in main, s is " + s);

	}

	private void method1(int a) {
		System.out.println("in method1, a is " + a);
		a = 42;
		System.out.println("in method1, a is " + a);
	}

	private void method2(int intParameter) {
		System.out.println("in method2, intParameter is " + intParameter);
		intParameter = 27;
		System.out.println("in method1, intParameter is " + intParameter);
	}

	private void method3(String s) {
		System.out.println("in method3, s is " + s);
		s = "bar";
		System.out.println("in method3, s is " + s);
	}

}