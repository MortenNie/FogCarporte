package dat.backend.model.persistence;

import dat.backend.model.entities.Rem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
                    int quantity = rs.getInt("quantity");


                    Rem newRem = new Rem(remId, remName, length, price, quantity);
                    remList.add(newRem);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return remList;


    }
}
