package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Carport;
import dat.backend.model.persistence.CarportFacade;
import dat.backend.model.persistence.ConnectionPool;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Orderdetails", value = "/orderdetails")
public class Orderdetails extends HttpServlet {
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

        int orderId = Integer.parseInt(request.getParameter("orderdetails"));
        List<Carport> carportList = CarportFacade.selectCarportsFromOrderId(orderId,connectionPool);
        request.setAttribute("carportList", carportList);
        request.getRequestDispatcher("WEB-INF/orderdetails.jsp").forward(request,response);    }
}
