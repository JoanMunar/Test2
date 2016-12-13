<html>
    <head>
        <title>File Upload</title>
    </head>
    <body>
        <h3>File Upload:</h3>
        Select a file to upload: <br />
        <form action="UploadServlet" method="post" enctype="multipart/form-data">
            <input type="file" name="file" size="50" />
            <br />
            <br />
            <input type="submit" value="Upload File" />
        </form>

        <%-- Sortir de la sessio --%>
        <a href="Logs.LogOut">Log Out</a>
        <%-- Veure els arxius --%>
        <a href="Servlet.Files">Consultar arxius</a>

        <%-- Sortir de la sessio --%>
        <%
            HttpSession sessio =  request.getSession();
            String email = (String) ses.getAttribute("email");
            int arroba = 0;

            for (int i = 0; i < email.length(); i++) {
                if (email.charAt(i) == '@'){
                    arroba = i;
                }
            }

            email = email.substring(0,arroba);

            File file = new File(getServletContext().getInitParameter("file-upload") + userdir + "\\UserLoggingLog.log");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String temp = null;

            while ((temp = bufferedReader.readLine()) != null) {
                out.println(temp + "<br>");
            }

        %>
    </body>
</html>