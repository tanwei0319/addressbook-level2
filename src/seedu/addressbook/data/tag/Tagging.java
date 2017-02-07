package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

/**
 * Association class that keeps track of addition and deletion
 * of a tag for a specific person during a session
 */
public class Tagging {
	
	private Person person;
	private Tag tag;
	private boolean isAddition;
	
	public Tagging(Person person, Tag tag, boolean isAddition) {
		this.person = person;
		this.tag = tag;
		this.isAddition = isAddition;
	}
	
	@Override
	public String toString() {
		String operator;
		
		if (isAddition) {
			operator = "+ ";
		} else {
			operator = "- ";
		}
		
		StringBuilder builder = new StringBuilder(operator);
		builder.append(person.getName()).append(" ").append(tag.toString());
		
		return builder.toString();
		
	}
}
