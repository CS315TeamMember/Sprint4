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

class PhotographContainerTest {

	@Test
	void testHashCode() {
		Album testAlbum1 = new Album("testAlbumName");
		Album testAlbum2 = new Album("newTestAlbumName");
		assertEquals("Overriden hashCode does not generate the same ID for the same name.", 918977832, testAlbum1.hashCode());
		assertNotEquals("Overriden hashCode does not generate different IDs for different names.", testAlbum1.hashCode(), testAlbum2.hashCode());
	}

	@Test
	void testPhotographContainer() {
		PhotographContainer testContainer = new PhotographContainer("testName");
		assertEquals("PhotographContainer() constructor does not correctly store the container's name.", "testName", testContainer.getName());
		
	}

	@Test
	void testGetName() {
		PhotographContainer testContainer = new PhotographContainer("testName");
		assertEquals("getName() does not correctly retrieve the PhotographContainter's set name.", "testName", testContainer.getName());
	}

	@Test
	void testSetName() {
		PhotographContainer testContainer = new PhotographContainer("testName");
		testContainer.setName("newName");
		assertEquals("setName() did not change the container's name.", "newName", testContainer.getName());
	}

	@Test
	void testGetPhotos() {
		PhotographContainer testContainer = new PhotographContainer("testContainer");
		ArrayList<Photograph> testList = new ArrayList<Photograph>();
		Photograph testPhoto1 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1815-12-10", 5);
		Photograph testPhoto2 = new Photograph("Alan_Turing_Aged_16.jpg", "Alan Turing", "1912-06-23", 5);
		Photograph testPhoto3 = new Photograph("AnnieEasley.jpg", "Annie Easley", "1933-04-23", 5);
		testContainer.addPhoto(testPhoto1);
		testList.add(testPhoto1);
		testContainer.addPhoto(testPhoto2);
		testList.add(testPhoto2);
		testContainer.addPhoto(testPhoto3);
		testList.add(testPhoto3);
		assertEquals("getPhotos() did not return the expected list of Photographs.", testList, testContainer.getPhotos());
	}

	@Test
	void testAddPhoto() {
		PhotographContainer testContainer = new PhotographContainer("testContainer");
		Photograph testPhoto1 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1815-12-10", 5);
		assertTrue("addPhoto() did not add a Photograph to PhotographContainer.", testContainer.addPhoto(testPhoto1));
	}

	@Test
	void testHasPhoto() {
		PhotographContainer testContainer = new PhotographContainer("testContainer");
		ArrayList<Photograph> testList = new ArrayList<Photograph>();
		Photograph testPhoto1 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1815-12-10", 5);
		testContainer.addPhoto(testPhoto1);
		testList.add(testPhoto1);
		assertEquals("Photograph does not exist in both testContainer and testList.", testList, testContainer.getPhotos());
		assertTrue("hasPhoto() did not find the Photograph in PhotographContainer.", testContainer.hasPhoto(testPhoto1));
	}

	@Test
	void testRemovePhoto() {
		PhotographContainer testContainer = new PhotographContainer("testContainer");
		ArrayList<Photograph> testList = new ArrayList<Photograph>();
		Photograph testPhoto1 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1815-12-10", 5);
		testContainer.addPhoto(testPhoto1);
		testList.add(testPhoto1);
		assertEquals("Photograph does not exist in both testContainer and testList.", testList, testContainer.getPhotos());
		assertTrue("removePhoto() did not remove the Photograph from PhotographContainer.", testContainer.removePhoto(testPhoto1));
	}

	@Test
	void testNumPhotographs() {
		PhotographContainer testContainer = new PhotographContainer("testContainer");
		ArrayList<Photograph> testList = new ArrayList<Photograph>();
		Photograph testPhoto1 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1815-12-10", 5);
		Photograph testPhoto2 = new Photograph("Alan_Turing_Aged_16.jpg", "Alan Turing", "1912-06-23", 5);
		Photograph testPhoto3 = new Photograph("AnnieEasley.jpg", "Annie Easley", "1933-04-23", 5);
		testContainer.addPhoto(testPhoto1);
		testList.add(testPhoto1);
		testContainer.addPhoto(testPhoto2);
		testList.add(testPhoto2);
		testContainer.addPhoto(testPhoto3);
		testList.add(testPhoto3);
		assertEquals("Photograph does not exist in both testContainer and testList.", testList, testContainer.getPhotos());
		assertEquals("numPhotographs() does not return the correct number of Photographs in PhotographContainer.", testList.size(), testContainer.numPhotographs());
	}

	@Test
	void testEqualsObject() {
		PhotographContainer testContainer1 = new PhotographContainer("testContainerName");
		PhotographContainer testContainer2 = new PhotographContainer("testContainerName");
		PhotographContainer testContainer3 = new PhotographContainer("testContainerName1");
		assertTrue("equals() did not register the current PhotographContainer object as being equal to a different PhotographContainer object.", testContainer1.equals(testContainer2));
		assertFalse("equals() did not find the difference between the current PhotoLibrary object as being equal to a different PhotoLibrary object.", testContainer1.equals(testContainer3));
	}

