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
import java.util.ArrayList;
import java.util.List;
import model.Cart;
import model.CartLogic;
import model.OrderDesc;
import model.OrderDescLogic;
import model.OrderMain;
import model.OrderMainLogic;
import model.Usr;

@WebServlet(value={"/Pay"})
public class Pay
extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        Usr loginUsr = (Usr)session.getAttribute("loginUsr");
        List<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
        boolean isOrdered = false;
        if (cartList == null) {
            cartList = new ArrayList<Cart>();
        }
        String rem2Cart = request.getParameter("rem2cart");
        String order = request.getParameter("order");
        System.out.println("BP1");
        if (rem2Cart != null) {
            String p_id = request.getParameter("p_id");
            String p_name = request.getParameter("p_name");
            Integer price = Integer.parseInt(request.getParameter("price"));
            Integer count = Integer.parseInt(request.getParameter("count"));
            Cart cart = new Cart(p_id, p_name, price, count);
            System.out.println(cart);
            CartLogic cartLogic = new CartLogic();
            cartList = cartLogic.rem2Cart(cart, cartList);
            session.setAttribute("cartList", cartList);
        }
        if (order != null && !cartList.isEmpty() && loginUsr != null) {
            OrderMain orderMain = new OrderMain(loginUsr.getUser_id());
            OrderMainLogic orderMainLogic = new OrderMainLogic();
            orderMain = orderMainLogic.insert(orderMain);
            ArrayList<OrderDesc> orderDescList = new ArrayList<OrderDesc>();
            for (Cart aCart : cartList) {
                OrderDesc orderDesc = new OrderDesc(orderMain.getPo_id());
                orderDesc.setP_id(aCart.getP_id());
                orderDesc.setQuantity(aCart.getCount());
                orderDesc.setHist_p_name(aCart.getP_name());
                orderDesc.setHist_price(aCart.getPrice());
                orderDescList.add(orderDesc);
            }
            OrderDescLogic orderDescLogic = new OrderDescLogic();
            orderDescLogic.insert(orderDescList);
            session.removeAttribute("cartList");
            isOrdered = true;
            request.setAttribute("po_id", (Object)orderMain.getPo_id());
        }
        request.setAttribute("isOrdered", (Object)isOrdered);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/pay.jsp");
        dispatcher.forward((ServletRequest)request, (ServletResponse)response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
