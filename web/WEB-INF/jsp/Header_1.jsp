<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table style="background-color: coral">
    <tr>
        <td style="width: 10%"><a href="index.jsp"><img src="logo.png" width="120px"></a></td>
        <td style="width: 1%"></td>
        <td style="width: 70%; font-size: x-large; color: bisque">${param.title}</td>
        <td style="width: 10%"><img src="user.png" width="80px"><br> Hello <c:out value="${user.name}" default="Guest"/></td>            
</tr>
</table>