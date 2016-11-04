<%-- 
    Document   : ProductListingDemo
    Created on : 19-Oct-2016, 11:08:58
    Author     : int303
--%>

<%@page import="java.util.List"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="sit.int303.practice.model.Product"%>
<%@page import="sit.int303.practice.model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
                    
            function changeSearchText() {
                var txt1 = document.getElementById('txt1');
                var txt2 = document.getElementById('txt2');
                var cat = document.getElementById('category');
                

                //txt2.value =  cat.options[cat.selectedIndex].value;
                var selectedValue = cat.options[cat.selectedIndex].value;
                var caption1 = document.getElementById('caption1');

                if (selectedValue === 'price') {
                    caption1.innerHTML = " Enter price range: ";
                    txt2.hidden = false;
                    txt2.type = 'number';
                    txt2.min = 0;
                    txt2.size = '10';
                    txt1.size = '10';
                    txt1.type = 'number';
                    txt1.min = 0;
                } else if (selectedValue === 'name') {
                    caption1.innerHTML = " Enter product description: ";
                    txt2.hidden = true;
                    txt1.type = 'text';
                    txt1.size = '50';
                } else {
                    caption1.innerHTML = " Enter product code: ";
                    txt2.hidden = true;
                    txt1.type = 'number';
                    txt1.min = 0;
                    txt1.size = '10';
                }
            }
        </script>
    </head>
    <body>
        <jsp:include page="/WEB-INF/jsp/Header.jsp?title=G2:Product Listing:::"/>

        <form action="SearchProduct" method="post">
            <table>
                <tr><td>Category: </td>
                    <td>
                        <select name="searchCategory" onchange="changeSearchText()" id="category">
                            <option value="id" ${param.searchCategory == "id" ? "selected":""}>Product ID</option>
                            <option value="name" ${param.searchCategory == "name" ? "selected" : ""}>Product Description</option>
                            <option value="price" ${param.searchCategory == "price" ? "selected" : ""}>Price Range</option>
                        </select>
                    </td>
                    <td id="caption1">&nbsp;</td>
                    <td><input type="text" name="searchText1" id="txt1" value="${param.searchText1}"></td>
                    <td id="caption2">&nbsp;</td>
                    <td><input type="text" name="searchText2" id="txt2" value="${param.searchText2}"></td>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td>View :
                        <select name="viewBy">
                            <option value="row" ${param.viewBy == 'row' ? 'selected':''}>List View</option>
                            <option value="column" ${param.viewBy == 'column' ? 'selected' : ''}>Gallery View</option>
                        </select>
                    </td>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td><input type="submit" value="Go!!"/></td>
                </tr>
            </table>
        </form>    
                            <c:if test="${! empty message}">
                                <table>
                                    <tr><td>${message}</td></tr>
                                </table>
                            </c:if>   
                        <form action="AddToCart" method="post">
                <table>
                    <input type="submit" value="Add to cart">
            <c:if test="${products != null}">
                
                <c:forEach items="${products}" var="p" varStatus="vs">
                    ${vs.count%3 ==1?"<tr>" : ""}
                    <td>
                        <img src="images/${p.productId}.jpg" width="150"><br>
                        ${p.productId}:${p.description}
                        ($<fmt:formatNumber value="${p.price}" pattern="#,###.00" />)
                        <input type="checkbox" name="pid" value="${p.productId}" title="Add To Cart">
                    </td>
                    ${vs.count%3 ==0?"</tr>" : ""}
                </c:forEach>
            </table>
           </form>
        </c:if>
    </body>
</html>

<%--<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body style="margin-left: 50px; width:90%">
        <jsp:include page="WEB-INF/jsp/Header.jsp?title=G2: Product Listing :::"/>
        <%
            List<Product> products = Product.findByName("");
            pageContext.setAttribute("products", products);
        %>

        <form action="SearchProduct" method="post">
            <table>
                <tr><td>Category:</td>
                    <td>
                        <select name="searchCategory" onchange="changeSearchText()" id="category">
                          
                        </select>
                </td>
            </tr>
        </table>
    </form>


    <c:if test="${products != null}" >
        <table class="table">
            <c:forEach items="${products}" var="p" varStatus="vs">
                ${vs.count%3==1?"<tr>":""}
                <td>
                    <img src="images/${p.productId}.jpg" width="200" height="150"><br>
                    ${p.productId}:${p.description} <br>
                    ( price: <fmt:formatNumber value="${p.price}" pattern="#,###.00"/> )

                </td>
                ${vs.count%3==0 ? "</tr>":""}
            </c:forEach>    
        </table>
    </c:if>    
</body>
</html>
--%>