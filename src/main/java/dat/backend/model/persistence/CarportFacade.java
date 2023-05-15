package dat.backend.model.persistence;

import dat.backend.model.entities.Carport;

public class CarportFacade {

    public static int CreateCarportAndReturnCarportId(double width, double length, double height, boolean shed, int orderId, ConnectionPool connectionPool) {

        return CarportMapper.CreateCarportAndReturnCarportId(width,length,height,shed,orderId, connectionPool);
    }

    public static int returnCarportId(double width, double length, double height, boolean shed, ConnectionPool connectionPool) {

        return CarportMapper.returnCarportId(width,length,height,shed,connectionPool);
    }
}
