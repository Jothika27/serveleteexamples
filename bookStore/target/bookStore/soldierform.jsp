<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <html>

        <head>
            <title>Soldiers Detail</title>
        </head>

        <body style="color: black;">
            <center>
                <h1>Soldiers Management</h1>
                <h2>
                    <a href="/new">Add New Soldier</a>
                    &nbsp;&nbsp;&nbsp;
                    <a href="/list">List All Soldiers</a>

                </h2>
            </center>
            <div align="center">
                <table border="1" cellpadding="5">
                    <caption>
                        <h2>List of Soldiers</h2>
                    </caption>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>DoB</th>
                        <th>Gender</th>
                        <th>Join Date</th>
                        <th>General Id</th>
                        <th>Event ID</th>
                    </tr>
                    <c:forEach var="soldier" items="${soldier}">
                        <tr>
                            <td>
                                <c:out value="${soldier.soldier_id}" />
                            </td>
                            <td>
                                <c:out value="${soldier.first_name}" />
                            </td>
                            <td>
                                <c:out value="${soldier.dob}" />
                            </td>
                            <td>
                                <c:out value="${soldier.gender}" />
                            </td>
                            <td>
                                <c:out value="${soldier.join_date}" />
                            </td>
                            <td>
                                <c:out value="${soldier.general_id}" />
                            </td>
                            <td>
                                <c:out value="${soldier.event_id}" />
                            </td>
                            <td>
                                <a href="/edit?soldier_id=<c:out value='${soldier.soldier_id}' />">Edit</a>
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <a href="/delete?soldier_id=<c:out value='${soldier.soldier_id}' />">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </body>

        </html>