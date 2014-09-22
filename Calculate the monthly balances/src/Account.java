
public class Account implements Balanceable, Withdrawable, Depositable {

	protected double balance = 0;

	@Override
	public void deposit(double amount) {
		// TODO Auto-generated method stub
		balance += amount;
	}

	@Override
	public void withdraw(double amount) {
		// TODO Auto-generated method stub
		balance -= amount;
	}

	@Override
	public double getBalance() {
		// TODO Auto-generated method stub
		return balance;
	}

	@Override
	public void setBalance(double amount) {
		// TODO Auto-generated method stub
		balance = amount;
	}
}
