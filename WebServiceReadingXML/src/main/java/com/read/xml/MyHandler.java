package com.read.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.model.Accounts;

public class MyHandler extends DefaultHandler{

	boolean accountNo=false;
	boolean name=false;
	boolean balance=false;
	Accounts accounts = new Accounts();
	public void startElement(String uri, String localName, String qName, 
			org.xml.sax.Attributes arg3) throws SAXException {
	
		if(qName.equalsIgnoreCase("accountNo"))//this name is same to in xml file
		{
			accountNo=true;
		}
		if(qName.equalsIgnoreCase("name"))
		{
			name=true;
		}
		if(qName.equalsIgnoreCase("balance"))
		{
			balance=true;
		}
	}
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
	}
	
	@Override
	public void characters(char[] ch, int start, int lenght)
			throws SAXException {
		if(accountNo)
		{
			accounts.setAccountNo(new String(ch,start,lenght));
			accountNo=false;
		}
		if(name)
		{
			accounts.setName(new String(ch,start,lenght));
			name=false;
		}
		
		if(balance)
		{
			accounts.setBalance(new String(ch,start,lenght));
			balance=false;
		}
		
	}
	
	public Accounts show()
	{
		return accounts;
	}
	
}

