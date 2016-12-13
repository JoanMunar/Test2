package Servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class Files extends HttpServlet {

    private String filePath;
    private boolean primeraSessio = true;

    public void init() {
        // Get the file location where it would be stored.
        filePath = getServletContext().getInitParameter("file-upload");
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessio =  request.getSession();
        String email = (String) sessio.getAttribute("email");
        int arroba = 0;

        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@'){
                arroba = i;
            }
        }

        email = email.substring(0,arroba);

        if (primeraSessio == true){

            primeraSessio = false;

            filePath += email + "/";

        }
        File file = new File(filePath);
        File[] files = file.listFiles();

        if (files != null) {
            for (int i = 0; i < files.length; i++) {

                if (request.getParameterMap().containsKey("delete")){
                    if (Integer.parseInt(request.getParameter("delete")) == i ){
                        files[i].delete();
                        response.sendRedirect("Servlet.Files");
                        break;
                    }
                }

            }
        }

        // Set refresh, autoload time as 5 seconds
        response.setIntHeader("Refresh", 5);

        // Set response content type
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String title = "Your files";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " +
                        "transitional//en\">\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n"+
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n"
        );
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException
    {
        doGet(request,response);
    }
}