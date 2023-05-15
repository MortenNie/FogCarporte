package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.*;
import dat.backend.model.persistence.CarportFacade;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.SpaerFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@WebServlet(name = "Premadecarport", value = "/premadecarport")
public class Premadecarport extends HttpServlet {
    private ConnectionPool connectionPool;


    @Override
    public void init() throws ServletException
    {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        double width = 6.0; //premade carport width.
        double length = 7.8; // premade carport length.
        double height = 3 - 0.9; //stolpens length minus the length which it has to be put into the ground.
        boolean shed = true; //Theres a shed on the premade carport.

        Spaer spaer = MathFunctions.SpaerSelection(width,length, connectionPool);
        Rem rem = MathFunctions.RemSelection(length, connectionPool);
        Stolpe stolpe = MathFunctions.stolpeSelection(length,height, shed, connectionPool);
        Tag tag = MathFunctions.tagSelection(width, length, connectionPool);
        request.setAttribute("stolpe", stolpe);
        request.setAttribute("spaer", spaer);
        request.setAttribute("rem", rem);
        request.setAttribute("tag", tag);
        int carportId = CarportFacade.returnCarportId(width,length, height,shed, connectionPool);
        Carport carport = new Carport(carportId,width,length, height, shed, spaer, rem, stolpe, tag);
        ShoppingCart sc = new ShoppingCart();
        sc.addCarport(carport);
        request.setAttribute("sc", sc);
        HttpSession session = request.getSession();
        session.setAttribute("carport", carport);





        request.getRequestDispatcher("WEB-INF/premadecarportpage.jsp").forward(request, response);

    }
}
