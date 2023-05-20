package dat.backend.model.persistence;

import dat.backend.model.entities.Stolpe;
import dat.backend.model.exceptions.DatabaseException;

import java.util.List;

public class StolpeFacade {
    public static List<Stolpe> getAllStolpe(ConnectionPool connectionPool)
    {
        return StolpeMapper.getAllStolpe(connectionPool);
    }

    public static void addStolpeToDB(String stolpeName, double length, int price, ConnectionPool connectionPool) throws DatabaseException {

        StolpeMapper.addStolpeToDB(stolpeName, length, price, connectionPool);

    }
}
