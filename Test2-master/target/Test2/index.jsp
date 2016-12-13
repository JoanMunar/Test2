<%@ page language="java" contentType="text/html; charset=UTF-8" %>
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
    </body>
</html>
