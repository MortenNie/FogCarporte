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

@WebServlet(name = "Customprice", value = "/customprice")
public class Customprice extends HttpServlet {

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
        double customPrice = Double.parseDouble(request.getParameter("price"));
        HttpSession session = request.getSession();
        int orderId = (int) session.getAttribute("orderId");
        OrderFacade.updateOrderPrice(orderId, customPrice, connectionPool);

        List<Order> orderList = OrderFacade.selectAllOrders(connectionPool);
        request.setAttribute("orderList",orderList);
        session.removeAttribute("orderId");
        request.getRequestDispatcher("WEB-INF/orderhistory.jsp").forward(request,response);


    }
}
