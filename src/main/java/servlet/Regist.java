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
import java.util.Enumeration;
import model.ChkInputProc;
import model.Usr;
import model.UsrLogic;

@WebServlet(value={"/Regist"})
public class Regist
extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usr registUsr;
        request.setCharacterEncoding("UTF-8");
        Object errorMsg = "";
        Usr usr = new Usr();
        UsrLogic ul = new UsrLogic();
        ChkInputProc cil = new ChkInputProc();
        int status = 0;
        Enumeration names = request.getParameterNames();
        String buff = "";
        while (names.hasMoreElements()) {
            buff = (String)names.nextElement();
            System.out.println(buff);
            System.out.println(request.getParameter(buff));
        }
        HttpSession session = request.getSession();
        if (request.getParameter("clear") != null) {
            session.removeAttribute("registUsr");
        }
        if ((registUsr = (Usr)session.getAttribute("registUsr")) == null) {
            session.setAttribute("registUsr", (Object)usr);
        }
        if (request.getParameter("regist0") != null) {
            status = 0;
            registUsr.setUser_id(registUsr.getUser_id() == null ? "" : registUsr.getUser_id());
            registUsr.setPassword(registUsr.getPassword() == null ? "" : registUsr.getPassword());
            registUsr.setL_name(registUsr.getL_name() == null ? "" : registUsr.getL_name());
            registUsr.setF_name(registUsr.getF_name() == null ? "" : registUsr.getF_name());
            registUsr.setL_name_kana(registUsr.getL_name_kana() == null ? "" : registUsr.getL_name_kana());
            registUsr.setF_name_kana(registUsr.getF_name_kana() == null ? "" : registUsr.getF_name_kana());
            registUsr.setPrefecture(registUsr.getPrefecture() == null ? "" : registUsr.getPrefecture());
            registUsr.setCity(registUsr.getCity() == null ? "" : registUsr.getCity());
            registUsr.setO_address(registUsr.getO_address() == null ? "" : registUsr.getO_address());
            registUsr.setTel(registUsr.getTel() == null ? "" : registUsr.getTel());
            registUsr.setEmail(registUsr.getEmail() == null ? "" : registUsr.getEmail());
        }
        if (request.getParameter("regist1") != null) {
            status = 1;
        }
        if (request.getParameter("regist2") != null) {
            status = 2;
        }
        if (status == 1) {
            try {
                registUsr.setPassword(cil.trimString(request.getParameter("password")));
                errorMsg = (String)errorMsg + cil.chkPassword(registUsr.getPassword());
                registUsr.setL_name(cil.trimString(request.getParameter("l_name")));
                errorMsg = (String)errorMsg + cil.chkL_name(registUsr.getL_name());
                registUsr.setF_name(cil.trimString(request.getParameter("f_name")));
                errorMsg = (String)errorMsg + cil.chkF_name(registUsr.getF_name());
                registUsr.setL_name_kana(cil.trimString(request.getParameter("l_name_kana")));
                errorMsg = (String)errorMsg + cil.chkL_name_kana(registUsr.getL_name_kana());
                registUsr.setF_name_kana(cil.trimString(request.getParameter("f_name_kana")));
                errorMsg = (String)errorMsg + cil.chkF_name_kana(registUsr.getF_name_kana());
                registUsr.setPrefecture(cil.trimString(request.getParameter("prefecture")));
                errorMsg = (String)errorMsg + cil.chkPrefecture(registUsr.getPrefecture());
                registUsr.setCity(cil.trimString(request.getParameter("city")));
                errorMsg = (String)errorMsg + cil.chkCity(registUsr.getCity());
                registUsr.setO_address(cil.trimString(request.getParameter("o_address")));
                errorMsg = (String)errorMsg + cil.chkO_address(registUsr.getO_address());
                registUsr.setTel(cil.trimString(request.getParameter("tel")));
                errorMsg = (String)errorMsg + cil.chkTel(registUsr.getTel());
                registUsr.setEmail(cil.trimString(request.getParameter("email")));
                errorMsg = (String)errorMsg + cil.chkEmail(registUsr.getEmail());
                status = ((String)errorMsg).length() == 0 ? 1 : 0;
            }
            catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
        if (status == 2) {
            try {
                registUsr.setUser_id(ul.getNewID());
                request.setAttribute("registUsr", (Object)registUsr);
                ul.insertUsr(registUsr);
                session.removeAttribute("registUsr");
            }
            catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
        request.setAttribute("status", (Object)status);
        request.setAttribute("errorMsg", errorMsg);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/regist.jsp");
        dispatcher.forward((ServletRequest)request, (ServletResponse)response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        this.doGet(request, response);
    }
}
