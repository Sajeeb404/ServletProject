package controller;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import static javax.print.DocFlavor.URL.PDF;

@WebServlet("/pdfServlet")
public class PDFServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/pdf");

        resp.setHeader("Content-Disposition", "inline; filename=\"javatpoint.pdf\"");



        PdfWriter pdfWriter = new PdfWriter(resp.getOutputStream());


        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);

        HttpSession httpSession = req.getSession(false);

        String dd = (String) httpSession.getAttribute("username");


        document.add(new Paragraph(dd));

        document.close();


    }
}
