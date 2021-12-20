

// IMPORT ???

import java.awt.*;
import java.util.ArrayList;

/**
 * @author Belkalai Mohamed, Bigot Loic, Boutet Louison
 * Cette classe fera toutes les opérations de traitement des données.
 * Elle sera liée à la base de donnée et permettra entre autre :
 * <ul>
 *     <li>d'ajouter des ouvrages à partir du répertoire local</li>
 *     <li>de procéder au traitement des Composantes Connexes</li>
 * </ul>
 *
 * */
public class GestionFichier {

    private final String REPERTOIRE = "A COMPLETE PAR LA SUITE";
    private ArrayList<String> titreOuvrage;

    /**
     * Cette méthode permet d'ajouter un ouvrage dans la BDD.
     * L'ouvrage est récupéré dans un répertoire local et ensuite crée dans le répertoire de l'application (REPERTOIRE).
     * @param titre,localisation
     * */
    public void addOuvrage(String titre, String localisation){

    }

    /**
     * Cette méthode permet de supprimer un ouvrage du répertoire local ET de la base de donnée.
     * @param titre
     * */
    public void removeOuvrage(String titre){

    }

    /**
     * Cette méthode ajoute une page dans un ouvrage dans le répertoire local et dans la base de donnée.
     * @param ouvrage,numPage,page
     * */
    public void addPage(Ouvrage ouvrage, int numPage, Image page){

    }

    /**
     * Cette méthode supprime une page d'un ouvrage dans le répertoire local et dans la base de donnée.
     * @param titre ,nbPage
     * */
    public void removePage(String titre, int nbPage){

    }

    /**
     * Cette méthode permet de visionner une page avec ses composantes connexes entourée afin de les identifiés.
     * Elle fera abstraction des bruits.
     * @param titre,numPage
     * @return Image l'image de base avec le détoure des CC en plus.
     * */
    public Image viewCC(String titre, int numPage){
		return null;

    }


}
