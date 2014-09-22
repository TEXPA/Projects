
public class Transactions {

	public static void deposit(Depositable account, double amount) {
		account.deposit(amount);
	}

	public static void withdraw(Withdrawable account, double amount) {
		account.withdraw(amount);
	}
}
