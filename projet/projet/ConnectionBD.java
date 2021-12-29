

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

    public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

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
     * @throws SQLException 
     */
    public void createOuvrage(Ouvrage ouvrage) throws SQLException {
    	Statement statement = connection.createStatement();
    	if (exist(ouvrage)) {
			System.out.println("L'ouvrage existe déjà dans la Base.");
		}else {
			String sql = "INSERT INTO OUVRAGE VALUES ( , "+ ouvrage.getTitre()+ ouvrage.getNbPage() +")";
			ResultSet resultSet = statement.executeQuery(sql);
			
		}
    	
    	
    }

    /**
     * Cette méthode supprime un ouvrage dans la base de donnée par le biais d'un objet Ouvrage.
     * @param ouvrage
     * @return void
     * @throws SQLException 
     * */
    public void deleteOuvrage(Ouvrage ouvrage) throws SQLException{
    	
		Statement stmt = connection.createStatement();
		String sql = "DELETE FROM ouvrages WHERE Titre=" + ouvrage.getTitre() + "";
		int rs = stmt.executeUpdate(sql);
    }
    
    /**
     * Cette méthode permettra de savoir si un ouvrage et déjà existant dans la base de donnée pour éviter tout soucis.
     * Elle se sert du titre de l'ouvrage pour le retrouver.
     * @param Ouvrage
     * @return Boolean
     * @throws SQLException 
     * */
    
    public boolean exist(Ouvrage ouvrage) throws SQLException {
    	Statement statement = connection.createStatement();
    	String checkString = "SELECT * FROM OUVRAGE WHERE Titre = " + ouvrage.getTitre();
    	ResultSet resultSet = statement.executeQuery(password);
    	if (resultSet.next()) {
			return true;
		}
    	return false;
    }

}
