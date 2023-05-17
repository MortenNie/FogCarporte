package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Carport;
import dat.backend.model.entities.Order;
import dat.backend.model.entities.ShoppingCart;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.CarportFacade;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.ItemListMapper;
import dat.backend.model.persistence.OrderFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Deleteorder", value = "/deleteorder")
public class Deleteorder extends HttpServlet {
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
        int orderId = Integer.parseInt(request.getParameter("deleteorder"));
        List<Carport>carportList = CarportFacade.selectCarportsFromOrderId(orderId, connectionPool);
        List<Integer> listOfCarportIds = new ArrayList<>();
        for (Carport s: carportList) {
            listOfCarportIds.add(s.getCarportId());

        }
        for (Integer t: listOfCarportIds) {
            try {
                ItemListMapper.deleteFromItemRem(t, connectionPool);
                ItemListMapper.deleteFromItemSpaer(t, connectionPool);
                ItemListMapper.deleteFromItemStolpe(t, connectionPool);
                ItemListMapper.deleteFromItemTag(t, connectionPool);
            } catch (DatabaseException e) {
                e.printStackTrace();
            }

        }

        for (Carport w: carportList) {
            try {
                CarportFacade.deleteCarport(w.getCarportId(), connectionPool);
            } catch (DatabaseException e) {
                e.printStackTrace();
            }


        }
        OrderFacade.deleteOrder(orderId, connectionPool);
        List<Order> orderList = OrderFacade.selectAllOrders(connectionPool);
        request.setAttribute("orderList", orderList);
        request.getRequestDispatcher("WEB-INF/orderhistory.jsp").forward(request, response);
    }
}
