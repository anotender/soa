<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
${error}
<form action="${pageContext.request.contextPath}/login" method="post">
    <input type="text" name="login" placeholder="login">
    <input type="password" name="password" placeholder="password">
    <button type="submit">Zaloguj</button>
</form>
</body>
</html>
