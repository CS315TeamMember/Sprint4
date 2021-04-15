package sprint4;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * Sprint 3 Testing
 * @author Adair Tabb
 * 
 *
 */

class CompareByRatingTest {

	@Test
	void testCompare() {
		CompareByRating testCompareByRating = new CompareByRating();
		Photograph testPhoto1 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1815-12-10", 5);
		Photograph testPhoto2 = new Photograph("Alan_Turing_Aged_16.jpg", "Alan Turing", "1912-06-23", 2);
		Photograph testPhoto3 = new Photograph("Alan_Turing_Aged_16.jpg", "Alan Turing", "1912-06-23", 5);
		Photograph testPhoto4 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1815-12-10", 5);
		Photograph testPhoto5 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1815-12-10", 3);
		assertTrue("compare() did not read the first photo as having the higher rating.", (testCompareByRating.compare(testPhoto1, testPhoto2) == 1));
		assertTrue("compare() did not read the first photo as having the lower rating.", (testCompareByRating.compare(testPhoto2, testPhoto1) == -1));
		assertTrue("compare() did not read the first photo as having the lower rating when both photos are otherwise the same.", (testCompareByRating.compare(testPhoto5, testPhoto1) == -1));
		assertTrue("compare() did not read the first photo as being alphabetically less than the second photo when both photos have the same rating.", (testCompareByRating.compare(testPhoto1, testPhoto3) < 0));
		assertTrue("compare() did not read the first photo as being alphabetically greater than the second photo when both photos have the same rating.", (testCompareByRating.compare(testPhoto3, testPhoto1) > 0));
		assertTrue("compare() did not read the two photos as being the same based on caption and rating.", testCompareByRating.compare(testPhoto1, testPhoto4) == 0);
	}

}
