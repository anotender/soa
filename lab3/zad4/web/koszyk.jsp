<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Koszyk</title>
    <c:import url="computer-parts.xml" var="partsXML"/>
    <x:parse var="parts" xml="${partsXML}"/>
</head>
<body>
<a href="index.jsp">Powrót</a>
<ul>
    <table border="1">
        <thead>
        <tr>
            <th>Nazwa</th>
            <th>Sztuk</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${shoppingCart}" var="product">
            <tr>
                <c:set var="id" value="${product.key}"/>
                <x:set var="part" select="$parts/computer-parts/part[@id = $id]"/>
                <td><x:out select="$part/name"/></td>
                <td>${product.value}</td>
                <td>
                    <form action="removeFromCart" method="post">
                        <input type="hidden" name="id" value="<c:out value="${product.key}"/>">
                        <button type="submit">Usuń</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</ul>
</body>
</html>