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
	
	@Test
	public void isSimilar_testSubset() throws IllegalValueException {
		Name supersetName = new Name("Adam Brown John");
		Name otherName = new Name("Betsy Choo");
		Name subsetName = new Name("Adam Brown");
		assertTrue(supersetName.isSimilar(subsetName));
		assertTrue(subsetName.isSimilar(supersetName));
		assertFalse(supersetName.isSimilar(otherName));
	}
	
	@Test
	public void isSimilar_testDifferentCase() throws IllegalValueException {
		Name upperCaseName = new Name("JOHN SMITH");
		Name mixedCaseName = new Name("joHn sMITh");
		Name lowerCaseName = new Name("john smith");
		assertTrue(upperCaseName.isSimilar(lowerCaseName));
		assertTrue(lowerCaseName.isSimilar(upperCaseName));
		assertTrue(mixedCaseName.isSimilar(lowerCaseName));
		assertTrue(mixedCaseName.isSimilar(upperCaseName));
	}

}
