package dat.backend.model.persistence;

import dat.backend.model.entities.Order;
import dat.backend.model.exceptions.DatabaseException;

import java.util.List;

public class OrderFacade {

    public static int addOrder(String name, String adress, String username, String status, double price, ConnectionPool connectionPool) throws DatabaseException {
        return OrderMapper.addOrder(name, adress, username, status, price, connectionPool);
    }

    public static List<Order> selectAllOrders(ConnectionPool connectionPool) {
        return OrderMapper.selectAllOrders(connectionPool);
    }

    public static List<Order> selectAllOrdersFromUser(String user, ConnectionPool connectionPool) {
        return OrderMapper.selectAllOrdersFromUser(user, connectionPool);
    }


    public static void deleteOrder(int orderId, ConnectionPool connectionPool) {

        OrderMapper.deleteOrder(orderId, connectionPool);


    }

    public static void updateOrderStatus(int orderId, String status, ConnectionPool connectionPool) {
        OrderMapper.updateOrderStatus(orderId, status, connectionPool);

    }

    public static Order selectOrderFromOrderId(int orderId ,ConnectionPool connectionPool){

        return OrderMapper.selectOrderFromOrderId(orderId,connectionPool);
    }


   public static void updateOrderPrice(int orderId,double price, ConnectionPool connectionPool ) {
        OrderMapper.updateOrderPrice(orderId, price, connectionPool);
    }
}