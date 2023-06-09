<%--
  Created by IntelliJ IDEA.
  User: sonig
  Date: 11-05-2023
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Welcome to the Custom carport page.
    </jsp:attribute>

    <jsp:attribute name="footer">
        Welcome to the Custom carport page.
    </jsp:attribute>

    <jsp:body>



        <c:if test="${sessionScope.user != null}">
            <p> list of materials: </p>
            <form method="post">
            <table class="table table-striped mt-4 custom-table">


                <tr>
                    <th>Spaer id:</th>
                    <th>Spaer name:</th>
                    <th>Spaer price pr. meter:</th>
                    <th>Spaer length [m]:</th>
                    <th>Spaer quantity: </th>


                </tr>

                <tr>
                    <td> ${requestScope.spaer.spaerId}</td>
                    <td> ${requestScope.spaer.spaerName} </td>
                    <td> ${requestScope.spaer.price} </td>
                    <td> ${requestScope.spaer.length} </td>
                    <td> ${requestScope.spaer.quantity} </td>

                </tr>

            </table>
            <table class="table table-striped mt-4 custom-table">


                <tr>
                    <th>Stolpe id:</th>
                    <th>Stolpe name:</th>
                    <th>Stolpe price pr. meter:</th>
                    <th>Stolpe length [m]:</th>
                    <th>Stolpe quantity: </th>


                </tr>

                <tr>
                    <td> ${requestScope.stolpe.stolpeId}</td>
                    <td> ${requestScope.stolpe.stolpeName} </td>
                    <td> ${requestScope.stolpe.price} </td>
                    <td> ${requestScope.stolpe.length} </td>
                    <td> ${requestScope.stolpe.quantity} </td>

                </tr>

            </table>

            <table class="table table-striped mt-4 custom-table">


                <tr>
                    <th>Rem id:</th>
                    <th>Rem name:</th>
                    <th>Rem price pr. meter:</th>
                    <th>Rem length [m]:</th>
                    <th>Rem quantity: </th>


                </tr>

                <tr>
                    <td> ${requestScope.rem.remId}</td>
                    <td> ${requestScope.rem.remName} </td>
                    <td> ${requestScope.rem.price} </td>
                    <td> ${requestScope.rem.length} </td>
                    <td> ${requestScope.rem.quantity} </td>

                </tr>

            </table>


            <table class="table table-striped mt-4 custom-table">


                <tr>
                    <th>Tag id:</th>
                    <th>Tag name:</th>
                    <th>Tag price pr. meter:</th>
                    <th>Tag length [m]:</th>
                    <th>Tag quantity: </th>


                </tr>

                <tr>
                    <td> ${requestScope.tag.tagId}</td>
                    <td> ${requestScope.tag.tagName} </td>
                    <td> ${requestScope.tag.price} </td>
                    <td> ${requestScope.tag.length} </td>
                    <td> ${requestScope.tag.quantity} </td>

                </tr>

            </table>

            <table class="table table-striped mt-4 custom-table">



                <tr>
                    <td>Materiale pris ${requestScope.sc.totalPrice}</td>
                    <td>Total pris: ${requestScope.sc.totalPrice + 0.4 * requestScope.sc.totalPrice} kr. inklusive dækningsgrad på 40% </td>


                </tr>


            </table>
                <div class="button-container">
            <button type="submit" formaction="addtoshoppingcart" class="btn btn-primary custom-button shadow" value="${requestScope.sc.totalPrice}" name="addtoshoppingcart">Add to Shoppingcart </button>
                </div>
        </form>
            <br/>
           <form method="post">
               <div class="button-container">
            <button type="submit" formaction="seeshoppingcart" class="btn btn-success shadow" value="${requestScope.sc.totalPrice}" name="seeshoppingcart">View Shoppingcart </button>
               </div>
           </form>
            <br/>
            <br/>

        </c:if>

        <c:if test="${sessionScope.user == null}">
            <p>You are not logged in yet. You can do it here: <a
                    href="login.jsp">Login</a></p>
        </c:if>

    </jsp:body>

</t:pagetemplate>
