import java.sql.Date;
import java.text.NumberFormat;

public class Invoices {
	private String emailAddress;
	private int customerID;
	private String invoiceNumber;
	private Date invoiceDate;
	private double invoiceTotal;

	public Invoices(String emailAddress, String invoiceNumber,
			Date invoiceDate, double invoiceTotal) {
		this.emailAddress = emailAddress;
		this.invoiceNumber = invoiceNumber;
		this.invoiceDate = invoiceDate;
		this.invoiceTotal = invoiceTotal;

	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public double getInvoiceTotal() {
		return invoiceTotal;
	}

	public void setInvoiceTotal(double invoiceTotal) {
		this.invoiceTotal = invoiceTotal;
	}

	public String getFormattedInvoiceTotal() {
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		return currency.format(invoiceTotal);
	}

}