package dat.backend.model.persistence;

import dat.backend.model.entities.Stolpe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
                    int quantity = rs.getInt("quantity");


                    Stolpe newStolpe = new Stolpe (stolpeId, stolpeName, length, price, quantity);
                    stolpeList.add(newStolpe);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stolpeList;


    }
}
