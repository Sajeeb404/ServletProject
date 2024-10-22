package controller;

import model.Register;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Base64;

@WebServlet("/userImage")
public class UserImageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession httpSession = req.getSession();
        Register register = (Register) httpSession.getAttribute("register");

        // Log the user image request
        System.out.println("User image requested");
        if (register != null) {
            System.out.println("Image requested for user: " + register.getUserName()); // Add this line
            System.out.println("Image available: " + (register.getImage() != null));
        } else {
            System.out.println("No user found in session");
        }

        // Rest of your existing code...
        if (register != null) {
            resp.setContentType("image/jpeg");
            InputStream inputStream = register.getImage();



//            byte[] imageBytes = inputStream.readAllBytes(); // Read the image bytes
//            String base64Image = Base64.getEncoder().encodeToString(imageBytes);
//            req.setAttribute("base64Image", base64Image);

            if (inputStream != null) {
                OutputStream outputStream = resp.getOutputStream();

                byte[] buffer = new byte[1024];
                int bytesRead;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                outputStream.flush();
                inputStream.close();
            } else {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }

    }


}
