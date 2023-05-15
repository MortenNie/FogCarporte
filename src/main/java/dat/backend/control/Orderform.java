package dat.backend.control;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Orderform", value = "/orderform")
public class Orderform extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double materialPrice = Double.parseDouble(request.getParameter("orderform"));
        HttpSession session = request.getSession();
        session.setAttribute("materialPrice", materialPrice);
        request.getRequestDispatcher("WEB-INF/orderform.jsp").forward(request, response);
    }
}
