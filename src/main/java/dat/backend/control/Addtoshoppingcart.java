package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Carport;
import dat.backend.model.entities.ShoppingCart;
import dat.backend.model.entities.User;
import dat.backend.model.persistence.ConnectionPool;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Addtoshoppingcart", value = "/addtoshoppingcart")
public class Addtoshoppingcart extends HttpServlet {
    private ConnectionPool connectionPool;
    ShoppingCart shoppingcart = new ShoppingCart();



    @Override
    public void init() throws ServletException {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Carport carport = (Carport) session.getAttribute("carport");
        shoppingcart.addCarport(carport);
        session.setAttribute("shoppingcart", shoppingcart);

        request.getRequestDispatcher("carportpage.jsp").forward(request,response);
    }
}
