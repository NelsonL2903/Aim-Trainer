package recursion;

public class RecursiveCountDown {

	public static void main(String[] args) {
	
		RecursiveCountDown rCD = new RecursiveCountDown();
		rCD.countDown(10);
	}

	public void countDown( int i ) {
		System.out.println(i);
		if (i <= -15) {
			return;
		}
		countDown( i-1 );
	}
	
}
