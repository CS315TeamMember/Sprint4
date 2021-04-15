package sprint4;

import java.util.*;

public class CompareByRating implements Comparator<Photograph> {

	@Override
	public int compare(Photograph p1, Photograph p2) {
		if(p1.getRating() > p2.getRating()) {
			return 1; 
		}
		if(p1.getRating() < p2.getRating()) {
			return -1;
		}
		else {
			return p1.getCaption().compareTo(p2.getCaption());
		}
	}

}
