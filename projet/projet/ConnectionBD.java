

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @author Belkalai Mohamed, Bigot Loic, Louison Boutet
 * Cette classe s'occupera des interactions avec la base de donnée. Elle contient en attribut :
 * <ul>
 * <li>L'URL de la base de donnée sous forme d'une chaine de caractères</li>
 * <li>Le nom d'utilisateur ainsi que le mot de passe qui permet de se connecter</li>
 * <li>Un objet Connection qui permettra via le constructeur de crée une connection avec la Base de donnée</li>
 * </ul>
 */
public class ConnectionBD {

    private String url;
    private String username;
    private String password;
    private Connection connection;

    /**
     * Le constructeur de la classe.
     *
     * @param url,username,password
     * @throws SQLException,ClassNotFoundException
     */
    public ConnectionBD(String url, String username, String password) throws SQLException, ClassNotFoundException {
        this.url = url;
        this.username = username;
        this.password = password;
        this.connection = DriverManager.getConnection(url, username, password);
    }

    /**
     * Cette méthode permet de trouver un ouvrage par le biais de son titre. On récupère ensuite les pages de l'ouvrage.
     *
     * @param titre
     * @return ArrayList<Img>
     */
    public void getOuvrageByTitre(String titre) {

    }

    /**
     * Cette méthode permet de trouver des ouvrages par le biais d'un. On récupère ensuite les titres de ses ouvrages.
     *
     * @param tag
     * @return ArrayList<String>
     */
    public void getOuvrageByTag(String tag) {

    }

    /**
     * Cette méthode permet de trouver des ouvrages par le biais d'une date. On récupère ensuite les titres de ses ouvrages.
     *
     * @param siècle
     * @return ArrayList<String>
     */
    public ArrayList<String> getOuvrageByDate(String siecle) {
		return null;

    }


    /**
     * Cette méthode permet d'actualiser un ouvrage dans la base de donnée à partir de l'emplacement de l'ouvrage modifié.
     *
     * @param titre,args
     * @return void
     */
    public void updateOuvrage(String titre) {

    }

    /**
     * Cette méthode crée un ouvrage dans la base de donnée par le biais d'un objet Ouvrage.
     * @param ouvrage
     * @return void
     */
    public void createOuvrage(Ouvrage ouvrage) {

    }

    /**
     * Cette méthode supprime un ouvrage dans la base de donnée par le biais d'un objet Ouvrage.
     * @param ouvrage
     * @return void
     * */
    public void deleteOuvrage(Ouvrage ouvrage){

    }

}
