<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Materials
    </jsp:attribute>

    <jsp:attribute name="footer">
        Material list.
    </jsp:attribute>

    <jsp:body>
        <p> List of materials: </p>
        <table class="table table-striped mt-4">

            <form method="post" >
                <tr>
                    <th>rem Id:</th>
                    <th>rem name: </th>
                    <th>length.</th>
                    <th>price pr. [m]</th>


                </tr>

                <c:forEach var="item" items="${requestScope.listOfRem}">


                <tr>

                    <td>${item.remId} </td>
                    <td>${item.remName} </td>
                    <td>${item.length} </td>
                    <td>${item.price} kr. </td>


                    <td><button name="deleterem" type="submit" value="${item.remId}" formaction="deleterem" class=" btn btn-primary"> Delete rem </button></td>




                </tr>

                </c:forEach>
        </table>
        </form>

        <table class="table table-striped mt-4">

            <form method="post" >
                <tr>
                    <th>spaer Id:</th>
                    <th>spaer name: </th>
                    <th>length.</th>
                    <th>price pr. [m]</th>


                </tr>

                <c:forEach var="item" items="${requestScope.listOfSpaer}">


                <tr>

                    <td>${item.spaerId} </td>
                    <td>${item.spaerName} </td>
                    <td>${item.length} </td>
                    <td>${item.price} kr. </td>


                    <td><button name="deletespaer" type="submit" value="${item.spaerId}" formaction="deletespaer" class=" btn btn-primary"> Delete spaer </button></td>




                </tr>

                </c:forEach>
        </table>
        </form>

        <table class="table table-striped mt-4">

            <form method="post" >
                <tr>
                    <th>stolpe Id:</th>
                    <th>stolpe name: </th>
                    <th>length.</th>
                    <th>price pr. [m]</th>


                </tr>

                <c:forEach var="item" items="${requestScope.listOfStolpe}">


                <tr>

                    <td>${item.stolpeId} </td>
                    <td>${item.stolpeName} </td>
                    <td>${item.length} </td>
                    <td>${item.price} kr. </td>


                    <td><button name="deletestolpe" type="submit" value="${item.stolpeId}" formaction="deletestolpe" class=" btn btn-primary"> Delete stolpe </button></td>




                </tr>

                </c:forEach>
        </table>
        </form>


        <table class="table table-striped mt-4">

            <form method="post" >
                <tr>
                    <th>tag Id:</th>
                    <th>tag name: </th>
                    <th>length.</th>
                    <th>price pr. [m]</th>


                </tr>

                <c:forEach var="item" items="${requestScope.listOfTag}">


                <tr>

                    <td>${item.tagId} </td>
                    <td>${item.tagName} </td>
                    <td>${item.length} </td>
                    <td>${item.price} kr. </td>


                    <td><button name="deletetag" type="submit" value="${item.tagId}" formaction="deletetag" class=" btn btn-primary"> Delete tag </button></td>




                </tr>

                </c:forEach>
        </table>
        </form>


    </jsp:body>

</t:pagetemplate>
