package dat.backend.model.persistence;

import dat.backend.model.entities.Spaer;

import java.util.List;

public class SpaerFacade {

    public static List<Spaer> getAllSpaer(ConnectionPool connectionPool)
    {
        return SpaerMapper.getAllSpaer(connectionPool);
    }
}
