package dat.backend.model.persistence;

import dat.backend.model.entities.Tag;

import java.util.List;

public class TagFacade {
    public static List<Tag> getAllTag(ConnectionPool connectionPool)
    {
        return TagMapper.getAllTag(connectionPool);
    }
}