	@Test
	void testToString() {
		PhotographContainer testContainer = new PhotographContainer("testName");
		Photograph testPhoto1 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1815-12-10", 5);
		Photograph testPhoto2 = new Photograph("Alan_Turing_Aged_16.jpg", "Alan Turing", "1912-06-23", 5);
		Photograph testPhoto3 = new Photograph("AnnieEasley.jpg", "Annie Easley", "1933-04-23", 5);
		testContainer.addPhoto(testPhoto1);
		testContainer.addPhoto(testPhoto2);
		testContainer.addPhoto(testPhoto3);
		assertEquals("", "Name: testName\nPhotographs: [adalovelace.jpg, Alan_Turing_Aged_16.jpg, AnnieEasley.jpg]", testContainer.toString());
	}

	@Test
	void testGetPhotosInt() {
		PhotographContainer testContainer = new PhotographContainer("testName");
		ArrayList<Photograph> testList = new ArrayList<Photograph>();
		Photograph testPhoto1 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1815-12-10", 5);
		Photograph testPhoto2 = new Photograph("Alan_Turing_Aged_16.jpg", "Alan Turing", "1912-06-23", 5);
		Photograph testPhoto3 = new Photograph("AnnieEasley.jpg", "Annie Easley", "1933-04-23", 5);
		Photograph testPhoto4 = new Photograph("Dorothy_Vaughn.jpg", "Dorothy Vaughan", "1910-09-20", 2);
		testContainer.addPhoto(testPhoto1);
		testContainer.addPhoto(testPhoto2);
		testContainer.addPhoto(testPhoto3);
		testContainer.addPhoto(testPhoto4);
		testList.add(testPhoto1);
		testList.add(testPhoto2);
		testList.add(testPhoto3);
		assertEquals("getPhotos(int) did not return the expected Photographs.", testList, testContainer.getPhotos(4));
		assertEquals("getPhotos(int) attempted to return Photographs using an invalid rating.", null, testContainer.getPhotos(-1));
	}

	@Test
	void testGetPhotosInYear() {
		ArrayList<Photograph> testList = new ArrayList<Photograph>();
		PhotographContainer testContainer = new PhotographContainer("testName");
		Photograph testPhoto1 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1815-12-10", 5);
		Photograph testPhoto2 = new Photograph("Alan_Turing_Aged_16.jpg", "Alan Turing", "1910-06-23", 4);
		Photograph testPhoto3 = new Photograph("AnnieEasley.jpg", "Annie Easley", "1933-04-23", 3);
		Photograph testPhoto4 = new Photograph("Dorothy_Vaughn.jpg", "Dorothy Vaughan", "1910-09-20", 2);
		testContainer.addPhoto(testPhoto1);
		testContainer.addPhoto(testPhoto2);
		testContainer.addPhoto(testPhoto3);
		testContainer.addPhoto(testPhoto4);
		testList.add(testPhoto2);
		testList.add(testPhoto4);
		assertEquals("getPhotosInYear() did not return the expected Photographs.", testList, testContainer.getPhotosInYear(1910));
		assertEquals("getPhotosInYear() attempted to return Photographs using an invalid year.", null, testContainer.getPhotosInYear(0));
	}

	@Test
	void testGetPhotosInMonth() {
		ArrayList<Photograph> testList = new ArrayList<Photograph>();
		PhotographContainer testContainer = new PhotographContainer("testName");
		Photograph testPhoto1 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1906-12-10", 5);
		Photograph testPhoto2 = new Photograph("Alan_Turing_Aged_16.jpg", "Alan Turing", "1910-06-23", 4);
		Photograph testPhoto3 = new Photograph("AnnieEasley.jpg", "Annie Easley", "1933-04-23", 3);
		Photograph testPhoto4 = new Photograph("Grace_Hopper_and_UNIVAC.jpg", "Grace Hopper and UNIVAC", "1906-12-09", 5);
		testContainer.addPhoto(testPhoto1);
		testContainer.addPhoto(testPhoto2);
		testContainer.addPhoto(testPhoto3);
		testContainer.addPhoto(testPhoto4);
		testList.add(testPhoto1);
		testList.add(testPhoto4);
		assertEquals("getPhotosInMonth() did not return the expected Photographs.", testList, testContainer.getPhotosInMonth(12, 1906));
		assertEquals("getPhotosInMonth() attempted to return Photographs using an invalid year.", null, testContainer.getPhotosInMonth(12, 190));
		assertEquals("getPhotosInMonth() attempted to return Photographs using an invalid month.", null, testContainer.getPhotosInMonth(121, 1906));
	}

	@Test
	void testGetPhotosBetween() {
		ArrayList<Photograph> testList = new ArrayList<Photograph>();
		PhotographContainer testContainer = new PhotographContainer("testName");
		Photograph testPhoto1 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1906-12-10", 5);
		Photograph testPhoto2 = new Photograph("Alan_Turing_Aged_16.jpg", "Alan Turing", "1910-06-23", 4);
		Photograph testPhoto3 = new Photograph("AnnieEasley.jpg", "Annie Easley", "1933-04-23", 3);
		Photograph testPhoto4 = new Photograph("Grace_Hopper_and_UNIVAC.jpg", "Grace Hopper and UNIVAC", "1906-12-09", 5);
		testContainer.addPhoto(testPhoto1);
		testContainer.addPhoto(testPhoto2);
		testContainer.addPhoto(testPhoto3);
		testContainer.addPhoto(testPhoto4);
		testList.add(testPhoto1);
		testList.add(testPhoto2);
		testList.add(testPhoto3);
		testList.add(testPhoto4);
		assertEquals("getPhotosBetween() did not return the expected Photographs.", testList, testContainer.getPhotosBetween("1906-12-09", "1950-11-02"));
	}

}
