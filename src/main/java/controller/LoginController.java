package controller;

import dao.RegisterDao;
import model.Register;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();

        String uName = req.getParameter("username");
        String pass = req.getParameter("userpass");

        if (RegisterDao.isValidate(uName, pass)){
            HttpSession session = req.getSession();


            Register register = RegisterDao.getRegisterByUserName(uName);
            session.setAttribute("register", register);
            session.setAttribute("username", uName);

        req.getRequestDispatcher("header.jsp").forward(req, resp);
        }else {
            printWriter.println("<h1>Sorry username or password error</h1>");
            req.getRequestDispatcher("login.html").include(req, resp);
        }


    }
}
