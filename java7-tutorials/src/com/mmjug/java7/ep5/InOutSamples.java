package com.mmjug.java7.ep5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class InOutSamples {

	public static void doStreamSample(Path path) {

		try (InputStream input = Files.newInputStream(path);
				OutputStream out1 = Files.newOutputStream(path,
						StandardOpenOption.APPEND)) {
			// INPUT OUTPUT Process

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void doReaderSample(Path path) {

		try (BufferedReader input = Files.newBufferedReader(path, 
						Charset.forName("utf-8"));
				BufferedWriter out1 = Files.newBufferedWriter(path,
						Charset.forName("utf-8"),
						StandardOpenOption.APPEND)) {
			// INPUT OUTPUT Process

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void doSeekChennelSample(Path path) {
		try (SeekableByteChannel chennel = Files.newByteChannel(path);
				SeekableByteChannel writeChannel = Files.newByteChannel(path, 
						StandardOpenOption.WRITE, 
						StandardOpenOption.APPEND)) {
			// INPUT OUTPUT Process

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void doFileChannelSample(Path path) {
		try (FileChannel channel = FileChannel.open(path);
				FileChannel wtChannel = FileChannel.open(path, StandardOpenOption.WRITE)) {
			// INPUT OUTPUT Process

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void easyReadSample(Path path) throws IOException {
		
		// Read Bytes
		byte [] bytes = Files.readAllBytes(path);
		
		// Read Lines
		List<String> lines = Files.readAllLines(path, Charset.defaultCharset());
		
		// Write bytes
		Files.write(path, bytes, StandardOpenOption.APPEND);
		
		// Write Text Lines
		Files.write(path, lines, Charset.forName("utf-8"), StandardOpenOption.APPEND);
	}
}
