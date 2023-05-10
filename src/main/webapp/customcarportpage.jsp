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
                    <select class="form-control" name="Height" id="dropdownHeight">
                        <option selected disabled value="">Height</option>
                        <option value="option1">2.1</option>
                        <option value="option2">2.2</option>
                        <option value="option3">2.3</option>
                        <option value="option3">2.4</option>
                        <option value="option3">2.5</option>
                        <option value="option3">2.6</option>
                        <option value="option3">2.7</option>
                        <option value="option3">2.8</option>
                        <option value="option3">2.9</option>
                        <option value="option3">3.0</option>
                    </select>
                </div>
                <br>
                <p>Choose the length of your custom carport</p>
                <div class="form-group">
                    <select class="form-control" name="Length" id="dropdownLength">
                        <option selected disabled value="">Length</option>
                        <option value="option1">3.2</option>
                        <option value="option2">3.4</option>
                        <option value="option3">3.6</option>
                        <option value="option3">3.8</option>
                        <option value="option3">4.0</option>
                        <option value="option3">4.2</option>
                        <option value="option3">4.4</option>
                        <option value="option3">4.6</option>
                        <option value="option3">4.8</option>
                        <option value="option3">5.0</option>
                        <option value="option3">5.2</option>
                        <option value="option3">5.4</option>
                        <option value="option3">5.6</option>
                        <option value="option3">5.8</option>
                        <option value="option3">6.0</option>
                        <option value="option3">6.2</option>
                        <option value="option3">6.4</option>
                        <option value="option3">6.6</option>
                        <option value="option3">6.8</option>
                        <option value="option3">7.0</option>
                        <option value="option3">7.2</option>
                        <option value="option3">7.4</option>
                        <option value="option3">7.6</option>
                        <option value="option3">7.8</option>
                    </select>
                </div>
                <br>
                <p>Choose the width of your custom carport</p>
                <div class="form-group">
                    <select class="form-control" name="Width" id="dropdownWidth">
                        <option selected disabled value="">Width</option>
                        <option value="option1">3.0</option>
                        <option value="option2">3.2</option>
                        <option value="option3">3.4</option>
                        <option value="option3">3.6</option>
                        <option value="option3">3.8</option>
                        <option value="option3">4.0</option>
                        <option value="option3">4.2</option>
                        <option value="option3">4.4</option>
                        <option value="option3">4.6</option>
                        <option value="option3">4.8</option>
                        <option value="option3">5.0</option>
                        <option value="option3">5.2</option>
                        <option value="option3">5.4</option>
                        <option value="option3">5.6</option>
                        <option value="option3">5.8</option>
                        <option value="option3">6.0</option>
                    </select>
                </div>
                <br>
                <p>Do you want your carport to have a shed?</p>
                <div class="form-group">
                    <select class="form-control" name="Shed" id="dropdownShed">
                        <option selected disabled value="">Shed?</option>
                        <option value="option1">Yes</option>
                        <option value="option2">No</option>
                    </select>
                </div>
                <br>
                <button type="submit" class="btn btn-primary">Submit</button>

            </form>
            </div>

        </c:if>

        <c:if test="${sessionScope.user == null}">
            <p>You are not logged in yet. You can do it here: <a href="login.jsp">Login</a></p>
        </c:if>



    </jsp:body>
</t:pagetemplate>