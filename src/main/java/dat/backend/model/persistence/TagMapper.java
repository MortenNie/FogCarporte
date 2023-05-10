package dat.backend.model.persistence;

import dat.backend.model.entities.Tag;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
                    int quantity = rs.getInt("quantity");


                    Tag newTag = new Tag(tagId, tagName, length, price, quantity);
                    tagList.add(newTag);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tagList;


    }

}
