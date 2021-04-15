package sprint3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

/**
 * Sprint 3 Testing
 * @author Adair Tabb
 * 
 *
 */

class PhotoLibraryTest {

	@Test
	void testSetName() {
		PhotoLibrary testLibrary = new PhotoLibrary("testLibraryName", 1);
		testLibrary.setName("testLibraryNameChanged");
		assertEquals("setName() did not reassign the name variable with a new value.", "testLibraryNameChanged", testLibrary.getName());
	}

	@Test
	void testRemovePhoto() {
		ArrayList<Photograph> testList = new ArrayList<Photograph>();
		PhotoLibrary testLibrary = new PhotoLibrary("testLibraryName", 1);
		Photograph testPhoto1 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1815-12-10", 5);
		testList.add(testPhoto1);
		testLibrary.addPhoto(testPhoto1);
		assertTrue("removePhoto() did not remove a Photograph only from PhotoLibrary's Arraylist.", testLibrary.removePhoto(testPhoto1));
		testLibrary.addPhoto(testPhoto1);
		testLibrary.createAlbum("testAlbum1");
		testLibrary.createAlbum("testAlbum2");
		testLibrary.addPhotoToAlbum(testPhoto1, "testAlbum1");
		testLibrary.addPhotoToAlbum(testPhoto1, "testAlbum2");
		assertTrue("removePhoto() did not remove a Photograph from PhotoLibrary's ArrayList and from every Album containing that Photograph.", testLibrary.removePhoto(testPhoto1));
		testLibrary.addPhotoToAlbum(testPhoto1, "testAlbum1"); //further testing to be sure the function removes from EVERY album. -- Adair
		testLibrary.addPhotoToAlbum(testPhoto1, "testAlbum2");
		testLibrary.removePhoto(testPhoto1);
		assertNotEquals("removePhoto() did not remove a Photograph from an Album.", testList, testLibrary.getAlbumByName("testAlbum1").getPhotos());
		assertNotEquals("removePhoto() did not remove a Photograph from all Albums.", testList, testLibrary.getAlbumByName("testAlbum2").getPhotos());
		
		
		
	}

	@Test
	void testEqualsObject() {
		PhotoLibrary testLibrary1 = new PhotoLibrary("testLibraryName", 1);
		PhotoLibrary testLibrary2 = new PhotoLibrary("testLibraryName", 1);
		PhotoLibrary testLibrary3 = new PhotoLibrary("testLibraryName", 2);
		assertTrue("equals() did not register the current PhotoLibrary object as being equal to a different PhotoLibrary object.", testLibrary1.equals(testLibrary2));
		assertFalse("equals() did not find the difference between the current PhotoLibrary object as being equal to a different PhotoLibrary object.", testLibrary1.equals(testLibrary3));
		
	}

	@Test
	void testToString() {
		PhotoLibrary testLibrary = new PhotoLibrary("testLibraryName", 1);
		Photograph testPhoto1 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1815-12-10", 5);
		Photograph testPhoto2 = new Photograph("Alan_Turing_Aged_16.jpg", "Alan Turing", "1912-06-23", 5);
		testLibrary.addPhoto(testPhoto1);
		testLibrary.addPhoto(testPhoto2);
		assertEquals("toString() did not return the expected String.", "Name: testLibraryName\nID: 1\nPhotos: [Filename: adalovelace.jpg\nCaption: Ada Lovelace, Filename: Alan_Turing_Aged_16.jpg\nCaption: Alan Turing]", testLibrary.toString());
	}


	@Test
	void testPhotoLibrary() {
		PhotoLibrary testLibrary = new PhotoLibrary("testLibraryName", 1);
		assertEquals("PhotoLibrary Constructor did not properly store the name variable.", "testLibraryName", testLibrary.getName());
		assertEquals("PhotoLibrary Constructor did not properly store the ID variable.", 1, testLibrary.getId());
	}

	@Test
	void testGetId() {
		PhotoLibrary testLibrary = new PhotoLibrary("testLibraryName", 1);
		assertEquals("getId() does not return the expected int.", 1, testLibrary.getId());
	}

