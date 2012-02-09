package com.mmjug.java7.ep4;

import java.nio.file.spi.FileSystemProvider;
import java.util.List;

public class ServiceProviderSample1 {
	public static void main(String[] args) {
		List<FileSystemProvider> list = FileSystemProvider.installedProviders();
		
		for(FileSystemProvider p : list) {
			System.out.println(p.getScheme() + " : " + p.getClass());
		}
	}
}
