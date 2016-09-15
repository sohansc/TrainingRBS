package rbs.module.transaction.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Formatter;



import rbs.module.transaction.model.DematTransaction;
import rbs.module.transaction.model.DepositTransaction;
import rbs.module.transaction.model.FxTransaction;
import rbs.module.transaction.model.LoanTransaction;
import rbs.module.transaction.model.Transaction;

public class DaoCreateImplementation implements DaoCreateTransaction {
	static Date stringToDate(String value){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		try {
			date = format.parse(value);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Date(date.getTime());
	}

	@Override
	public String CreateTransactions(int loan_number,int empid) {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public String CreateTransactions(int amount,String type, int account_no, String description,int emp_id) {
		try {
			LocalDate ldt = LocalDate.now();
			String mydate = ldt.toString();
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		    SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yyyy");
		    java.util.Date date = format1.parse(mydate);
		    String newdate = format2.format(date);
			//boolean isvalid = callAPI(mydate,country);
			//if(isvalid){}
			//else{return "Is not a valid date"
			//}
			boolean isvalid = true;
			if (isvalid){
				//JSONObject obj3 = new JSONObject();
				//obj3 = bankstructuresAPI(emp_id);
				//String permissions = obj3.getString(create_permissions);
				//int amount_allowed = obj3.getInt(amount_allowed);
				String permissions = "allowed"; 
				int amount_allowed = 100000;
				if(permissions.equalsIgnoreCase("allowed")&&amount_allowed>=amount)
				{
					// TODO Auto-generated method stub
					//JSONObject obj = new JSONObject();
					//obj = callAPI(account_no);
					//int length = obj.length()
					int length = 10;
					if(length!=0)
					{
						DepositTransaction dep = new DepositTransaction();
						//will refer to accounts team API to get account details

						Connection c = DatabaseConnection.getConnection();
						//transaction id should be auto incremented and assigned from DB
						String statement = "select MAX(TRANS_ID) from TRANSACTION;";
						PreparedStatement query3 = c.prepareStatement(statement);

						
						dep.setTransactionDate(mydate);	
						if(type.equals("deposit"))
						{
							dep.setTransactionTo(account_no);
							dep.setTransactionToType("SB");
							dep.setAmount(amount);
							dep.setAccountType("Deposit");
							dep.setTransactionDesc("Deposit");
							
							//boolean happened = updatebalance(account_no,amount);
							String stmt = "BEGIN \n SAVEPOINT STARTTRANS; \n INSERT INTO TRANSACTION VALUES("+"(select MAX(TRANS_ID)+1 from TRANSACTION)"+",'"+newdate+"',"+dep.getTransactionFrom()+",'"+dep.getTransactionFromType()+"',"+dep.getTransactionTo()+",'"+dep.getTransactionToType()+"',"+dep.getAmount()+",'"+dep.getAccountType()+"');\n INSERT INTO DEPOSIT VALUES("+"(select MAX(TRANS_ID) from TRANSACTION)"+",'"+dep.getTransactionDesc()+"');\n EXCEPTION \n WHEN OTHERS THEN \n ROLLBACK TO starttrans; \n RAISE; \n END;";
							
							//String stmt2 = "INSERT INTO TRANSACTION VALUES("+dep.getTransactionId()+","+dep.getTransactionDesc();
							PreparedStatement query = c.prepareStatement(stmt);
							System.out.println(stmt);
							//PreparedStatement query2 = c.prepareStatement(stmt2);
							 query.executeQuery();
							//ResultSet result2 = query2.executeQuery();
						}
						else if (type.equals("withdrawal"))
						{
							dep.setTransactionFrom(account_no);
							dep.setTransactionFromType("SB");
							dep.setAmount(amount);
							dep.setAccountType("Deposit");
							dep.setTransactionDesc("Withdrawal");
							String stmt = "BEGIN \n SAVEPOINT STARTTRANS; \n INSERT INTO TRANSACTION VALUES("+"(select MAX(TRANS_ID)+1 from TRANSACTION)"+",'"+newdate+"',"+dep.getTransactionFrom()+",'"+dep.getTransactionFromType()+"',"+dep.getTransactionTo()+",'"+dep.getTransactionToType()+"',"+dep.getAmount()+",'"+dep.getAccountType()+"');\n INSERT INTO DEPOSIT VALUES("+"(select MAX(TRANS_ID) from TRANSACTION)"+",'"+dep.getTransactionDesc()+"');\n EXCEPTION \n WHEN OTHERS THEN \n ROLLBACK TO starttrans; \n RAISE; \n END;";
							//boolean happened = updatebalance(account_no,(-amount));
							//String stmt = "insert into Transaction values("+dep.getTransactionId()+","+dep.getTransactionDate()+","+dep.getTransactionFrom()+","+dep.getTransactionFromType()+","+dep.getTransactionTo()+","+dep.getTransactionToType()+","+dep.getAmount()+","+dep.getAccountType();
							//String stmt2 = "insert into Deposit values("+dep.getTransactionId()+","+dep.getTransactionDesc();
							PreparedStatement query = c.prepareStatement(stmt);
							//PreparedStatement query2 = c.prepareStatement(stmt2);
							System.out.println(stmt);

							ResultSet result = query.executeQuery();
							//ResultSet result2 = query2.executeQuery();
						}
						return "create successful";
					}
					else{
						return "Account number doesn't exist";
					}
				}
				else{
					return "You don't have the required permissions";
				}

			}
			else{
				return "The date is not correct";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
