<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Here you can order your premade or custom carport.
    </jsp:attribute>

  <jsp:attribute name="footer">
        Here you can order your custom or premade carport.
    </jsp:attribute>

  <jsp:body>



    <c:if test="${sessionScope.user != null}">
      <br/>

        Choose either a premade 6 m x 7.8 m carport or a custom carport with your own dimensions!
      <br/>
      <br/>
      <div class="container"> <!-- Container, så der ikke kommer til at være vertical scroll (just incase) -->
      <div class="row justify-content-around"> <!-- En row hvor begge columns/buttons skal være i. Justify-content-around betyder der er lige mellemrum på begge sider og imellem de to cols.-->
        <div class="col-lg-4 col-md-12 mb-4 mb-lg-4">  <!-- Størrelse+Margin på col. -->
        <form method="post">
          <button formaction="premadecarport" type="submit" class="align-baseline btn btn-outline-success d-flex flex-column justify-content-center">
            Premade Carport
        <img src="https://cdn.johannesfog.dk/product-resources/2164022-00823_FOG-CP01DUR-CARPORT.jpg"
             class="img-fluid shadow-sm rounded mb-4"
             alt="premadeImage"
             style="height: 322px; width: 100%"
        />
            <!-- img-fluid makes the image responsive within its container. It's a bootstrap class)
            Shadow-sm adds a small shadow, rounded makes the buttons/pictures rounded and not pointy. Mb is Margin-bottom.
            alt = replacement text in case the image doesn't load.
            I had to "hard code" the height of this image, for some reason it refused to match the size of the col.
            The one below did with no problem.
            -->
        </button>
        </form>
        </div>

        <div class="col-lg-4 col-md-12 mb-4 mb-lg-4">
        <form method="post">
        <button formaction="customcarport" type="submit" class="align-baseline btn btn-outline-success d-flex flex-column justify-content-center">
          Custom Carport
          <img src="https://www.neoflamedesign.com/38273/wooden-carport-with-flat-roof-7x8-habrita-17-m2.jpg"
               class="img-fluid shadow-sm rounded mb-4"
               alt="customImage"
               style="height: 100%; width: 100%"

          />
        </button>
      </form>
      </div>
      </div>
      </div>

    </c:if>

    <c:if test="${sessionScope.user == null}">
      <p>You are not logged in yet. You can do it here: <a
              href="login.jsp">Login</a></p>
    </c:if>

  </jsp:body>

</t:pagetemplate>