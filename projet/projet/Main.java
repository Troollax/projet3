import java.sql.SQLException;

/**
 * Classe qui permettra de lancer le programme
 *
 * */

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
    	
    	ConnectionBD BD = new ConnectionBD("jdbc:mysql://http://http://localhost:8080/phpmyadmin/index.php#PMAURL-0:index.php?db=&table=&server=1&target=&token=96f6bb31885556b0df444cebdf562263", "root", "test");
    	
    }
}
