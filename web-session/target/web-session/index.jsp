<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <html>

        <head>
            <title>Index</title>
        </head>

        <body>
            <h1>Login App using HttpSession</h1>
            <a href="login.jsp">Login</a>|
            <a href="LogoutServlet">Logout</a>|
            <a href="ProfileServlet">Profile</a>
            ${invalid}
            ${text}
            ${Logout}
        </body>

        </html>