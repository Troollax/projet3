

import javafx.scene.*;
import javafx.stage.*;

/**
 * @author Belkalai Mohamed, Bigot Loic, Boutet Louison
 * Cette classe est l'interface graphique du programme. Elle utilise la librairie javafx.
 * Elle possède en attribut les dimensions de la fenêtre d'affichage.
 * */
public class Interface {

    private final int DIMENSION_X;
    private final int DIMENSION_Y;

    /**
     * C'est le constructeur de la classe. Par défaut il se met en mainView.
     * @param DIMENSION_X,DIMENSION_Y
     * */
    public Interface(int DIMENSION_X, int DIMENSION_Y) {
        this.DIMENSION_X = DIMENSION_X;
        this.DIMENSION_Y = DIMENSION_Y;
        mainView();
    }

    /**
     * Cette methode représente la vue principale.
     * Sur celle-ci, on peut ensuite basculer avec overallView en choisissant un ouvrage.
     * C'est en quelque sorte le menu principal de l'application, on peut manipuler le répertoire des ouvrages.
     * */
    public void mainView(){

    }

    /**
     * Cette methode représente la vue Galerie d'un ouvrage.
     * On y voit les pages en miniature, on peut ainsi les sélectionnées et donc basculer enpageView.
     * On peut aussi éditer l'ouvrage.
     * @param nomFichier
     * */
    public void overallView(String nomFichier){

    }

    /**
     * Cette methode représente la vue complète d'une page.
     * On peut zoomer et délimiter les Composantes Connexes de la page qui serait entourées.
     * On pourra retourner en overallView.
     * */
    public void pageView(){

    }
}
