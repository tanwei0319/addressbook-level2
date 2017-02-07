package seedu.addressbook.data.person;

import static org.junit.Assert.*;

import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {

	@Test
	public void isSimilar_testNull() throws IllegalValueException {
		Name testName = new Name("Adam Brown");
		assertFalse(testName.isSimilar(null));
		
		
	}

}
