package seedu.addressbook.data.person;

/**
 * An interface for printable strings Name, Phone, Email, Address
 * Implementations should guarantee: details are present and not null
 */
public interface Printable {
	public String getPrintableString();
}
