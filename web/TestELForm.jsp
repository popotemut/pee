<%-- 
    Document   : TestELForm
    Created on : 05-Oct-2016, 10:45:46
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
        <h1>Test EL Form ::</h1>
        <form action="TestEL.jsp?programId=P0125779" method="post">
            <table>
                <tr>
                    <td>Student ID:</td><td><input type="text" name="sid"/></td> 
                </tr>
                <tr>
                    <td>Student Name:</td><td><input type="text" name="sname"/></td>
                </tr>
                <tr>
                    <td>Favorite Subject:</td>
                    <td>
                        <input type="checkbox" name="subjects" value="java"/>Java Programming <br>
                        <input type="checkbox" name="subjects" value="db"/>Database Management System<br>
                        <input type="checkbox" name="subjects" value="network"/>Computer Network<br>
                        <input type="checkbox" name="subjects" value="sec"/>Computer Security<br>
                        <input type="checkbox" name="subjects" value="service"/>Computer Service<br>
                    </td>
                </tr>
                <tr><td></td><td style="text-align: center"><input type="submit"/></td></tr>
            </table>    
        </form>
    </body>
</html>
