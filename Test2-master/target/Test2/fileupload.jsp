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
            <a href="LogOut">Log Out</a>
        </form>
        <button>Out</button>
    </body>
</html>