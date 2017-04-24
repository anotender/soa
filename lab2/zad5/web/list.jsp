<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<form action="list" method="post">
    <input type="text" name="name" placeholder="name" required><br><br>
    <input type="email" name="email" placeholder="email" required><br><br>
    <input type="text" name="comment" placeholder="comment" required><br><br>
    <button type="submit">Zapisz</button>
    <br>
</form>
<c:forEach items="${sessionScope.feedbackList}" var="feedback">
    ${feedback.name} (${feedback.email})
    <form action="editFeedback" method="get">
        <input type="hidden" name="id" value="${feedback.id}">
        <button type="submit">Edytuj</button>
    </form>
    <br>
    ${feedback.comment}
</c:forEach>
</body>
</html>
