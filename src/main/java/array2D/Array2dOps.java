package array2D;

public class Array2dOps {

	int[][] array;
	
	public static void main(String[] args) {

		Array2dOps a2d = new Array2dOps();
		
		a2d.init1();
		a2d.initForLoop();
		a2d.printArray();
	}
	
	public void init1() {
		
		array = new int[][]{{1,2,3,4,5},{2,4,6,8,10},{3,6,9,12,15}};
	}
	
	public void initForLoop() {
		int r = 0;
		int v = 11;
		for (int i = 0; i < 3; ++i) {
			int c = 0;
			for (int j = 0; j < 5; ++j) {
				array[r][c] = v;
				++c;
				++v;
			}
			v = v + 5;
			++r;
		}
	}
	
	public void printArray() {
		int r = 0;
		for(int i = 0; i < 3; ++i) {
			int c = 0;
			for (int j = 0; j < 5; ++j) {
				System.out.print(array[r][c] + " ");
				++c;
			}
			System.out.println("");
			++r;
		}
	}

}
