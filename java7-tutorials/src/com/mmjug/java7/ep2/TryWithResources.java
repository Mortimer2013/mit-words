package com.mmjug.java7.ep2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TryWithResources {

	public void copy(String pathFrom, String pathTo) {
		
		try (InputStream in = new FileInputStream(pathFrom);
			OutputStream out = new FileOutputStream(pathTo)) {

			byte[] buf = new byte[1024];
			int n;
			
			while((n = in.read(buf)) >= 0) {
				out.write(buf, 0, n);
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
}
