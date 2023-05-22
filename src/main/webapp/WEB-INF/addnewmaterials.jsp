<%--
  Created by IntelliJ IDEA.
  User: sonig
  Date: 20-05-2023
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Add new material.
    </jsp:attribute>

    <jsp:attribute name="footer">
        Add new material page.
    </jsp:attribute>

    <jsp:body>

        <form method="post" action="addnewmaterialstwo">
            <label for name="materialtype"> Material type:  </label>
            <input type="text" id="materialtype"  name="materialtype"/></br>

            <label for name="name"> Material name: </label>
            <input type="text" id="name" name="name" /> </br>

            <label for name="length"> Material length [m]: </label>
            <input type="text" id="length" name="length" /> </br>

            <label for name="price"> Material price pr. [m]: </label>
            <input type="text" id="price" name="price" /> </br>

            <input type="submit"/>



        </form>



    </jsp:body>

</t:pagetemplate>
