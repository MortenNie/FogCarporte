<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>

<!DOCTYPE html>
<html lang="da">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><jsp:invoke fragment="header"/></title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>

<body class="d-flex flex-column">
<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container menu">
            <a class="navbar-brand" href="index.jsp">
                <img class="h-100" src="https://cms.johannesfog.dk/media/cdcndnkg/logo.svg?ud=sP1o1-ho2gg" alt="logo"/>
            </a>

            <button class="navbar-toggler navbar-toggler-icon" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
                    aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">

            </button>

            <div class="collapse navbar-collapse w-100 justify-content-between" id="navbarNavAltMarkup">
                <div class="navbar-nav flex-grow-1">
                    <a class="nav-item nav-link" href="${pageContext.request.contextPath}/welcome.jsp">Home</a>
                    <a class="nav-item nav-link" href="${pageContext.request.contextPath}/carportpage.jsp">Order Carport</a>
                    <a class="nav-item nav-link" href="${pageContext.request.contextPath}/imagewall.jsp">Image wall of Carports</a>
                </div>

                <div class="d-flex align-items-center nav-item--login">
                    <a class="nav-item nav-link  d-flex flex-column align-items-center text-secondary" href="${pageContext.request.contextPath}/shoppingcart.jsp">
                        &#128722; <span>Shopping Cart</span></a>
                    <c:if test="${sessionScope.user == null }">
                        <a class="nav-item nav-link d-flex flex-column align-items-center text-secondary" href="${pageContext.request.contextPath}/login.jsp">&#128274;<span>Login</span></a>
                    </c:if>
                    <c:if test="${sessionScope.user != null }">
                        <a class="nav-item nav-link d-flex flex-column align-items-center text-secondary" href="${pageContext.request.contextPath}/logout">&#128275;<span>Log out</span></a>
                    </c:if>
                </div>
            </div>
        </div>
    </nav>
</header>
<div class="row col-3">
<div class="d-flex justify-content-center">
    <c:if test="${sessionScope.user != null}">
        <p>${sessionScope.user.username}</p>
    </c:if>
</div>
</div>

<main id="body" class="container flex-grow-1 mt-4" style="min-height: 400px;">
    <h1><jsp:invoke fragment="header"/></h1>
    <jsp:doBody/>
</main>

<!-- Footer -->
<footer>
    <div class="container mt-3">
        <hr/>
        <div class="row mt-4">
            <div class="col text-center">
                Firskovvej 20<br/>
                2800 Lyngby
            </div>
            <div class="col text-center">
                All rights reserved<br/>
                <p>&copy; Fog Inc. </p>
            </div>
            <div class="col text-center">
                Johannes Fog A/S<br/>
                CVR-nr. 16314439
            </div>
        </div>
    </div>
</footer>

<!-- Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

</body>
</html>