	@Test
	void testGetAlbums() {
		PhotoLibrary testLibrary = new PhotoLibrary("testLibraryName", 1);
		HashSet<Album> testSet = new HashSet<Album>();
		testLibrary.createAlbum("testAlbum1");
		testSet.add(testLibrary.getAlbumByName("testAlbum1"));
		testLibrary.createAlbum("testAlbum2");
		testSet.add(testLibrary.getAlbumByName("testAlbum2"));
		testLibrary.createAlbum("testAlbum3");
		testSet.add(testLibrary.getAlbumByName("testAlbum3"));
		assertEquals("", testSet, testLibrary.getAlbums());
	}

	@Test
	void testCommonPhotos() {
		ArrayList<Photograph> testList = new ArrayList<Photograph>();
		PhotoLibrary testLibrary1 = new PhotoLibrary("testLibraryName", 1);
		PhotoLibrary testLibrary2 = new PhotoLibrary("testLibraryName", 2);
		Photograph testPhoto1 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1815-12-10", 5);
		Photograph testPhoto2 = new Photograph("Alan_Turing_Aged_16.jpg", "Alan Turing", "1912-06-23", 5);
		Photograph testPhoto3 = new Photograph("AnnieEasley.jpg", "Annie Easley", "1933-04-23", 5);
		Photograph testPhoto4 = new Photograph("Dorothy_Vaughn.jpg", "Dorothy Vaughan", "1910-09-20", 5);
		testLibrary1.addPhoto(testPhoto1);
		testLibrary1.addPhoto(testPhoto2);
		testLibrary1.addPhoto(testPhoto3);
		testLibrary2.addPhoto(testPhoto1);
		testLibrary2.addPhoto(testPhoto3);
		testLibrary2.addPhoto(testPhoto4);
		testList.add(testPhoto1);
		testList.add(testPhoto3);
		assertEquals("commonPhotos() does not correctly locate and store all Photographs two PhotoLibrary ArrayLists have in common.", testList, PhotoLibrary.commonPhotos(testLibrary1, testLibrary2));
	}

	@Test
	void testSimilarity() {
		PhotoLibrary testLibrary1 = new PhotoLibrary("testLibraryName", 1);
		PhotoLibrary testLibrary2 = new PhotoLibrary("testLibraryName", 2);
		Photograph testPhoto1 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1815-12-10", 5);
		Photograph testPhoto2 = new Photograph("Alan_Turing_Aged_16.jpg", "Alan Turing", "1912-06-23", 5);
		Photograph testPhoto3 = new Photograph("AnnieEasley.jpg", "Annie Easley", "1933-04-23", 5);
		Photograph testPhoto4 = new Photograph("Dorothy_Vaughn.jpg", "Dorothy Vaughan", "1910-09-20", 5);
		assertEquals(0.0, PhotoLibrary.similarity(testLibrary1, testLibrary2), 0.001);
		testLibrary1.addPhoto(testPhoto1);
		testLibrary1.addPhoto(testPhoto2);
		testLibrary1.addPhoto(testPhoto3);
		testLibrary2.addPhoto(testPhoto1);
		testLibrary2.addPhoto(testPhoto3);
		testLibrary2.addPhoto(testPhoto4);
		assertEquals(2.0/6.0, PhotoLibrary.similarity(testLibrary1, testLibrary2), 0.001);
	}

	@Test
	void testCreateAlbum() {
		PhotoLibrary testLibrary = new PhotoLibrary("testLibraryName", 1);
		assertTrue("createAlbum() did not create a new Album object.", testLibrary.createAlbum("testAlbumName"));
	}

	@Test
	void testRemoveAlbum() {
		PhotoLibrary testLibrary = new PhotoLibrary("testLibraryName", 1);
		testLibrary.createAlbum("testAlbumName");
		assertTrue("removeAlbum() did not delete an Album object.", testLibrary.removeAlbum("testAlbumName"));
	}

	@Test
	void testAddPhotoToAlbum() {
		PhotoLibrary testLibrary = new PhotoLibrary("testLibraryName", 1);
		Photograph testPhoto1 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1906-12-10", 5);
		testLibrary.addPhoto(testPhoto1);
		testLibrary.createAlbum("testAlbumName");
		assertTrue("addPhotoToAlbum() did not add a Photograph to an Album's ArrayList.", testLibrary.addPhotoToAlbum(testPhoto1, "testAlbumName"));
	}

