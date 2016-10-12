package rbs.module.transaction.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Formatter;

import rbs.module.transaction.model.DematTransaction;
import rbs.module.transaction.model.DepositTransaction;
import rbs.module.transaction.model.FxTransaction;
import rbs.module.transaction.model.LoanTransaction;
import rbs.module.transaction.model.Transaction;

public class DaoImplementation implements Dao {

	@Override
	public ArrayList<Transaction> getTransactions(Date date) {
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		try{	
			Connection c = DatabaseConnection.getConnection();
			PreparedStatement query = c.prepareStatement("select * from transaction where trans_date= to_date(?,'dd-mm-yyyy')");
			query.setString(1, dateToString(date));
    		ResultSet result = query.executeQuery();
    		
    		while(result.next()){
    			Transaction t=new Transaction();
    			
    			t.setTransactionId(result.getDouble(1));
    			t.setTransactionDate(dateToString(result.getDate(2)));	
    			t.setTransactionFrom(result.getDouble(3));
    			t.setTransactionFromType(result.getString(4));
    			t.setTransactionTo(result.getDouble(5));
    			t.setTransactionToType(result.getString(6));
    			t.setAmount(result.getDouble(7));
    			t.setAccountType(result.getString(8));
    			transactions.add(t);
    		} 		
    		c.close();
		}
		catch (Exception e) {
			System.out.println("failure");	
		}
		return transactions;
	}
	public ArrayList<Transaction> getTransactions(double accountnumber) {
       ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        try{        
                Connection c = DatabaseConnection.getConnection();
                PreparedStatement query = c.prepareStatement("select * from transaction where account_from=? or account_to=?");     
                query.setDouble(1, accountnumber);
                query.setDouble(2, accountnumber);
            ResultSet result = query.executeQuery();
            
            while(result.next()){
                    Transaction t=new Transaction();
                   
                    t.setTransactionId(result.getDouble(1));
        			t.setTransactionDate(dateToString(result.getDate(2)));	
        			t.setTransactionFrom(result.getDouble(3));
        			t.setTransactionFromType(result.getString(4));
        			t.setTransactionTo(result.getDouble(5));
        			t.setTransactionToType(result.getString(6));
        			t.setAmount(result.getDouble(7));
        			t.setAccountType(result.getString(8));
        			transactions.add(t);
            }                 
            c.close();
        }
        catch (Exception e) {
                System.out.println("Failure");        
        }
        return transactions;
}

//	@SuppressWarnings({ "unchecked", "rawtypes" })
//	@Override
//	public ArrayList getTransactions(String accountType) {
//		ArrayList transactions = new ArrayList();
//		if(accountType.equals("LOAN")){
//			ResultSet result = getTransactionutility(accountType);
//			try {
//				while(result.next()){
//					LoanTransaction lt = new LoanTransaction();
//					lt.setTransactionId(result.getDouble(1));
//                    lt.setTransactionDate(dateToString(result.getDate(2)));
//                    lt.setTransactionType(result.getString(3));
//                    lt.setAmount(result.getDouble(4));
//                    lt.setAccountNumber(result.getDouble(5));
//                    lt.setAccountType(result.getString(6));
//                    lt.setTransactionFrom(result.getDouble(7));
//                    lt.setTransactionFromType(result.getString(8));
//                    lt.setTransactionTo(result.getDouble(10));
//                    lt.setTransactionToType(result.getString(9));
//                    lt.setTransactionDescription(result.getString(11));
//                    
//                    transactions.add(lt);
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		
//			
//		}
//		return transactions;*/
//		return null;
//	}
	
	ResultSet getTransactionUtility(String accountType){
		ResultSet result=null; 
		try{        
             Connection c = DatabaseConnection.getConnection();
             PreparedStatement query = c.prepareStatement("select * from transaction join "+accountType+" using(trans_id)");     
             result = query.executeQuery();
		 }
		 catch (Exception e) {
             System.out.println("Failure");        
		 }
		 return result;
	}
	
	String dateToString(java.sql.Date d){
		return new Formatter().format("%td-%tm-%tY",d,d,d).toString();
    }
	
