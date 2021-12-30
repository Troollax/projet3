package Projet_L2;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller {

	//
	@FXML
	ImageView myImageView;
	
	Image myImage = new Image(getClass().getResourceAsStream("image.jpg"));
	
	public void displayImage() {
		myImageView.setImage(myImage);
	}
	
	
	//
}
