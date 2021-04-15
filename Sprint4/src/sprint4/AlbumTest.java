package sprint4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;


/**
 * Sprint 3 Testing
 * @author Adair Tabb
 * 
 *
 */

class AlbumTest {

	@Test
	void testAlbum() {
		Album testAlbum = new Album("testAlbumName");
		assertEquals("Album() does not correctly store the album name.", "testAlbumName", testAlbum.getName());
	}

	@Test
	void testHashCode() { 
		Album testAlbum1 = new Album("testAlbumName");
		Album testAlbum2 = new Album("newTestAlbumName");
		assertEquals("Overriden hashCode does not generate the same ID for the same name.", 918977832, testAlbum1.hashCode());
		assertNotEquals("Overriden hashCode does not generate different IDs for different names.", testAlbum1.hashCode(), testAlbum2.hashCode());
	}

	@Test
	void testGetName() {
		Album testAlbum = new Album("testAlbumName");
		assertEquals("getName() does not retrieve the set name.", "testAlbumName", testAlbum.getName());
	}

	@Test
	void testSetName() {
		Album testAlbum = new Album("testAlbumName");
		testAlbum.setName("newTestAlbumName");
		assertEquals("setName() did not change the Album's name.", "newTestAlbumName", testAlbum.getName());
	}

	@Test
	void testGetPhotos() {
		Album testAlbum = new Album("testAlbumName");
		ArrayList<Photograph> testList = new ArrayList<Photograph>();
		Photograph testPhoto1 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1815-12-10", 5);
		Photograph testPhoto2 = new Photograph("Alan_Turing_Aged_16.jpg", "Alan Turing", "1912-06-23", 5);
		Photograph testPhoto3 = new Photograph("AnnieEasley.jpg", "Annie Easley", "1933-04-23", 5);
		Photograph testPhoto4 = new Photograph("Dorothy_Vaughn.jpg", "Dorothy Vaughan", "1910-09-20", 5);
		Photograph testPhoto5 = new Photograph("Grace_Hopper_and_UNIVAC.jpg", "Grace Hopper and UNIVAC", "1906-12-09", 5);
		testAlbum.addPhoto(testPhoto1);
		testList.add(testPhoto1);
		testAlbum.addPhoto(testPhoto2);
		testList.add(testPhoto2);
		testAlbum.addPhoto(testPhoto3);
		testList.add(testPhoto3);
		testAlbum.addPhoto(testPhoto4);
		testList.add(testPhoto4);
		testAlbum.addPhoto(testPhoto5);
		testList.add(testPhoto5);
		assertEquals("getPhotos() did not return a Photograph from the Album.", testList, testAlbum.getPhotos());
	}

	@Test
	void testAddPhoto() {
		Album testAlbum = new Album("testAlbumName");
		Photograph testPhoto1 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1815-12-10", 5);
		assertTrue("addPhoto() did not add a Photograph to the Album's ArrayList.", testAlbum.addPhoto(testPhoto1));
		assertFalse("addPhoto() added a duplicate Photograph to Album's ArrayList.", testAlbum.addPhoto(testPhoto1));
	}

	@Test
	void testHasPhoto() {
		Album testAlbum = new Album("testAlbumName");
		Photograph testPhoto1 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1815-12-10", 5);
		Photograph testPhoto2 = new Photograph("Alan_Turing_Aged_16.jpg", "Alan Turing", "1912-06-23", 5);
		testAlbum.addPhoto(testPhoto1);
		testAlbum.addPhoto(testPhoto2);
		assertTrue("hasPhoto() did not find a Photograph that was added to Album's ArrayList.", testAlbum.hasPhoto(testPhoto2));
	}

	@Test
	void testRemovePhoto() {
		Album testAlbum = new Album("testAlbumName");
		Photograph testPhoto1 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1815-12-10", 5);
		Photograph testPhoto2 = new Photograph("Alan_Turing_Aged_16.jpg", "Alan Turing", "1912-06-23", 5);
		testAlbum.addPhoto(testPhoto1);
		testAlbum.addPhoto(testPhoto2);
		assertTrue("removePhoto() did not remove a Photograph from Album's ArrayList.", testAlbum.removePhoto(testPhoto2));
	}

	@Test
	void testNumPhotographs() {
		Album testAlbum = new Album("testAlbumName");
		Photograph testPhoto1 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1815-12-10", 5);
		Photograph testPhoto2 = new Photograph("Alan_Turing_Aged_16.jpg", "Alan Turing", "1912-06-23", 5);
		testAlbum.addPhoto(testPhoto1);
		testAlbum.addPhoto(testPhoto2);
		assertEquals("numPhotographs() did not return the correct number of Photographs in Album's ArrayList.", 2, testAlbum.numPhotographs());
	}

	@Test
	void testEqualsObject() {
		Album testAlbum1 = new Album("testAlbumName");
		Album testAlbum2 = new Album("testAlbumName");
		assertTrue("equals() did not register the current Album object as being equal to a different Album object.", testAlbum1.equals(testAlbum2));
	}

	@Test
	void testToString() {
		Album testAlbum = new Album("testAlbumName");
		Photograph testPhoto1 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1815-12-10", 5);
		Photograph testPhoto2 = new Photograph("Alan_Turing_Aged_16.jpg", "Alan Turing", "1912-06-23", 5);
		testAlbum.addPhoto(testPhoto1);
		testAlbum.addPhoto(testPhoto2);
		assertEquals("toString() did not return the expected String.", "Photo Album: testAlbumName\nPhotographs: [adalovelace.jpg, Alan_Turing_Aged_16.jpg]", testAlbum.toString());
	}

}
