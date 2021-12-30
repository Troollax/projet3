
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Classe qui permettra de lancer le programme
 *
 */

public class Main {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		ConnectionBD BD = new ConnectionBD("jdbc:mysql://localhost:3307/test", "root", "usbw");
		Ouvrage ou = new Ouvrage("Labelle", "bodelaire", "12/20/2021", null, 5);
		BD.createOuvrage(ou);
		System.out.println(BD.exist(ou));
		BD.deleteOuvrage(ou);
		System.out.println(BD.exist(ou));
		/*
		 * GestionFichier GF = new GestionFichier(); ;
		 * 
		 * GF.removePage("'Labelle'", 0);
		 */

	}

}
