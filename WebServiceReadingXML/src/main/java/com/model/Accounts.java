package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Accounts {
	
  private String accountNo;
  private String name;
  private String balance;
  
  private List<Accounts> accountList = new ArrayList<Accounts>();
  
  
  public Accounts() {
  }


public Accounts(String accountNo, String name, String balance) {
	super();
	this.accountNo = accountNo;
	this.name = name;
	this.balance = balance;
}


public String getAccountNo() {
	return accountNo;
}


public void setAccountNo(String accountNo) {
	this.accountNo = accountNo;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getBalance() {
	return balance;
}


public void setBalance(String balance) {
	this.balance = balance;
}


public List<Accounts> getAccountList() {
	return accountList;
}


public void setAccountList(List<Accounts> accountList) {
	this.accountList = accountList;
}
	
  
}
