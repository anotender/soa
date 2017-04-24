<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<form method="post" action="${pageContext.request.contextPath}/zgaduj">
    Podaj liczbę: <input type="number" min="0" max="100" name="liczba" required>
    <button type="submit">Zgaduj</button>
</form>
<c:choose>
    <c:when test="${result == 'gt'}">Twoja liczba (${lastNumber}) jest <strong>wieksza</strong> niz zagadka</c:when>
    <c:when test="${result == 'lt'}">Twoja liczba (${lastNumber}) jest <strong>mniejsza</strong> niz zagadka</c:when>
    <c:when test="${result == 'eq'}">
        Brawo, zagdales po ${numberOfTries} probach<br>
        Sprobuj <a href="index.jsp">raz jeszcze</a>
    </c:when>
</c:choose>
</body>
</html>
