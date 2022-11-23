<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>student delete</title>
</head>
<body>
 <div align="center">
  <h1>Enter The Id to Delete</h1>
  <form action="<%= request.getContextPath() %>/deleteServlet" method="post">
   <table style="with: 80%">
    <tr>
     <td>User Id</td>
     <td><input type="text" name="id" /></td>
    </tr>
   </table>
   <input type="submit" value="Delete" />
  </form>
 </div>
</body>
</html>