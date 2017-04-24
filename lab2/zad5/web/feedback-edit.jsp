<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edycja</title>
</head>
<body>
<a href="list">Powrót</a>
<c:if test="${error!=null}">
    <c:out value="${error}"/>
</c:if>
<c:if test="${feedback!=null}">
    <form action="editFeedback" method="post">
        <input type="hidden" name="id" value="${feedback.id}">
        <input type="text" name="name" value="${feedback.name}" placeholder="Imię"><br><br>
        <input type="email" name="email" value="${feedback.email}" placeholder="Email"><br><br>
        <input type="text" name="komentarz" value="${feedback.comment}" placeholder="Komentarz"><br><br>
        <button type="submit">Zapisz</button>
    </form>
</c:if>
</body>
</html>
