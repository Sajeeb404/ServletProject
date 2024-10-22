package controller;


import dao.RegisterDao;
import model.Register;

import javax.servlet.ServletException;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;


@WebServlet("/subRegi")
@MultipartConfig
public class Regi extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        String uName = req.getParameter("username");
        String eMail = req.getParameter("email");
        String pass = req.getParameter("password");
        String conPass = req.getParameter("confirm-password");

        Part filePart = req.getPart("image");

        String fileType = filePart.getContentType();

        InputStream inputStream = null;

        if (filePart != null) {
            if (!fileType.equals("image/jpeg")) {
                printWriter.println("Invalide file type Please upload a JPEG image");
                    req.getRequestDispatcher("regi.html").include(req, resp);
                return;
            }else {
                try {
                    inputStream = filePart.getInputStream();
                } catch (IOException e) {
                    printWriter.println("Error retrieving file input stream: " + e.getMessage());
                    return;
                }
            }
        }




        Register register = new Register();
        register.setUserName(uName);
        register.setEmail(eMail);
        register.setPassword(pass);
        register.setConfirmPassword(conPass);
        register.setImage(inputStream);

        boolean status = false;
        try {
        status = RegisterDao.saved(register);

        } catch (Exception e) {
            printWriter.println("<h2>Error: " + e.getMessage() + "</h2>");

        }



        if (status){
        resp.sendRedirect("viewUser");
        }else {
            printWriter.println("<h1> Data not Saved!</h1>");
        req.getRequestDispatcher("regi.html").include(req,resp);

        }
        inputStream.close();
        printWriter.close();

    }
}
