package com.mmjug.java7.ep4;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathSample {

	public static void main(String[] args) {
		FileSystem fs = FileSystems.getDefault();
		
		// Path with only one parameter
		Path path1 = fs.getPath("c:\\tmp\\fpone.txt");
		System.out.println(path1);
		
		// Path with varargs
		Path path2 = fs.getPath("c:", "tmp","sample","ftwo.txt");
		System.out.println(path2);
		
		// Path made by Paths
		Path path3 = Paths.get("c:\\tmp\\fthree.txt");
		System.out.println(path3);
	}
}
