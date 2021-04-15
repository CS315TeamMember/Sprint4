/* Sprint 3
 * Evelina Teran
 */

package sprint3;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;


public class PhotoLibrary extends PhotographContainer{
	
	/**
	 *  
	 * "id" is an integer containing the PhotoLibrary's unique id. Once
	 * set it will never change.
	 * 
	 * "albums" is a Hashset of Albums that this user created. Each album will
	 * then contain photos from this user's photos stream that they have organized into albums.
	 */
	private final int ID;
	private HashSet<Album> albums = new HashSet<Album>();
	/**
	 * Constructor for name and id
	 * 
	 * @param name
	 * @param id
	 */
	public PhotoLibrary(String name, int id) {
		this.name = name;
		this.ID = id;		
	}
	
	
	/**
	 * Accessor/getter for id
	 * @return ID
	 */
	public int getId() {
		return ID;
	}
	/**
	 * @author Evelina
	 * Accessor/getter for albums
	 */
	public HashSet<Album> getAlbums(){
		return albums;
	}
	
	
	/**
	 * Mutator/setter for the field name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	//Erases a photo from the feed
	//Modify this one
	public boolean removePhoto(Photograph p) {
		if (!photos.contains(p)) {
			return false;
		}
		else {
			String albumName = null;
			for(Album album1: albums) {
				if (album1.hasPhoto(p)){
					albumName = album1.getName();
					removePhotoFromAlbum(p, albumName);
				}
			}
			return getPhotos().remove(p);
		}
		
	}
	
	
	/**
	 * This method is meant to compare one PhotoLibrary object against the current Photolibrary object and returns true or false depending on if the IDs match.
	 *
	 * @param o The object being compared to the PhotoLibrary object.
	 * @return If the object is not a PhotoLibrary object, it will return false. If the object is a PhotoLibrary object, but its ID is different from the current PhotoLibrary object, the method will return false. If the object is a PhotoLibrary object AND has the same ID as the current Photolibrary object, it will return true.
	 * @author Adair Tabb
	 */
	public boolean equals(Object o) {
		if (!(o instanceof PhotoLibrary)) {
			return false;
		}
		PhotoLibrary that = (PhotoLibrary) o;
		
		return (this.ID == that.ID);
	}
	
	/**
	 * A method to allow PhotoLibrary's field information to be printed as an easily readable String the object is called in a print() or println().
	 * @return A String containing the PhotoLibrary object's fields in an understandable format.
	 * @author Adair Tabb
	 */
	public String toString() {
		ArrayList<String> photographs = new ArrayList<String>();
		for(Photograph photo : photos) {
			photographs.add(photo.toString());
		}
		return "Name: " + name + "\n" + "ID: " + ID + "\n" + "Photos: " + photographs;
	}

	/**
	 * @author Evelina
	 * Compares two photo feeds and seeing how many photos they have in common.
	 * @param a represents a feed of photographs
	 * @param b represents a feed of photographs
	 * @return result The number of photos the two feeds have in common
	 */
	public static ArrayList<Photograph> commonPhotos(PhotoLibrary a, PhotoLibrary b){
		ArrayList<Photograph>aPhotos = a.getPhotos();
		ArrayList<Photograph>bPhotos = b.getPhotos();
		
		ArrayList<Photograph>result = new ArrayList<Photograph>();
		
		// Using for each loops to loop through every photo in the ArrayLists aPhotos and bPhotos
		// Structure for these loops are "for (type variableName : arrayName)"
		for (Photograph photoA : aPhotos) {
			if(bPhotos.contains(photoA)) {
					result.add(photoA);
				}
			}
		return result;
	}
	
	/**
	 * @author Evelina
	 * Returns a measure of how similar the photo beeds are between PhotoLibrary a and PhotoLibrary b, in terms of
	 * a numerical value between 0 and 1.
	 * @param a represents a photo feed
	 * @param b represents a photo feed
	 * @return simVal Returns a value between 0 and 1
	 */
	
	public static double similarity(PhotoLibrary a, PhotoLibrary b) {
		double simVal;
		
		ArrayList<Photograph>result = PhotoLibrary.commonPhotos(a, b);
		if (result.isEmpty()) {
			return 0.0;
		}
		else {
			// number of common photos divided by total number of photos (percentage of similarity)
			simVal = (double)result.size() / ((double)a.numPhotographs() + (double)b.numPhotographs());
			return simVal;
		}
	}
	
	
	
	/**
	 * Creates a new Album with the name albumName if an Album with that name exists in the set of albums.
	 * @author Evelina
	 * @param albumName Name of the album being created.
	 * @return Returns true if the add was successful, false otherwise.
	 */
	public boolean createAlbum(String albumName) {
		Album a1 = new Album(albumName);
		return albums.add(a1);
	}
	
	/**
	 * Removes the Album with name albumName if an Album with that name exists in the set of albums.
	 * @author Evelina
	 * @param albumName Name of the album being removed.
	 * @return Returns true if the remove was successful, false otherwise.
	 */
	public boolean removeAlbum(String albumName) {
		if (!albums.contains(getAlbumByName(albumName))) {
			return false;
		}
		else {
			return albums.remove(getAlbumByName(albumName));
			//return getPhotos().remove(albumName);
		}
	}
	
	/**
	 * Add the Photograph p to the Album in the set of albums that has name albumName if and only if 
	 * it is in the PhotoLibrary's list of photos and it was not already in that album.
	 * @author Evelina
	 * @param p The photo that is being added to the album.
	 * @param albumName The name of the album for which the photo is being added.
	 * @return Returns true if the Photograph was added; return false if it was not added.
	 */
	public boolean addPhotoToAlbum(Photograph p, String albumName) {
		if (getAlbumByName(albumName) != null) {
			if (photos.contains(p)) {
				return getAlbumByName(albumName).addPhoto(p);
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	/**
	 * Removes the Photograph p from the Album in the set of albums that has name albumName.
	 * @author Evelina
	 * @param p Photograph that is being removed.
	 * @param albumName Name of the album for which the photo is being removed from.
	 * @return Returns true if the photo was successfully removed. Otherwise return false.
	 */
	public boolean removePhotoFromAlbum(Photograph p, String albumName) {
		return getAlbumByName(albumName).removePhoto(p);
	}
	
	/**
	 * Given an album name, return the Album with that name from the set of albums.
	 * @author Evelina
	 * @param albumName Name of the album that is being searched for.
	 * @return Returns the Album. If an album with that name is not found, returns null.
	 */
	Album getAlbumByName(String albumName) {
		for(Album album1: albums) {
			if (album1.getName().equals(albumName)){
				return album1;
			}
		}
		
		return null;
	}
	
}
