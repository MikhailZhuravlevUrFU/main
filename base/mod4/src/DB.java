import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB {
    private final String HOST = "localhost";
    private final String PORT = "3306";
    private final String DB_NAME = "java_db";
    private final String LOGIN = "root";
    private final String PASS = "";

    private Connection dbConn = null;

    private Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connStr = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME;
        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConn = DriverManager.getConnection(connStr, LOGIN, PASS);
        return dbConn;
    }

    public void isConnected() throws SQLException, ClassNotFoundException {
        dbConn = getDbConnection();
        System.out.println(dbConn.isValid(1000));
    }

    public List<Integer> getUsers(String table) throws SQLException, ClassNotFoundException {
        String sql = "SELECT id FROM " + table + " WHERE login = 'john'";
        List<Integer> userIds = new ArrayList<>();

        Statement statement = getDbConnection().createStatement();
        ResultSet res = statement.executeQuery(sql);

        while (res.next()) {
            int userId = res.getInt("id");
            userIds.add(userId);
        }

        return userIds;
    }

    public List<Integer> getItems(String table) throws SQLException, ClassNotFoundException {
        String sql = "SELECT id FROM " + table + " WHERE category = 'hats'";
        List<Integer> itemIds = new ArrayList<>();

        Statement statement = getDbConnection().createStatement();
        ResultSet res = statement.executeQuery(sql);

        while (res.next()) {
            int itemId = res.getInt("id");
            itemIds.add(itemId);
        }

        return itemIds;
    }

    public void insertOrders(List<Integer> userIds, List<Integer> itemIds) throws SQLException, ClassNotFoundException {
        Connection conn = getDbConnection();
        String insertSql = "INSERT INTO orders (user_id, item_id) VALUES (?, ?)";
        PreparedStatement preparedStatement = conn.prepareStatement(insertSql);

        for (int userId : userIds) {
            for (int itemId : itemIds) {
                preparedStatement.setInt(1, userId);
                preparedStatement.setInt(2, itemId);

                preparedStatement.executeUpdate();
            }
        }
    }

    public void checkOrders() throws SQLException, ClassNotFoundException {
        String sql = "SELECT users.login, items.title " +
                "FROM orders " +
                "JOIN users ON orders.user_id = users.id " +
                "JOIN items ON orders.item_id = items.id";
        Statement statement = getDbConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        System.out.println("Все заказы \n");

        while (resultSet.next()) {
            String userName = resultSet.getString("login");
            String itemName = resultSet.getString("title");
            System.out.println(userName + " - " + itemName);
        }
    }
}
