<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <fmt:setLocale value="en_US"/>
</head>
<body>
<table border="1">
    <thead>
    <tr>
        <th>Tytul</th>
        <th>Gatunek</th>
        <th>Rok</th>
        <th>Dochod</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="film" items="${films}">
        <tr>
            <td><c:out value="${film.title}"/></td>
            <c:choose>
                <c:when test="${film.genre == 'wojenny'}">
                    <td style="background-color: aqua"><c:out value="${film.genre}"/></td>
                </c:when>
                <c:otherwise>
                    <td><c:out value="${film.genre}"/></td>
                </c:otherwise>
            </c:choose>
            <td><c:out value="${film.year}"/></td>
            <td><fmt:formatNumber value="${film.income}" type="currency"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
