package dat.backend.model.persistence;

import dat.backend.model.entities.Spaer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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


}
