package dat.backend.model.persistence;

import dat.backend.model.entities.Tag;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TagMapper {
    static List<Tag> getAllTag(ConnectionPool connectionPool) {

        String sql = "SELECT * FROM tag";

        List<Tag> tagList = new ArrayList<>();

        try (Connection connection = connectionPool.getConnection()) {

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                    int tagId = rs.getInt("tag_id");
                    String tagName = rs.getString("tag_name");
                    double length = rs.getDouble("length");
                    int price = rs.getInt("price");
                    int quantity = 1;


                    Tag newTag = new Tag(tagId, tagName, length, price, quantity);
                    tagList.add(newTag);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tagList;


    }


    static void addTagToDB(String tagName, double length, int price, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");

        String sql = "Insert into tag (tag_name, length, price) values (?,?,?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, tagName);
                ps.setDouble(2, length);
                ps.setInt(3, price);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not add tag to DB");
        }

    }


}
