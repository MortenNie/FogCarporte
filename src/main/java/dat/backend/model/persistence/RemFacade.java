package dat.backend.model.persistence;

import dat.backend.model.entities.Rem;


import java.util.List;

public class RemFacade {
    public static List<Rem> getAllRem(ConnectionPool connectionPool)
    {
        return RemMapper.getAllRem(connectionPool);
    }
}
