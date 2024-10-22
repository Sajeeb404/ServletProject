package controller;

import dao.FileDao;
import model.FileUploadModel;

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


@WebServlet("/upload")
@MultipartConfig(maxFileSize = 10485760) // 10MB
public class FileUploadController extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        Part filePart = request.getPart("fname"); // Retrieve the uploaded file
        FileUploadModel fileUpload = new FileUploadModel();
        InputStream inputStream =null;
        String filename = filePart.getSubmittedFileName();
        String filetyename = filePart.getContentType();

        if (!filetyename.equals("image/jpeg")) {
            printWriter.println("Invalide file type Please upload a JPEG image");
            request.getRequestDispatcher("file.jsp").include(request, response);
            return;
        }else {
            try {
                inputStream = filePart.getInputStream();
            } catch (Exception e) {
                printWriter.println("Error retrieving file input stream: " + e.getMessage());
                return;

            }
        }


        fileUpload.setFileName(filename);
        fileUpload.setFileType(filetyename);
        fileUpload.setFile(inputStream); // Get InputStream

        boolean isSaved = FileDao.saveFile(fileUpload);

        // Provide feedback to the user
        
        
        if (isSaved) {
            request.getRequestDispatcher("file.jsp").forward(request, response);
            printWriter.println("File uploaded successfully!");
        } else {
            printWriter.println("File upload failed.");
        }

        inputStream.close();
        printWriter.close();
    }


}
