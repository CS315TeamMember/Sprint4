package sprint4;

import java.util.*;

/**
 * Sprint 1
 * @author Adair Tabb
 * 
 */

/**
 * Sprint 2
 * @author Evelina
 *
 */

/**
 * Sprint 3
 * @author Adair Tabb
 *
 */

public class Photograph implements Comparable<Photograph> {
	/**
	 * 
	 * Stores the permanent filename of a Photograph object.
	 * @author Adair Tabb
	 */
	private final String FILENAME;
	/**
	 * Stores the permanent caption of a Photograph object.
	 * @author Adair Tabb
	 */
	private String caption; //mutator for caption can't work with caption as a final variable. - A.
	
	
	/**
	 * @author Evelina
	 * A String containing the date the photograph was taken.
	 * 
	 */
	private String dateTaken;
	
	/**
	 * @author Evelina
	 * An int that contains the rating of the photograph on a scale from 0 to 5.
	 */
	private int rating;
	
	/**
	 * Constructor for a Photograph object, taking a filename and caption, which are then stored in the class fields.
	 * @param filename The filename of the photograph object.
	 * @param caption  The caption of the photograph object.
	 * @author Adair Tabb
	 */
	Photograph(String filename, String caption) {
		this.FILENAME = filename;
		this.caption = caption;
	}
	
	
	/**
	 * @author Evelina 
	 * Constructor for a Photograph object that takes a filename, caption, date the photo was taken, and a rating of the photo and stores it in the class fields.
	 * 
	 * @param filename The filename of the photograph object.
	 * @param caption The caption of the photograph object.
	 * @param dateTaken The date the photograph object was taken.
	 * @param rating The rating on a scale from 0 to 5 of the photo object.
	 */
	public Photograph(String filename, String caption, String dateTaken, int rating) {
		this.FILENAME = filename;
		this.caption = caption;
		this.dateTaken = dateTaken;
		this.rating = rating;
	}
	
	/**
	 * Gets and returns the filename stored in the corresponding class field.
	 * @return The string currently stored in the FILENAME class field.
	 * @author Adair Tabb
	 */
	public String getFileName() {
		return FILENAME;
	}
	
	/**
	 * Gets and returns the caption stored in the corresponding class field.
	 * @return The string currently stored in the CAPTION class field.
	 * @author Adair Tabb
	 */
	public String getCaption() {
		return caption;
	}
	
	/**
	 * @author Evelina
	 * Gets and returns the date the photo was taken in the corresponding class field.
	 * @return The string currently stored in the dateTaken class field.
	 */
	public String getDateTaken() {
		return dateTaken;
	}
	
	/**
	 * @author Evelina
	 * Gets and returns the rating of the photo in the corresponding class field.
	 * @return The int currently stored in the rating class field.
	 */
	public int getRating() {
		return rating;
	}
	
	/**
	 * @author Evelina
	 * Mutator/setter for the field caption.
	 * @param caption
	 */
	public void setCaption(String caption) {
		this.caption = caption;
	}
	
	/**
	 * @author Evelina
	 * Mutator/setter for the field rating.
	 * @param rating
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	/**
	 * @author Adair Tabb
	 * A method that is meant to compare a different Photograph object to the current Photograph object.
	 * @param o The object to be compared to the current Photograph object.
	 * @return Returns false if the object is not a Photograph, or if the Photograph being compared to the current Photograph has a different value FILENAME and CAPTION. Returns true if the object is a Photograph and has the same value FILENAME and CAPTION.
	 * 
	 * @author Evelina
	 * Edited to fit sprint 2 requirements
	 * Added the dateTaken being compared and added as a requirement for two photos to be considered equal.
	 */
	public boolean equals(Object o) {
		if (!(o instanceof Photograph)) {
			return false;
		}
		Photograph that = (Photograph) o;
		
		return this.FILENAME.equals(that.FILENAME) && this.caption.equals(that.caption) && this.dateTaken.equals(that.dateTaken);
	}
	
	/**
	 * A method to allow a Photograph object's field information to be printed as an easily readable String when the object is called in a print() or println().
	 * @return A String containing the Photograph object's fields in an understandable format. 
	 * @author Adair Tabb
	 */
	public String toString() {
		return "Filename: " + FILENAME + "\n" + "Caption: " + caption;
	}
	
	/**
	 * @author Evelina
	 *  Overrides the default hashCode method in the Object class to produce a unique integer for a Photograph object.
	 */
	public int hashCode() {
		String uniqueStr = FILENAME + "---" + caption + "---" + dateTaken;
		return uniqueStr.hashCode();
	}


	@Override
	public int compareTo(Photograph p) {
		int result = this.getDateTaken().compareTo(p.getDateTaken());
		if(result < 0) {
			return result;
		}
		if (result > 0) {
			return result;
		}
		else {
			return this.getCaption().compareTo(p.getCaption());
		}
	}
}
