


<%@ include file="header.jsp" %> <!-- Include the header JSP file -->
<br>
<br>
<br>
<br>

<form action="upload" method="post" enctype="multipart/form-data">
    Select File: <input type="file" name="fname" accept="image/jpeg"><br>
    <input type="submit" value="Upload">
</form>

<img src="userImage?ts=<%= System.currentTimeMillis() %>" alt="User Image" width="100" height="100" />

</body>
</html>
