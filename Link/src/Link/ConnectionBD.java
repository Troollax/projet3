package Link;

import java.awt.Image;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @author Belkalai Mohamed, Bigot Loic, Louison Boutet Cette classe s'occupera
 *         des interactions avec la base de donnée. Elle contient en attribut :
 *         <ul>
 *         <li>L'URL de la base de donnée sous forme d'une chaine de
 *         caractères</li>
 *         <li>Le nom d'utilisateur ainsi que le mot de passe qui permet de se
 *         connecter</li>
 *         <li>Un objet Connection qui permettra via le constructeur de crée
 *         une connection avec la Base de donnée</li>
 *         </ul>
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

	// JUSTE UN TEST
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println("Debut du test ! \n");
		String url = "jdbc:mysql://localhost:3307/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		ConnectionBD BD = new ConnectionBD(url, "root", "usbw");
		System.out.println("Connection r�ussi ! \n");
		Ouvrage ou = new Ouvrage("Labelle", "bodelaire", "2021-12-24", null, 5);
		System.out.println("Cr�ation de l'ouvrage. \n");
		BD.createOuvrage(ou);
		System.out.println("L'ouvrage existe :" + BD.exist(ou) + "\n");
		BD.deleteOuvrage(ou);
		System.out.println("L'ouvrage existe :" + BD.exist(ou));
	}

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
		Class.forName("com.mysql.cj.jdbc.Driver");
		this.connection = DriverManager.getConnection(url, username, password);
	}

	/**
	 * Cette méthode permet de trouver un ouvrage par le biais de son titre. On
	 * récupère ensuite les pages de l'ouvrage.
	 *
	 * @param titre
	 * @return
	 * @return ArrayList<Image>
	 * @throws SQLException
	 */
	public ArrayList<Image> getPagesByTitre(String titre) throws SQLException {
		ArrayList<Image> ouvrage = new ArrayList<>();
		Statement statement = connection.createStatement();

		// TODO SQL à finir !!
		String sql = "";
		ResultSet resultSet = statement.executeQuery(sql);
		for (int i = 0; i < resultSet.getFetchSize(); i++) {
			ouvrage.add((Image) resultSet.getBlob(i));
		}
		return ouvrage;
	}

	/**
	 * Cette méthode permet de trouver des ouvrages par le biais d'un. On
	 * récupère ensuite les titres de ses ouvrages.
	 *
	 * @param tag
	 * @return
	 * @return ArrayList<String>
	 * @throws SQLException
	 */
	public ArrayList<String> getOuvrageByTag(String tag) throws SQLException {
		ArrayList<String> ouvrage = new ArrayList<>();
		Statement statement = connection.createStatement();
		String sql = "SELECT titre FROM ouvrage "
				+ "WHERE INNER JOIN Possede ON ouvrage.Id_Ouvrage = Possede.Id_Ouvrage "
				+ "INNER JOIN Tags ON Possede.Id_Tags =  Tags.Id_Tags AND Tags.nom LIKE '%" + tag + "%'";
		ResultSet resultSet = statement.executeQuery(sql);
		for (int i = 0; i < resultSet.getFetchSize(); i++) {
			ouvrage.add(resultSet.getString(i));
		}
		return ouvrage;
	}

	/**
	 * Cette méthode permet de trouver des ouvrages par le biais d'une date. On
	 * récupère ensuite les titres de ses ouvrages.
	 *
	 * @param date
	 * @return ArrayList<String>
	 * @throws SQLException
	 */

	public ArrayList<String> getOuvrageByDate(String date) throws SQLException {
		ArrayList<String> ouvrage = new ArrayList<>();
		Statement statement = connection.createStatement();
		String sql = "SELECT titre FROM ouvrage WHERE YEAR(date) LIKE '%" + date + "%'";
		ResultSet resultSet = statement.executeQuery(sql);
		for (int i = 0; i < resultSet.getFetchSize(); i++) {
			ouvrage.add(resultSet.getString(i));
		}
		return ouvrage;
	}

	/**
	 * Cette méthode permet d'actualiser un ouvrage dans la base de donnée à
	 * partir de l'emplacement de l'ouvrage modifié.
	 *
	 * @param titre,args
	 * @return void
	 * @throws SQLException
	 */
	public void updateOuvrage(Ouvrage ouvrage) throws SQLException {
		if (exist(ouvrage)) {
			Statement statement = connection.createStatement();
			String sql = "UPDATE `ouvrage` SET `NbPages`=" + ouvrage.getNbPage() + ",`DateDeParution`="
					+ ouvrage.getDate() + ",`Auteur`" + ouvrage.getAuteur() + " WHERE Titre LIKE '" + ouvrage.getTitre()
					+ "'";
			statement.executeUpdate(sql);
		} else {
			System.out.println("L'ouvrage en question n'existe pas.");
		}

	}

	/**
	 * Cette méthode crée un ouvrage dans la base de donnée par le biais d'un
	 * objet Ouvrage.
	 * 
	 * @param ouvrage
	 * @return void
	 * @throws SQLException
	 */
	public void createOuvrage(Ouvrage ouvrage) throws SQLException {
		Statement statement = connection.createStatement();
		if (exist(ouvrage)) {
			System.out.println("L'ouvrage existe déjà dans la Base.");
		} else {
			String sql = "INSERT INTO `test`.`ouvrage` (`Titre`, `NbPages`, `DateDeParution`, `Auteur`) VALUES (" + " '"
					+ ouvrage.getTitre() + "', '" + ouvrage.getNbPage() + "', '" + ouvrage.getDate() + "', '"
					+ ouvrage.getAuteur() + "');";
			statement.executeUpdate(sql);

		}

	}

	/**
	 * Cette méthode supprime un ouvrage dans la base de donnée par le biais d'un
	 * objet Ouvrage.
	 * 
	 * @param ouvrage
	 * @return void
	 * @throws SQLException
	 */
	public void deleteOuvrage(Ouvrage ouvrage) throws SQLException {

		Statement stmt = connection.createStatement();
		String sql = "DELETE FROM ouvrage WHERE Titre LIKE " + "'" + ouvrage.getTitre() + "'";
		stmt.executeUpdate(sql);
	}

	/**
	 * Cette méthode permettra de savoir si un ouvrage et déjà existant dans la
	 * base de donnée pour éviter tout soucis. Elle se sert du titre de l'ouvrage
	 * pour le retrouver.
	 * 
	 * @param Ouvrage
	 * @return Boolean
	 * @throws SQLException
	 */

	public boolean exist(Ouvrage ouvrage) throws SQLException {
		Statement statement = connection.createStatement();
		String checkString = "SELECT * FROM OUVRAGE WHERE Titre = " + "'" + ouvrage.getTitre() + "'";
		ResultSet resultSet = statement.executeQuery(checkString);
		if (resultSet.next()) {
			return true;
		}
		return false;
	}

}
