package dat.backend.model.persistence;

import dat.backend.model.entities.Rem;
import dat.backend.model.exceptions.DatabaseException;


import java.util.List;

public class RemFacade {
    public static List<Rem> getAllRem(ConnectionPool connectionPool)
    {
        return RemMapper.getAllRem(connectionPool);
    }

    public static void addRemToDB(String remName, double length, int price, ConnectionPool connectionPool) throws DatabaseException {

        RemMapper.addRemToDB(remName, length, price, connectionPool);


    }

}

