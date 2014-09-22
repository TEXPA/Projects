import java.util.Scanner;
import java.util.ArrayList;

public class CountriesApp {
	static CountriesTextFile newCountry = new CountriesTextFile();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		// display a welcome message
		System.out
				.println("Welcome to the Countries Maintenance application\n");

		// display the command menu
		displayMenu();

		// perform 1 or more actions
		int action = 0;
		while (action != 4) {
			// get the input from the user
			System.out.println();
			action = Validator.getInt(sc, "Enter menu number: ");

			System.out.println();

			if (action == 1)
				displayAllCountries();
			else if (action == 2)
				addCountry();
			else if (action == 3)
				deleteCountry();
			else if (action == 4)
				System.out.println("Bye.\n");
			else
				System.out.println("Error! Not a valid command.\n");
		}
	}

	private static void deleteCountry() {
		String countryName = Validator.getLine(sc, "Enter country name: ");

		newCountry.deleteCountry(countryName);

		System.out.println();
		System.out.println(countryName + " has been deleted.\n");
	}

	public static void displayMenu() {
		System.out.println("COMMAND MENU");
		System.out.println("1    - List countries");
		System.out.println("2    - Add a country");
		System.out.println("3    - Delete a country");
		System.out.println("4    - Exit this application\n");

	}

	public static void displayAllCountries() {
		System.out.println("Countries LIST\n");

		ArrayList<String> count = newCountry.getCountries();
		for (String string : count) {

			System.out.println(string);
		}
	}

	public static void addCountry() {
		String countryName = Validator.getLine(sc, "Enter country name: ");

		newCountry.addCountry(countryName);

		System.out.println();
		System.out.println(countryName + " has been added.\n");
	}

}
