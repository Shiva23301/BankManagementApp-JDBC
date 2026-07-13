package com.library.manage;

public class Bank {

	private int accountNo;
	private String name;
	private int balance;

	public Bank(int accountNo, String name, int balance) {
		super();
		this.accountNo = accountNo;
		this.name = name;
		this.balance = balance;
	}

	public Bank(int accountNo, int balance) {
		super();
		this.accountNo = accountNo;
		this.balance = balance;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Bank [accountNo=" + accountNo + ", name=" + name + ", balance=" + balance + "]";
	}

}
