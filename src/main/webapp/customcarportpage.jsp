<%--
  Created by IntelliJ IDEA.
  User: jakob
  Date: 5/10/2023
  Time: 11:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Here you can order a custom carport with your own dimensions!
    </jsp:attribute>

    <jsp:attribute name="footer">
            Here you can order a custom carport with your own dimensions!
    </jsp:attribute>

    <jsp:body>
        <c:if test="${sessionScope.user != null}">
            <p>Choose the height of your custom carport</p>
            <form action="/submit" method="post">
                <div class="form-group dropdownHeight">
                    <label for="dropdownHeight">Height</label>
                    <select class="form-control" name="Height" id="dropdownHeight">
                        <option value="2.1">2.1</option>
                        <option value="2.2">2.2</option>
                        <option value="2.3">2.3</option>
                        <option value="2.4">2.4</option>
                        <option value="2.5">2.5</option>
                        <option value="2.6">2.6</option>
                        <option value="2.7">2.7</option>
                        <option value="2.8">2.8</option>
                        <option value="2.9">2.9</option>
                        <option value="3.0">3.0</option>
                    </select>
                </div>
                <br>

                <p>Choose the length of your custom carport</p>
                <div class="form-group dropdownLength">
                    <label for="dropdownLength">Length</label>
                    <select class="form-control" name="Length" id="dropdownLength"> //onmousedown="if(this.options.length>10){this.size=10;}"  onchange='this.size=0;' onblur="this.size=0;">
                        <option value="3.2">3.2</option>
                        <option value="3.4">3.4</option>
                        <option value="3.6">3.6</option>
                        <option value="3.8">3.8</option>
                        <option value="4.0">4.0</option>
                        <option value="4.2">4.2</option>
                        <option value="4.4">4.4</option>
                        <option value="4.6">4.6</option>
                        <option value="4.8">4.8</option>
                        <option value="5.0">5.0</option>
                        <option value="5.2">5.2</option>
                        <option value="5.4">5.4</option>
                        <option value="5.6">5.6</option>
                        <option value="5.8">5.8</option>
                        <option value="6.0">6.0</option>
                        <option value="6.2">6.2</option>
                        <option value="6.4">6.4</option>
                        <option value="6.6">6.6</option>
                        <option value="6.8">6.8</option>
                        <option value="7.0">7.0</option>
                        <option value="7.2">7.2</option>
                        <option value="7.4">7.4</option>
                        <option value="7.6">7.6</option>
                        <option value="7.8">7.8</option>
                    </select>
                </div>
                <br>

                <p>Choose the width of your custom carport</p>
                <div class="form-group dropdownWidth">
                    <label for="dropdownWidth">Width</label>
                    <select class="form-control" name="Width" id="dropdownWidth">
                        <option value="3.0">3.0</option>
                        <option value="3.2">3.2</option>
                        <option value="3.4">3.4</option>
                        <option value="3.6">3.6</option>
                        <option value="3.8">3.8</option>
                        <option value="4.0">4.0</option>
                        <option value="4.2">4.2</option>
                        <option value="4.4">4.4</option>
                        <option value="4.6">4.6</option>
                        <option value="4.8">4.8</option>
                        <option value="5.0">5.0</option>
                        <option value="5.2">5.2</option>
                        <option value="5.4">5.4</option>
                        <option value="5.6">5.6</option>
                        <option value="5.8">5.8</option>
                        <option value="6.0">6.0</option>
                    </select>
                </div>
                <br>
                <p>Do you want your carport to have a shed?</p>
                <div class="form-group dropdownShed">
                    <label for="dropdownShed">Shed(Yes or No)</label><select class="form-control" name="Shed" id="dropdownShed">
                        <option value="Yes">Yes</option>
                        <option value="No">No</option>
                    </select>
                </div>
                <br>

                <button formaction="confirmcustomcarport" type="submit" class="btn btn-primary">Submit</button>
                <br>
                <br>

            </form>
            </div>

        </c:if>

        <c:if test="${sessionScope.user == null}">
            <p>You are not logged in yet. You can do it here: <a href="login.jsp">Login</a></p>
        </c:if>



    </jsp:body>
</t:pagetemplate>