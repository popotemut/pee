<%-- 
    Document   : ListPokemon
    Created on : 31-Aug-2016, 10:46:47
    Author     : int303
--%>

<%@page import="java.io.PrintWriter"%>
<%@page import="sit.int303.practice.model.Pokemon"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Pokemon::</title>
    </head>
    <body>
        <jsp:include page="/includeFiles/pageTop.html"/>
        <%
            String searchParam = request.getParameter("searchParam");
            List<Pokemon> pokemons = (List) request.getAttribute("pks");
            if (pokemons != null) {
                int col = 1;
        %>
        <table width=90%>
            <%
                for (Pokemon p : pokemons) {
                    if (col % 5 == 1) {
                        out.println("<tr>");
                    }
            %>
            <td align='center'><br><img src='go/<%= p.getName() %>.png' height=80>
                <br><br>#<%=(p.getId() < 10 ? "00" : (p.getId() < 100 ? "0" : "")) + p.getId() + " " + p.getName()%>
                <br></td>
                <%
                        if (col % 5 == 0) {
                            out.println("<tr>");
                        }
                        col++;
                    }
                    if ((col - 1) % 5 != 0) {
                        out.println("<tr>");
                    }
                %>
        </table><br><p><hr>
        <%} else {%>
        <h3 style='color:red'><%=searchParam %>%DOES NOT EXIST !!! ... Try Again</h3>
        <%}%>
        

    </body>
</html>
