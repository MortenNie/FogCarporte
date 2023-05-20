package dat.backend.control;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Givecustomprice", value = "/givecustomprice")
public class Givecustomprice extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int orderId = Integer.parseInt(request.getParameter("givecustomprice"));
        HttpSession session = request.getSession();
        session.setAttribute("orderId", orderId);
        request.getRequestDispatcher("WEB-INF/customprice.jsp").forward(request, response);
    }
}
