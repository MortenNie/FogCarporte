<%--
  Created by IntelliJ IDEA.
  User: sonig
  Date: 29-05-2023
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>
<<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Confirmation page
    </jsp:attribute>

    <jsp:attribute name="footer">
        Confirmation page
    </jsp:attribute>

    <jsp:body>

        Your order id for reference is ${requestScope.orderId}. </br>
        You will hear from us very soon.




    </jsp:body>

</t:pagetemplate>

