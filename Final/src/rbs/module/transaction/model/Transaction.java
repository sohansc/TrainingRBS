package rbs.module.transaction.model;

import java.sql.Date;

public class Transaction {
	private double transactionId;
	private String transactionDate;
	private double transactionFrom;
	private String transactionFromType;
	private double transactionTo;
	private String transactionToType;
	private double amount;
	private String accountType;
	public double getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(double transactionId) {
		this.transactionId = transactionId;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public double getTransactionFrom() {
		return transactionFrom;
	}
	public void setTransactionFrom(double transactionFrom) {
		this.transactionFrom = transactionFrom;
	}
	public String getTransactionFromType() {
		return transactionFromType;
	}
	public void setTransactionFromType(String transactionFromType) {
		this.transactionFromType = transactionFromType;
	}
	public double getTransactionTo() {
		return transactionTo;
	}
	public void setTransactionTo(double transactionTo) {
		this.transactionTo = transactionTo;
	}
	public String getTransactionToType() {
		return transactionToType;
	}
	public void setTransactionToType(String transactionToType) {
		this.transactionToType = transactionToType;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionDate=" + transactionDate
				+ ", transactionFrom=" + transactionFrom + ", transactionFromType=" + transactionFromType
				+ ", transactionTo=" + transactionTo + ", transactionToType=" + transactionToType + ", amount=" + amount
				+ ", transactionType=" + accountType + "]";
	}
	
	
}
