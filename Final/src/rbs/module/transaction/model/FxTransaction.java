package rbs.module.transaction.model;

public class FxTransaction extends Transaction {
	private String currencyFrom;
	private String currencyTo;
	private double rate;
	public String getCurrencyFrom() {
		return currencyFrom;
	}
	public void setCurrencyFrom(String currencyFrom) {
		this.currencyFrom = currencyFrom;
	}
	public String getCurrencyTo() {
		return currencyTo;
	}
	public void setCurrencyTo(String currencyTo) {
		this.currencyTo = currencyTo;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	@Override
	public String toString() {
		return currencyFrom + ", " + currencyTo + ", " + rate
				+ ", " + getTransactionId() + ", " + getTransactionDate()
				+ ", " + getTransactionFrom() + ", "
				+ getTransactionFromType() + ", " + getTransactionTo() + ", "
				+ getTransactionToType() + ", " + getAmount() + ", "
				+ getAccountType() + "\n";
	}
		
}
