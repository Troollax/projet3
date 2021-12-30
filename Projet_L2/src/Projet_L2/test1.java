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
import javafx.scene.control.TreeItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.scene.control.Label;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class test1 extends Application {

   @Override
   public void start(Stage primaryStage) throws Exception {
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

       Scene scene = new Scene(root, 550, 250);

       primaryStage.setTitle("Interface de Suppression");
       primaryStage.setScene(scene);
       primaryStage.show();
   }

   public static void main(String[] args) {
       launch(args);
   }

}
	 
	

	 




