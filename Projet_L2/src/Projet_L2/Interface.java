package Projet_L2;



import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Interface extends Application {

    @Override
    public void start(Stage stage) {
    	

        TreeTableView<Ouvrage> Tableau = new TreeTableView<Ouvrage>();

        // Create column EmpNo (Data type of String).
        TreeTableColumn<Ouvrage, String> Titre //
                = new TreeTableColumn<Ouvrage, String>("Titre");

        // Create column FullName (Data type of String).
        TreeTableColumn<Ouvrage, String> Auteur//
                = new TreeTableColumn<Ouvrage, String>("Auteur");

        // Create 2 sub column for FullName.
        TreeTableColumn<Ouvrage, String> PrenomAuteur //
                = new TreeTableColumn<Ouvrage, String>("Prénom");

        TreeTableColumn<Ouvrage, String> NomAuteur //
                = new TreeTableColumn<Ouvrage, String>("Nom");

        // Add sub columns to the FullName
        Auteur.getColumns().addAll(PrenomAuteur, NomAuteur);

       
        // Defines how to fill data for each cell.
        // Get value from property of Employee.
        Titre.setCellValueFactory(new TreeItemPropertyValueFactory<Ouvrage, String>("titre"));
        PrenomAuteur.setCellValueFactory(new TreeItemPropertyValueFactory<Ouvrage, String>("prenom"));
        NomAuteur.setCellValueFactory(new TreeItemPropertyValueFactory<Ouvrage, String>("nom"));
       
        // Add columns to TreeTable.
        Tableau.getColumns().addAll(Titre, Auteur);

        // Data
        Ouvrage un = new Ouvrage("Le petit Prince", "Antoine" , "de Saint Exuperry");

        Ouvrage deux = new Ouvrage("L'Avare", "Molière" , " ");

        Ouvrage trois = new Ouvrage("Le Rouge et le Noir", "Stendhal" , " ");
           

        // Root Item
        TreeItem<Ouvrage> itemRoot = new TreeItem<Ouvrage>(un);
        TreeItem<Ouvrage> itemSmith = new TreeItem<Ouvrage>(deux);
        TreeItem<Ouvrage> itemMcNeil = new TreeItem<Ouvrage>(trois);

        itemRoot.getChildren().addAll(itemSmith, itemMcNeil);
        Tableau.setRoot(itemRoot);
        //
        StackPane root = new StackPane();
        root.setPadding(new Insets(5));
        root.getChildren().add(Tableau);

        stage.setTitle("Bienvenue");

        Scene scene = new Scene(root, 450, 300);
        stage.setScene(scene);
        
        
        
     
        
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}