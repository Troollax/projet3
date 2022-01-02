package Link;

// IMPORT ???

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.transform.Source;

import javafx.scene.image.*;
import javafx.scene.image.Image;

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
	 * @param titre,localisation
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException 
	 */
	public void addOuvrage(Ouvrage ouvrage, String localisation)
			throws ClassNotFoundException, SQLException, IOException {

		/*
		 * TODO Reccupérer le fichier à l'aide de localisation Ajouter dans la Base de
		 * donnée un ouuvrage à l'aide du nom du dossier trouvé (avec titre) Ajouter les
		 * pages du dossier dans la BD
		 */

		// Création de l'ouvrage dans le répertoire
		int counterFichier = 0;
		int counterImage = 1;
		String titre = ouvrage.getTitre();
		try {

			// Variables des chemins
			Path sourcePath = Paths.get(localisation + titre);
			Path outputPath = Paths.get(REPERTOIRE + titre);
			// Création du dossier dans REPERTOIRE
			Files.createDirectories(outputPath);
			File sourceFolder = new File(localisation + titre);

			for (File sourceFile : sourceFolder.listFiles()) {
				// Création d'un chemin avec le nom de l'image
				Path target = outputPath.resolve(sourcePath.getFileName());
				Files.copy(sourcePath, target, StandardCopyOption.REPLACE_EXISTING);
				counterFichier++;
			}
			System.out.println(counterFichier + " fichier on était copié !");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Ajout de l'ouvrage dans la BDD
		ConnectionBD connectionBD = new ConnectionBD();
		connectionBD.createOuvrage(ouvrage);

		// Ajout des images dans le répertoire
		File folder = new File(REPERTOIRE + titre);

		for (File image : folder.listFiles()) {
			connectionBD.ajoutPage(image, counterImage, ouvrage);
			counterImage++;
		}
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

		ConnectionBD BD = new ConnectionBD();
		BD.deleteOuvrage(ouvrage);
		// TODO PARTIE REPERTOIRE
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

		ConnectionBD BD = new ConnectionBD();
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

		ConnectionBD BD = new ConnectionBD();
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
