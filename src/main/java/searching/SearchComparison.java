package searching;

import java.util.Random;
import sorting.BubbleSort;

public class SearchComparison {

    public static void main(String[] args) {
   	 SearchComparison searchComparison = new SearchComparison();

   	 LinearSearchEfficiency linearSearch = new LinearSearchEfficiency();
   	 BinarySearch binarySearch = new BinarySearch();
   	 BubbleSort bubbleSort = new BubbleSort();

   	 int arraySize = 1000;
   	 int[] array = new int[arraySize];

   	 int linearSum = 0;
   	 int binarySum = 0;
   	 int numberOfLoops = 500;

   	 for (int i = 0; i < numberOfLoops; ++i) {
   		 searchComparison.initializeRandom(array);

   		 linearSearch.setComparisons(0);
   		 linearSearch.search(array, 42);
   		 linearSum += linearSearch.getComparisons();

   		 binarySearch.setComparisons(0);
   		 bubbleSort.sort(array);
   		 binarySearch.search(array, 42, 0, array.length-1);
   		 binarySum += binarySearch.getComparisons();

   	 }

   	 System.out.println(" =======================  Linear search ==========================");
   	 double mean = linearSum / numberOfLoops;
   	 System.out.println(linearSum + " comparisons performed in " + numberOfLoops + " loops");
   	 System.out.println("mean value is " + mean);

   	 System.out.println(" =======================  Binary search ==========================");
   	 mean = binarySum / numberOfLoops;
   	 System.out.println(binarySum + " comparisons performed in " + numberOfLoops + " loops");
   	 System.out.println("mean value is " + mean);
    }

    public void initializeRandom(int[] array) {
   	 Random randGen = new Random();
   	 for (int i = 0; i < array.length; ++i) {
   		 array[i] = randGen.nextInt(array.length);
   	 }
    }
}
