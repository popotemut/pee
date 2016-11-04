<%-- 
    Document   : ListCustomer
    Created on : 07-Sep-2016, 11:23:49
    Author     : int303
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="sit.int303.practice.model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <title>Customer Listing</title>
    </head>
    <body style="margin-right: 50px;width: 90%">
        <jsp:include page="">
        <h1>Customer Listing ::</h1>
        <form action="SearchCustomer" method='post'>
            <table class="table" style="background-color: burlywood;margin-left: 50px">
                <tr>
                    <td>Enter Customer name/id : </td>
                    <td><input type="text" name="searhParam"
                               value='${param.searchParam}'/></td>
                    <td><input type="submit"/></td>
                </tr>
            </table>
        </form>        
        <table class="table" style="margin-left: 50px">
            <tr style="background-color: antiquewhite">
                <td>Customer ID</td>
                <td>Name</td>
                <td>City</td>
                <td>State</td>
                <td>Phone</td>
                <td>Email</td>           
            </tr>

            <%--       <jsp:useBean id="customers" type="java.util.List<Customer>" class="java.util.ArrayList" scope="session"/>
                       //List<Customer> customers = (List) request.getAttribute("customers");
   //                    if(customers != null && customers.size()>0){
   //                        int count = 1;
   //                    for (Customer c : customers) {
   //                    
            --%>
            <c:forEach items="${customers}" var="c" varStatus="vs">
                <tr style='background-color:${vs.count%2 == 0 ? "white" : "azure"}'>

                    <td style="text-align: center">${c.CustomerId}</td>
                    <td><a href="GetCustomer?id=${c.CustomerId}">${c.Name}"</a></td>
                    <td>${c.City()}</td>
                    <td>${c.State()}</td>
                    <td>${c.Phone}</td>
                    <td>${c.Email}</td>
                </tr>

            </c:forEach>

            <tr><td style="color: red">${message}</td></tr>

        </table>
    </div>
    <hr>
    <%--<%
    List<Customer> customers = Customer.findByName("");
    for(Customer c : customers){
        %>
        Customer ID: <%= c.getCustomerId()%> <br>
        Name: <%= c.getName()%> <br>
        City: <%= c.getCity()%> <br>
        Email: <%= c.getEmail()%> <br>
        <hr>
<%}%>--%>
</body>
</html>
