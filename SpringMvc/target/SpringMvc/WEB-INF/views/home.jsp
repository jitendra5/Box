<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SpringMVC+ReactJS</title>
    </head>
    <body>
        <div align="center">
            <h1>Boxes</h1>
            <h3><a href="/addbox">New Box</a></h3>
            <table border="1">
                <th>No.</th>
                <th>Name</th>
                <th>Weight</th>
                <th>Color</th>
                <th>Country</th>
                <th>Delete Box</th>
                 
                <c:forEach var="box" items="${listBoxes}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${box.name}</td>
                    <td>${box.weight}</td>
                    <td>${box.color}</td>
                    <td>${box.country}</td>
                    <td>
                        <a href="/deletebox?id=${box.id}">Delete</a>
                    </td>
                             
                </tr>
                </c:forEach>             
            </table>
        </div>
    </body>
</html>
