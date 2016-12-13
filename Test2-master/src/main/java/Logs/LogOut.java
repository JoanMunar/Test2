package Logs;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class LogOut extends HttpServlet {
    public void init(){

    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        request.getSession().invalidate();
        response.sendRedirect("index.jsp");

    }
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
}