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
        <p>We've got many years of experience and an overall 5/5 star rating.</p>
        <p>&#9733;&#9733;&#9733;&#9733;&#9733;</p>


        <br/>
        <br/>


        <c:if test="${sessionScope.user != null}">
            <p>You are logged in with the role of "${sessionScope.user.role}".</p>

            <form method="post">

                <button formaction="ordercupcake" type="submit" class="align-baseline shadow-sm btn btn-outline-success">Order cupcake</button>
                <button formaction="orderhistory" type="submit" class="align-baseline shadow-sm btn btn-outline-success"> See all orders</button>


            </form>
        </c:if>

        <c:if test="${sessionScope.user == null}">
            <p>You are not logged in yet. You can do it here: <a
                    href="login.jsp">Login</a></p>

            <p>You can sign up here if you're not already signed up: <a href ="signup.jsp">Sign up</a></p>
        </c:if>

    </jsp:body>

</t:pagetemplate>