package demo;

import app.CCLabeler;
import app.ImagesToProcessList;
import app.MeasuresList;
import ij.ImagePlus;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class demo  {
	


	public static void main(String[] args) {

		// cree une liste d'images à traiter
		ImagesToProcessList ipl = new ImagesToProcessList();
//		ipl.addImagesFromFolder("./images/document/"); // 10 images
		//ipl.addImageName("./images/document/00000.jpg");
		ipl.addImageName("C:\\Users\\loic\\Desktop\\Java IJ du prof\\images\\document\\00000.jpg");
		// traite chaque image de la liste
		CCLabeler counter = new CCLabeler();
		ImagePlus Plus = new ImagePlus("C:\\Users\\loic\\Desktop\\Java IJ du prof\\images\\document\\00000.jpg");
		

		for (Object o : ipl) {
			// traite l'image et compte les particules
			String imagename_to_process = (String) o;
			System.out.println(imagename_to_process);
			counter.process(imagename_to_process);

			// recupère les mesures de l'image traitée
			MeasuresList measure_list = counter.getMeasures();	
			counter.generate_output(Plus);

		}


}
}