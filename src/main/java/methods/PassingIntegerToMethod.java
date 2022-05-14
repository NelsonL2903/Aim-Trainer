package methods;

public class PassingIntegerToMethod {

	public static void main(String[] args) {
		Integer x = 42;
		doMeth(x);
		System.out.println(x);
	}

	public static void doMeth(Integer x) {
		x = 7;
	}
}
