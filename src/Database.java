
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    public Connection getConnection(String url, String username, String password) throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }

    public static Connection initDb() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/food_items";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Database db = new Database();
        return db.getConnection(url, "root", "1234");
    }
}
