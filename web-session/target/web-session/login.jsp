<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <title>Index</title>
        </head>

        <body>
            <div>
                <form action="LoginServlet" method="post">
                    <label for="Name">Name</label>
                    <input type="text" name="name"><br>
                    <label for="Password">Password</label>
                    <input type="password" name="password"><br>
                    <input type="submit" value="login">
                    ${invalid}
                    ${text}
                    ${Logout}
                </form>
            </div>
        </body>

        </html>