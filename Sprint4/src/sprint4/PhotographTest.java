package sprint4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * Sprint 3 Testing
 * @author Adair Tabb
 * 
 *
 */

class PhotographTest {

	@Test
	void testHashCode() {
		Photograph testPhoto1 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1815-12-10", 5);
		Photograph testPhoto2 = new Photograph("Alan_Turing_Aged_16.jpg", "Alan Turing", "1912-06-23", 5);
		assertEquals("Overriden hashCode() does not produce the same ID for the same String more than once.", testPhoto1.hashCode(), testPhoto1.hashCode());
		assertNotEquals("Overriden hashCode() produces the same ID for two different Strings.", testPhoto1.hashCode(), testPhoto2.hashCode());
	}

	@Test
	void testPhotographStringString() {
		Photograph testPhoto1 = new Photograph("adalovelace.jpg", "Ada Lovelace");
		assertEquals("Photograph Constructor does not correctly store the FILENAME.", "adalovelace.jpg", testPhoto1.getFileName());
		assertEquals("Photograph Constructor does not correctly store the CAPTION.", "Ada Lovelace", testPhoto1.getCaption());
	}

	@Test
	void testPhotographStringStringStringInt() {
		Photograph testPhoto1 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1815-12-10", 5);
		assertEquals("Photograph Constructor does not correctly store the FILENAME.", "adalovelace.jpg", testPhoto1.getFileName());
		assertEquals("Photograph Constructor does not correctly store the CAPTION.", "Ada Lovelace", testPhoto1.getCaption());
		assertEquals("Photograph Constructor does not correctly store the dateTaken", "1815-12-10", testPhoto1.getDateTaken());
		assertEquals("Photograph Constructor does not correctly store the rating.", 5, testPhoto1.getRating());
	}

	@Test
	void testGetFileName() {
		Photograph testPhoto1 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1815-12-10", 5);
		assertEquals("getFileName() does not return the expected String.", "adalovelace.jpg", testPhoto1.getFileName());
	}

	@Test
	void testGetCaption() {
		Photograph testPhoto1 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1815-12-10", 5);
		assertEquals("getCaption() does not return the expected String.", "Ada Lovelace", testPhoto1.getCaption());
	}

	@Test
	void testGetDateTaken() {
		Photograph testPhoto1 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1815-12-10", 5);
		assertEquals("getDateTaken() does not return the expected String.", "1815-12-10", testPhoto1.getDateTaken());
	}

	@Test
	void testGetRating() {
		Photograph testPhoto1 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1815-12-10", 5);
		assertEquals("getRating() does not return the expected int.", 5, testPhoto1.getRating());
	}

	@Test
	void testSetCaption() {
		Photograph testPhoto1 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1815-12-10", 5);
		testPhoto1.setCaption("loveLace camelCase");
		assertEquals("setCaption() did not reassign the CAPTION variable with a new value.", "loveLace camelCase", testPhoto1.getCaption());
	}

	@Test
	void testSetRating() {
		Photograph testPhoto1 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1815-12-10", 5);
		testPhoto1.setRating(1);
		assertEquals("setRating() did not reassign the rating variable with a new value.", 1, testPhoto1.getRating());
	}

	@Test
	void testEqualsObject() {
		Photograph testPhoto1 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1815-12-10", 5);
		Photograph testPhoto2 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1815-12-10", 5);
		Photograph testPhoto3 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1999-12-04", 5);
		assertTrue("equals() did not register the current Photograph object as being equal to a different Photograph object.", testPhoto1.equals(testPhoto2));
		assertFalse("equals() did not find a difference between the current Photograph object and a different Photograph object.", testPhoto1.equals(testPhoto3));
	}

	@Test
	void testToString() {
		Photograph testPhoto1 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1815-12-10", 5);
		assertEquals("toString() did not return the expected String.", "Filename: adalovelace.jpg\nCaption: Ada Lovelace", testPhoto1.toString());
	}

	@Test
	void testCompareTo() {
		Photograph testPhoto1 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1815-12-10", 5);
		Photograph testPhoto2 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1815-12-10", 5);
		Photograph testPhoto3 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1999-12-04", 5);
		Photograph testPhoto4 = new Photograph("Alan_Turing_Aged_16.jpg", "Alan Turing", "1815-12-10", 5);
		assertTrue("compareTo() did not register the first photo's date as being before the second photo's date.", (testPhoto1.compareTo(testPhoto3) < 0));
		assertTrue("compareTo() did not register the first photo's date as being after the second photo's date.", (testPhoto3.compareTo(testPhoto1) > 0));
		assertTrue("compareTo() did not register the first photo's caption as being alphabetically less than the second photo's caption when both photos have the same date.", (testPhoto1.compareTo(testPhoto4) < 0));
		assertTrue("compareTo() did not register the first photo's caption as being alphabetically greater than the second photo's caption when both photos have the same date.", (testPhoto4.compareTo(testPhoto1) > 0));
		assertTrue("compareTo() did not register both photos as being the same based on date and caption.", (testPhoto1.compareTo(testPhoto2) == 0));
	}

}
