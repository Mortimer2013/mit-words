package com.mmjug.java7.ep5;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileAndPath {
	
	public static void main(String[] args) {
		Path path = Paths.get("A:","var","tomcat-7","lib","catalina.jar");
		File file = new File("A:\\var\\tomcat-7");
		
		System.out.println("path" + "\t" + path);
		System.out.println("file" + "\t" + path.toFile());
		System.out.println("file" + "\t" + file);
		System.out.println("path" + "\t" + file.toPath());
		
	}
}
