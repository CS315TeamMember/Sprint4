package sprint3;
import java.util.*;


public class Main {
	public static void main(String args[]) {
		Album yup = new Album("yup");
		Album zer = new Album("zer");
		Album xxx = new Album("xxx");
		
		Photograph selfie = new Photograph("selfie", "me");
		Photograph friend = new Photograph("friend", "me and tim");
		Photograph mom = new Photograph("mom", "my mom");
		
		if (yup.addPhoto(selfie)) {
			System.out.print("Photo has been added");	
		}
		else {
			System.out.print("Photo has not been added");
		}
		
		System.out.print(yup.getPhotos());
		
		
		if (yup.hasPhoto(selfie)) {
			System.out.print("Photo is in album");
		}
		else {
			System.out.print("Photo is not in album");
		}
		
		
		
		
		
		
	}

}
