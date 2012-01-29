package com.mmjug.java7.ep2;

import java.util.Arrays;
import java.util.List;

public class Snippet {
	List<Integer> intList;
	List<List<String>> strListList;
	
	public void createArrays() {
		// No Warning
		intList = Arrays.asList(1,2,3,4);
		
		// Warning
		strListList = Arrays.asList(Arrays.asList("a","b","c"),
				Arrays.asList("a","b","c"));
	}
}