	@Test
	void testRemovePhotoFromAlbum() {
		PhotoLibrary testLibrary = new PhotoLibrary("testLibraryName", 1);
		Photograph testPhoto1 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1906-12-10", 5);
		testLibrary.addPhoto(testPhoto1);
		testLibrary.createAlbum("testAlbumName");
		testLibrary.addPhotoToAlbum(testPhoto1, "testAlbumName");
		assertTrue("removePhotofromAlbum() did not remove a Photograph from an Album's ArrayList.", testLibrary.removePhotoFromAlbum(testPhoto1, "testAlbumName"));
	}

	@Test
	void testGetName() {
		PhotoLibrary testLibrary = new PhotoLibrary("testLibraryName", 1);
		assertEquals("getName() does not return the expected String.", "testLibraryName", testLibrary.getName());
	}

	@Test
	void testGetPhotos() {
		PhotoLibrary testLibrary = new PhotoLibrary("testLibraryName", 1);
		ArrayList<Photograph> testList = new ArrayList<Photograph>();
		Photograph testPhoto1 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1815-12-10", 5);
		Photograph testPhoto2 = new Photograph("Alan_Turing_Aged_16.jpg", "Alan Turing", "1912-06-23", 5);
		Photograph testPhoto3 = new Photograph("AnnieEasley.jpg", "Annie Easley", "1933-04-23", 5);
		testLibrary.addPhoto(testPhoto1);
		testLibrary.addPhoto(testPhoto2);
		testLibrary.addPhoto(testPhoto3);
		testList.add(testPhoto1);
		testList.add(testPhoto2);
		testList.add(testPhoto3);
		assertEquals("getPhotos does not return the expected list.", testList, testLibrary.getPhotos());
	}

	@Test
	void testAddPhoto() {
		PhotoLibrary testLibrary = new PhotoLibrary("testLibraryName", 1);
		Photograph testPhoto1 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1815-12-10", 5);
		Photograph testPhoto2 = new Photograph("Alan_Turing_Aged_16.jpg", "Alan Turing", "1912-06-23", 5);
		testLibrary.addPhoto(testPhoto2);
		assertTrue("addPhoto() did not add a Photograph to PhotoLibrary's ArrayList.", testLibrary.addPhoto(testPhoto1));
		assertFalse("addPhoto() will add a duplicate Photograph object to PhotoLibrary's ArrayList.", testLibrary.addPhoto(testPhoto2));
	}

	@Test
	void testHasPhoto() {
		PhotoLibrary testLibrary = new PhotoLibrary("testLibraryName", 1);
		Photograph testPhoto1 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1815-12-10", 5);
		Photograph testPhoto2 = new Photograph("Alan_Turing_Aged_16.jpg", "Alan Turing", "1912-06-23", 5);
		testLibrary.addPhoto(testPhoto1);
		testLibrary.addPhoto(testPhoto2);
		assertTrue("hasPhoto() did not find a Photograph that was added to PhotoLibrary's ArrayList.", testLibrary.hasPhoto(testPhoto2));
	}

	@Test
	void testNumPhotographs() {
		PhotoLibrary testLibrary = new PhotoLibrary("testLibraryName", 1);
		Photograph testPhoto1 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1815-12-10", 5);
		Photograph testPhoto2 = new Photograph("Alan_Turing_Aged_16.jpg", "Alan Turing", "1912-06-23", 5);
		testLibrary.addPhoto(testPhoto1);
		testLibrary.addPhoto(testPhoto2);
		assertEquals("numPhotographs() did not return the expected int.", 2, testLibrary.numPhotographs());
	}

	@Test
	void testGetPhotosInt() {
		ArrayList<Photograph> testList = new ArrayList<Photograph>();
		PhotoLibrary testLibrary = new PhotoLibrary("testLibraryName", 1);
		Photograph testPhoto1 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1815-12-10", 5);
		Photograph testPhoto2 = new Photograph("Alan_Turing_Aged_16.jpg", "Alan Turing", "1912-06-23", 4);
		Photograph testPhoto3 = new Photograph("AnnieEasley.jpg", "Annie Easley", "1933-04-23", 3);
		Photograph testPhoto4 = new Photograph("Dorothy_Vaughn.jpg", "Dorothy Vaughan", "1910-09-20", 2);
		testLibrary.addPhoto(testPhoto1);
		testLibrary.addPhoto(testPhoto2);
		testLibrary.addPhoto(testPhoto3);
		testLibrary.addPhoto(testPhoto4);
		testList.add(testPhoto1);
		testList.add(testPhoto2);
		assertEquals("getPhotos(int) did not return the expected Photographs.", testList, testLibrary.getPhotos(4));
		assertEquals("getPhotos(int) attempted to return Photographs using an invalid rating.", null, testLibrary.getPhotos(-1));
	}

