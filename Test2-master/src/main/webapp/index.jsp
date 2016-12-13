<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.io.File" %>
<%@ page import="java.io.FileReader" %>
<%@ page import="java.io.BufferedReader" %>

<%
    Cookie[] cookies = request.getCookies();
    String emailCookie = "";
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("email")){
                emailCookie = cookie.getValue();
            }
        }
    }
%>

<html>
    <head>
        <title>File Uploading Form</title>
    </head>
    <body>
        <h3>File Upload:</h3>
        <br/>
        <form action="LogIn" method="POST">
            <p>Email:</p>
            <input type="email" name="email">
            <br/>
            <p>Password:</p>
            <input type="password" name="password">
            <input type="checkbox" name="box" value="cookie">
            Remember me
            <br/>
            <input type="submit">
        </form>

        <%
            File file = new File(getServletContext().getInitParameter("file-upload") + "Logs.log");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String temp = "";
            while ((temp = bufferedReader.readLine()) != null) {
                out.println(temp + "<br>");
            }
        %>

    </body>
</html>
