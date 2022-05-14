package methods;

import java.util.ArrayList;
import java.util.List;

public class PassingArrayToMethod {

	public static void main(String[] args) {
		List<Integer> intList = new ArrayList<Integer>();

		intList.add(1);
		intList.add(3);
		intList.add(17);
		printList(intList);

		addIntToList(intList, 123);
		printList(intList);

		messUpList(intList);
		printList(intList);

	}

	public static void addIntToList(List<Integer> iList, Integer i) {
		iList.add(i);
	}

	public static void printList(List<Integer> iList) {
		for (Integer i : iList) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void messUpList(List<Integer> listOfInts) {
		listOfInts = new ArrayList<Integer>();
		listOfInts.add(13);
		listOfInts.add(16);
		listOfInts.add(22);
		listOfInts.add(2874);
	}
}
