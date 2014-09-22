import java.util.Scanner;
import java.util.ArrayList;

public class CustomerMaintApp implements CustomerConstants {
	// declare two class variables
	private static CustomerDAO customerDAO = null;
	private static Scanner sc = null;

	public static void main(String args[]) {
		// display a welcome message
		System.out.println("Welcome to the Customer Maintenance application\n");

		// set the class variables
		customerDAO = DAOFactory.getCustomerDAO();
		sc = new Scanner(System.in);

		// display the command menu
		displayMenu();

		// perform 1 or more actions
		String action = "";
		while (!action.equalsIgnoreCase("exit")) {
			// get the input from the user
			action = Validator.getString(sc, "Enter a command: ");
			System.out.println();

			if (action.equalsIgnoreCase("list"))
				displayAllCustomers();
			else if (action.equalsIgnoreCase("add"))
				addCustomer();
			else if (action.equalsIgnoreCase("del")
					|| action.equalsIgnoreCase("delete"))
				deleteCustomer();
			else if (action.equalsIgnoreCase("update"))
				updateCustomer();
			else if (action.equalsIgnoreCase("help")
					|| action.equalsIgnoreCase("menu"))
				displayMenu();
			else if (action.equalsIgnoreCase("exit"))
				System.out.println("Bye.\n");
			else
				System.out.println("Error! Not a valid command.\n");
		}
	}

	public static void displayMenu() {
		System.out.println("COMMAND MENU");
		System.out.println("list    - List all customers");
		System.out.println("add     - Add a customer");
		System.out.println("del     - Delete a customer");
		System.out.println("update  - Update a customer");
		System.out.println("help    - Show this menu");
		System.out.println("exit    - Exit this application\n");
	}

	public static void displayAllCustomers() {
		System.out.println("CUSTOMER LIST \n");

		ArrayList<Customer> customers = customerDAO.getCustomers();
		if (customers == null) {
			System.out.println("Error! Unable to get products.\n");
		} else {
			Customer c = null;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < customers.size(); i++) {
				c = customers.get(i);
				sb.append(StringUtils.padWithSpaces(c.getEmailAddress(),
						EMAIL_SIZE + 4));
				sb.append(StringUtils.padWithSpaces(c.getFirstName(),
						FIRSTNAME_SIZE + 4));
				sb.append(c.getLastName());
				sb.append("\n");
			}
			System.out.println(sb.toString());
		}
	}

	public static void addCustomer() {
		String emailAddress = Validator.getString(sc,
				"Enter customer email address: ");
		String firstName = Validator.getLine(sc, "Enter first name: ");
		String lastName = Validator.getLine(sc, "Enter last name: ");

		Customer customer = new Customer();
		customer.setEmailAdrress(emailAddress);
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		boolean success = customerDAO.addCustomer(customer);

		System.out.println();
		if (success)
			System.out.println(firstName + " was added to the database.\n");
		else
			System.out.println("Error! Unable to add customer\n");
	}

	public static void deleteCustomer() {
		String emailAddress = Validator.getString(sc,
				"Enter email address to delete: ");

		Customer c = customerDAO.getCustomer(emailAddress);

		System.out.println();
		if (c != null) {
			boolean success = customerDAO.deleteCustomer(c);
			if (success)
				System.out.println(c.getFirstName()
						+ " was deleted from the database.\n");
			else
				System.out.println("Error! Unable to delete customer \n");
		} else {
			System.out.println("No customer matches that email address.\n");
		}
	}

	private static void updateCustomer() {
		String emailAddress = Validator.getString(sc,
				"Enter email address to update: ");

		Customer c = customerDAO.getCustomer(emailAddress);
		System.out.println();
		if (c != null) {
			String firstName = Validator.getLine(sc,
					"Enter first name to update: ");
			c.setFirstName(firstName);

			String lastName = Validator.getLine(sc,
					"Enter last name to update: ");
			c.setLastName(lastName);
			boolean success = customerDAO.updateCustomer(c);
			if (success) {
				System.out.println();
				System.out.println(c.getFirstName()
						+ " was updated from the database.\n");
			} else
				System.out.println("Error! Unable to update customer \n");
		} else {
			System.out.println("No customer matches that email address.\n");
		}
	}

}