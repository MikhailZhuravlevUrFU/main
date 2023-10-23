import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DB db = new DB();

        try {
            List<Integer> userIds = db.getUsers("users");
            List<Integer> itemIds = db.getItems("items");
            db.insertOrders(userIds, itemIds);
            db.checkOrders();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
