
import java.util.Scanner;

public class MyValidator {
	Scanner sc = null;

	public MyValidator(Scanner sc) {
		this.sc = sc; // initialize the Scanner object for this class
	}

	public int getInt(String prompt) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			String s = getRequiredString(prompt);
			try {
				i = Integer.parseInt(s);
				isValid = true;
			} catch (NumberFormatException nfe) {
				System.out.println("Error! Invalid integer value. Try again.");
			}
		}
		return i;
	}

	public int getIntWithinRange(String prompt, int min, int max) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			i = getInt(prompt);
			if (i <= min)
				System.out.println("Error! Number must be greater than " + min);
			else if (i >= max)
				System.out.println("Error! Number must be less than " + max);
			else
				isValid = true;
		}
		return i;
	}

	public double getDouble(String prompt) {
		double d = 0;
		boolean isValid = false;
		while (isValid == false) {
			System.out.print(prompt);
			if (sc.hasNextDouble()) {
				d = sc.nextDouble();
				isValid = true;
			} else {
				System.out.println("Error! Invalid decimal value. Try again.");
			}
			sc.nextLine(); // discard any other data entered on the line
		}
		return d;
	}

	public double getDoubleWithinRange(String prompt, double min, double max) {
		double d = 0;
		boolean isValid = false;
		while (isValid == false) {
			d = getDouble(prompt);
			if (d <= min)
				System.out.println("Error! Number must be greater than " + min);
			else if (d >= max)
				System.out.println("Error! Number must be less than " + max);
			else
				isValid = true;
		}
		return d;
	}

	// force the user to enter a string
	public String getRequiredString(String prompt) {
		String s = "";
		boolean isValid = false;
		while (isValid == false) {
			System.out.print(prompt);
			s = sc.nextLine();
			if (s.equals("")) {
				System.out.println("Error! This entry is required. Try again.");
			} else {
				isValid = true;
			}
		}
		return s;
	}

	// force the user to enter one of two strings
	public String getChoiceString(String prompt, String s1, String s2) {
		String s = "";
		boolean isValid = false;
		while (isValid == false) {
			s = this.getRequiredString(prompt);
			if (!s.equalsIgnoreCase(s1) && !s.equalsIgnoreCase(s2)) {
				System.out.println("Error! Entry must be '" + s1 + "' or '"
						+ s2 + "'. Try again.");
			} else {
				isValid = true;
			}
		}
		return s;
	}

	// force the user to enter one of two strings
	public String getChoiceString(String prompt, String s1, String s2, String s3) {
		String s = "";
		boolean isValid = false;
		while (isValid == false) {
			s = this.getRequiredString(prompt);
			if (!s.equalsIgnoreCase(s1) && !s.equalsIgnoreCase(s2)
					&& !s.equalsIgnoreCase(s3)) {
				System.out.println("Error! Entry must be '" + s1 + "', '" + s2
						+ "', or '" + s3 + "'. Try again.");
			} else {
				isValid = true;
			}
		}
		return s;
	}
}