
public class SavingAccount extends Account {

	private double interestRate = 0;
	private double interestPayment = 0;

	public SavingAccount(double initialInterestRate) {
		interestRate = initialInterestRate;
	}

	public void payInterest() {
		interestPayment = balance * interestRate;
		balance += interestPayment;

	}

	public double getInterestPayment() {
		return interestPayment;
	}
}