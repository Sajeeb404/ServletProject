package controller;

import dao.RegisterDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();

        int id = Integer.parseInt(req.getParameter("id"));

        int status = RegisterDao.deleteById(id);

        if (status>0) {
            resp.sendRedirect("viewUser");
//            req.getRequestDispatcher("viewUser").forward(req, resp);
        }


    }
}
