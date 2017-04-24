<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<form action="WybierzPiwo.do" method="POST">
    <select name="kolor">
        <option value="jasny">jasny</option>
        <option value="bursztynowy">bursztynowy</option>
        <option value="brazowy">brązowy</option>
        <option value="ciemny">ciemny</option>
    </select>
    <input type="number" name="wiek" placeholder="wiek">
    <button type="submit">Wyślij</button>
</form>
</body>
</html>