	@Override
	public ArrayList<Transaction> getTransactions(Date start, Date end) {
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		try{	
			Connection c = DatabaseConnection.getConnection();
			PreparedStatement query = c.prepareStatement("select * from transaction where trans_date between to_date(?,'dd-mm-yyyy') and to_date(?,'dd-mm-yyyy')");
			query.setString(1, dateToString(start));
			query.setString(2, dateToString(end));
    		ResultSet result = query.executeQuery();
    		
    		while(result.next()){
    			Transaction t=new Transaction();
    			
    			t.setTransactionId(result.getDouble(1));
    			t.setTransactionDate(dateToString(result.getDate(2)));	
    			t.setTransactionFrom(result.getDouble(3));
    			t.setTransactionFromType(result.getString(4));
    			t.setTransactionTo(result.getDouble(5));
    			t.setTransactionToType(result.getString(6));
    			t.setAmount(result.getDouble(7));
    			t.setAccountType(result.getString(8));
    			
    			transactions.add(t);
    		} 		
    		c.close();
		}
		catch (Exception e) {
			System.out.println("failure");	
		}
		return transactions;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ArrayList getTransactions(String accountType) {
		ArrayList transactions = new ArrayList();
		if(accountType.equals("LOAN")){
			ResultSet result = getTransactionUtility(accountType);
			try {
				while(result.next()){
					LoanTransaction t=new LoanTransaction();
					t.setTransactionId(result.getDouble(1));
					t.setTransactionDate(dateToString(result.getDate(2)));	
					t.setTransactionFrom(result.getDouble(3));
					t.setTransactionFromType(result.getString(4));
					t.setTransactionTo(result.getDouble(5));
					t.setTransactionToType(result.getString(6));
					t.setAmount(result.getDouble(7));
					t.setAccountType(result.getString(8));
					t.setTransactionDesc(result.getString(9));
					transactions.add(t);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 		
		}
		
		else if(accountType.equals("DEPOSIT")){
			ResultSet result = getTransactionUtility(accountType);
			try {
				while(result.next()){
					DepositTransaction t=new DepositTransaction();
					t.setTransactionId(result.getDouble(1));
					t.setTransactionDate(dateToString(result.getDate(2)));	
					t.setTransactionFrom(result.getDouble(3));
					t.setTransactionFromType(result.getString(4));
					t.setTransactionTo(result.getDouble(5));
					t.setTransactionToType(result.getString(6));
					t.setAmount(result.getDouble(7));
					t.setAccountType(result.getString(8));
					t.setTransactionDesc(result.getString(9));
					transactions.add(t);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 		
		}
		
		else if(accountType.equals("FX")){
			ResultSet result = getTransactionUtility(accountType);
			try {
				while(result.next()){
					FxTransaction t=new FxTransaction();
					t.setTransactionId(result.getDouble(1));
					t.setTransactionDate(dateToString(result.getDate(2)));	
					t.setTransactionFrom(result.getDouble(3));
					t.setTransactionFromType(result.getString(4));
					t.setTransactionTo(result.getDouble(5));
					t.setTransactionToType(result.getString(6));
					t.setAmount(result.getDouble(7));
					t.setAccountType(result.getString(8));
					t.setCurrencyFrom(result.getString(9));
					t.setCurrencyTo(result.getString(10));
					t.setRate(result.getDouble(11));
					transactions.add(t);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 		
		}
		
		else if(accountType.equals("DEMAT")){
			ResultSet result = getTransactionUtility(accountType);
			try {
				while(result.next()){
					DematTransaction t=new DematTransaction();
					t.setTransactionId(result.getDouble(1));
					t.setTransactionDate(dateToString(result.getDate(2)));	
					t.setTransactionFrom(result.getDouble(3));
					t.setTransactionFromType(result.getString(4));
					t.setTransactionTo(result.getDouble(5));
					t.setTransactionToType(result.getString(6));
					t.setAmount(result.getDouble(7));
					t.setAccountType(result.getString(8));
					t.setScript(result.getString(9));
					t.setUnits(result.getDouble(10));
					t.setUnitCost(result.getDouble(11));
					transactions.add(t);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 		
		}
		
		return transactions;
	}

}
