package Projet_L2;


import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.scene.control.Label;




public class Interface extends Application{
	
	
	

	public static void main(String[] args) {
		
        Application.launch(args);
       
    }

	 @Override
	 public void start(Stage stage) throws Exception {

		stage.setTitle("Bienvenue");		 
		BorderPane root1 = new BorderPane();
		Scene sc = new Scene (root1, 800, 500);		 
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
	        
	        
	        for (char c : "Bienvenue dans notre projet".toCharArray()) {
	            console.write(c);
	        }
	        ps.close();
	
		//Tableau
        TreeTableView<Ouvrage> Tableau = new TreeTableView<Ouvrage>();

        	//Colonne Titre
        	TreeTableColumn<Ouvrage, String> Titre = new TreeTableColumn<Ouvrage, String>("Titre");

        	//Colonne Auteur
        	TreeTableColumn<Ouvrage, String> Auteur = new TreeTableColumn<Ouvrage, String>("Auteur");
        	TreeTableColumn<Ouvrage, String> PrenomAuteur  = new TreeTableColumn<Ouvrage, String>("Pr�nom");
        	TreeTableColumn<Ouvrage, String> NomAuteur  = new TreeTableColumn<Ouvrage, String>("Nom");
        	Auteur.getColumns().addAll(PrenomAuteur, NomAuteur);
        	
        	//Colonne Nombre de mots
        	TreeTableColumn<Ouvrage, String> NbreMots = new TreeTableColumn<Ouvrage, String>("Nombre de mots");
 
        //D�finit comment aller chercher la valeur des attributs dans la classe Ouvrage
        Titre.setCellValueFactory(new TreeItemPropertyValueFactory<Ouvrage, String>("titre"));
        PrenomAuteur.setCellValueFactory(new TreeItemPropertyValueFactory<Ouvrage, String>("prenom"));
        NomAuteur.setCellValueFactory(new TreeItemPropertyValueFactory<Ouvrage, String>("nom"));
        NbreMots.setCellValueFactory(new TreeItemPropertyValueFactory<Ouvrage, String>("nbrMots"));
        
        //Ajoute les colonne au Tableau
        Tableau.getColumns().addAll(Titre, Auteur,NbreMots);

        //Informations
        Ouvrage un = new Ouvrage("Le petit Prince", "Antoine" , "de Saint Exuperry", 25000);
        Ouvrage deux = new Ouvrage("L'Avare", "Moli�re" , " ", 40000);
        Ouvrage trois = new Ouvrage("Le Rouge et le Noir", "Stendhal" , " ", 132456);
           

        //Root Item
        TreeItem<Ouvrage> Ouvr1 = new TreeItem<Ouvrage>(un);
        TreeItem<Ouvrage> Ouvr2 = new TreeItem<Ouvrage>(deux);
        TreeItem<Ouvrage> Ouvr3 = new TreeItem<Ouvrage>(trois);

        Ouvr1.getChildren().addAll(Ouvr2, Ouvr3);
        Tableau.setRoot(Ouvr1);
        
       

       
		//Barre de droite 
		VBox vbox2 = new VBox();
		vbox2.setPadding(new Insets(10));
		vbox2.setSpacing(40);
		
			//Boutons pr�sents dans la barre
			Button btn_Ouvrir = new Button("Ouvrir");
			Button btn_Ajouter = new Button("Ajouter");
			Button btn_Supprimer = new Button("Supprimer");
			Button btn_Editer = new Button("Editer");
			Button btn_Galerie = new Button("Galerie");
			Button btn_Loic = new Button("LOIC");
			
			vbox2.getChildren().addAll(btn_Ouvrir,btn_Ajouter, btn_Supprimer, btn_Editer, btn_Galerie,btn_Loic);		
		
		//Positionnement des �l�ments
		root1.setTop(hbox);
		root1.setRight(vbox2);
		root1.setCenter(Tableau);
		stage.show();
		
		
		//permet d'ouvrir l'interface fxml Ajouter
		btn_Ajouter.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				AnchorPane root = new AnchorPane();
			       
			       TextField t1 = new TextField();
			       TextField t2 = new TextField();
			       TextField t3 = new TextField();
			       
			       Label l1 = new Label("Id");
			       Label l2 = new Label("Titre");
			       Label l3 = new Label("Auteur");
			       
			       
			       
			     
			    	   

			       Button button4 = new Button("Ajouter l'ouvrage");

			       // (Id) Anchor to the Top + Left + Right
			       AnchorPane.setTopAnchor(t1, 20.0);
			       AnchorPane.setLeftAnchor(t1, 50.0);
			       AnchorPane.setRightAnchor(t1, 320.0);
			       
			       AnchorPane.setTopAnchor(l1, 22.0);
			       AnchorPane.setLeftAnchor(l1, 30.0);
			       AnchorPane.setRightAnchor(l1, 320.0);
			       
			       // (Titre) Anchor to the Top + Left + Right
			       AnchorPane.setTopAnchor(t2, 50.0);
			       AnchorPane.setLeftAnchor(t2, 50.0);
			       AnchorPane.setRightAnchor(t2, 320.0);
			       
			       AnchorPane.setTopAnchor(l2, 52.0);
			       AnchorPane.setLeftAnchor(l2, 20.0);
			       AnchorPane.setRightAnchor(l2, 320.0);
			       
			       // (Auteur) Anchor to the Top + Left + Right
			       AnchorPane.setTopAnchor(t3, 80.0);
			       AnchorPane.setLeftAnchor(t3, 50.0);
			       AnchorPane.setRightAnchor(t3, 320.0);
			       
			       AnchorPane.setTopAnchor(l3, 82.0);
			       AnchorPane.setLeftAnchor(l3, 10.0);
			       AnchorPane.setRightAnchor(l3, 320.0);

			       // (B4) Anchor to the four sides of AnchorPane
			       AnchorPane.setTopAnchor(button4, 150.0);
			       AnchorPane.setLeftAnchor(button4, 50.0);
			       AnchorPane.setRightAnchor(button4, 50.0);
			       AnchorPane.setBottomAnchor(button4, 45.0);

			       // Add buttons to AnchorPane
			       root.getChildren().addAll(t1, t3, t2,l1,l2,l3, button4);
			       Scene secondScene = new Scene(root, 500, 300);
			   	
				// New window (Stage)
				Stage newWindow = new Stage();
				newWindow.setTitle("Interface de Suppression");
				newWindow.setScene(secondScene);

				// Set position of second window, related to primary window.
				newWindow.setX(stage.getX() + 800);
				newWindow.setY(stage.getY() + 100);

				newWindow.show();
				
				 for (char c : "\nOuverture de l'interface d'Ajouts".toCharArray()) {
			            try {
							console.write(c);
						} catch (IOException e) {
							e.printStackTrace();
						}
			        }
			        ps.close();
				
				
			}
			
		});
		
		
		
		//Permet d'ouvrir l'interface Supprimer
		btn_Supprimer.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				AnchorPane root = new AnchorPane();
			       
			       TextField t1 = new TextField();
			       TextField t2 = new TextField();
			       TextField t3 = new TextField();
			       
			       Label l1 = new Label("Id");
			       Label l2 = new Label("Titre");
			       Label l3 = new Label("Auteur");

			       Button button4 = new Button("Supprimer l'ouvrage");

			       // (Id) Anchor to the Top + Left + Right
			       AnchorPane.setTopAnchor(t1, 20.0);
			       AnchorPane.setLeftAnchor(t1, 50.0);
			       AnchorPane.setRightAnchor(t1, 320.0);
			       
			       AnchorPane.setTopAnchor(l1, 22.0);
			       AnchorPane.setLeftAnchor(l1, 30.0);
			       AnchorPane.setRightAnchor(l1, 320.0);

			       // (Titre) Anchor to the Top + Left + Right
			       AnchorPane.setTopAnchor(t2, 50.0);
			       AnchorPane.setLeftAnchor(t2, 50.0);
			       AnchorPane.setRightAnchor(t2, 320.0);
			       
			       AnchorPane.setTopAnchor(l2, 52.0);
			       AnchorPane.setLeftAnchor(l2, 20.0);
			       AnchorPane.setRightAnchor(l2, 320.0);
			       
			       // (Auteur) Anchor to the Top + Left + Right
			       AnchorPane.setTopAnchor(t3, 80.0);
			       AnchorPane.setLeftAnchor(t3, 50.0);
			       AnchorPane.setRightAnchor(t3, 320.0);
			       
			       AnchorPane.setTopAnchor(l3, 82.0);
			       AnchorPane.setLeftAnchor(l3, 10.0);
			       AnchorPane.setRightAnchor(l3, 320.0);

			       // (B4) Anchor to the four sides of AnchorPane
			       AnchorPane.setTopAnchor(button4, 150.0);
			       AnchorPane.setLeftAnchor(button4, 50.0);
			       AnchorPane.setRightAnchor(button4, 50.0);
			       AnchorPane.setBottomAnchor(button4, 45.0);

			       // Add buttons to AnchorPane
			       root.getChildren().addAll(t1, t3, t2,l1,l2,l3, button4);
			       Scene secondScene = new Scene(root, 500, 300);
			   	
				// New window (Stage)
				Stage newWindow = new Stage();
				newWindow.setTitle("Interface de Suppression");
				newWindow.setScene(secondScene);

				// Set position of second window, related to primary window.
				newWindow.setX(stage.getX() + 800);
				newWindow.setY(stage.getY() + 100);

				newWindow.show();
				
				 for (char c : "\nOuverture de l'interface de Suppression".toCharArray()) {
			            try {
							console.write(c);
						} catch (IOException e) {
							e.printStackTrace();
						}
			        }
			        ps.close();
				
				
			}
		});
		/*		btn_Supprimer.setOnMouseClicked((event) -> {
				    try {
				        FXMLLoader fxmlLoader = new FXMLLoader();
				        fxmlLoader.setLocation(getClass().getResource("Supprimer.fxml"));
				       
				        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
				        Stage stage1 = new Stage();
				        stage1.setTitle("New Window");
				        stage1.setScene(scene);
				        stage1.show();
				    } catch (IOException e) {
				        Logger logger = Logger.getLogger(getClass().getName());
				        logger.log(Level.SEVERE, "Failed to create new Window.", e);
				    }
			 
				    
				}); */
		
				//Permet d'ouvrir l'interface de Loic
				btn_Loic.setOnMouseClicked((event) -> {
				    try {
				        FXMLLoader fxmlLoader = new FXMLLoader();
				        fxmlLoader.setLocation(getClass().getResource("Scene.fxml"));
				       
				        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
				        Stage stage1 = new Stage();
				        stage1.setTitle("New Window");
				        stage1.setScene(scene);
				        stage1.show();
				    } catch (IOException e) {
				        Logger logger = Logger.getLogger(getClass().getName());
				        logger.log(Level.SEVERE, "Failed to create new Window.", e);
				    }
			 
				    for (char c : "\nOuverture de l'interface d'Editage".toCharArray()) {
			            try {
							console.write(c);
						} catch (IOException e) {
							e.printStackTrace();
						}
			        }
			        ps.close();
				});
				
				//Permet d'ouvrir l'interface Editer
				btn_Editer.setOnMouseClicked((event) -> {
				    try {
				        FXMLLoader fxmlLoader = new FXMLLoader();
				        fxmlLoader.setLocation(getClass().getResource("Editer.fxml"));
				       
				        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
				        Stage stage1 = new Stage();
				        stage1.setTitle("New Window");
				        stage1.setScene(scene);
				        stage1.show();
				    } catch (IOException e) {
				        Logger logger = Logger.getLogger(getClass().getName());
				        logger.log(Level.SEVERE, "Failed to create new Window.", e);
				    }
			 
				    for (char c : "\nOuverture de l'interface d'Editage".toCharArray()) {
			            try {
							console.write(c);
						} catch (IOException e) {
							e.printStackTrace();
						}
			        }
			        ps.close();
				});
		
		
				//Permet d'ouvrir l'interface Ouvrir
				
				btn_Ouvrir.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {

						Label Label = new Label(" Id � ouvrir :");
						Label Label2 = new Label("           ");
						
						BorderPane secondaryLayout = new BorderPane();
						TextField tf = new TextField();
						
						
						secondaryLayout.setLeft(Label);
						secondaryLayout.setRight(Label2);
						secondaryLayout.setCenter(tf);
						Scene secondScene = new Scene(secondaryLayout, 300, 100);

						// New window (Stage)
						Stage newWindow = new Stage();
						newWindow.setTitle("Interface d'Ouverture");
						newWindow.setScene(secondScene);

						// Set position of second window, related to primary window.
						newWindow.setX(stage.getX() + 800);
						newWindow.setY(stage.getY() + 100);

						newWindow.show();
						
						
						
						for (char c : "\nOuverture de l'interface d'Ouverture".toCharArray()) {
				            try {
								console.write(c);
							} catch (IOException e) {
								e.printStackTrace();
							}
				        }
				        ps.close();
					}
				});
			
			/*	btn_Ouvrir.setOnMouseClicked((event) -> {
				    try {
				        FXMLLoader fxmlLoader = new FXMLLoader();
				        fxmlLoader.setLocation(getClass().getResource("Ouvrir.fxml"));
				       
				        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
				        Stage stage1 = new Stage();
				        stage1.setTitle("New Window");
				        stage1.setScene(scene);
				        stage1.show();
				    } catch (IOException e) {
				        Logger logger = Logger.getLogger(getClass().getName());
				        logger.log(Level.SEVERE, "Failed to create new Window.", e);
				    }
			 
				    
				}); */
		
		
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
	 
		    for (char c : "\nOuverture de la Galerie".toCharArray()) {
	            try {
					console.write(c);
				} catch (IOException e) {
					e.printStackTrace();
				}
	        }
	        ps.close();
		});
	 
	 }
		//�crit dans le TextArea, � la mani�re d'une console
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
	

	 




