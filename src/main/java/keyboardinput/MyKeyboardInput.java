package keyboardinput;

import java.util.Scanner;

public class MyKeyboardInput {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("enter some text");
		String myStringAbc = keyboard.nextLine();
		System.out.println("you typed -->" + myStringAbc + "<--");
	}

}
