package Link;

// IMPORT ???

import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author Belkalai Mohamed, Bigot Loic, Boutet Louison Cette classe fera toutes
 *         les opérations de traitement des données. Elle sera liée à la base de
 *         donnée et permettra entre autre :
 *         <ul>
 *         <li>d'ajouter des ouvrages à partir du répertoire local</li>
 *         <li>de procéder au traitement des Composantes Connexes</li>
 *         </ul>
 *
 */

public class GestionFichier {

	private final String REPERTOIRE = "A COMPLETE PAR LA SUITE";
	private ArrayList<String> titreOuvrage;

	/**
	 * Cette méthode permet d'ajouter un ouvrage dans la BDD. L'ouvrage est récupéré
	 * dans un répertoire local et ensuite crée dans le répertoire de l'application
	 * (REPERTOIRE).
	 * 
	 * @param <VarChar>
	 * @param titre,localisation
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void addOuvrage(String titre, int page, String localisation) throws ClassNotFoundException, SQLException {

		/*
		 * TODO Reccupérer le fichier à l'aide de localisation Ajouter dans la Base de
		 * donnée un ouuvrage à l'aide du nom du dossier trouvé (avec titre) Ajouter les
		 * pages du dossier dans la BD
		 */
		/*
		 * ConnectionBD BD = new ConnectionBD("jdbc:mysql://localhost:3307/test",
		 * "root", "usbw"); Connection conn = BD.getConnection(); Statement stmt =
		 * conn.createStatement(); String sql =
		 * "INSERT INTO ouvrages VALUES ("+page+", "+titre+")"; int rs =
		 * stmt.executeUpdate(sql);
		 */
	}

	/**
	 * Cette méthode permet de supprimer un ouvrage du répertoire local ET de la
	 * base de donnée.
	 * 
	 * @param Ouvrage
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void removeOuvrage(Ouvrage ouvrage) throws ClassNotFoundException, SQLException {

		ConnectionBD BD = new ConnectionBD("jdbc:mysql://localhost:3307/test", "root", "usbw");
		BD.deleteOuvrage(ouvrage);
		//TODO PARTIE REPERTOIRE
	}

	/**
	 * Cette méthode ajoute une page dans un ouvrage dans le répertoire local et
	 * dans la base de donnée.
	 * 
	 * @param ouvrage,numPage,page
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void addPage(Ouvrage ouvrage, int numPage, Image page, String cc)
			throws ClassNotFoundException, SQLException {

		ConnectionBD BD = new ConnectionBD("jdbc:mysql://localhost:3307/test", "root", "usbw");
		Connection conn = BD.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "INSERT INTO pages VALUES (" + numPage + ", " + cc + ", " + ouvrage.getTitre() + ")";

		int rs = stmt.executeUpdate(sql);

	}

	/**
	 * Cette méthode supprime une page d'un ouvrage dans le répertoire local et dans
	 * la base de donnée.
	 * 
	 * @param titre ,nbPage
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void removePage(String titre, int nbPage) throws ClassNotFoundException, SQLException {

		ConnectionBD BD = new ConnectionBD("jdbc:mysql://localhost:3307/test", "root", "usbw");
		Connection conn = BD.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "DELETE FROM pages WHERE titreouvrage=" + titre + "";
		int rs = stmt.executeUpdate(sql);
	}

	/**
	 * Cette méthode permet de visionner une page avec ses composantes connexes
	 * entourée afin de les identifiés. Elle fera abstraction des bruits.
	 * 
	 * @param titre,numPage
	 * @return Image l'image de base avec le détoure des CC en plus.
	 */
	public Image viewCC(String titre, int numPage) {
		return null;

	}

}
