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
import model.OrderDesc;
import model.OrderDescLogic;
import model.OrderMain;
import model.OrderMainLogic;
import model.Usr;

@WebServlet(value={"/HistoryDetail"})
public class HistoryDetail
extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        boolean toRedirect = false;
        HttpSession session = request.getSession();
        Usr loginUsr = (Usr)session.getAttribute("loginUsr");
        Integer po_id = 0;
        String strPo_id = request.getParameter("po_id");
        try {
            po_id = Integer.parseInt(strPo_id);
        }
        catch (Exception exception) {
            // empty catch block
        }
        if (loginUsr != null && po_id != 0) {
            OrderMainLogic orderMainLogic = new OrderMainLogic();
            List<OrderMain> orderMainList = orderMainLogic.selectByPoId(po_id);
            OrderDescLogic orderDescLogic = new OrderDescLogic();
            List<OrderDesc> orderDescList = orderDescLogic.selectByPo_id(po_id);
            if (orderDescList == null || orderMainList == null) {
                toRedirect = true;
            } else {
                Integer total = 0;
                for (OrderDesc orderDesc : orderDescList) {
                    total = total + orderDesc.getQuantity() * orderDesc.getHist_price();
                }
                request.setAttribute("orderMainList", orderMainList);
                request.setAttribute("orderDescList", orderDescList);
                request.setAttribute("total", (Object)total);
            }
            request.setAttribute("toRedirect", (Object)toRedirect);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/history-detail.jsp");
            dispatcher.forward((ServletRequest)request, (ServletResponse)response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/history-detail-redirect.jsp");
            dispatcher.forward((ServletRequest)request, (ServletResponse)response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
