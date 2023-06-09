<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Welcome to the logged in area
    </jsp:attribute>

    <jsp:attribute name="footer">
        Logged in area
    </jsp:attribute>

    <jsp:body>


        <c:if test="${sessionScope.user != null}">
            <p>You should be logged in now:</p>
            <p>You are logged in with the role of "${sessionScope.user.role}".</p>
            <form method="post">

                <button formaction="ordercarport" type="submit" class="align-baseline btn btn-outline-success shadow">Order a carport</button>
                <button formaction="orderhistory" type="submit" class="align-baseline btn btn-outline-success shadow">See all orders</button>
            <c:if test="${sessionScope.user.role == 'admin'}">
                <button formaction="addnewmaterials" type="submit" class="align-baseline btn btn-outline-success shadow">Add new materials to DB</button>
                <button formaction="deleteoldmaterials" type="submit" class="align-baseline btn btn-outline-success shadow">Delete old materials from DB</button>

            </c:if>
            </form>

        </c:if>

        <c:if test="${sessionScope.user == null}">
            <p>You are not logged in yet. You can do it here: <a
                    href="login.jsp">Login</a></p>
            <p>Or if you don't have an account, sign up here: <a href="signup.jsp">Sign up</a></p>
        </c:if>

    </jsp:body>

</t:pagetemplate>