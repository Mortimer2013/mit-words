package com.mmjug.java7.ep2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class RethrowSample {
	public void doSample() throws FileNotFoundException, SAXException,
			IOException, ParserConfigurationException {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			@SuppressWarnings("unused")
			Document doc = builder.parse(new FileInputStream("file.xml"));

		} catch (final Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
