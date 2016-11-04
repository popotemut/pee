<%-- 
    Document   : Header
    Created on : 12-Oct-2016, 11:50:50
    Author     : int303
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <table style="background-color: coral">
            <tr>
                <td style="width: 10%"><a href="index.jsp"><img src="logo.png" width="120px"></td>
                        <td style="width: 1%"></td>
                        <td style="width: 70%;font-size: x-large;color: bisque">${param.title}</td>
                        <td style="width: 10%">
                            <a href="user.png" width="80px"</a><br>
                            <img src="user.pug" width="80px"><br>
                            Hello<c:out value="${user.name}" default="Guest"/>
                        </td>
            </tr>
        </table>
    </body>
</html>
