package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/** 
 * Parent class of Address, Email and Phone
 *  Extracts commonalities from its child class
 */
public class Contact {
	
	public final String value;
    private boolean isPrivate;

    /**
     * Validates given information of a person.
     *
     * @throws IllegalValueException if given information string is invalid.
     */
    public Contact(String info, boolean isPrivate, String messageConstraints, String validationRegex) throws IllegalValueException {
        this.isPrivate = isPrivate;
        String trimmedInfo = info.trim();
        if (!isValidInfo(trimmedInfo, validationRegex)) {
            throw new IllegalValueException(messageConstraints);
        }
        this.value = trimmedInfo;
    }

    /**
     * Checks if a given string is a valid person information.
     */
    public static boolean isValidInfo(String test, String validationRegex) {
        return test.matches(validationRegex);
    }
    
    @Override
    public String toString() {
        return value;
    }
    

    @Override
    public int hashCode() {
        return value.hashCode();
    }


    public boolean isPrivate() {
        return isPrivate;
    }

}
