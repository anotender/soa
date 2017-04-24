<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="http://localhost:8080/zad2_war_exploded/game" method="post">
    <select name="wybor">
        <option value="kamien">kamień</option>
        <option value="papier">papier</option>
        <option value="nożyce">nożyce</option>
    </select>
    <button type="submit">Graj!</button>
</form>
</body>
</html>