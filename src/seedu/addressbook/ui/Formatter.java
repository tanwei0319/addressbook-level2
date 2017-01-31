package seedu.addressbook.ui;

import static seedu.addressbook.common.Messages.MESSAGE_GOODBYE;
import static seedu.addressbook.common.Messages.MESSAGE_INIT_FAILED;
import static seedu.addressbook.common.Messages.MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE;
import static seedu.addressbook.common.Messages.MESSAGE_USING_STORAGE_FILE;
import static seedu.addressbook.common.Messages.MESSAGE_WELCOME;

import java.util.List;

public class Formatter {

    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    public static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    public static final String LS = System.lineSeparator();

    public static final String DIVIDER = "===================================================";

    /** Format of indexed list item */
    public static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";

    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;

    /** Format of a comment input line. Comment lines are silently consumed when reading user input. */
    public static final String COMMENT_LINE_FORMAT_REGEX = "#.*";
    
    /** Get enter command message
     *  @return formatted enter command message
     */ 
    public String getEnterCommandMessage() {
    	return LINE_PREFIX + "Enter command: ";
    }
    
    /** Get command entered message
     * @param fullInputLine
     * @return formatted command entered message
     */
    public String getCommandEnteredMessage(String fullInputLine) {
    	return "[Command entered:" + fullInputLine + "]";
    }
    
    /** Get welcome message
     * 
     * @param version
     * @param storageFileInfo
     * @return formatted welcome message
     */
    public String getWelcomeMessage(String version, String storageFilePath) {
    	String storageFileInfo = String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
    	return DIVIDER + "\n" + DIVIDER + "\n" + MESSAGE_WELCOME + "\n" + version 
    			+ "\n" + MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE
    			+ "\n" + storageFileInfo + "\n" + DIVIDER;
    }
    
    /** Get goodbye message
     * 
     * @return formatted goodbye message 
     */
    public String getGoodbyeMessage() {
    	return MESSAGE_GOODBYE + "\n" + DIVIDER + "\n" + DIVIDER;
    }
    
    /** Get init failed message
     * 
     * @return formatted init failed message 
     */
    public String getInitFailedMessage() {
    	return MESSAGE_INIT_FAILED + DIVIDER + DIVIDER;
    }
	
    /** Get show to user message
     * 
     * @param message to be shown to user
     * @return formatted show to user message 
     */
    public String getShowToUser(String message) {
    	return LINE_PREFIX + message.replace("\n", LS + LINE_PREFIX);
    }

    /** Formats a list of strings as a viewable indexed list. 
     *	@param a list of strings
     * 	@return formatted indexed string list 
     * */
    public String getIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(getIndexedListItem(displayIndex, listItem)).append("\n");
            displayIndex++;
        }
        return formatted.toString();
    }

    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     * @return formatted indexed list string item
     */
    public String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }

}
