package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Block;
import seedu.addressbook.data.person.Street;
import seedu.addressbook.data.person.Unit;
import seedu.addressbook.data.person.PostalCode;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses must be in the following format: "
    														+ "<BLOCK NUMBER>, <STREET NUMBER>, #<UNIT NUMBER>, <POSTAL CODE>";
    public static final String ADDRESS_DELIMITER = ",";
    
    public static final int TOTAL_PARTS = 4;
    public static final int BLOCK_INDEX = 0;
    public static final int STREET_INDEX = 1;
    public static final int UNIT_INDEX = 2;
    public static final int POSTALCODE_INDEX = 3;

    private boolean isPrivate;

    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;
    
    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
    	String entireAddress = address.trim();
        if (!isValidAddress(entireAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        
    	trimAddress(address);
        this.isPrivate = isPrivate;

    }

	private void trimAddress(String address) {
		String[] trimmedAddress = address.split(ADDRESS_DELIMITER);

    	this.block = new Block(trimmedAddress[BLOCK_INDEX].trim());
    	this.street = new Street(trimmedAddress[STREET_INDEX].trim());
    	this.unit = new Unit(trimmedAddress[UNIT_INDEX].trim());
    	this.postalCode = new PostalCode(trimmedAddress[POSTALCODE_INDEX].trim());
    	
	}

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
    	String[] trimmedAddress = test.split(ADDRESS_DELIMITER);
    	
    	// Not all info required are available 
    	if (trimmedAddress.length != TOTAL_PARTS) {
    		return false;
    	}
    	
    	// Unit number does not follow required #<UNIT_NUMBER> format
    	if (trimmedAddress[UNIT_INDEX].trim().charAt(0) != '#') {
    		return false;
    	}
    	
    	// Postal code is not 6-digit integer
    	int postalCodeInt = Integer.parseInt(trimmedAddress[POSTALCODE_INDEX].trim());
    	if (postalCodeInt < 100000 || postalCodeInt > 999999) {
    		return false;
    	}
    	
    	return true;
    }

    @Override
    public String toString() {
    	String[] addressParts = { block.toString(), street.toString(), unit.toString(), postalCode.toString() };
    	String fullAddress = String.join(", ", addressParts);
    	
        return fullAddress;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.toString().equals(((Address) other).toString())); // state check
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }

}
