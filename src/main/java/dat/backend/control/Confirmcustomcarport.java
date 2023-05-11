package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Rem;
import dat.backend.model.entities.Spaer;
import dat.backend.model.entities.Stolpe;
import dat.backend.model.persistence.ConnectionPool;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Confirmcustomcarport", value = "/confirmcustomcarport")
public class Confirmcustomcarport extends HttpServlet {
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
        double height = Double.parseDouble(request.getParameter("Height"));
        double length = Double.parseDouble(request.getParameter("Length"));
        double width = Double.parseDouble(request.getParameter("Width"));
        String shedOption = request.getParameter("Shed");
        boolean shed;

        if (shedOption.equals("Yes"))
            shed = true;
        else
            shed = false;

        Spaer spaer = MathFunctions.SpaerSelection(width,length, connectionPool);
        Rem rem = MathFunctions.RemSelection(length, connectionPool);
        Stolpe stolpe = MathFunctions.stolpeSelection(length,height, shed, connectionPool);
        request.setAttribute("stolpe", stolpe);
        request.setAttribute("spaer", spaer);
        request.setAttribute("rem", rem);

        request.getRequestDispatcher("WEB-INF/customcarportpagetwo.jsp").forward(request, response);

    }
}
