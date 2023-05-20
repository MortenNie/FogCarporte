<%--
  Created by IntelliJ IDEA.
  User: sonig
  Date: 20-05-2023
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Update to custom price
    </jsp:attribute>

    <jsp:attribute name="footer">
        Update balance page
    </jsp:attribute>

    <jsp:body>

        <form method="post" action="customprice">

            <label for name="price"> custom price: </label>
            <input type="text" id="price" name="price" value="price" /> </br>
            <input type="submit" value="customprice"/>



        </form>



    </jsp:body>

</t:pagetemplate>
