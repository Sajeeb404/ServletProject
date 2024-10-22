package controller;


import dao.RegisterDao;
import model.Register;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/edit1")
public class EditServlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();

        printWriter.println("<h1> View Data by id</h1>");

        int id = Integer.parseInt(req.getParameter("id"));

        Register register = RegisterDao.getRegisterById(id);

        printWriter.println("<form action='updateRegister' method='post' enctype='multipart/form-data'>");
        printWriter.println("<input type='hidden' name ='id'  value='"+register.getId()+"'> <br>");
        printWriter.println("User Name : <input type='text' name ='username' value='"+register.getUserName()+"'> <br>");
        printWriter.println("Email : <input type='email' name ='email' value='"+register.getEmail()+"'> <br>");
        printWriter.println("Password : <input type='password' name ='password' value='"+register.getPassword()+"'> <br>");
        printWriter.println("Confirm Password : <input type='password' name ='conPassword' value='"+register.getConfirmPassword()+"'> <br>");
        printWriter.println("Change Photo: <input type='file' name='image' accept='image/jpeg' required/> <br>");
        printWriter.println("<button type='submit'> Update</button>");
        printWriter.println("</form>");



        printWriter.close();
    }
}
