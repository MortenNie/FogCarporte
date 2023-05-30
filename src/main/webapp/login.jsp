<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Login
    </jsp:attribute>

    <jsp:attribute name="footer">
            Login
    </jsp:attribute>

    <jsp:body>

        <h3>You can log in here</h3>
        <div class="container py-3"> <!-- py = py stands for padding-Y(y-axis) so padding for bottom and top. -->
        <div class="row d-flex"> <!-- row & d-flex = Bootstrap classes -->
        <div class="col-5"> <!-- col, col-md, col-lg, col-xl = Bootstrap classes & "definers". md, lg, xl er for forskellige skærmstørrelser. Col gælder for alle.  -->
        <div class="card shadow" style="border-radius: 2rem;"> <!-- Card = Bootstrap class der er god til at virke som en "login form", Shadow = skygge, rem = size. 1rem = 16px -->
        <div class="card-body p-5"> <!-- p = padding, dvs mellemrum mellem kanten af Card og hvor teksten/button etc er. dvs. Ingen padding = teksten ville være helt til kanten. -->
            <strong style="font-size:24px">Login</strong> <!-- Strong = Tyk/Fed tekst -->
            <form action="login" method="post">
            <div class="form-group">
                <label for="username">Username or Email</label>
                <br/>
                <input type="text" class="form-control shadow"
                       id="username" name=username
                       placeholder="Enter username or email">
            </div>
            <br/>
            <div class="form-group">
                <label for="password">Password</label>
                <br/>
                <input type="password" class="form-control shadow" id="password" name="password" placeholder="Password">
                <small id="nopasswordshare" class="form-text text-muted">We'll never share your password with anyone.</small> <!-- Basically bare for sjov, synes det kunne være sjovt at tilføje. -->
            </div>
            <br/>
                <button type="submit" class="btn btn-primary shadow">Log in</button>
        </form>
            <br/>
            <br/>
            <p>Or if you don't have an account <br/>
                Sign up here instead:
            </p>
            <a class="btn btn-primary shadow" href="${pageContext.request.contextPath}/signup.jsp" role="button">Sign up</a>
        </div>
        </div>
        </div>
        </div>
        </div>
        <br/>
        <br/>
    </jsp:body>
</t:pagetemplate>