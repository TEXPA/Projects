
import java.util.Scanner;

public class ConvertNumbers {

	public static void main(String[] args) {

		// display a welcome message
		System.out.println("Welcome to the Number to Word Converter.\n");

		// create the Scanner object
		Scanner sc = new Scanner(System.in);

		// perform conversions until choice isn't equal to "y" or "Y"
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			// get an int from the user
			System.out.print("Enter the number you want to convert to words: ");
			int num = sc.nextInt();

			String[] singleDigit = { " one ", " two ", " three ", " four ",
					" five ", " six ", " seven ", " eight ", " nine ", " ten ",
					" eleven ", " twelve ", " thertee ", " fourteen ",
					" fifteen ", " sixteen ", " seventeen ", " eighteen ",
					" nineteen " };

			String[] doubleDigit = { " twenty ", " thirty ", " fourty ",
					" fifty ", " sixty ", " seventy ", " eighty ", " ninety " };

			String hundreds = " hundred ";

			String thousands = " thousand ";

			if (num == 0) {
				System.out.println(" zero ");
			}
			if (num >= 1000) {
				int tempNumber = (num / 1000);
				num = num % 1000;
				System.out.print(singleDigit[tempNumber - 1] + thousands);
			}
			if (num >= 100) {
				int tempNumber = (num / 100);
				num = num % 100;
				System.out.print(singleDigit[tempNumber - 1] + hundreds);
			}

			if (num >= 20) {
				int tempNumber = (num / 10);
				num = num % 10;
				System.out.print(doubleDigit[tempNumber - 2]);
			}

			if (num < 20 && num > 0) {
				System.out.println(singleDigit[num - 1]);

			}
			System.out.println();

			// see if the user wants to continue
			System.out.print("Continue? (y/n): ");
			choice = sc.next();
			System.out.println();
		}
		sc.close();
	}
}
