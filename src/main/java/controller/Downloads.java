package controller;

import dao.FileDao;
import model.FileUploadModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@WebServlet("/down")
public class Downloads extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        int ids = Integer.parseInt(req.getParameter("id"));

        System.out.println(ids);

        FileUploadModel fileUploadModel = FileDao.getFileById(ids);

        if (fileUploadModel != null) {
            resp.setContentType("application/octet-stream");
            resp.setHeader("Content-Disposition","attachment; filename=\"" +fileUploadModel.getFileName()+"\"");

            try (InputStream inputStream = fileUploadModel.getFile();
                 OutputStream outputStream = resp.getOutputStream()){

                byte[] buffer = new byte[1024];
                int bytesRead;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }



            } catch (Exception e) {
                e.printStackTrace();

            }


        }else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "File Not Found!");
        }



    }
}
