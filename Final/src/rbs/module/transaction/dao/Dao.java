package rbs.module.transaction.dao;

import java.sql.Date;
import java.util.ArrayList;

import rbs.module.transaction.model.Transaction;

public interface Dao {
	ArrayList<Transaction> getTransactions(Date date);
	ArrayList getTransactions(String accountType);
	ArrayList<Transaction> getTransactions(double accountNumber);
	ArrayList<Transaction> getTransactions(Date start, Date end);
}
