package sprint4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;

/**
 * PhotoViewer Graphical User Interface 
 * 
 * This class contains the graphical user interface for the Photograph Organization
 * software. 
 * 
 * You will need to implement certain portions of this class, marked with comments starting with "TODO" to connect 
 * it with your existing code. 
 * 
 * This class provides an example layout for the GUI. You are encouraged to be creative in your design. 
 * More information about Swing is online at: 
 * https://docs.oracle.com/javase/tutorial/uiswing/components/componentlist.html.
 * 
 * 
 */
public class PhotoViewer extends JFrame {

    /**
     * Serialization string required by extending JFrame
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Image Library that is displayed in this GUI
     */
    private PhotographContainer imageLibrary;
    private int albumPosition;

    private JButton nextButton;
    private JButton previousButton;

    private JButton dateSortButton;
    private JButton captionSortButton;
    private JButton ratingSortButton;

    private ButtonGroup ratingButtonGroup;

    private JRadioButton rb1;
    private JRadioButton rb2;
    private JRadioButton rb3;
    private JRadioButton rb4;
    private JRadioButton rb5;

    private BorderLayout panelLayout;
    private BoxLayout iconLayout;

    private JLabel imageDisplayLabel;
    
    private JPanel controlPanel;
    private JPanel displayPanel;
    private JPanel thumbnailPanel;
    private JPanel bottomPanel;
    private JPanel panelPane;
    
    /**
     * Getter for image library
     * 
     * @return The PhotographContainer associated with this graphical user interface
     */
    public PhotographContainer getImageLibrary() {
        return imageLibrary;
    }

    /**
     * Set the PhotographContainer associated with this graphical user interface
     * 
     * @param imageLibrary The PhotographContainer to display
     */
    public void setImageLibrary(PhotographContainer imageLibrary) {
        this.imageLibrary = imageLibrary;
    }


    /**
     * Button listener for the Next and Previous Buttons
	 * @author Alex Dozzi
	 */
    class NavigationListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (e.getActionCommand() == "next") { 
				albumPosition++;
				if (albumPosition >= getImageLibrary().getPhotos().size()) {
						albumPosition = 0; 
				}	
				displayPhoto(albumPosition);
				drawThumbnails();
			}
			
