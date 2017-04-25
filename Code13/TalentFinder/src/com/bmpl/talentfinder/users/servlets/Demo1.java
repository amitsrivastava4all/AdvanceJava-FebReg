package com.bmpl.talentfinder.users.servlets;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

public class Demo1 {
	public static PrintStream getOut() throws FileNotFoundException{
		String path = "/Users/amit/Documents/FileHandlingTesting/Test123/sample.txt";
		PrintStream ps = new PrintStream(new File(path));
		return ps;
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		ArrayList l = new ArrayList(); // Non - Generic
		l.add(10);
		l.add(20.90);
		l.add("Hello");
		//l.get
		PrintStream out = Demo1.getOut();
		System.setOut(out);
		System.out.println("Hello Java");
		Object t = "Hello";
		t = 90;
		t = 100.29;
		t = true;

	}

}
