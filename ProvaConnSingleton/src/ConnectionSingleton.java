import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;

public class ConnectionSingleton {
    private static Connection connection;
    private static Properties properties = new Properties();

    public static Connection getConnection() {
        if (connection == null) {
            try (InputStream input = new FileInputStream("config.properties")) {
                properties.load(input);

                String url = properties.getProperty("db.url");
                String username = properties.getProperty("db.username");
                String password = properties.getProperty("db.password");

                // Carica il driver JDBC


                Class.forName("com.mysql.cj.jdbc.Driver");
                // Crea la connessione al database utilizzando le informazioni dal file config.properties
                connection = DriverManager.getConnection(url, username, password);
            } catch (IOException | ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    // Metodo per chiudere la connessione al database
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
