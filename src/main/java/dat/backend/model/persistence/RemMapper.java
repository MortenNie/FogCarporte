package dat.backend.model.persistence;

import dat.backend.model.entities.Rem;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RemMapper {
    static List<Rem> getAllRem(ConnectionPool connectionPool) {

        String sql = "SELECT * FROM rem";

        List<Rem> remList = new ArrayList<>();

        try (Connection connection = connectionPool.getConnection()) {

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                    int remId = rs.getInt("rem_id");
                    String remName = rs.getString("rem_name");
                    double length = rs.getDouble("length");
                    int price = rs.getInt("price");
                    int quantity = 1;


                    Rem newRem = new Rem(remId, remName, length, price, quantity);
                    remList.add(newRem);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return remList;


    }

     static void addRemToDB(String remName, double length, int price, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");

        String sql = "Insert into rem (rem_name, length, price) values (?,?,?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, remName);
                ps.setDouble(2, length);
                ps.setInt(3, price);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not add rem to DB");
        }

    }

}
