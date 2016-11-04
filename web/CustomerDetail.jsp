<%-- 
    Document   : CustomerDetail
    Created on : 28-Sep-2016, 11:44:25
    Author     : int303
--%>

<%@page import="sit.int303.practice.model.Customer"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        List<Customer> customers = Customer.findByName("b");
        Customer customer = customers.get(0);
        
        request.setAttribute("c", customer);
    %>
    <jsp:useBean id="c" scope="request" type="sit.int303.practice.model.Customer"/>
    <body>
        <h1>Customer Detail ::: </h1><hr>
        <table>
            <tr><td>Customer ID: </td>
                <td>
                    <input type="text" size="10" name="customerId" value="${c.customerId}" disabled/>
                </td>
            </tr>
            <tr><td>Name: </td><td><input type="text" name="name" value="${c.names}" size="40"/></td></tr>
            <tr><td>Address: </td><td> <textarea style="width: 400px;" rows="2"/> ${c.addressLine1} </textarea></td></tr>
            <tr><td></td><td><textarea style="width: 400px;" rows="2"/> ${c.addressLine2} </textarea></td></tr>
            <tr><td>City: </td><td><input type="text" name="city" value="${c.city}"/></td></tr>
            <tr><td>State: </td><td><input type="text" name="state" value="${c.state}" size="5"/></td></tr> 
            <tr><td>Zip: </td><td><input type="text" name="zip" value="${c.zip}" size="15"/></td></tr>
            <tr><td>Phone: </td><td><input type="text" name="phone" value="${c.phone}"/></td></tr>
            <tr><td>Fax: </td><td><input type="text" name="fax" value="${c.fax}" size="15"/></td></tr>
            <tr><td>Email Address: </td><td><input type="text" name="name" value="<%=c.getEmail()%>" size="10"/></td></tr>
            <tr><td>Discount Code: </td><td></td></tr>
            <tr><td>Credit Limit: </td><td><input type="text" name="name" value="<%=c.getCreditLimit()%>"/></td></tr>
            <tr><td></td><td align="right"><input type="button" value="Back" onclick="history.back()"/></td></tr>
        </table>
    </body>
</html>
