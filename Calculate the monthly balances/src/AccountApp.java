
import java.util.Scanner;
import java.text.NumberFormat;

public class AccountApp {
	public static void main(String args[]) {
		// display a welcome message
		System.out.println("Welcome to the Account application\n");

		NumberFormat currency = NumberFormat.getCurrencyInstance();

		// set some default amounts
		CheckingAccount checking = new CheckingAccount(1); // $1 monthly fee
		SavingAccount savings = new SavingAccount(50000); // 1% monthly interest
		checking.setBalance(1000.0); // $1000
		savings.setBalance(1000.0); // $1000

		// display starting values
		System.out.println("Starting Balances");
		System.out.println("Checking: "
				+ currency.format(checking.getBalance()));
		System.out
				.println("Savings:  " + currency.format(savings.getBalance()));
		System.out.println();

		System.out.println("Enter the transactions for the month\n");

		// create the Scanner object
		Scanner sc = new Scanner(System.in);
		MyValidator v = new MyValidator(sc);

		// continue until choice isn't equal to "y" or "Y"
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			String transactionType = v.getChoiceString(
					"Withdrawal or deposit? (w/d): ", "w", "d");

			// get input from user
			String accountType = v.getChoiceString(
					"Checking or savings? (c/s): ", "c", "s");

			// checking
			if (accountType.equalsIgnoreCase("c")) {
				// withdrawal
				if (transactionType.equalsIgnoreCase("w")) {
					double amount = getWithdrawalAmount(v, checking);
					Transactions.withdraw(checking, amount);
				}
				// deposit
				else {
					double amount = getDepositAmount(v);
					Transactions.deposit(checking, amount);
				}
			}

			// savings
			else {
				// withdrawal
				if (transactionType.equalsIgnoreCase("w")) {
					double amount = getWithdrawalAmount(v, checking);
					Transactions.withdraw(savings, amount);
				}
				// deposit
				else {
					double amount = getDepositAmount(v);
					Transactions.deposit(savings, amount);
				}
			}

			// see if the user wants to continue
			choice = v.getChoiceString("Continue? (y/n): ", "y", "n");
			System.out.println();
		}

		// make month-end calculations
		checking.chargeMonthlyFee();
		savings.getInterestPayment();

		// display monthly fees
		System.out.println("Monthly Payments and Fees");
		System.out.println("Checking fee:              "
				+ currency.format(checking.getMonthlyFee()));
		System.out.println("Savings interest payment:  "
				+ currency.format(savings.getInterestPayment()));
		System.out.println();

		// display final balances
		System.out.println("Final Balances");
		System.out.println("Checking: "
				+ currency.format(checking.getBalance()));
		System.out
				.println("Savings:  " + currency.format(savings.getBalance()));
		System.out.println();
	}

	private static double getDepositAmount(MyValidator v) {
		double amount = v.getDoubleWithinRange("Amount?: ", 0, 10000); // $10,000
																		// limit
		System.out.println();

		return amount;
	}

	private static double getWithdrawalAmount(MyValidator v, Balanceable account) {
		double amount = v.getDoubleWithinRange("Amount?: ", 0,
				account.getBalance()); // no more than the account balance
		System.out.println();

		return amount;
	}
}