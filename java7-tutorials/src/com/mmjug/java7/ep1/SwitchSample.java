package com.mmjug.java7.ep1;

public class SwitchSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	static void writeChar(String str) {
		switch (str) {
		case "one":
			System.out.println("One is comming");
			break;
		case "two":
			System.out.println("Two is comming");
			break;
		case "three":
			System.out.println("Three is comming");
			break;
		default:
			System.out.println(str + " is comming");
			break;

		}
	}

}
