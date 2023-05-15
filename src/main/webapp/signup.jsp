<%--
  Created by IntelliJ IDEA.
  User: jakob
  Date: 5/10/2023
  Time: 10:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Create your account
    </jsp:attribute>

    <jsp:attribute name="footer">

    </jsp:attribute>

    <jsp:body>
        <h3>You can sign up here</h3>
        <div class="container py-3 h-100"> <!-- py = Bootstrap class for spacing -->
            <div class="row d-flex h-100"> <!-- row & d-flex = Bootstrap classes -->
                <div class="col-xl-5"> <!-- col, col-md(medium), col-lg(large), col-xl(xlarge) = Bootstrap classes & "definers". Uden col-xl-5 ville formene fylde hele skærmen. 1 er mindst, col-1 er mindst, col-12 er størst.-->
                    <div class="card shadow" style="border-radius: 2rem;"> <!-- Card = Bootstrap class der er god til at virke som en "login form", Shadow = skygge, rem = size. 1rem = 16px -->
                        <div class="card-body p-5"> <!-- p = padding, dvs mellemrum mellem kanten af Card og hvor teksten/button etc er. dvs. Ingen padding = teksten ville være helt til kanten. -->
                            <strong style="font-size:24px">Sign up</strong>
                            <form action="signup" method="post">
                                <div class="form-group">

                                    <label for="username">Username or Email</label>
                                    <br/>
                                    <input type="text" class="form-control shadow" id="username" name="username" placeholder=" Enter username or email">
                                </div>
                                <br/>
                                <div class="form-group">
                                    <label for="password">Password</label>
                                    <br/>
                                    <input type="password" class="form-control shadow" id="password" name="password" placeholder="Password">
                                    <small id="nopasswordshare" class="form-text text-muted">We'll never share your password with anyone.</small> <!-- Basically bare for sjov, synes det kunne være sjovt at tilføje. -->
                                </div>
                                <br/>
                                <button type="submit" class="btn btn-primary shadow">Sign up</button>
                            </form>
                            <br/>
                            <br/>
                            <p>Or if you already have an account <br/>
                                Log in here instead:
                            </p>
                            <a class="btn btn-primary shadow" href="${pageContext.request.contextPath}/login.jsp" role="button">Login</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <br/>
        <br/>

    </jsp:body>

</t:pagetemplate>

</body>
</html>
