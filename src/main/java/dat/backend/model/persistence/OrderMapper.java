package dat.backend.model.persistence;

import dat.backend.model.entities.Order;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderMapper {

    public static int addOrder( String name, String adress,String username,String status, double price, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        Order order;
        String sql = "insert into fogcarporte.order (name, adress, username, status, price) values (?,?,?,?,?)";
        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS))
            {
                ps.setString(1, name);
                ps.setString(2, adress);
                ps.setString(3, username);
                ps.setString(4, status);
                ps.setDouble(5, price);
                ps.executeUpdate();


                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                return rs.getInt(1);



            }
        }
        catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Could not insert order into database");
        }

    }

    public static List<Order> selectAllOrders(ConnectionPool connectionPool) {
        Logger.getLogger("web").log(Level.INFO, "");
        List<Order> orderList = new ArrayList<>();
        String sql = "SELECT * FROM fogcarporte.order";

        try (Connection connection = connectionPool.getConnection()){

            try(PreparedStatement ps = connection.prepareStatement(sql)){

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    int OrderId = rs.getInt("order_id");
                    Timestamp date = rs.getTimestamp("date");
                    String name = rs.getString("name");
                    String adress = rs.getString("adress");
                    String status = rs.getString("status");
                    double price = rs.getDouble("price");

                    Order newOrder = new Order(OrderId, name, adress, date,status,price);
                    orderList.add(newOrder);


                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderList;
    }

    public static List<Order> selectAllOrdersFromUser(String user,ConnectionPool connectionPool) {
        Logger.getLogger("web").log(Level.INFO, "");
        List<Order> orderList = new ArrayList<>();
        String sql = "SELECT * FROM fogcarporte.order WHERE username = ?";

        try (Connection connection = connectionPool.getConnection()){

            try(PreparedStatement ps = connection.prepareStatement(sql)){
                ps.setString(1, user);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int OrderId = rs.getInt("order_id");
                    Timestamp date = rs.getTimestamp("date");
                    String name = rs.getString("name");
                    String adress =rs.getString("adress");
                    String status = rs.getString("status");
                    double price = rs.getDouble("price");


                    Order newOrder = new Order(OrderId,name,adress, date,status,price);
                    orderList.add(newOrder);


                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderList;
    }
}
