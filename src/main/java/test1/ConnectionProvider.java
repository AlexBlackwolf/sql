package test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionProvider {
    private static Connection connection;

    private static String URL = "jdbc:mysql://localhost:3306/checkpointbeta";

    private static String USERNAME = "root";

    private static String PASSWORD = "hylvanuvola";

    // Costruttore privato per impedire l'istanziazione diretta
    private ConnectionProvider() {
        // Inizializzazione
    }

    public static Connection getInstance() throws SQLException, SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        }
        return connection;
    }
}