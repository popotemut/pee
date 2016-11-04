<%-- 
    Document   : Login
    Created on : 13-Oct-2016, 16:05:13
    Author     : int303
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body style="margin-left: 50px;width: 90%">
        <jsp:include page="/WEB-INF/jsp/Header.jsp?title=G1:  Authentication :::"/>
        <div style="margin-top: 50px;width: 100%;align-items: center">
        <div style="width:400px">
            <form action="Login">
                <div class="form-group">
                    <label for="exampleInputEmail1">User Name</label>
                    <input type="text" name="userName" class="form-control" placeholder="User name">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Password</label>
                    <input type="password" name="password" class="form-control" placeholder="Password">
                </div>
                <button type="submit" class="btn btn-default">Login</button>
            </form>    
            <div><h3 style="color:red">${message}</h3></div>
        </div>
        </div>
    </body>
</html>
