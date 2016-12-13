package Logs;// Import required java libraries
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class LogIn extends HttpServlet {

    public void doPost(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        ApplicationContext context = new ClassPathXmlApplicationContext("bean-config.xml");
        List<User> llista = (List) context.getBean("llista");

        Cookie cookie = new Cookie("email",request.getParameter("email"));

        HttpSession session = request.getSession(true);

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String checkbox = request.getParameter("box");

        for (User user : llista){
            if (email.equals(user.getEmail()) && password.equals(user.getPass())) {

                session.setAttribute("email", email);
                session.setAttribute("password", password);

                if(checkbox != null) {
                    cookie.setMaxAge(60 * 60 * 24 * 7);
                    response.addCookie(cookie);
                }
                response.sendRedirect("fileupload.jsp");
                return;
            }

        }
        response.sendRedirect("error.jsp");

    }
}