package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import model.OrderMain;
import model.OrderMainLogic;
import model.Usr;

@WebServlet(value={"/History"})
public class History
extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderMainLogic orderMainLogic;
        List<OrderMain> orderMainList;
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        Usr loginUsr = (Usr)session.getAttribute("loginUsr");
        if (loginUsr != null && (orderMainList = (orderMainLogic = new OrderMainLogic()).findAllByUserId(loginUsr)) != null) {
            request.setAttribute("orderMainList", orderMainList);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/history.jsp");
        dispatcher.forward((ServletRequest)request, (ServletResponse)response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
