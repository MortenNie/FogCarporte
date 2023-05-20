package dat.backend.model.persistence;

import dat.backend.model.entities.Spaer;
import dat.backend.model.exceptions.DatabaseException;

import java.util.List;

public class SpaerFacade {

    public static List<Spaer> getAllSpaer(ConnectionPool connectionPool)
    {
        return SpaerMapper.getAllSpaer(connectionPool);
    }


    public static void addSpaerToDB(String spaerName, double length, int price, ConnectionPool connectionPool) throws DatabaseException {

        SpaerMapper.addSpaerToDB(spaerName, length, price, connectionPool);

    }
}
