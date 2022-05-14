package methods;

public class ChangingClassVariables {
	int aClassInt;

	public static void main(String[] args) {

		ChangingClassVariables cav = new ChangingClassVariables();
		cav.aClassInt = 42;
		System.out.println("in main, aClassInt is " + cav.aClassInt);

		cav.method1();
		System.out.println("in main, back from method 1, aClassInt is " + cav.aClassInt);

		cav.method2(cav.aClassInt);
		System.out.println("in main, back from method 2, aClassInt is " + cav.aClassInt);

	}

	private void method1() {
		aClassInt = 5342;
		System.out.println("in method 1, aClassInt is " + aClassInt);
	}

	private void method2(int anInt) {
		anInt = -1234;
		System.out.println("in method 2, aClassInt is " + anInt);
	}
}