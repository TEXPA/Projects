import java.util.Scanner;

public class RomansNumbersConverter {
	public static void main(String[] argv) {
		String input;

		// prompt until user chooses to exit
		while (true) {
			// prompt for input
			System.out.print("Enter a number to convert, or \"End\": ");
			Scanner sc = new Scanner(System.in);
			input = sc.nextLine();

			// end game if user has opted to
			if (input.equalsIgnoreCase("End"))
				break;

			// display output
			System.out.println("You entered the number   " + input);
			System.out.println("It is equal to the Roman   "
					+ decimalToNumeral(input) + "\n");
		}

		// user has opted to exit the game
		System.out.println("Have a good day!");

	}

	// converts decimal number in a string to a roman numeral
	public static String decimalToNumeral(String numeralToConvert) {
		return decimalToNumeral(Integer.parseInt(numeralToConvert)); // convert	to int and pass to the other function
	}


	// converts decimal number to a roman numeral
	public static String decimalToNumeral(int numberToConvert) {
		String toReturn = "";

		// for each possible value if it is above that value, remove it from the
		// number and add to the numeral
		for (; numberToConvert >= 1000; numberToConvert -= 1000)
			toReturn += "M";
		for (; numberToConvert >= 900; numberToConvert -= 900)
			toReturn += "CM";
		for (; numberToConvert >= 500; numberToConvert -= 500)
			toReturn += "D";
		for (; numberToConvert >= 400; numberToConvert -= 400)
			toReturn += "CD";
		for (; numberToConvert >= 100; numberToConvert -= 100)
			toReturn += "C";
		for (; numberToConvert >= 90; numberToConvert -= 90)
			toReturn += "XC";
		for (; numberToConvert >= 50; numberToConvert -= 50)
			toReturn += "L";
		for (; numberToConvert >= 40; numberToConvert -= 40)
			toReturn += "XL";
		for (; numberToConvert >= 10; numberToConvert -= 10)
			toReturn += "X";
		for (; numberToConvert >= 9; numberToConvert -= 9)
			toReturn += "IX";
		for (; numberToConvert >= 5; numberToConvert -= 5)
			toReturn += "V";
		for (; numberToConvert >= 4; numberToConvert -= 4)
			toReturn += "IV";
		for (; numberToConvert >= 1; numberToConvert -= 1)
			toReturn += "I";

		return toReturn;
	}

}