package org.oliot.bis.capturingApp;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;

public class Translator {
	protected DocumentBuilderFactory factory;
	protected DocumentBuilder builder;
	protected Document document;
	
	public Translator() {
		
		factory = DocumentBuilderFactory.newInstance();
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		
	}
}
