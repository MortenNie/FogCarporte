package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Carport;
import dat.backend.model.entities.ShoppingCart;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.CarportFacade;
import dat.backend.model.persistence.ConnectionPool;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "Deletecarportfromcart", value = "/deletecarportfromcart")
public class Deletecarportfromcart extends HttpServlet {

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

        int carportId = Integer.parseInt(request.getParameter("deletecarportfromcart"));
        HttpSession session = request.getSession();
        ShoppingCart sc = (ShoppingCart) session.getAttribute("shoppingcart");
        List<Carport> carportList = sc.getCarports();

        try {
            CarportFacade.deleteCarport(carportId, connectionPool);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
        for (Iterator<Carport> iterator = carportList.iterator(); iterator.hasNext(); ) {
            Carport value = iterator.next();
            if (value.getCarportId() == carportId) {
                iterator.remove();
            }
        }
        ShoppingCart sc2 = new ShoppingCart();

        if(carportList.isEmpty()) {

            request.getRequestDispatcher("shoppingcart.jsp").forward(request, response);

        }else{
            for ( Carport c : carportList){
                sc2.addCarport(c);
            }
        }

        session.removeAttribute("shoppingcart");
        session.setAttribute("shoppingcart", sc2);
        request.getRequestDispatcher("shoppingcart.jsp").forward(request, response);

    }
}
