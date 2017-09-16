
package com.read.xml;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.model.Accounts;
import com.read.xml.MyHandler;

public class ReadXML {

	public static void main(String[] args) {
		
		SAXParserFactory factory =SAXParserFactory.newInstance();
		SAXParser saxParser= null;
		try {
			 saxParser = factory.newSAXParser();
			 MyHandler handler = new MyHandler();
			try {
				saxParser.parse("J:\\requestFile\\acc.xml", handler);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}
	
	public Accounts readXml(String fileName)
	{
		MyHandler handler = null;
		
		SAXParserFactory factory =SAXParserFactory.newInstance();
		SAXParser saxParser= null;
		try {
			 saxParser = factory.newSAXParser();
			 handler = new MyHandler();
			try {
				saxParser.parse("J:\\requestFile\\"+fileName, handler);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		
		return handler.show();
	}
	
}

