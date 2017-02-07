package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class UtilsTest {
    @Test
    public void isAnyNull() {
        // empty list
        assertFalse(Utils.isAnyNull());

        // Any non-empty list
        assertFalse(Utils.isAnyNull(new Object(), new Object()));
        assertFalse(Utils.isAnyNull("test"));
        assertFalse(Utils.isAnyNull(""));

        // non empty list with just one null at the beginning
        assertTrue(Utils.isAnyNull((Object) null));
        assertTrue(Utils.isAnyNull(null, "", new Object()));
        assertTrue(Utils.isAnyNull(null, new Object(), new Object()));

        // non empty list with nulls in the middle
        assertTrue(Utils.isAnyNull(new Object(), null, null, "test"));
        assertTrue(Utils.isAnyNull("", null, new Object()));

        // non empty list with one null as the last element
        assertTrue(Utils.isAnyNull("", new Object(), null));
        assertTrue(Utils.isAnyNull(new Object(), new Object(), null));
        
        // non empty list with multiple nulls
        assertTrue(Utils.isAnyNull(null, null));
        assertTrue(Utils.isAnyNull(null, null, null, null));

        // confirms nulls inside the list are not considered
        List<Object> nullList = Arrays.asList((Object) null);
        assertFalse(Utils.isAnyNull(nullList));
        
        // empty array
        assertFalse(Utils.isAnyNull(new Object[] {}));
        
        // array with nulls
        assertTrue(Utils.isAnyNull(new Object[] {null, null}));
        
        // non-empty array with nulls
        assertTrue(Utils.isAnyNull(new Object[] {"abc", null}));
        
        // non-empty array without null
        assertFalse(Utils.isAnyNull(new Object[] {"abc", 1, 2}));
    }

    @Test
    public void elementsAreUnique() throws Exception {
        // empty list
        assertAreUnique();

        // only one object
        assertAreUnique((Object) null);
        assertAreUnique(1);
        assertAreUnique("");
        assertAreUnique("abc");

        // all objects unique
        assertAreUnique("abc", "ab", "a");
        assertAreUnique(1, 2);
        assertAreUnique(" abc", "abc");
        assertAreUnique(null, "");

        // some identical objects
        assertNotUnique("abc", "abc");
        assertNotUnique("abc", "", "abc", "ABC");
        assertNotUnique("", "abc", "a", "abc");
        assertNotUnique(1, new Integer(1));
        assertNotUnique(null, 1, new Integer(1));
        assertNotUnique(null, null);
        assertNotUnique(null, "a", "b", null);
        assertNotUnique(1, 1, 1, 1, 1);
        
        // empty ArrayLists
        assertNotUnique(new ArrayList<String>(), new ArrayList<String> ());
        
        // non-empty ArrayLists
        ArrayList<Integer> arrayList1 = new ArrayList<Integer> ();
        ArrayList<Integer> arrayList2 = new ArrayList<Integer> ();
        arrayList1.add(1);
        assertAreUnique(arrayList1, arrayList2);
        arrayList2.add(1);
        assertNotUnique(arrayList1, arrayList2);
        
    }

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }
}
