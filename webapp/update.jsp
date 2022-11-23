<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>student update</title>
</head>
<body>
 <div align="center">
  <h1>Update Student Form</h1>
  <form action="<%= request.getContextPath() %>/updateServlet" method="post">
   <table style="with: 80%">
    <tr>
     <td>Student Id</td>
     <td><input type="number" name="id" /></td>
    </tr>
    <tr>
     <td>Student Name</td>
     <td><input type="text" name="name" /></td>
    </tr>
    <tr>
     <td>Physics Mark</td>
     <td><input type="number" name="physics" /></td>
    </tr>
    <tr>
     <td>Maths Mark</td>
     <td><input type="number" name="maths" /></td>
    </tr>
    <tr>
     <td>Chemistry Mark</td>
     <td><input type="number" name="chemistry" /></td>
    </tr>
   </table>
   <input type="submit" value="Submit" />
  </form>
  </div>
</body>
</html>