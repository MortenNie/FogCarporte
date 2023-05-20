package dat.backend.model.persistence;

import dat.backend.model.entities.Stolpe;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StolpeMapper {
    static List<Stolpe> getAllStolpe(ConnectionPool connectionPool) {

        String sql = "SELECT * FROM stolpe";

        List<Stolpe> stolpeList = new ArrayList<>();

        try (Connection connection = connectionPool.getConnection()) {

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                    int stolpeId = rs.getInt("stolpe_id");
                    String stolpeName = rs.getString("stolpe_name");
                    double length = rs.getDouble("length");
                    int price = rs.getInt("price");
                    int quantity = 1;


                    Stolpe newStolpe = new Stolpe (stolpeId, stolpeName, length, price, quantity);
                    stolpeList.add(newStolpe);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stolpeList;


    }

    static void addStolpeToDB(String stolpeName, double length, int price, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");

        String sql = "Insert into stolpe (stolpe_name, length, price) values (?,?,?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, stolpeName);
                ps.setDouble(2, length);
                ps.setInt(3, price);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not add stolpe to DB");
        }

    }

}
