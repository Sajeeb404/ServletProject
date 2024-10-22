package controller;

import dao.FileDao;
import model.FileUploadModel;

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

@WebServlet("/fileServlet")
public class FileViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter printWriter = resp.getWriter();


        HttpSession httpSession = req.getSession(false);

        if (httpSession == null || httpSession.getAttribute("username")== null) {
            resp.sendRedirect("login.html");
            return;
        }

        req.getRequestDispatcher("header.jsp").include(req, resp);

        printWriter.println("<h1> View all images</h1>");

        printWriter.println("<img src=\"userImage?ts=<%= System.currentTimeMillis() %>\" alt=\"User Image\" width=\"100\" height=\"100\" />");
        
        
        printWriter.println("<table border='1'>");
        printWriter.println("<tr> <th> File Name</th>");
        printWriter.println("<th> Files</th> ");
        printWriter.println("<th> Download</th> </tr>");

        ArrayList<FileUploadModel> files = FileDao.getAllFile();
        
        for (FileUploadModel list : files) {
            printWriter.println("<tr> <td>"+ list.getFileName() + "</td>");

            InputStream inputStream = list.getFile();

            String base = (inputStream != null)?convertBase64(inputStream):null;

            if (base !=null) {
                printWriter.println("<td> <img src='data:image/jpeg;base64," + base + "' width='100' height='100'/></td>");

            }else {
                printWriter.println("<td>No Image</td>");
            }

            printWriter.println("<td> <a href='down?id="+list.getId()+"'> "+list.getId()+"Download</a> </td> </tr>");



        }


        
        
        printWriter.println("</table>");



        printWriter.close();
    }


    String convertBase64(InputStream inputStream){


        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()){

            byte[] buffer = new byte[1024];
            int byetesRead;

            while ((byetesRead = inputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, byetesRead);
            }


            return Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }

}
