package sprint4;

import java.util.*;

public class CompareByCaption implements Comparator<Photograph> {

	@Override
	public int compare(Photograph p1, Photograph p2) {
		int captionResult = p1.getCaption().compareTo(p2.getCaption());
		if (captionResult == 0) {
			if(p1.getRating() > p2.getRating()) {
				return 1; 
			}
			if(p1.getRating() < p2.getRating()) {
				return -1;
			}
			else {
				return 0;
			}
		}
		else {
			return captionResult;
		}
	}

}
 