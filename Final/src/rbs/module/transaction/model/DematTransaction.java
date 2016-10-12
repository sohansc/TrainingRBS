package rbs.module.transaction.model;

public class DematTransaction extends Transaction {
	private String script;
	private double units;
	private double unitCost;
	
	
	public String getScript() {
		return script;
	}
	public void setScript(String script) {
		this.script = script;
	}
	public double getUnits() {
		return units;
	}
	public void setUnits(double units) {
		this.units = units;
	}
	@Override
	public String toString() {
		return script + ", " + units + ", " + unitCost
				+ ", " + getTransactionId() + ", " + getTransactionDate()
				+ ", " + getTransactionFrom() + ", "
				+ getTransactionFromType() + ", " + getTransactionTo() + ", "
				+ getTransactionToType() + ", " + getAmount() + ", " + getAccountType()
				+ "\n";
	}
	public double getUnitCost() {
		return unitCost;
	}
	public void setUnitCost(double unitCost) {
		this.unitCost = unitCost;
	}
}
