package methods;

public class PassingParameters {

	public static void main(String[] args) {
		PassingParameters pp = new PassingParameters();
		pp.method1();
		pp.method2("this is a test");
		pp.method3(42);
		pp.method4("another test", 314159);
	}

	public void method1() {
		System.out.println("this method takes no parameters");
	}

	public void method2(String a) {
		System.out.println("this method takes one parameter, which is a string: " + a);
	}

	public void method3(int a) {
		System.out.println("this method takes one parameter, which is an int: " + a);
	}

	public void method4(String a, int b) {
		System.out.println("this method takes two parameters, a string (" + a + ") and and an int(" + b + ")");
	}
}