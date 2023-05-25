<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Welcome to the frontpage
    </jsp:attribute>

    <jsp:attribute name="footer">
        Welcome to Fog's Carports
    </jsp:attribute>

    <jsp:body>

        <p>Welcome to Fog's Carports!</p>
        <p>This is the best place in Denmark to order professional Carports.</p>
        <p>We've got many years of experience and an overall 5/5 &#11088; rating.</p>
        <p>&#11088;&#11088;&#11088;&#11088;&#11088;</p>


        <br/>
        <br/>


        <c:if test="${sessionScope.user != null}">
            <p>You are logged in with the role of "${sessionScope.user.role}".</p>

        </c:if>

        <c:if test="${sessionScope.user == null}">
            <p>You are not logged in yet. You can do it here: <a
                    href="login.jsp">Login</a></p>

            <p>You can sign up here if you're not already signed up: <a href ="signup.jsp">Sign up</a></p>
        </c:if>

    </jsp:body>

</t:pagetemplate>