			else if (e.getActionCommand() == "previous") {
				albumPosition--;
				if (albumPosition < 0) {
					albumPosition = getImageLibrary().getPhotos().size()-1;  
				}
				displayPhoto(albumPosition);
				drawThumbnails();
			}
			
		}
    }
    
    /**
     * Button Listener for the Rating radio buttons
     * @author Alex Dozzi
     */
    class RatingChangeListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "rate1") {
				getImageLibrary().getPhotos().get(albumPosition).setRating(1);	

			}
			
			else if (e.getActionCommand() == "rate2") {
				getImageLibrary().getPhotos().get(albumPosition).setRating(2);	

			}
			
			else if (e.getActionCommand() == "rate3") {
				getImageLibrary().getPhotos().get(albumPosition).setRating(3);

			}
			
			else if (e.getActionCommand() == "rate4") {
				getImageLibrary().getPhotos().get(albumPosition).setRating(4);	

			}
			
			else if (e.getActionCommand() == "rate5") {
				getImageLibrary().getPhotos().get(albumPosition).setRating(5);

			}
			drawThumbnails();
						
		}
    }
    
    /**
     * Button Listener for the Sort buttons
     * @author Alex Dozzi
     */
    class SortNavigationListener implements ActionListener {
    	
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "dateSort") {				
				Collections.sort(getImageLibrary().getPhotos());		
			}
			
			else if (e.getActionCommand() == "captionSort") {
				CompareByCaption cc = new CompareByCaption();
				getImageLibrary().getPhotos().sort(cc);
				
			}
			
			else if (e.getActionCommand() == "ratingSort") {
				CompareByRating cr = new CompareByRating();
				getImageLibrary().getPhotos().sort(cr);	
			}
			
			drawThumbnails();
		}
        
    }

    /**
     * Main method.  This method initializes a PhotoViewer, loads images into a PhotographContainer, then
     * initializes the Graphical User Interface.
     * 
     * @param args  Optional command-line arguments
     */
    public static void main(String[] args) {
        // Instantiate the PhotoViewer Class
        PhotoViewer myViewer = new PhotoViewer();

        // The relative image directory (for Windows, change to "images\\")
        String imageDirectory = "images\\";
        
        //Photograph p1 = new Photograph (imageDirectory + "Ada_Lovelace.jpg", "caption", " 2015 -06 -30 ", 5) ;
        Photograph p1 = new Photograph(imageDirectory + "Ada_Lovelace.jpg", "Ada Lovelace", "1815-12-10", 5);
		Photograph p2 = new Photograph(imageDirectory + "Alan_Turing_Aged_16.jpg", "Alan Turing", "1912-06-23", 4);
		Photograph p3 = new Photograph(imageDirectory + "AnnieEasley.jpg", "Annie Easley", "1933-04-23", 3);
		Photograph p4 = new Photograph(imageDirectory + "Dorothy_Vaughan.jpg", "Dorothy Vaughan", "1910-09-20", 2);
		Photograph p5 = new Photograph(imageDirectory + "Grace_Hopper_and_UNIVAC.jpg", "Grace Hopper and UNIVAC", "1906-12-09", 1);

    	myViewer.setImageLibrary(new PhotoLibrary(" Test Library ", 1) ) ;
    	myViewer.getImageLibrary().addPhoto(p1);
    	myViewer.getImageLibrary().addPhoto(p2);
    	myViewer.getImageLibrary().addPhoto(p3);
    	myViewer.getImageLibrary().addPhoto(p4);
    	myViewer.getImageLibrary().addPhoto(p5);
        // TODO Load images below
    	p1.loadImageData(p1.getFileName());
    	p2.loadImageData(p2.getFileName());
    	p3.loadImageData(p3.getFileName());
    	p4.loadImageData(p4.getFileName());
    	p5.loadImageData(p5.getFileName());

        // Invoke and start the Graphical User Interface
        javax.swing.SwingUtilities.invokeLater(() -> myViewer.initialize());
    
    }
    
    
    
    /**
     * Initialize all the GUI components.  This method will be called by
     * SwingUtilities when the application is started.
     */
    private void initialize() {

        // Tell Java to exit the program when the window is closed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Tell Java to title the window based on the imageLibrary's name
        this.setTitle(this.imageLibrary.getName());

        // Display panels for the window.  They default to FLowLayout.
        controlPanel = new JPanel();
        displayPanel = new JPanel();
        thumbnailPanel = new JPanel();
        bottomPanel = new JPanel();

        // We will use border layout on the main panel, since it is much easier for organizing panels.
        panelLayout = new BorderLayout();
        panelPane = new JPanel(panelLayout);

        // Create a label to display the full image.
        imageDisplayLabel = new JLabel();

        // Initialize listeners for all components
        NavigationListener controlNavigationListener = new NavigationListener();
        RatingChangeListener ratingButtonListener = new RatingChangeListener();
        SortNavigationListener sortListener = new SortNavigationListener();


        // Add buttons for sorting thumbnails.
        dateSortButton = new JButton("Sort by Date");
        dateSortButton.setActionCommand("dateSort");
        dateSortButton.addActionListener(sortListener);

        captionSortButton = new JButton("Sort by Caption");
        captionSortButton.setActionCommand("captionSort");
        captionSortButton.addActionListener(sortListener);

        ratingSortButton = new JButton("Sort by Rating");
        ratingSortButton.setActionCommand("ratingSort");
        ratingSortButton.addActionListener(sortListener);
 
        controlPanel.add(dateSortButton);
        controlPanel.add(captionSortButton);
        controlPanel.add(ratingSortButton);

        displayPanel.add(imageDisplayLabel);

        // Use a BoxLayout to display the thumbnails.
        iconLayout = new BoxLayout(thumbnailPanel, BoxLayout.Y_AXIS);
        thumbnailPanel.setLayout(iconLayout);
        drawThumbnails();

        // Add buttons for next and previous navigation
        previousButton = new JButton("Previous");
        previousButton.setActionCommand("previous");
        previousButton.addActionListener(controlNavigationListener);
        bottomPanel.add(previousButton);
        
        nextButton = new JButton("Next");
        nextButton.setActionCommand("next");
        nextButton.addActionListener(controlNavigationListener);
        bottomPanel.add(nextButton);

        
        // Use a set of radio buttons to set and display the ratings of the current image.
        // Many other interesting controls exist (like the slider) but radio buttons are familiar.
        ratingButtonGroup = new ButtonGroup();
        rb1 = new JRadioButton("1");
        rb2 = new JRadioButton("2");
        rb3 = new JRadioButton("3");
        rb4 = new JRadioButton("4");
        rb5 = new JRadioButton("5");

        // Add Rating options to the bottom panel
        bottomPanel.add(new JLabel("   Rating"));

        rb1.setActionCommand("rate1");
        rb1.addActionListener(ratingButtonListener);
        ratingButtonGroup.add(rb1);
        bottomPanel.add(rb1);

        rb2.setActionCommand("rate2");
        rb2.addActionListener(ratingButtonListener);
        ratingButtonGroup.add(rb2);
        bottomPanel.add(rb2);

        rb3.setActionCommand("rate3");
        rb3.addActionListener(ratingButtonListener);
        ratingButtonGroup.add(rb3);
        bottomPanel.add(rb3);

        rb4.setActionCommand("rate4");
        rb4.addActionListener(ratingButtonListener);
        ratingButtonGroup.add(rb4);
        bottomPanel.add(rb4);

        rb5.setActionCommand("rate5");
        rb5.addActionListener(ratingButtonListener);
        ratingButtonGroup.add(rb5);
        bottomPanel.add(rb5);


        // Call the method that displays the main photograph
        displayPhoto(albumPosition);

        // Add all the panels to the main display based on BorderLayout
        panelPane.add(controlPanel, BorderLayout.PAGE_START);
        panelPane.add(displayPanel, BorderLayout.CENTER);
        panelPane.add(thumbnailPanel, BorderLayout.WEST);
        panelPane.add(bottomPanel, BorderLayout.SOUTH);
        this.getContentPane().add(panelPane);

        // Show the main application window
        this.pack();
        this.setVisible(true);
    }
    

    /**
     * Display thumbnails in the thumbnailPanel.  
     * 
     * @author Adair Tabb
     */
    private void drawThumbnails() {
        // Clear the panel of all thumbnails
        thumbnailPanel.removeAll();
        
        // For each photograph in the library, add it to the panel in the appropriate order
        for (Photograph p : imageLibrary.getPhotos()) {
            
            // Create a label for image information, including caption, date taken, and rating
            JLabel thumbnailLabel = new JLabel("<html><body width='300'>"
                    + p.getCaption() + "<br>(" + p.getDateTaken() + ")<br>" 
                    + "rated: " + p.getRating() + "</body></html>");
            
            // TODO add an appropriate listener to display the chosen photo in the main image display
            // Note: you will need a way to get the position of image p in the imageLibrary's photos list
           
            thumbnailLabel.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					displayPhoto(imageLibrary.getPhotos().indexOf(p));
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
            	
            });
            
            
            // Add the scaled image as the thumbnail.
            try {
                BufferedImage b = p.getImageData();
                thumbnailLabel.setIcon(new ImageIcon(b.getScaledInstance(102, 77, Image.SCALE_FAST)));
            } catch (Exception e) {
                System.err.println("Could not scale the image.");
            }
          
            
            // Add this thumbnail and label to the thumbnailPanel
            thumbnailPanel.add(thumbnailLabel);
        }
    }

    /**
     * Displays a photo, given by the index into the imageLibrary's photos, into the main display.
     * 
     * @param position The position into the imageLibrary's photos list
     * 
     * @author Adair Tabb
     */
    private void displayPhoto(int position) {
    	Photograph p = imageLibrary.getPhotos().get(position);
    	albumPosition = position;
    	BufferedImage b = p.getImageData();
    	imageDisplayLabel.setIcon(new ImageIcon(b));
    	
        // Repaint the display so that the new image gets displayed
        displayPanel.repaint();
        

    }
}
