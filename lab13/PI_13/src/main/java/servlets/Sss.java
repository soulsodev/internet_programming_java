package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Sss", urlPatterns={"/Sss"})
@MultipartConfig
public class Sss extends HttpServlet {

  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String filename = request.getParameter("file");
    String docdir   = getServletContext().getInitParameter("doc-dir");

    File file = new File(docdir+ "\\\\" + filename);
    PrintWriter out = response.getWriter();
    response.setContentType("APPLICATION/OCTET-STREAM");
    response.setHeader("Content-Disposition", "attachment; filename=\""
        + file.getName() + "\"");

    FileInputStream fileInputStream = new FileInputStream(file.getAbsolutePath());

    int i;
    while( (i = fileInputStream.read()) != -1 )
    {
      out.write(i);
    }
    fileInputStream.close();
    out.close();
    System.out.println("Sss: downloaded" + filename);
  }

  protected void doPost(HttpServletRequest request,
                        HttpServletResponse response) throws ServletException, IOException {
    String docdir   = getServletContext().getInitParameter("doc-dir");

    String savePath = docdir;

    File fileSaveDir = new File(savePath);
    if (!fileSaveDir.exists()) {
      fileSaveDir.mkdir();
    }

    for (Part part : request.getParts()) {
      String fileName = extractFileName(part);
      fileName = new File(fileName).getName();
      part.write(savePath + File.separator + fileName);
    }
    System.out.println("Sss: Upload has been done successfully!");
    getServletContext().getRequestDispatcher("/index.jsp").forward(
        request, response);
  }

  private String extractFileName(Part part) {
    String contentDisp = part.getHeader("content-disposition");
    String[] items = contentDisp.split(";");
    for (String s : items) {
      if (s.trim().startsWith("filename")) {
        return s.substring(s.indexOf("=") + 2, s.length()-1);
      }
    }
    return "";
  }

}