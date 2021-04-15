package sprint4;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * Sprint 3 Testing
 * @author Adair Tabb
 * 
 *
 */

class CompareByCaptionTest {

	@Test
	void testCompare() {
		CompareByCaption testCompareByCaption = new CompareByCaption();
		Photograph testPhoto1 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1815-12-10", 5);
		Photograph testPhoto2 = new Photograph("Alan_Turing_Aged_16.jpg", "Alan Turing", "1912-06-23", 2);
		Photograph testPhoto3 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1815-12-10", 5);
		Photograph testPhoto4 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1815-12-10", 3);
		assertTrue("compare() did not read the first photo's caption as alphabetically less than the second photo's caption.", (testCompareByCaption.compare(testPhoto1, testPhoto2) < 0));
		assertTrue("compare() did not read the first photo's caption as alphabetically greater than the second photo's caption.", (testCompareByCaption.compare(testPhoto2, testPhoto1) > 0));
		assertTrue("compare() did not read the two photos as having the same caption or did not read the first photo as having the higher rating.", (testCompareByCaption.compare(testPhoto1, testPhoto4) == 1));
		assertTrue("compare() did not read the two photos as having the same caption or did not read the first photo as having the lower rating.", (testCompareByCaption.compare(testPhoto4, testPhoto1) == -1));
		assertTrue("compare() did not read the two photos as being the same based on caption and rating.", (testCompareByCaption.compare(testPhoto1, testPhoto3) == 0));
	}

}
