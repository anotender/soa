<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:import url="computer-parts.xml" var="partsXML"/>
    <x:parse var="parts" xml="${partsXML}"/>
</head>
<body>
<a href="${pageContext.request.contextPath}/getCart">Koszyk</a>
<ul>
    <x:forEach select="$parts/computer-parts/part" var="part">
        <li>
            <form action="${pageContext.request.contextPath}/addToCart" method="post">
                <x:out select="$part/name"/>, <x:out select="$part/price"/>
                <input type="hidden" name="id" value="<x:out select="$part/@id"/>">
                <input type="number" name="sztuk" min="0" placeholder="sztuk">
                <button type="submit">Dodaj</button>
            </form>
        </li>
    </x:forEach>
</ul>
</body>
</html>
