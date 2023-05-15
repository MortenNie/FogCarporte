package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Carport;
import dat.backend.model.entities.ShoppingCart;
import dat.backend.model.entities.User;
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

@WebServlet(name = "Finishorder", value = "/finishorder")
public class Finishorder extends HttpServlet {
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
        String clientName = request.getParameter("Name");
        String clientAdress = request.getParameter("Adress");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingcart");
        List<Carport> listofCarports = shoppingCart.getCarports();
        double materialPrice = (double) session.getAttribute("materialPrice");
        double price = MathFunctions.priceWithDaekningsGrad(materialPrice,0.4);
        int orderId = -1;
        int carportId = -1;
        List<Integer>listOfCarportIds = new ArrayList<>();
        try {
          orderId = OrderFacade.addOrder(clientName,clientAdress,user.getUsername(),"pending", price, connectionPool);
          for (Carport s: listofCarports) {
              listOfCarportIds.add(s.getCarportId());
              ItemListMapper.AddToItemListSpaer(s.getSpaer().getSpaerId(),s.getSpaer().getQuantity(),carportId, connectionPool);
              ItemListMapper.AddToItemListRem(s.getRem().getRemId(),s.getRem().getQuantity(),carportId, connectionPool);
              ItemListMapper.AddToItemListStolpe(s.getStolpe().getStolpeId(),s.getStolpe().getQuantity(),carportId, connectionPool);
              ItemListMapper.AddToItemListTag(s.getTag().getTagId(),s.getTag().getQuantity(),carportId, connectionPool);
          }
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        for (Integer t: listOfCarportIds) {
            try {
                CarportFacade.addOrderIdToCarport(orderId, t, connectionPool);
            } catch (DatabaseException e) {
                e.printStackTrace();
            }

        }

        shoppingCart.getCarports().clear();
        session.removeAttribute("shoppingcart");
        request.getRequestDispatcher("WEB-INF/welcome.jsp").forward(request, response);

    }


}
