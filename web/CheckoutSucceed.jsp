<%-- 
    Document   : CheckoutSucceed
    Created on : 27-Oct-2016, 16:26:17
    Author     : int303
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <title>Checkout</title>
    </head>
    <body>
        <jsp:include page="WEB-INF/jsp/Header.jsp?title=G1: Checkout Completed :::"/>
        <h1 style='margin-left: 100px'> Your  order has been completed successfully </h1><br><br>
        <h3 style='margin-left: 100px'> Thank you ...
            <a href='ProductListing.jsp'><input style='font-size: small' type='button' value='Continue Shopping'/></a></h3>
    </body>
</html>
