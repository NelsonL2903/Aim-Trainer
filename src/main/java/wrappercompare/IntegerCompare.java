package wrappercompare;

public class IntegerCompare {
	public static void main(String[] args) {
		int a = 444222;
		int b = a;

		System.out.println("a = " + a + " b = " + b);

		if (a == b) {
			System.out.println("a == b");
		} else {
			System.out.println("a != b");
		}

		Integer aa = 424242;
		Integer bb = 424242;

		System.out.println("aa = " + aa + " bb = " + bb);
		if (aa == bb) {
			System.out.println("a == b using == comparator");
		} else {
			System.out.println("a != b  using == comparator");
		}

		if (aa.equals(bb)) {
			System.out.println("a == b using equals method");
		} else {
			System.out.println("a != b using equals method");
		}
		Integer aaa = 444222;
		Integer bbb = aaa;

		System.out.println("aaa = " + aaa + " bbb = " + bbb);
		if (aa == bb) {
			System.out.println("a == b using == comparator");
		} else {
			System.out.println("a != b  using == comparator");
		}

		if (aa.equals(bb)) {
			System.out.println("a == b using equals method");
		} else {
			System.out.println("a != b using equals method");
		}

		if (aa.intValue() == bb.intValue()) {
			System.out.println("a == b using intValue method");
		} else {
			System.out.println("a != b using intValue method");
		}

	}
}
