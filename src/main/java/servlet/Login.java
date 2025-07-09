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
import model.Usr;
import model.UsrLogic;

@WebServlet(value={"/Login"})
public class Login
extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login;
        RequestDispatcher dispatcher;
        request.setCharacterEncoding("UTF-8");
        int errorFlg = 0;
        String logout = request.getParameter("logout");
        if (logout != null) {
            System.out.println(request.getParameter("logout"));
            HttpSession session = request.getSession();
            session.invalidate();
            request.setAttribute("errorMsg", (Object)"\u30ed\u30b0\u30a2\u30a6\u30c8\u3057\u307e\u3057\u305f");
            ++errorFlg;
            dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
            dispatcher.forward((ServletRequest)request, (ServletResponse)response);
        }
        if ((login = request.getParameter("login")) != null) {
            String password;
            UsrLogic usrLogic = new UsrLogic();
            String user_id = request.getParameter("user_id");
            Usr usr = new Usr(user_id, password = request.getParameter("password"));
            if (usrLogic.findAUsr(usr) == null) {
                request.setAttribute("errorMsg", (Object)"\u30e6\u30fc\u30b6\u30fcID\u3082\u3057\u304f\u306f\u30d1\u30b9\u30ef\u30fc\u30c9\u304c\u9593\u9055\u3063\u3066\u3044\u307e\u3059\u3002");
                ++errorFlg;
            } else if (usrLogic.findAUsr(usr).size() == 1) {
                HttpSession session = request.getSession();
                session.setAttribute("loginUsr", (Object)usrLogic.findAUsr(usr).get(0));
            } else {
                request.setAttribute("errorMsg", (Object)"\u30e6\u30fc\u30b6\u30fcID\u3082\u3057\u304f\u306f\u30d1\u30b9\u30ef\u30fc\u30c9\u304c\u9593\u9055\u3063\u3066\u3044\u307e\u3059\u3002");
                ++errorFlg;
            }
            if (errorFlg == 0) {
                RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
                dispatcher2.forward((ServletRequest)request, (ServletResponse)response);
            }
        }
        if (request.getParameter("login") != "" || errorFlg != 0) {
            System.out.println("BP1");
            dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
            dispatcher.forward((ServletRequest)request, (ServletResponse)response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("BP2");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
        dispatcher.forward((ServletRequest)request, (ServletResponse)response);
    }
}
