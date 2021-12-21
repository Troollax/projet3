package Projet_L2;



import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
		Scene sc = new Scene (root1, 800, 400);		 
		stage.setScene(sc);
		
		//console
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(10));
		hbox.setSpacing(5);
		
		TextField Console = new TextField();
		Console.setPrefWidth(800);
		Console.setPrefHeight(50);
		hbox.getChildren().addAll(Console);
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
        Ouvrage un = new Ouvrage("Le petit Prince", "Antoine" , "de Saint Exuperry", 25000);
        Ouvrage deux = new Ouvrage("L'Avare", "Molière" , " ", 40000);
        Ouvrage trois = new Ouvrage("Le Rouge et le Noir", "Stendhal" , " ", 132456);
           

        //Root Item
        TreeItem<Ouvrage> itemRoot = new TreeItem<Ouvrage>(un);
        TreeItem<Ouvrage> itemSmith = new TreeItem<Ouvrage>(deux);
        TreeItem<Ouvrage> itemMcNeil = new TreeItem<Ouvrage>(trois);

        itemRoot.getChildren().addAll(itemSmith, itemMcNeil);
        Tableau.setRoot(itemRoot);
        
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
		
		
	}	

}
