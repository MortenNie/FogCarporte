package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Order;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.OrderFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Discounttenpercent", value = "/discounttenpercent")
public class Discounttenpercent extends HttpServlet {

    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         int orderId = Integer.parseInt(request.getParameter("discounttenpercent"));
         Order order = OrderFacade.selectOrderFromOrderId(orderId, connectionPool);
         Double discountedPrice = order.getPrice() - 0.1 * order.getPrice();
         OrderFacade.updateOrderPrice(orderId, discountedPrice, connectionPool);

         List<Order> orderList = OrderFacade.selectAllOrders(connectionPool);
         request.setAttribute("orderList",orderList);
         request.getRequestDispatcher("WEB-INF/orderhistory.jsp").forward(request,response);
    }
}
