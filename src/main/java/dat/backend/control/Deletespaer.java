package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Rem;
import dat.backend.model.entities.Spaer;
import dat.backend.model.entities.Stolpe;
import dat.backend.model.entities.Tag;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Deletespaer", value = "/deletespaer")
public class Deletespaer extends HttpServlet {

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
        int spaerId = Integer.parseInt(request.getParameter("deletespaer"));
        try {
            SpaerFacade.deleteSpaer(spaerId, connectionPool);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        List<Spaer> listOfSpaer = SpaerFacade.getAllSpaer(connectionPool);
        List<Rem> listOfRem = RemFacade.getAllRem(connectionPool);
        List<Stolpe> listOfStolpe = StolpeFacade.getAllStolpe(connectionPool);
        List<Tag> listOfTag = TagFacade.getAllTag(connectionPool);

        request.setAttribute("listOfSpaer", listOfSpaer);
        request.setAttribute("listOfRem",listOfRem);
        request.setAttribute("listOfStolpe", listOfStolpe);
        request.setAttribute("listOfTag", listOfTag);
        request.getRequestDispatcher("WEB-INF/deleteoldmaterials.jsp").forward(request,response);

    }
}

