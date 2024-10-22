package controller;

import dao.RegisterDao;
import model.Register;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Base64;

@WebServlet("/viewUser")
public class ViewUser extends HttpServlet {


    String convertToBase64(InputStream inputStream) {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            return Base64.getEncoder().encodeToString(outputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();

        HttpSession session = req.getSession(false);

        if (session ==null || session.getAttribute("username")== null) {
            resp.sendRedirect("login.html");
            return;
        }

        req.getRequestDispatcher("header.jsp").include(req,resp);
        printWriter.println("<br><h1> View All User</h1>");

        printWriter.println("<table border='1' collapsed> <tr>");
        printWriter.println("<th>ID</th>");
        printWriter.println("<th>User Name</th>");
        printWriter.println("<th>Email</th>");
        printWriter.println("<th>Password</th>");
        printWriter.println("<th>Confirm Password</th>");
        printWriter.println("<th>Image</th>");
        printWriter.println("<th>Edit</th>");
        printWriter.println("<th>Delete</th>");
        printWriter.println("<th>Download</th> </tr>");



        ArrayList<Register> list = RegisterDao.getAllRegister();

        for (Register rs: list) {
        printWriter.println("<tr> <td>"+rs.getId()+"</td>");
        printWriter.println("<td>"+rs.getUserName()+"</td>");
        printWriter.println("<td>"+rs.getEmail()+"</td>");
        printWriter.println("<td>"+rs.getPassword()+"</td>");
        printWriter.println("<td>"+rs.getConfirmPassword()+"</td>");

        InputStream inputStream = rs.getImage();
        String imga64 = (inputStream != null)?convertToBase64(inputStream):null;

            if (imga64 != null) {
                printWriter.println("<td> <img src='data:image/jpeg;base64," + imga64 + "' width='100' height='100'/></td>");
            }else {
                printWriter.println("<td>No Image</td>");
            }


            printWriter.println("<td> <a href='edit1?id="+ rs.getId() +"'> Edit</a> </td>");
        printWriter.println("<td> <a href='deleteServlet?id="+ rs.getId() +"'> Delete</a> </td>");
         printWriter.println("<td> <a href='download?id="+ rs.getId() +"'> Download</a> </td> </tr>");

        }


        printWriter.println("</table>");

        printWriter.println("<br>");
        printWriter.println("<br>");
        printWriter.println("<br>");
        printWriter.println("<br>");
        printWriter.println("<br>");

        printWriter.close();

    }
}
