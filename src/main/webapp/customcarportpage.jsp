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
                <div class="form-group">
                    <label for="dropdownHeight">Height</label>
                    <select class="form-control" name="Height" id="dropdownHeight">
                        <option value="2.1">2.1</option>
                        <option value="2.2">2.2</option>
                        <option value="option3">2.3</option>
                        <option value="option4">2.4</option>
                        <option value="option5">2.5</option>
                        <option value="option6">2.6</option>
                        <option value="option7">2.7</option>
                        <option value="option8">2.8</option>
                        <option value="option9">2.9</option>
                        <option value="option10">3.0</option>
                    </select>
                </div>
                <br>

                <p>Choose the length of your custom carport</p>
                <div class="form-group">
                    <label for="dropdownLength">Length</label>
                    <select class="form-control" name="Length" id="dropdownLength">
                        <option value="3.2">3.2</option>
                        <option value="option2">3.4</option>
                        <option value="option3">3.6</option>
                        <option value="option4">3.8</option>
                        <option value="option5">4.0</option>
                        <option value="option6">4.2</option>
                        <option value="option7">4.4</option>
                        <option value="option8">4.6</option>
                        <option value="option9">4.8</option>
                        <option value="option10">5.0</option>
                        <option value="option11">5.2</option>
                        <option value="option12">5.4</option>
                        <option value="option13">5.6</option>
                        <option value="option14">5.8</option>
                        <option value="option15">6.0</option>
                        <option value="option16">6.2</option>
                        <option value="option17">6.4</option>
                        <option value="option18">6.6</option>
                        <option value="option19">6.8</option>
                        <option value="option20">7.0</option>
                        <option value="option21">7.2</option>
                        <option value="option22">7.4</option>
                        <option value="option23">7.6</option>
                        <option value="option24">7.8</option>
                    </select>
                </div>
                <br>

                <p>Choose the width of your custom carport</p>
                <div class="form-group">
                    <label for="dropdownWidth">Width</label>
                    <select class="form-control" name="Width" id="dropdownWidth">
                        <option value="3.0">3.0</option>
                        <option value="option2">3.2</option>
                        <option value="option3">3.4</option>
                        <option value="option4">3.6</option>
                        <option value="option5">3.8</option>
                        <option value="option6">4.0</option>
                        <option value="option7">4.2</option>
                        <option value="option8">4.4</option>
                        <option value="option9">4.6</option>
                        <option value="option10">4.8</option>
                        <option value="option11">5.0</option>
                        <option value="option12">5.2</option>
                        <option value="option13">5.4</option>
                        <option value="option14">5.6</option>
                        <option value="option15">5.8</option>
                        <option value="option16">6.0</option>
                    </select>
                </div>
                <br>
                <p>Do you want your carport to have a shed?</p>
                <div class="form-group">
                    <label for="dropdownShed">Shed(Yes or No)</label><select class="form-control" name="Shed" id="dropdownShed">
                        <option value="Yes">Yes</option>
                        <option value="No">No</option>
                    </select>
                </div>
                <br>

                <button formaction="customcarport" type="submit" class="btn btn-primary">Submit</button>
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