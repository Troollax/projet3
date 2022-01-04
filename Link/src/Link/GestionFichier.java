package Link;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
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

	private final String REPERTOIRE = "/Ouvrages/";

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
			connectionBD.addPage(image, counterImage, ouvrage);
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
	 * @throws IOException
	 */
	public void addPage(Ouvrage ouvrage, int numPage, File page)
			throws ClassNotFoundException, SQLException, IOException {
		ConnectionBD connectionBD = new ConnectionBD();
		Path repertoire = Paths.get(REPERTOIRE + ouvrage.getTitre());
		Path sourcePath = page.toPath();
		Files.copy(sourcePath, repertoire);
		connectionBD.addPage(page, numPage, ouvrage);
	}

	/**
	 * Cette méthode supprime une page d'un ouvrage dans le répertoire local et dans
	 * la base de donnée.
	 * 
	 * @param titre,numPage
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void removePage(String titre, int numPage) throws ClassNotFoundException, SQLException {
		File repertoire = new File(REPERTOIRE + titre);
		ConnectionBD connectionBD = new ConnectionBD();
		int counter = 1;
		for (File image : repertoire.listFiles()) {
			if (counter == numPage) {
				connectionBD.deletePage(image);
				image.deleteOnExit();
			}
			counter++;
		}
		

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
