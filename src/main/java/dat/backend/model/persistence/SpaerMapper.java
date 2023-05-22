package dat.backend.model.persistence;

import dat.backend.model.entities.Spaer;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SpaerMapper {

    static List<Spaer> getAllSpaer(ConnectionPool connectionPool) {

        String sql = "SELECT * FROM spaer";

        List<Spaer> spaerList = new ArrayList<>();

        try (Connection connection = connectionPool.getConnection()) {

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                    int spaerId = rs.getInt("spaer_id");
                    String spaerName = rs.getString("spaer_name");
                    double length = rs.getDouble("length");
                    int price = rs.getInt("price");
                    int quantity = 1;


                    Spaer newSpaer = new Spaer(spaerId, spaerName, length, price, quantity);
                    spaerList.add(newSpaer);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return spaerList;


    }

    static void addSpaerToDB(String spaerName, double length, int price, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");

        String sql = "Insert into spaer (spaer_name, length, price) values (?,?,?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, spaerName);
                ps.setDouble(2, length);
                ps.setInt(3, price);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not add spaer to DB");
        }

    }

    static void deleteSpaer(int spaerId, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        String sql = "DELETE from spaer Where spaer_id = ?";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1, spaerId);
                ps.executeUpdate();


            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "could not delete spaer");
        }


    }



}
