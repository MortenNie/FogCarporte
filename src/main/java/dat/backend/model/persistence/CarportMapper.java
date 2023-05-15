package dat.backend.model.persistence;

import dat.backend.model.entities.Rem;
import dat.backend.model.entities.Spaer;
import dat.backend.model.entities.Stolpe;
import dat.backend.model.entities.Tag;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

class CarportMapper {

     static int CreateCarportAndReturnCarportId(double width, double length, double height, boolean shed, int orderId, ConnectionPool connectionPool) {
        Logger.getLogger("web").log(Level.INFO, "");
        int ts = -1;

        String sql = "insert into carport (width, length, height, shed, order_id) values (?,?,?,?,?)";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {


                ps.setDouble(1, width);
                ps.setDouble(2, length);
                ps.setDouble(3, height);
                ps.setBoolean(4, shed);
                ps.setInt(5,orderId);



                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();


                ts = rs.getInt(1);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ts;
    }

    public static int returnCarportId(double width, double length, double height, boolean shed, ConnectionPool connectionPool) {
        Logger.getLogger("web").log(Level.INFO, "");
        int ts = -1;

        String sql = "insert into carport (width, length, height, shed) values (?,?,?,?)";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {


                ps.setDouble(1, width);
                ps.setDouble(2,length);
                ps.setDouble(3,height);
                ps.setBoolean(4, shed);

                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();


                ts = rs.getInt(1);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ts;
    }

}

