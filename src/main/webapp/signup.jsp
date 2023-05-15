<%--
  Created by IntelliJ IDEA.
  User: jakob
  Date: 5/10/2023
  Time: 10:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Sign up
    </jsp:attribute>

    <jsp:attribute name="footer">
        Sign up page.
    </jsp:attribute>

    <jsp:body>
        <form action="signup" method="post">
            Username/Email: <input type="text" name="username"/><br/>
            <br/>
            Password: <input type="password" name="password"><br/>
            <br/>

            <button class="btn btn-warning shadow box-shadow--4dp" type="submit">Sign up</button>
        </form>

    </jsp:body>

</t:pagetemplate>

</body>
</html>
