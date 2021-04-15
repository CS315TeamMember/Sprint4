package sprint3;

import java.util.ArrayList;

/**
 * Sprint 3
 * @author Alex Dozzi
 * 
 */

public class Album extends PhotographContainer{

	
	/**
	 * Constructor for an Album object. Takes in a string as the name for a given album.
	 * @param (name): name of the album
	 */
	public Album(String name) {
		this.name = name;
	}

	
	/**
	 * Method that returns the Album name and the filenames of the photographs in the Album as a string. Overrides inherited method from PhotographContainer.
	 * @return (String): String of Album name and photos.
	 * @author Adair Tabb
	 */
	@Override
	public String toString() {
		ArrayList<String> photographs = new ArrayList<String>();
		for(Photograph photo : photos) {
			photographs.add(photo.getFileName());
		}
		return "Photo Album: " + name + "\nPhotographs: " + photographs;		
	}
	

}

