package dat.backend.control;

import dat.backend.model.entities.Carport;
import dat.backend.model.entities.ShoppingCart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Deletecarportfromcart", value = "/deletecarportfromcart")
public class Deletecarportfromcart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        ShoppingCart sc = (ShoppingCart) session.getAttribute("Shoppingcart");
        List<Carport> carportList = sc.getCarports();




    }
}