	@Test
	void testGetPhotosInYear() {
		ArrayList<Photograph> testList = new ArrayList<Photograph>();
		PhotoLibrary testLibrary = new PhotoLibrary("testLibraryName", 1);
		Photograph testPhoto1 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1815-12-10", 5);
		Photograph testPhoto2 = new Photograph("Alan_Turing_Aged_16.jpg", "Alan Turing", "1910-06-23", 4);
		Photograph testPhoto3 = new Photograph("AnnieEasley.jpg", "Annie Easley", "1933-04-23", 3);
		Photograph testPhoto4 = new Photograph("Dorothy_Vaughn.jpg", "Dorothy Vaughan", "1910-09-20", 2);
		testLibrary.addPhoto(testPhoto1);
		testLibrary.addPhoto(testPhoto2);
		testLibrary.addPhoto(testPhoto3);
		testLibrary.addPhoto(testPhoto4);
		testList.add(testPhoto2);
		testList.add(testPhoto4);
		assertEquals("getPhotosInYear() did not return the expected Photographs.", testList, testLibrary.getPhotosInYear(1910));
		assertEquals("getPhotosInYear() attempted to return Photographs using an invalid year.", null, testLibrary.getPhotosInYear(0));
	}

	@Test
	void testGetPhotosInMonth() {
		ArrayList<Photograph> testList = new ArrayList<Photograph>();
		PhotoLibrary testLibrary = new PhotoLibrary("testLibraryName", 1);
		Photograph testPhoto1 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1906-12-10", 5);
		Photograph testPhoto2 = new Photograph("Alan_Turing_Aged_16.jpg", "Alan Turing", "1910-06-23", 4);
		Photograph testPhoto3 = new Photograph("AnnieEasley.jpg", "Annie Easley", "1933-04-23", 3);
		Photograph testPhoto4 = new Photograph("Grace_Hopper_and_UNIVAC.jpg", "Grace Hopper and UNIVAC", "1906-12-09", 5);
		testLibrary.addPhoto(testPhoto1);
		testLibrary.addPhoto(testPhoto2);
		testLibrary.addPhoto(testPhoto3);
		testLibrary.addPhoto(testPhoto4);
		testList.add(testPhoto1);
		testList.add(testPhoto4);
		assertEquals("getPhotosInMonth() did not return the expected Photographs.", testList, testLibrary.getPhotosInMonth(12, 1906));
		assertEquals("getPhotosInMonth() attempted to return Photographs using an invalid year.", null, testLibrary.getPhotosInMonth(12, 190));
		assertEquals("getPhotosInMonth() attempted to return Photographs using an invalid month.", null, testLibrary.getPhotosInMonth(121, 1906));
	}

	@Test
	void testGetPhotosBetween() {
		ArrayList<Photograph> testList = new ArrayList<Photograph>();
		PhotoLibrary testLibrary = new PhotoLibrary("testLibraryName", 1);
		Photograph testPhoto1 = new Photograph("adalovelace.jpg", "Ada Lovelace", "1906-12-10", 5);
		Photograph testPhoto2 = new Photograph("Alan_Turing_Aged_16.jpg", "Alan Turing", "1910-06-23", 4);
		Photograph testPhoto3 = new Photograph("AnnieEasley.jpg", "Annie Easley", "1933-04-23", 3);
		Photograph testPhoto4 = new Photograph("Grace_Hopper_and_UNIVAC.jpg", "Grace Hopper and UNIVAC", "1906-12-09", 5);
		testLibrary.addPhoto(testPhoto1);
		testLibrary.addPhoto(testPhoto2);
		testLibrary.addPhoto(testPhoto3);
		testLibrary.addPhoto(testPhoto4);
		testList.add(testPhoto1);
		testList.add(testPhoto2);
		testList.add(testPhoto3);
		testList.add(testPhoto4);
		assertEquals("getPhotosBetween() did not return the expected Photographs.", testList, testLibrary.getPhotosBetween("1906-12-09", "1950-11-02"));
	}

}
