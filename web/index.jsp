<%-- 
    Document   : index.jsp
    Created on : 12-Oct-2016, 11:22:16
    Author     : int303
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>G2 Home Page</title>
    </head>
    <body style="margin-left: 50px; width: 95%">
        <jsp:include page="/WEB-INF/jsp/Header.jsp?title=G2:Homepage:::"/>
                    <c:set var="loginOrLogout" value="${sessionScope.user==null?'Login':'Logout'}"/>
                    <p>Main Menu::</p>
                    <hr>
                    <p><a href="Page1.jsp">Page #01</a></p>
                    <p><a href="Page2.jsp">Page #02</a></p>
                    <p><a href="Page3.jsp">Page #03</a></p>
                    <p><a href="Page4.jsp">Page #04</a></p>
                    <hr>
                    <p><a href="SearchCustomer">Search Customer</a></p>
                    <hr>
                    <p><a href="SearchProduct">Product</p>
                    <p><a href="${loginOrLogout}.jsp">${loginOrLogout}</a></p>
    </body>
</html>



<%-- 
    Document   : index
    Created on : 12-Oct-2016, 11:26:32
    Author     : int303

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>G2 Home page</title>
    </head>
    <body style="margin-left: 50px;width: 90%">
        <jsp:include page="/WEB-INF/jsp/Header.jsp?title=G1:H o m e p a g e:::"/>
        <c:set var="loginOrlogout" value="${sessionScope.user==null?'Login':'Logout'}"/>
        <table style="background-color: coral">
            <tr>
                <td style="width: 10%"><a href="index.jsp"><img src="logo.png" width="120px"></a></td>
                <td style="width: 1%"></td>
                <td style="width: 70%;font-size: x-large;color: bisque">G1: H o m e p a g e :::</td>
                <td style="width: 10%">
                    <img src="user.pug" width="80px"><br>
                    Hello<c:out value="${user.name}" default="Guest"/>
                    </td>
            </tr>
        </table>
  
    </body>
</html>
--%>