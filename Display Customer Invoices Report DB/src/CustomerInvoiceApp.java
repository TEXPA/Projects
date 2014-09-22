import java.sql.*;

public class CustomerInvoiceApp {
	private static Connection connection = null;

	public static void main(String args[]) {
		// get the connection and start the Derby engine
		connection = MurachDB.getConnection();
		
		printProducts();

		
	}

	public static void printProducts() {
		Invoices i = null;

		try (Statement statement = connection.createStatement(
				ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = statement
						.executeQuery("SELECT c.CustomerID, c.EmailAddress, i.InvoiceNumber, "
								+ "i.InvoiceDate, i.InvoiceTotal FROM Customers c "
								+ "INNER JOIN Invoices i ON c.CustomerID=i.CustomerID "
								+ "ORDER BY c.EmailAddress ASC"))

		{

			System.out.println("Welcome to the Customer Invoices Report \n");
			while (rs.next()) {
				int customerID = rs.getInt("CustomerID");
				String emailAddress = rs.getString("EmailAddress");
				String invoiceNumber = rs.getString("InvoiceNumber");
				Date invoiceDate = rs.getDate("InvoiceDate");
				double invoiceTotal = rs.getDouble("InvoiceTotal");

				i = new Invoices(emailAddress, invoiceNumber, invoiceDate,
						invoiceTotal);
				printInvoices(i);

			}

		} catch (SQLException e) {
			e.printStackTrace(); // for debugging
		}
		System.out.println();
	}

	private static void printInvoices(Invoices i) {
		String productString = StringUtils.padWithSpaces(i.getEmailAddress(),
				25)
				+ StringUtils.padWithSpaces(i.getInvoiceNumber(), 10)
				+ StringUtils.padWithSpaces(i.getInvoiceDate().toString(), 15)
				+ i.getFormattedInvoiceTotal();

		System.out.println(productString);
	}
}