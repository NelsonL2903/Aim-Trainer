package searching;

public class BinarySearch {
    private int comparisons = 0;

    public int getComparisons() {
   	 return comparisons;
    }

    public void setComparisons(int comparisons) {
   	 this.comparisons = comparisons;
    }

    public int search(int[] array, int key, int low, int high) {
   	 // implement the binary search here
 // don't forget to increment the number of comparisons
    	if (low > high) {
    		return -1;
    	}
    	int midix = (low + high)/2;
    	if (array[midix] == key) {
    		++comparisons;
    		return midix;
    	} else if (array[midix] > key) {
    		++comparisons;
    		return search(array, key, low, midix-1);
    	} else {
    		++comparisons;
    		return search(array, key, midix+1, high);
    	}
    }
}
