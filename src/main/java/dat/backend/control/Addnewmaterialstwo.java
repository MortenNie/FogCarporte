package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Addnewmaterialstwo", value = "/addnewmaterialstwo")
public class Addnewmaterialstwo extends HttpServlet {
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
     String type = request.getParameter("materialtype");
     String name = request.getParameter("name");
     double length = Double.parseDouble(request.getParameter("length"));
     int price = Integer.parseInt(request.getParameter("price"));

     if (type.equalsIgnoreCase("rem")) {
         try {
             RemFacade.addRemToDB(name,length,price, connectionPool);
         } catch (DatabaseException e) {
             e.printStackTrace();
         }


     }

     else if (type.equalsIgnoreCase("spaer")) {
         try {
             SpaerFacade.addSpaerToDB(name, length, price, connectionPool);
         } catch (DatabaseException e) {
             e.printStackTrace();
         }


     }

     else if (type.equalsIgnoreCase("stolpe")) {
         try {
             StolpeFacade.addStolpeToDB(name, length, price, connectionPool);
         } catch (DatabaseException e) {
             e.printStackTrace();
         }


     }
     else {
         try {
             TagFacade.addTagToDB(name, length, price, connectionPool);
         } catch (DatabaseException e) {
             e.printStackTrace();
         }


     }

     request.getRequestDispatcher("welcome.jsp").forward(request, response);

    }
}
