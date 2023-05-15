<%--
  Created by IntelliJ IDEA.
  User: freed
  Date: 11/05/2023
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Order form
    </jsp:attribute>

    <jsp:attribute name="footer">
        Order form.
    </jsp:attribute>

    <jsp:body>
        <form  method="post">
            Name: <input type="text" class="form-control" placeholder="Name" aria-label="Name" name="Name"/><br/>
            <br/>
            Adress: <input type="text" class="form-control" placeholder="Adress" aria-label="Adress" name="Adress"><br/>
            <br/>

            <button type="submit"  formaction="finishorder" class="btn btn-primary btn-lg">Get offer </button>
        </form>

    </jsp:body>

</t:pagetemplate>
