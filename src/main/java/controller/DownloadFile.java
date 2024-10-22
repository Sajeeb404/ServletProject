package controller;

import dao.RegisterDao;
import model.Register;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@WebServlet("/download")
public class DownloadFile extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String fileId = req.getParameter("id");

        Register registerDao = RegisterDao.getFileByID(Integer.parseInt(fileId));

        if (registerDao != null) {
            resp.setContentType("application/octet-stream");
            resp.setHeader("Content-Disposition", "attachment; filename=\"" + registerDao.getUserName() + ".jpg\"");


            try (InputStream inputStream = registerDao.getImage();
                 OutputStream outputStream = resp.getOutputStream()
            ){
                byte[] buffer = new byte[1024];
                int bytesRead;

                while ((bytesRead =inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer,0, bytesRead);
                }


            }


        }else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "File not found.");
        }



    }

}