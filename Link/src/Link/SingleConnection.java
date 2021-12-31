package Link;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Belkalai Mohamed, Bigot Loic, Boutet Louison
 * Cette classe permet de se connecter à la base de donnée en utilisant le pattern Singleton.
 * Elle sera utilisée par la classe ConnectionBD.
 */
public class SingleConnection {

    private static Connection connection;

    /**
     * C'est le constructeur de la classe.
     *
     * @param url,user,password
     */
    private SingleConnection(String url, String user, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection réussi !");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Cette methode permet de récupérer l'instance Connection.
     * Si l'instance en question n'existe pas, elle en crée une via les paramètres puis la retourne.
     *
     * @param url,user,password
     * @return Connection
     */
    public static Connection getInstance(String url, String user, String password) {
        if (connection == null) {
            SingleConnection sc = new SingleConnection(url, user, password);
        }
        return connection;
    }

}
