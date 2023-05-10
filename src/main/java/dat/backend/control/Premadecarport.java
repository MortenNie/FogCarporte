package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Spaer;
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

        request.setAttribute("spaer", spaer);





        request.getRequestDispatcher("WEB-INF/premadecarportpage.jsp").forward(request, response);

    }
}
