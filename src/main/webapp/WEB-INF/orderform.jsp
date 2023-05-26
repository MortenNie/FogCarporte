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
         Order form page
    </jsp:attribute>

    <jsp:attribute name="footer">
        Order form.
    </jsp:attribute>

    <jsp:body>

        <div class="container py-3"> <!-- py = Bootstrap class for spacing -->
        <div class="row d-flex "> <!-- row & d-flex = Bootstrap classes -->
        <div class="col-xl-5"> <!-- col, col-md(medium), col-lg(large), col-xl(xlarge) = Bootstrap classes & "definers". Uden col-xl-5 ville formene fylde hele skærmen. 1 er mindst, col-1 er mindst, col-12 er størst.-->
        <div class="card shadow" style="border-radius: 2rem;"> <!-- Card = Bootstrap class der er god til at virke som en "login form", Shadow = skygge, rem = size. 1rem = 16px -->
        <div class="card-body p-5"> <!-- p = padding, dvs mellemrum mellem kanten af Card og hvor teksten/button etc er. dvs. Ingen padding = teksten ville være helt til kanten. -->
        <strong style="font-size:24px">Order Form</strong> <!-- Tyk/Fed tekst -->
        <br/>
        <form method="post">
            <div class="form-group">
                <label for="Name">Please type your name:</label>
                <br/>
                <input type="text" class="form-control shadow" id="Name" name="Name" placeholder="Name">
            </div>
            <br/>
            <div class="form-group">
                <label for="Adress">Please type your address:</label>
                <br/>
                <input type="text" class="form-control shadow" id="Adress" name="Adress" placeholder="Address">
                </div>
            <br/>
            <br/>
            <button type="submit" formaction="finishorder" class="btn btn-primary shadow">Submit Order</button>
        </form>
        </div>
        </div>
        </div>
        </div>
        </div>
        <br/>
        <br/>


    </jsp:body>

</t:pagetemplate>
