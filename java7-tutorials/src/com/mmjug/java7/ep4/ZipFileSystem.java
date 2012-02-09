package com.mmjug.java7.ep4;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipFileSystem {

	public static void main(String[] args) {
		
		Path zip = Paths.get("A:","var","tomcat-7","lib","catalina.jar");

		try (FileSystem fs = FileSystems.newFileSystem(zip,
				ClassLoader.getSystemClassLoader())) {
			System.out.println("FileSystem : " + fs);
			System.out.println("Class : " + fs.getClass());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
