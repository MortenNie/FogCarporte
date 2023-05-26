<%--
  Created by IntelliJ IDEA.
  User: freed
  Date: 15/05/2023
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Order Details
    </jsp:attribute>

    <jsp:attribute name="footer">
        Order details.
    </jsp:attribute>

    <jsp:body>

        <div class="table-responsive">
        <table class="table table-striped mt-4">

            <form method="post" >
                <tr>
                    <th>Carport Id:</th>
                    <th>chosen Width:</th>
                    <th>chosen Length:</th>
                    <th>chosen Height:</th>
                    <th>Shed Yes/No:</th>
                    <th>Spaer Name: </th>
                    <th>Spaer Quantity: </th>
                    <th>Spaer Length [m]:</th>
                    <th>Rem Name: </th>
                    <th>Rem Quantity: </th>
                    <th>Rem Length [m]:</th>
                    <th>Stolpe Name: </th>
                    <th>Stolpe Quantity: </th>
                    <th>Stolpe Length [m]:</th>
                    <th>Tag Name: </th>
                    <th>Tag Quantity: </th>
                    <th>Tag Length [m]:</th>

                </tr>

                <c:forEach var="item" items="${requestScope.carportList}">


                <tr>

                    <td>${item.carportId} </td>
                    <td>${item.width} </td>
                    <td>${item.length} </td>
                    <td>${item.height} </td>
                    <td>${item.shed} </td>
                    <td>${item.spaer.spaerName} </td>
                    <td>${item.spaer.quantity} </td>
                    <td>${item.spaer.length} </td>
                    <td>${item.rem.remName} </td>
                    <td>${item.rem.quantity} </td>
                    <td>${item.rem.length} </td>
                    <td>${item.stolpe.stolpeName} </td>
                    <td>${item.stolpe.quantity} </td>
                    <td>${item.stolpe.length} </td>
                    <td>${item.tag.tagName} </td>
                    <td>${item.tag.quantity} </td>
                    <td>${item.tag.length} </td>




                </tr>

                </c:forEach>
        </table>
        </div>
        </form>


    </jsp:body>

</t:pagetemplate>
