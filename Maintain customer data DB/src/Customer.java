

public class Customer {
	private String emailAddress;
	private String firstName;
	private String lastName;

	public Customer() {
		this("", "", "");
	}

	public Customer(String emailAddress, String firstName, String lastName) {
		this.emailAddress = emailAddress;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public void setEmailAdrress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public boolean equals(Object object) {
		if (object instanceof Customer) {
			Customer customer2 = (Customer) object;
			if (emailAddress.equals(customer2.getEmailAddress())
					&& firstName.equals(customer2.getFirstName())
					&& lastName.equals(customer2.getLastName()))
				return true;
		}
		return false;
	}

}