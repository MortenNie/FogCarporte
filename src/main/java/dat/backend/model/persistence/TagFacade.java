package dat.backend.model.persistence;

import dat.backend.model.entities.Tag;
import dat.backend.model.exceptions.DatabaseException;

import java.util.List;

public class TagFacade {
    public static List<Tag> getAllTag(ConnectionPool connectionPool)
    {
        return TagMapper.getAllTag(connectionPool);
    }

    public static void addTagToDB(String tagName, double length, int price, ConnectionPool connectionPool) throws DatabaseException {

        TagMapper.addTagToDB(tagName, length, price, connectionPool);

    }

    static void deleteTag(int tagId, ConnectionPool connectionPool) throws DatabaseException {

        TagMapper.deleteTag(tagId, connectionPool);

    }
}
