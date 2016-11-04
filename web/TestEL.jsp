<%-- 
    Document   : TestEL
    Created on : 05-Oct-2016, 10:45:15
    Author     : int303
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        Map<String, String> subjects = new HashMap();
        subjects.put("java", "Java Programming");
        subjects.put("db", "Database Management System");
        subjects.put("network", "Computer Network");
        subjects.put("sec", "Computer Security");
        subjects.put("service", "Computer Service");
        pageContext.setAttribute("subjects", subjects);
    %>
    <body>
        <h1>Display parameter</h1><hr>
        Program ID:${param.programId}<br>
        Student ID:${param.sid}<br>
        Student Name:${param.sname}<br>
        Favorite Subjects:<br>
        ${subjects[paramValues.subjects[0]]==null?"":"&nbsp;&nbsp;&nbsp;-"}
        ${subjects[paramValues.subjects[0]]==null?"":subjects[paramValues.subjects[0]]}
        ${subjects[paramValues.subjects[0]]==null?"":"<br>"}

        ${subjects[paramValues.subjects[1]]==null?"":"&nbsp;&nbsp;&nbsp;-"}
        ${subjects[paramValues.subjects[1]]==null?"":subjects[paramValues.subjects[1]]}
        ${subjects[paramValues.subjects[1]]==null?"":"<br>"}

        ${subjects[paramValues.subjects[2]]==null?"":"&nbsp;&nbsp;&nbsp;-"}
        ${subjects[paramValues.subjects[2]]==null?"":subjects[paramValues.subjects[2]]}
        ${subjects[paramValues.subjects[2]]==null?"":"<br>"}

        ${subjects[paramValues.subjects[3]]==null?"":"&nbsp;&nbsp;&nbsp;-"}
        ${subjects[paramValues.subjects[3]]==null?"":subjects[paramValues.subjects[3]]}
        ${subjects[paramValues.subjects[3]]==null?"":"<br>"}

        ${subjects[paramValues.subjects[4]]==null?"":"&nbsp;&nbsp;&nbsp;-"}
        ${subjects[paramValues.subjects[4]]==null?"":subjects[paramValues.subjects[4]]}
        ${subjects[paramValues.subjects[4]]==null?"":"<br>"}
        
        ${subjects[paramValues.subjects[5]]==null?"":"&nbsp;&nbsp;&nbsp;-"}
        ${subjects[paramValues.subjects[5]]==null?"":subjects[paramValues.subjects[5]]}
        ${subjects[paramValues.subjects[5]]==null?"":"<br>"}
        
        JSESSION ID:${cookie.JSESSIONID.value}<br>
        Browser:${header["User-Agent"]}
    </body>
</html>
