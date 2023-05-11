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

@WebServlet(name = "Customcarport", value = "/customcarport")
public class Customcarport extends HttpServlet {
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

        request.getRequestDispatcher("customcarportpage.jsp").forward(request,response);
       }
}
