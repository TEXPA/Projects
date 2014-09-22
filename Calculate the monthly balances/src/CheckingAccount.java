
public class CheckingAccount extends Account {

	private double monthlyFee = 0;

	public CheckingAccount(double initialMonthlyFee) {
		monthlyFee = initialMonthlyFee;
	}

	public void chargeMonthlyFee() {
		balance -= monthlyFee;
	}

	public double getMonthlyFee() {
		return monthlyFee;
	}
}
