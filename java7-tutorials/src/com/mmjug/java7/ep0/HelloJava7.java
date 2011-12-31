package com.mmjug.java7.ep0;

import java.math.BigDecimal;

public class HelloJava7 {

	public static void main(String[] args) {
		BigDecimal ver = new BigDecimal(1_7_0).divide(new BigDecimal(100));
		
		System.out.println("Hello Java 7!");
		System.out.println("JDK Version is " + ver);
	}
}
