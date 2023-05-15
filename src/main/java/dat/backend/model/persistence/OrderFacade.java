package dat.backend.model.persistence;

import dat.backend.model.exceptions.DatabaseException;

public class OrderFacade {

    public static int addOrder(String name, String adress, String username,String status, double price, ConnectionPool connectionPool) throws DatabaseException {
        return OrderMapper.addOrder(name, adress, username, status, price, connectionPool);
    }
}
