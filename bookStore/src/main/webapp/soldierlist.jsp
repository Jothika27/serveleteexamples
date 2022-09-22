<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <html>

        <head>
            <title>Soldiers Details Management</title>
        </head>

        <body style="color: black;">
            <center>
                <h1>Solierss Management</h1>
                <h2>
                    <a href="/new">Add New Soldier</a>
                    &nbsp;&nbsp;&nbsp;
                    <a href="/list">List All Soldiers</a>

                </h2>
            </center>
            <div align="center">
                <c:if test="${soldier != null}">
                    <form action="update" method="post">
                </c:if>
                <c:if test="${soldier == null}">
                    <form action="insert" method="post">
                </c:if>
                <table border="1" cellpadding="5">
                    <caption>
                        <h2>
                            <c:if test="${soldier != null}">
                                Edit Book
                            </c:if>
                            <c:if test="${soldier == null}">
                                Add New Book
                            </c:if>
                        </h2>
                    </caption>
                    <c:if test="${soldier != null}">
                        <input type="hidden" name="soldier_id" value="<c:out value='${soldier.soldier_id}' />" />
                    </c:if>
                    <tr>
                        <th>Soldier Id: </th>
                        <td>
                            <input type="text" name="soldier_id" size="45"
                                value="<c:out value='${soldier.soldier_id}' />" />
                        </td>
                    </tr>
                    <tr>
                        <th>Name: </th>
                        <td>
                            <input type="text" name="first_name" size="45"
                                value="<c:out value='${soldier.first_name}' />" />
                        </td>
                    </tr>
                    <tr>
                        <th>DOB: </th>
                        <td>
                            <input type="text" name="dob" size="45" value="<c:out value='${soldier.dob}' />" />
                        </td>
                    </tr>
                    <tr>
                        <th>Gender: </th>
                        <td>
                            <input type="text" name="gender" size="5" value="<c:out value='${soldier.gender}' />" />
                        </td>
                    </tr>
                    <tr>
                        <th>Join Date: </th>
                        <td>
                            <input type="text" name="join_date" size="45"
                                value="<c:out value='${soldier.join_date}' />" />
                        </td>
                    </tr>
                    <tr>
                        <th>General Id: </th>
                        <td>
                            <input type="text" name="general_id" size="45"
                                value="<c:out value='${soldier.general_id}' />" />
                        </td>
                    </tr>
                    <tr>
                        <th>Event Id: </th>
                        <td>
                            <input type="text" name="event_id" size="5" value="<c:out value='${soldier.event_id}' />" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="Save" />
                        </td>
                    </tr>
                </table>
                </form>
            </div>
        </body>

        </html>