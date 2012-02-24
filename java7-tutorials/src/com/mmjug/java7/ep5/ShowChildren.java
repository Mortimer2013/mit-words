package com.mmjug.java7.ep5;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ShowChildren {
	
	private static final String BIAS = "    ";
	
	public void showChildren(Path path, String bias) throws IOException {
		
		System.out.println(bias + path.getFileName());
		
		if(Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)) {
			DirectoryStream<Path> directory = Files.newDirectoryStream(path);
			
			for(Path p : directory)
				this.showChildren(p, bias + BIAS);
		}
	}
	
	public static void main(String[] args) {

		ShowChildren sc = new ShowChildren();
		Path zip = Paths.get("A:","var","tomcat-7","lib","catalina.jar");
		
		try (FileSystem fs = FileSystems.newFileSystem(zip,
				ClassLoader.getSystemClassLoader())) {
			sc.showChildren(fs.getPath("org","apache","naming"), BIAS);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
