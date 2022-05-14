package icsfileio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Ics4uFileIo {

	public static void main(String[] args) {
		Ics4uFileIo fileio = new Ics4uFileIo();
		fileio.initialize();
		fileio.write();
		fileio.read();
		fileio.print();
		fileio.print2();
	}

	//creates an array list
	private List<String> strings = new ArrayList<String>();
	
	//initializes the array by adding strings to the array list
	public void initialize() {
		for(int i = 0; i < 2; ++i) {
		strings.add("Hello!");
		strings.add("How's It Going?");
		strings.add("That's Cool!");
		strings.add("You're Awesome!");
		strings.add("What's Up?");
		}
	}
	
	//adds the strings in the array list to the file
	public void write() {
		Path path = Paths.get("myfile.txt");
	try {
	//writes the strings on the file
		Files.write(path, strings);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	//reads the file and sets the array equal to the content of the file
	public void read() {
		Path path = Paths.get("myfile.txt");
	try {
	strings = Files.readAllLines(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//prints out the whole array all at once
	public void print() {
		System.out.println(strings);
	}
	
	//prints out the array index by index
	public void print2() {
		for (String i : strings) {
			System.out.println(i);
		}
	}
	
}
