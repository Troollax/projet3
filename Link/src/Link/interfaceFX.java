package Link;





import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class interfaceFX extends Application{
	
	
	

	public static void main(String[] args) {
        Application.launch(args);
    }

	 @Override
	 public void start(Stage stage) throws Exception {
		 
		 	

	        
	    

	        
		 
		stage.setTitle("Bienvenue");		 
		BorderPane root1 = new BorderPane();
		Scene sc = new Scene (root1, 800, 450);		 
		stage.setScene(sc);
		
		
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(10));
		hbox.setSpacing(5);
		
		//console
			TextArea ta = new TextArea();
			ta. setPrefHeight(100); 
			ta. setPrefWidth(800); 
			
		
		 
	    	ta.setEditable(false);
	        Console console = new Console(ta);
	        PrintStream ps = new PrintStream(console, true);
	        System.setOut(ps);
	        System.setErr(ps);
	        Scene app = new Scene(ta);
	        hbox.getChildren().addAll(ta);
	        
	        
	        for (char c : "some text".toCharArray()) {
	            console.write(c);
	        }
	        ps.close();
	
		//Tableau
        TreeTableView<Ouvrage> Tableau = new TreeTableView<Ouvrage>();

        	//Colonne Titre
        	TreeTableColumn<Ouvrage, String> Titre = new TreeTableColumn<Ouvrage, String>("Titre");

        	//Colonne Auteur
        	TreeTableColumn<Ouvrage, String> Auteur = new TreeTableColumn<Ouvrage, String>("Auteur");
        	TreeTableColumn<Ouvrage, String> PrenomAuteur  = new TreeTableColumn<Ouvrage, String>("Prénom");
        	TreeTableColumn<Ouvrage, String> NomAuteur  = new TreeTableColumn<Ouvrage, String>("Nom");
        	Auteur.getColumns().addAll(PrenomAuteur, NomAuteur);
        	
        	//Colonne Nombre de mots
        	TreeTableColumn<Ouvrage, String> NbreMots = new TreeTableColumn<Ouvrage, String>("Nombre de mots");
 
        //Définit comment aller chercher la valeur des attributs dans la classe Ouvrage
        Titre.setCellValueFactory(new TreeItemPropertyValueFactory<Ouvrage, String>("titre"));
        PrenomAuteur.setCellValueFactory(new TreeItemPropertyValueFactory<Ouvrage, String>("prenom"));
        NomAuteur.setCellValueFactory(new TreeItemPropertyValueFactory<Ouvrage, String>("nom"));
        NbreMots.setCellValueFactory(new TreeItemPropertyValueFactory<Ouvrage, String>("nbrMots"));
        
        //Ajoute les colonne au Tableau
        Tableau.getColumns().addAll(Titre, Auteur,NbreMots);

        //Informations
        Ouvrage un = new Ouvrage("Le petit Prince", "Antoine" , "de Saint Exuperry", null, 25000);
        Ouvrage deux = new Ouvrage("L'Avare", "Molière" , " ", null, 40000);
        Ouvrage trois = new Ouvrage("Le Rouge et le Noir", "Stendhal" , " ", null, 132456);
           

        //Root Item
        TreeItem<Ouvrage> Ouvr1 = new TreeItem<Ouvrage>(un);
        TreeItem<Ouvrage> Ouvr2 = new TreeItem<Ouvrage>(deux);
        TreeItem<Ouvrage> Ouvr3 = new TreeItem<Ouvrage>(trois);

        Ouvr1.getChildren().addAll(Ouvr2, Ouvr3);
        Tableau.setRoot(Ouvr1);
        
        StackPane root = new StackPane();
        root.setPadding(new Insets(5));
        root.getChildren().add(Tableau);


       
		//Barre de droite 
		VBox vbox2 = new VBox();
		vbox2.setPadding(new Insets(10));
		vbox2.setSpacing(40);
		
			//Boutons présents dans la barre
			Button btn_Ouvrir = new Button("Ouvrir");
			Button btn_Ajouter = new Button("Ajouter");
			Button btn_Supprimer = new Button("Supprimer");
			Button btn_Editer = new Button("Editer");
			Button btn_Galerie = new Button("Galerie");
			
			vbox2.getChildren().addAll(btn_Ouvrir,btn_Ajouter, btn_Supprimer, btn_Editer, btn_Galerie);		
		
		//Positionnement des éléments
		root1.setTop(hbox);
		root1.setRight(vbox2);
		root1.setCenter(Tableau);
		stage.show();
		
		
		//permet d'ouvrir l'interface fxml Ajouter
		btn_Ajouter.setOnMouseClicked((event) -> {
		    try {
		        FXMLLoader fxmlLoader = new FXMLLoader();
		        fxmlLoader.setLocation(getClass().getResource("Ajouter.fxml"));
		       
		        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
		        Stage stage1 = new Stage();
		        stage1.setTitle("New Window");
		        stage1.setScene(scene);
		        stage1.show();
		    } catch (IOException e) {
		        Logger logger = Logger.getLogger(getClass().getName());
		        logger.log(Level.SEVERE, "Failed to create new Window.", e);
		    }
		});
		
		
		
		//Permet d'ouvrir l'interface Galerie
		btn_Galerie.setOnMouseClicked((event) -> {
		    try {
		        FXMLLoader fxmlLoader = new FXMLLoader();
		        fxmlLoader.setLocation(getClass().getResource("Galerie.fxml"));
		       
		        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
		        Stage stage1 = new Stage();
		        stage1.setTitle("New Window");
		        stage1.setScene(scene);
		        stage1.show();
		    } catch (IOException e) {
		        Logger logger = Logger.getLogger(getClass().getName());
		        logger.log(Level.SEVERE, "Failed to create new Window.", e);
		    }
	 
	 
		});
	 
	 }
		//Renvoie de la console dans lme TextArea de l'interface
	 	public static class Console extends OutputStream {

	        private TextArea output;

	        public Console(TextArea ta) {
	            this.output = ta;
	        }

	        @Override
	        public void write(int i) throws IOException {
	            output.appendText(String.valueOf((char) i));
	        }
	    }
		 
	
}
	 




