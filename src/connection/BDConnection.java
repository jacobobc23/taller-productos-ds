package connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mariadb.jdbc.Connection;

/**
 * Esta clase proporciona una conexión a la base de datos MariaDB
 * @author Jacobo-bc
 */
public class BDConnection {
    
    private final String base = "bd_productos";
    private final String user = "root";
    private final String password = "";
    
    private final String url = "jdbc:mariadb://localhost:3306/" + base;
    private Connection con = null;
    
    public Connection getConnection() {

        try {

            Class.forName("org.mariadb.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);

        } catch (SQLException e) {
            System.err.println(e);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BDConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return con;

    }
    
}
