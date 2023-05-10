package dat.backend.model.persistence;

import dat.backend.model.entities.Stolpe;

import java.util.List;

public class StolpeFacade {
    public static List<Stolpe> getAllStolpe(ConnectionPool connectionPool)
    {
        return StolpeMapper.getAllStolpe(connectionPool);
    }
}
