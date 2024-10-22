<!DOCTYPE html>
<html>
<head>
    <title>Send Email</title>
</head>
<body>
<%@ include file="header.jsp" %>
<br>
<br>
<br>
    <form action="sendEmail" method="post">
        To: <input type="email" name="to" required><br>
        Subject: <input type="text" name="subject" required><br>
        Body:<br><textarea name="body" required></textarea><br>
        <input type="submit" value="Send Email">
    </form>
</body>
</html>
