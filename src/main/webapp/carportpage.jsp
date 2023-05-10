<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Here you can order your custom or premade carport.
    </jsp:attribute>

  <jsp:attribute name="footer">
        Here you can order your custom or premade carport.
    </jsp:attribute>

  <jsp:body>



    <c:if test="${sessionScope.user != null}">
      <br>

        Choose either a premade 6 m x 7.8 m carport or a custom carport with your own dimensions!
      <br>
      <form method="post">

        <button formaction="premadecarport" type="submit" class="align-baseline btn btn-outline-success">Premade Carport</button>
        <button formaction="customcarport" type="submit" class="align-baseline btn btn-outline-success"> Custom Carport</button>


      </form>

    </c:if>

    <c:if test="${sessionScope.user == null}">
      <p>You are not logged in yet. You can do it here: <a
              href="login.jsp">Login</a></p>
    </c:if>

  </jsp:body>

</t:pagetemplate>