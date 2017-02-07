package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents a Person's name in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidName(String)}
 */
public class Name {

    public static final String EXAMPLE = "John Doe";
    public static final String MESSAGE_NAME_CONSTRAINTS = "Person names should be spaces or alphabetic characters";
    public static final String NAME_VALIDATION_REGEX = "[\\p{Alpha} ]+";
    public final String fullName;

    /**
     * Validates given name.
     *
     * @throws IllegalValueException if given name string is invalid.
     */
    public Name(String name) throws IllegalValueException {
        String trimmedName = name.trim();
        if (!isValidName(trimmedName)) {
            throw new IllegalValueException(MESSAGE_NAME_CONSTRAINTS);
        }
        this.fullName = trimmedName;
    }

    /**
     * Returns true if a given string is a valid person name.
     */
    public static boolean isValidName(String test) {
        return test.matches(NAME_VALIDATION_REGEX);
    }

    /**
     * Retrieves a listing of every word in the name, in order.
     */
    public List<String> getWordsInName() {
        return Arrays.asList(fullName.split("\\s+"));
    }

    @Override
    public String toString() {
        return fullName;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Name // instanceof handles nulls
                && this.fullName.equals(((Name) other).fullName)); // state check
    }

    @Override
    public int hashCode() {
        return fullName.hashCode();
    }

    /**
     * Returns true of the other name is very similar to this name.
     * Two names are considered similar if one is a subset of another,
     * or both names are the same strings but in different case/order,
     * or both are not null.
     * Precondition: Each name has a maximum of three parts (i.e Adam Brown Smith)
     */
	public boolean isSimilar(Name other) {
		
		if (other == null) {
			// test for null
			return false;
		} 
		
		String thisName = this.toString().toLowerCase();
		String otherName = other.toString().toLowerCase();
		
		if (thisName.contains(otherName) || otherName.contains(thisName)) {
			// test for subset and different cases
			return true;		
		} else {
			// test for different order
			String[] thisNameElements = thisName.split(" ");
			String[] otherNameElements = otherName.split(" ");

			ArrayList<String> thisNameArrayList = new ArrayList<String> (Arrays.asList(thisNameElements));
			ArrayList<String> otherNameArrayList = new ArrayList<String> (Arrays.asList(otherNameElements));
			
			for (int i = 0; i < thisNameArrayList.size(); i++) {
				if (!thisNameArrayList.contains(otherNameArrayList.get(i))) {
					return false;
				}
			}
			
			return true;
		}
		
	}

}
