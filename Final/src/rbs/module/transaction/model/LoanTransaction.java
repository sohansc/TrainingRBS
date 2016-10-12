package rbs.module.transaction.model;

public class LoanTransaction extends Transaction {
	private double transactionId;
	private String transactionDesc;
	public double getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(double transactionId) {
		this.transactionId = transactionId;
	}
	public String getTransactionDesc() {
		return transactionDesc;
	}
	public void setTransactionDesc(String transactionDesc) {
		this.transactionDesc = transactionDesc;
	}
	@Override
	public String toString() {
		return transactionId + ", " + transactionDesc
				+ ", " + getTransactionDate() + ", " + getTransactionFrom()
				+ ", " + getTransactionFromType() + ", "
				+ getTransactionTo() + ", " + getTransactionToType() + ", "
				+ getAmount() + ", " + getAccountType() + "\n";
	}
	
}
