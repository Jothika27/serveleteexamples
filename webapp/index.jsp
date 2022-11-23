<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>student index</title>
</head>
<body>
 <div align="center">
  <h1>Student Form</h1>
  <form action="<%= request.getContextPath() %>/studentServlet" method="post">
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
  <div>
  <% out.println("\n"); %>
  </div>
 <div align="center">
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>


<form method="post">

<table border="2">
   <tr>
        <td>Student ID</td>
        <td>Student Name</td>
        <td>Physics Mark</td>
        <td>Maths Mark</td>
        <td>Chemistry Mark</td>
        <td>Average</td>
        <td>Delete</td>
        <td>update</td>
   </tr>
   <%
   try
   {
       Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
       String query="select * from student";
       Connection conn=DriverManager.getConnection("jdbc:ucanaccess://C:/Users/7000033050/Documents/userdetails.accdb;openExclusive=false;ignoreCase=true","","");
       Statement stmt=conn.createStatement();
       ResultSet rs=stmt.executeQuery(query);
       while(rs.next())
       {
   %>
       <tr><td><%out.println(rs.getInt("id")); %></td>
       <td><%out.println(rs.getString("name")); %></td>
       <td><%out.println(rs.getFloat("physics")); %></td>
       <td><%out.println(rs.getFloat("maths")); %></td>
       <td><%out.println(rs.getFloat("chemistry")); %></td>
       <td><%out.println(Math.ceil((rs.getFloat("physics")+rs.getFloat("maths")+rs.getFloat("chemistry"))/3)); %></td>
       <td><a href="/delete.jsp">Delete</a></td>
       <td><a href="/update.jsp">Update</a></td></tr>
   <%
       }
   %>
   </table>
   <%
        rs.close();
        stmt.close();
        conn.close();
   }
   catch(Exception e)
   {
        e.printStackTrace();
   }
   %>
</form>
 <div>
</body>
</html>