package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Order;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.OrderFacade;
import dat.backend.model.persistence.OrderMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Updateorderstatus", value = "/updateorderstatus")
public class Updateorderstatus extends HttpServlet {

    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException
    {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int orderId= Integer.parseInt(request.getParameter("updateorderstatus"));
        Order order= OrderFacade.selectOrderFromOrderId(orderId,connectionPool);

        if (order.getStatus().equals("pending") ){
            order.setStatus("accepted");
            OrderFacade.updateOrderStatus(orderId, order.getStatus(),connectionPool);

        }
        else if (order.getStatus().equals("accepted")){
            order.setStatus("completed");
            OrderFacade.updateOrderStatus(orderId,order.getStatus(),connectionPool);
        }
        else {
            order.setStatus("pending");
            OrderFacade.updateOrderStatus(orderId,order.getStatus(),connectionPool);
        }

        List <Order> orderList= OrderFacade.selectAllOrders(connectionPool);

        request.setAttribute("orderList",orderList);
        request.getRequestDispatcher("WEB-INF/orderhistory.jsp").forward(request,response);

    }
}
