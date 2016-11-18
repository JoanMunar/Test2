// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class Cookies extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException
    {
        // Create cookies for first and last names.
        Cookie email = new Cookie("email",
                request.getParameter("email"));

        // Set expiry date after 24 Hrs for both the cookies.
        email.setMaxAge(60 * 60 * 24 * 7);

        // Add both the cookies in the response header.
        response.addCookie( email );

        // Set response content type
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String title = "Setting Cookies Example";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " +
                        "transitional//en\">\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "  <li><b>User</b>: "
                + request.getParameter("user") + "\n" +
                "  <li><b>Password</b>: "
                + request.getParameter("password") + "\n" +
                "</ul>\n" +
                "</body></html>");
    }
}