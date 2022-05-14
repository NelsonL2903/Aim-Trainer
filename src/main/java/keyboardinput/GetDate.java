package keyboardinput;

import java.util.Scanner;

public class GetDate {

	public static void main(String[] args) {
		// TODO: fix the bug
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter the date in this format: YYYY/MM/DD");
		String dateStr = keyboard.nextLine();
		System.out.println("Todays date is " + dateStr);
		String[] strArr = dateStr.split("/");
		int year = Integer.parseInt(strArr[0]);
		int month = Integer.parseInt(strArr[1]);
		int day = Integer.parseInt(strArr[2]);
		System.out.println("Year is " + year);
		System.out.println("Month is " + month);
		System.out.println("Day is " + day);
	}

}
