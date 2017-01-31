package seedu.addressbook.data.person;

public class PostalCode {

	private final String postalCode;
	
	public PostalCode(String code) {
		this.postalCode = code;
	}
	
	public String toString() {
		return postalCode;
	}
	
	public String getPostalCode() {
		return this.postalCode;
	}
}
