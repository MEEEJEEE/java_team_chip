import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:sqlite:clothing.db";

    public DatabaseManager() {
        createDatabase();
    }

    private void createDatabase() {
        try (Connection connection = DriverManager.getConnection(DB_URL);
             Statement statement = connection.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS clothing (" +
                         "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                         "name TEXT," +
                         "color TEXT," +
                         "season TEXT," +
                         "style TEXT," +
                         "laundry TEXT)";
            statement.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getClothingItems() {
        StringBuilder clothingItems = new StringBuilder();
        try (Connection connection = DriverManager.getConnection(DB_URL);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM clothing")) {
            while (resultSet.next()) {
                clothingItems.append("옷 이름: ").append(resultSet.getString("name"))
                             .append(", 색상: ").append(resultSet.getString("color"))
                             .append(", 계절: ").append(resultSet.getString("season"))
                             .append(", 스타일: ").append(resultSet.getString("style"))
                             .append(", 세탁 방법: ").append(resultSet.getString("laundry")).append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clothingItems.toString();
    }

    public void addClothingItem(String name, String color, String season, String style, String laundry) {
        try (Connection connection = DriverManager.getConnection(DB_URL);
             Statement statement = connection.createStatement()) {
            String sql = "INSERT INTO clothing (name, color, season, style, laundry) VALUES ('" +
                         name + "', '" + color + "', '" + season + "', '" + style + "', '" + laundry + "')";
            statement.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
