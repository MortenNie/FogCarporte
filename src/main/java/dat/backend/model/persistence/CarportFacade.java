package dat.backend.model.persistence;

import dat.backend.model.entities.Carport;

public class CarportFacade {

    public static int CreateCarportAndReturnCarportId(double width, double length, double height, boolean shed, int orderId, ConnectionPool connectionPool) {

        return CarportMapper.CreateCarportAndReturnCarportId(width,length,height,shed,orderId, connectionPool);
    }

}
