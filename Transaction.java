// דניאל בן עמי ת.ז 313577140

import java.sql.Time;

public class Transaction {
	private Time time;
	private String type;
	private double amount;
	
	public Time getTime() {
		return time;
	}
	public String getType() {
		return type;
	}
	public double getAmount() {
		return amount;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public void setType(String type) {
		if (type.equalsIgnoreCase("W") || type.equalsIgnoreCase("T") || type.equalsIgnoreCase("D")) {
			this.type = type;
		}
		else {
			System.out.println("Illegal action");
		}
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Transaction [time=" + time + ", type=" + type + ", amount=" + amount + "]";
	}
	public Transaction(Time time, String type, double amount) {
		setTime(time);
		setType(type);
		setAmount(amount);
	}
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Transaction && ((Transaction)obj).amount == this.amount && ((Transaction)obj).time == this.time
				&& ((Transaction)obj).type.equalsIgnoreCase(this.type);
	}
	
}
