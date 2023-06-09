<%--
  Created by IntelliJ IDEA.
  User: freed
  Date: 15/05/2023
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Order List
    </jsp:attribute>

    <jsp:attribute name="footer">
        Order list.
    </jsp:attribute>

    <jsp:body>
        <p> List of orders: </p>
        <table class="table table-striped mt-4">

            <form method="post" >
                <tr>
                    <th>name:</th>
                    <th>order Id:</th>
                    <th>date:</th>
                    <th>status:</th>
                    <th>price:</th>

                </tr>

                <c:forEach var="item" items="${requestScope.orderList}">


                <tr>

                    <td>${item.name} </td>
                    <td>${item.orderId} </td>
                    <td>${item.date} </td>
                    <td>${item.status}</td>
                    <td>${item.price}</td>

                    <td><button name="orderdetails" type="submit" value="${item.orderId}" formaction="orderdetails" class=" btn btn-primary"> See order details </button></td>
                    <c:if test="${sessionScope.user.role == 'admin'}">
                        <td><button name="deleteorder" type="submit" value="${item.orderId}" formaction="deleteorder" class=" btn btn-primary"> Delete this order </button></td>
                        <td><button name="updateorderstatus" type="submit" value="${item.orderId}" formaction="updateorderstatus" class=" btn btn-primary"> Change order status </button></td>
                        <td><button name="discounttenpercent" type="submit" value="${item.orderId}" formaction="discounttenpercent" class=" btn btn-primary"> give 10% discount </button></td>
                        <td><button name="givecustomprice" type="submit" value="${item.orderId}" formaction="givecustomprice" class=" btn btn-primary"> give custom price </button></td>
                    </c:if>

                </tr>

                </c:forEach>
        </table>
        </form>


    </jsp:body>

</t:pagetemplate>

