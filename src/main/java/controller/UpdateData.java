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

@WebServlet("/updateRegister")
@MultipartConfig
public class UpdateData extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter printWriter = resp.getWriter();
        InputStream inputStream =null;



        try {
            String idParam = req.getParameter("id");
            String uname = req.getParameter("username");
            String em = req.getParameter("email");
            String pass = req.getParameter("password");
            String cpass = req.getParameter("conPassword");

            Part filPart = req.getPart("image");

            inputStream = (filPart != null) ? filPart.getInputStream() : null;

         Register register = new Register();
            register.setId(Integer.parseInt(idParam));
            register.setUserName(uname);
            register.setEmail(em);
            register.setPassword(pass);
            register.setConfirmPassword(cpass);
            register.setImage(inputStream);

            int status = RegisterDao.updateRegi(register);

            if (status>0) {
                printWriter.println("<h1> Data updated successfully</h1>");
                resp.sendRedirect("viewUser");
            }

        } catch (NumberFormatException e) {
            printWriter.println("<h1>Invalid user ID. Please try again.</h1>");
        } catch (Exception e) {
            printWriter.println("<h1>Error occurred: " + e.getMessage() + "</h1>");
        } finally {
            printWriter.close();
            inputStream.close();

        }


    }
}
