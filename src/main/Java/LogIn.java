// Import required java libraries
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class LogIn extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException
    {

        ApplicationContext context = new ClassPathXmlApplicationContext("bean-config.xml");
        User user = (User) context.getBean("user1");

        HttpSession session = request.getSession(true);

        String email = (String) request.getAttribute("email");
        String pass = (String) request.getAttribute("password");


        if(email.equals(user.getEmail()) && pass.equals(user.getPass())) {

            session.setAttribute("email", email);
            session.setAttribute("pass", pass);


            response.sendRedirect("fileupload.jsp");

        } else {
            response.sendRedirect("index.jsp");
        }


    }
}