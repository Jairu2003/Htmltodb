<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h1>Data Entry Form</h1>
    <form action="InsertData" method="post" >
FRIEND-ID<input type="text" id="id"  name="id" >
 FRIEND-NAME<input type="text" id="names" name="names" required><br><br>
FRIEND-ADDRESS <input type="text" id="adds" name="adds" required><br><br>
<input type="submit" value="Submit">

</form>

</body>
</html>