package dat.backend.model.persistence;

import dat.backend.model.entities.Order;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
}
